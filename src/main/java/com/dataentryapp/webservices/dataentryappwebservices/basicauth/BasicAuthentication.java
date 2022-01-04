package com.dataentryapp.webservices.dataentryappwebservices.basicauth;

public class BasicAuthentication {
	
	private String message;

	public BasicAuthentication(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "BasicAuthentication [message=" + message + "]";
	}
	
	
}
