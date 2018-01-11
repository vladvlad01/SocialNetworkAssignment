package org.vlad.struts.action;

import java.util.ArrayList;
import java.util.List;

public class ViewFriends
{
	private String email;
	private List<User> emails;
	private SQLManager sqlmanager;
	public List<User> getEmails() {
		return emails;
	}
	public void setEmails(List<User> emails) {
		this.emails = emails;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ViewFriends()
	{
		this.sqlmanager = new SQLManager();
		this.emails = new ArrayList<User>();
	}
	public String viewfriends()
	{
		for (String email2:sqlmanager.getFriends(email))
		{
			emails.add(new User(email2));
		}
		return "success";
	}
}


