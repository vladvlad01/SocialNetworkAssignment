package org.vlad.struts.action;

import java.util.ArrayList;
import java.util.List;

public class AddFriend
{
	private String email;
	private String emailoffriend;
	private SQLManager sqlmanager;
	public AddFriend()
	{
		this.sqlmanager = new SQLManager();
	}
	public String add()
	{
		return sqlmanager.addFriend(email,emailoffriend)?"success":"failure";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailoffriend() {
		return emailoffriend;
	}
	public void setEmailoffriend(String emailoffriend) {
		this.emailoffriend = emailoffriend;
	}
}


