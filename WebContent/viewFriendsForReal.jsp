<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"></meta>
<title>Your friends</title>
</head>
<body>
	<h1>These are your friends:</h1>
	<s:iterator value="emails">
		<s:property value="email" />
		<br />
	</s:iterator>
	<br /> Please use the back button to go back to your User Profile.
</body>
</html>