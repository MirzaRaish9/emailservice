package com.email.model;

public class emailRequest {

	private String to;
	private String subject;
	private String message;
	
	
	public emailRequest(String to, String subject, String message) {
		super();
		this.to = to;
		this.subject = subject;
		this.message = message;
	}
	
	


	public emailRequest() {
		super();
		// TODO Auto-generated constructor stub
	}




	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}


	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}


	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}


	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}


	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}


	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "emailRequest [to=" + to + ", subject=" + subject + ", message=" + message + "]";
	}
	
	
	
	
}
