package org.vlad.struts.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLManager 
{
	public boolean isEmailTaken(String email)
	{
//		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SocialNetwork?useSSL=false", "root", "root");
			// here lotto is database name, root is username and password
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Userdata WHERE Email='"+email+"'");
			int count = 0;
			while (rs.next()) 
			{
				count++;
			}

			con.close();
			return count != 0;
		} catch (Exception e)
		{
			e.printStackTrace();
			return true;
		}
	}
	public boolean registerNewUser(String email,String password)
	{
		Pattern pat = Pattern.compile("^.*@.*\\..{2,4}$");
		Matcher match = pat.matcher(email);
		if (match.matches())
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SocialNetwork?useSSL=false", "root", "root");
				// here lotto is database name, root is username and password
				if (isEmailTaken(email))
				{
					return false;
				}
				else
				{
					Statement insert = con.createStatement();
					insert.executeUpdate("INSERT INTO Userdata (Email,Passwd) VALUES ('"+email+"','"+password+"')");
					
					con.close();
					return true;
				}
	//			Statement insert = con.createStatement();
	//			insert.execute("INSERT INTO Userdata (Email,Passwd) VALUES ("+email+","+password+")");
	//			Statement stmt = con.createStatement();
	//			ResultSet rs = stmt.executeQuery("select * from lotto ORDER BY ID DESC LIMIT 5");
	//			con.close();
			} catch (Exception e)
			{
				e.printStackTrace();
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	public boolean loginUser(String email, String password) {
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SocialNetwork?useSSL=false", "root", "root");
			// here lotto is database name, root is username and password
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Userdata WHERE Email='"+email+ "' AND Passwd='"+password+"'");
			int count = 0;
			while (rs.next()) 
			{
				count++;
			}

			con.close();
			return count != 0;
		} catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<String> getAllUsers() 
	{
		ArrayList<String> users = new ArrayList<String>();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SocialNetwork?useSSL=false", "root", "root");
			// here lotto is database name, root is username and password
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Email FROM Userdata");
			while (rs.next()) 
			{
				users.add(rs.getString(1));
			}

			con.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return users;
	}
	public ArrayList<String> getFriends(String email) 
	{
		ArrayList<String> users = new ArrayList<String>();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SocialNetwork?useSSL=false", "root", "root");
			// here lotto is database name, root is username and password
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Friends FROM userdata WHERE Email = '"+email+"'");
			while (rs.next()) 
			{
				String friends = rs.getString(1);
				for (String friendEmail:friends.split(";"))
				{
					users.add(friendEmail);
				}
			}

			con.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return users;
	}
	public boolean addFriend(String email, String emailoffriend) 
	{
		ArrayList<String> currentFriends = getFriends(email);
		if (currentFriends.contains(emailoffriend) || !isEmailTaken(emailoffriend))
		{
			return false;
		}
		else
		{
			String userFriends = "";
			for (String s:currentFriends)
			{
				userFriends+=s+";";
			}
			userFriends+=emailoffriend;
			setFriends(email,userFriends);
			return true;
		}
	}
	private void setFriends(String email, String userFriends) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SocialNetwork?useSSL=false", "root", "root");
			Statement insert = con.createStatement();
			insert.executeUpdate("UPDATE userdata SET Friends = '"+userFriends+"' WHERE Email = '"+email+"'");
			
			con.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public boolean postMessage(String email, String emailoftarget, String message) 
	{
		if (isEmailTaken(emailoftarget))
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SocialNetwork?useSSL=false", "root", "root");
				Statement insert = con.createStatement();

				insert.executeUpdate("INSERT INTO posts VALUES (0,'"+email+"','"+emailoftarget+"','"+Base64.getEncoder().encodeToString(message.getBytes())+"')");
				
				con.close();
	//			Statement insert = con.createStatement();
	//			insert.execute("INSERT INTO Userdata (Email,Passwd) VALUES ("+email+","+password+")");
	//			Statement stmt = con.createStatement();
	//			ResultSet rs = stmt.executeQuery("select * from lotto ORDER BY ID DESC LIMIT 5");
	//			con.close();
				return true;
			} catch (Exception e)
			{
				e.printStackTrace();
				return false;
			}
		}
		else
		{
			return false;
		}
		
	}
	public ArrayList<String> getPosts(String wallname) 
	{
		if (!isEmailTaken(wallname))
		{
			return null;
		}
		else
		{
			ArrayList<String> messages = new ArrayList<String>();
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SocialNetwork?useSSL=false", "root", "root");
				// here lotto is database name, root is username and password
				
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT EmailFrom,Email,Message FROM posts WHERE Email = '"+wallname+"'");
				while (rs.next()) 
				{
					String messageEntry = rs.getString(1)+";"+rs.getString(2)+";"+new String(Base64.getDecoder().decode(rs.getString(3).getBytes()));
					messages.add(messageEntry);
				}

				con.close();

				return messages;
			} catch (Exception e)
			{
				e.printStackTrace();
				return null;
			}
		}
	}
}
