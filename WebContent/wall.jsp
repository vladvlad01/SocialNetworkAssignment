<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"></meta>
<title>Wall</title>
</head>
<body>
	<h1>
		You are viewing
		<s:property value="wallname" />
		's wall.
	</h1>
	<s:iterator value="messages">    
	    From: <s:property value="from" />
		<br />
	     To: <s:property value="to" />
		<br />
	     Message: <s:property value="message" />
		<br />
		<br />
	</s:iterator>
	<br /> Please use your back button.
</body>
</html>