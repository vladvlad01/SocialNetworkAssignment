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
<title>Insert title here</title>
</head>
<body>
	<h1>This is a success page</h1>
	<s:form action="goToLogin">
		<s:submit value="Go To Login"></s:submit>
	</s:form>
</body>
</html>