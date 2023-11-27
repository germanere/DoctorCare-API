package com.duc.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.duc.entity.User;
import com.duc.repository.UserRepository;

@Service
@Component("forgotPasswordService")
@ComponentScan(basePackages = {"com.duc.service"})
public class ForgotPasswordService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
    private JavaMailSender mailSender;
    
    public void sendVerificationCode(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("Email không tồn tại trong hệ thống.");
        }
        String verificationCode = generateVerificationCode();

        String subject = "Xác nhận email";
        String text ="https://doctorcare-api.onrender.com/api/users/reset-password" +verificationCode;
        sendEmail(email, subject, text);
    }
    
    public void resetPassword(String email, String newPassword, String confirmPassword) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("Email không tồn tại trong hệ thống.");
        }
        if (!newPassword.equals(confirmPassword)) {
            throw new RuntimeException("Mật khẩu mới và xác nhận mật khẩu không khớp.");
        }
        user.setPassword(newPassword);
        userRepository.save(user);
    }
    
    
    private void sendEmail(String email, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    private final String generateVerificationCode() {
    	 int codeLength = 6; // Độ dài của mã xác thực =6
    	    String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Các ký tự có thể sử dụng trong mã xác thực
    	    StringBuilder sb = new StringBuilder();
    	    Random random = new Random();
    	    for (int i = 0; i < codeLength; i++) {
    	        int randomIndex = random.nextInt(characters.length());
    	        char randomChar = characters.charAt(randomIndex);
    	        sb.append(randomChar);
    	    }
    	    return sb.toString();
    }
}
