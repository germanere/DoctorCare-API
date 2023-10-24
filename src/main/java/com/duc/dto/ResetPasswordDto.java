package com.duc.dto;

public class ResetPasswordDto {
	 private String email;
	 private String verificationCode;
	 private String newPassword;
	 private String confirmPassword;
	 
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVerificationCode() {
		return verificationCode;
	}
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public ResetPasswordDto() {
		
	}
	public ResetPasswordDto(String email, String verificationCode, String newPassword, String confirmPassword) {
		super();
		this.email = email;
		this.verificationCode = verificationCode;
		this.newPassword = newPassword;
		this.confirmPassword = confirmPassword;
	}
}
