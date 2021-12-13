package com.kouki.demo.error;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorDetails {

	
	private String message;
	private String url;
	@JsonFormat(shape = JsonFormat.Shape.STRING ,pattern = "dd-MM-yyy hh:mm:ss")
	private Date timestamp;
	
	public ErrorDetails() {
		this.timestamp=new Date();
	}
	
	public ErrorDetails(String message, String url) {
		this();
		this.message = message;
		this.url = url;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
