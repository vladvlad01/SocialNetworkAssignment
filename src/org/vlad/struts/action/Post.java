package org.vlad.struts.action;

import java.util.ArrayList;
import java.util.List;

public class Post
{
	private String email;
	private String emailoftarget;
	private String message;
	private SQLManager sqlmanager;
	public Post()
	{
		this.sqlmanager = new SQLManager();
	}
	public String post()
	{
		return sqlmanager.postMessage(email,emailoftarget,message)?"success":"failure";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailoftarget() {
		return emailoftarget;
	}
	public void setEmailoftarget(String emailoftarget) {
		this.emailoftarget = emailoftarget;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}


