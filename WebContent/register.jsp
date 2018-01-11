<%@ taglib
	prefix="s"
	uri="/struts-tags"%>
<%@ page
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta
	http-equiv="Content-Type"
	content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<s:form action="register">
		<s:textfield
			name="email"
			label="Register your Email" />
		<s:password
			name="password"
			label="Register your Password" />
		<s:submit />
	</s:form>
	<br /> If you already have an account click the button below
	<br />
	<s:form action="goToLogin">
		<s:submit value="Go To Login"></s:submit>
	</s:form>
</body>
</html>