package org.vlad.struts.action;

public class Register
{
	private String email;
	private String password;
	private SQLManager sqlmanager;
	public Register()
	{
		this.sqlmanager = new SQLManager();
	}
	public String registration()
	{
		if (sqlmanager.registerNewUser(email,password))
		{
			return "success";
		}
		else
		{
			return "failure";
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

