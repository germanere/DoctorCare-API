package com.duc.service;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;

import com.duc.entity.Patient;

public class MedicalReportRequest {
	private String RecipientEmail;
	private Patient patientname;
	@Autowired
	EmailService emailService;
    public void sendMedicalReport(String recipientEmail, Patient patientName) {
        try {
           emailService.sendMedicalReportEmail(recipientEmail, patientName);
            System.out.println("Email sent successfully.");
        } catch (IOException | MessagingException e) {
            System.out.println("Failed to send email: " + e.getMessage());
        }
    }

	public void setRecipientEmail(String recipientEmail) {
		RecipientEmail = recipientEmail;
	}
	public Patient getPatientname() {
		return patientname;
	}
	public void setPatientname(Patient patientname) {
		this.patientname = patientname;
	}
	public String getRecipientEmail() {
		return RecipientEmail;
	}

	public MedicalReportRequest(String recipientEmail, Patient patientname) {
		super();
		RecipientEmail = recipientEmail;
		this.patientname = patientname;
	}
    
}
