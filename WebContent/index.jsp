<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
</head>
<body>
	<s:form action="login">
		<s:textfield name="email" label="Type your login Email" />
		<s:password name="password" label="Type your login Password" />
		<s:submit value="Login">

		</s:submit>
	</s:form>
	<s:form action="getmembers">
		<s:submit value="View All Members"></s:submit>
	</s:form>
	If your don't have an account, create one now!

	<s:form action="goToRegister">
		<s:submit value="Create Account"></s:submit>
	</s:form>
</body>
</html>