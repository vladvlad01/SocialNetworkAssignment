package org.vlad.struts.action;

public class User {
	private String email;
	public User(String string) 
	{
		this.email = string;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
