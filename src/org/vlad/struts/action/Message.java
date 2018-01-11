package org.vlad.struts.action;

public class Message 
{
	private String from;
	private String to;
	private String message;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMessage() {
		return message;
	}
	public Message(String from, String to, String message) {
		super();
		this.from = from;
		this.to = to;
		this.message = message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
