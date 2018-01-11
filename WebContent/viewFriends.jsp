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
	content="text/html; charset=ISO-8859-1"></meta>
<title>Members</title>
</head>
<body>
	<h1>These are the currently registered members:</h1>
	<s:iterator value="emails">    
	    Email: <s:property value="email" />
	    <br/>
	</s:iterator>
	<s:form action="goToLogin">
		<s:submit value="Back to Login"></s:submit>
	</s:form>
</body>
</html>