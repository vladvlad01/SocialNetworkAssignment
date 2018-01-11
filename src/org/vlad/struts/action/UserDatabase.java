package org.vlad.struts.action;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase
{
	private List<User> emails;
	private SQLManager sqlmanager;
	public UserDatabase()
	{
		this.emails = new ArrayList<User>();
		this.sqlmanager = new SQLManager();
	}
	public String getmembers()
	{
		for (String email:sqlmanager.getAllUsers())
		{
			emails.add(new User(email));
		}
		return "success";
	}
	public List<User> getEmails() {
		return emails;
	}
	public void setEmails(List<User> emails) {
		this.emails = emails;
	}
}


