package org.vlad.struts.action;

import java.util.ArrayList;
import java.util.List;

public class Wall
{
	private String wallname;
	private List<Message> messages;
	private SQLManager sqlmanager;
	public Wall()
	{
		this.messages = new ArrayList<Message>();
		this.sqlmanager = new SQLManager();
	}
	public String viewWall()
	{
		ArrayList<String> queryResult = sqlmanager.getPosts(wallname);
		if (queryResult!=null)
		{
			for (String s:queryResult)
			{
				String data[] = s.split(";");
				messages.add(new Message(data[0],data[1],data[2]));
			}
			return "success";
		}
		else
		{
			return "failure";
		}
	}
	public String getWallname() {
		return wallname;
	}
	public void setWallname(String wallname) {
		this.wallname = wallname;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
}


