package com.duc.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.duc.entity.Patient;
import com.duc.entity.Schedule;
import com.duc.entity.User;
import com.duc.repository.ScheduleReposiroty;

import jakarta.mail.util.ByteArrayDataSource;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@Service
public class EmailService {
	@Autowired
	UserService userService;
	
	@Autowired
	ScheduleReposiroty scheduleReposiroty;
	
	@Autowired
    private JavaMailSender mailSender;

	   public void sendMedicalReportEmail(String recipientEmail, Patient patientName) throws IOException, MessagingException {
	        // Tạo tệp PDF thông tin bệnh lý
	        byte[] pdfBytes = createMedicalReportPdf(patientName);

	        // Gửi email với tệp PDF đính kèm
	        sendEmailWithAttachment(patientName.getUsers().getEmail(), "Thông tin bệnh lý", "Xin chào, dưới đây là thông tin bệnh lý của bạn.", pdfBytes, "Thông tin bệnh lý.pdf");
	    }

	    private byte[] createMedicalReportPdf(Patient patient) throws IOException {
			User user =userService.FindUserById(patient.getUsers().getId());
			Schedule schedule = scheduleReposiroty.getById(user.getId());
	        PDDocument document = new PDDocument();
	        PDPage page = new PDPage(PDRectangle.A4);
	        document.addPage(page);

	        PDPageContentStream contentStream = new PDPageContentStream(document, page);
	        File fontFile = ResourceUtils.getFile("classpath:arial-unicode-ms.ttf");
	        PDFont font = PDType0Font.load(document, fontFile);
	        contentStream.setFont(font, 12);
	        contentStream.beginText();
	        contentStream.newLineAtOffset(25, 700);
	        contentStream.showText("Bệnh nhân: " + patient.getName());
	        contentStream.newLine();
	        contentStream.showText("Thông tin bệnh lý: " + patient.getPathologydetail());
	        contentStream.newLine();
	        contentStream.showText("Tên Bác Sĩ: " + schedule.getUsers().getDoctorUser().getName());
	        contentStream.newLine();
	        contentStream.showText("Ngày Khám: " + schedule.getDate());
	        contentStream.newLine();
	        contentStream.showText("giờ Khám: " + schedule.getTime());
	        contentStream.endText();
	        contentStream.close();

	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        document.save(outputStream);
	        document.close();

	        return outputStream.toByteArray();
	    }

	    private void sendEmailWithAttachment(String recipientEmail, String subject, String body, byte[] attachmentBytes, String attachmentName) throws MessagingException {
	        jakarta.mail.internet.MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper helper;
			try {
				helper = new MimeMessageHelper(message, true);
		        helper.setFrom("your-email@example.com");
		        helper.setTo(recipientEmail);
		        helper.setSubject(subject);
		        helper.setText(body);
		        // Đính kèm tệp PDF
		        FileSystemResource res = new FileSystemResource(new File("c:/Sample.jpg"));
		        jakarta.activation.DataSource dataSource = new ByteArrayDataSource(attachmentBytes, "application/pdf");
		        helper.addAttachment(attachmentName, dataSource);
			} catch (jakarta.mail.MessagingException e) {

				e.printStackTrace();
			}
	        mailSender.send(message);
	    }
	    
}
