<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<body>
	<s:form action="goToLogin">
		<s:submit value="LogOff"></s:submit>
	</s:form>
	<s:form action="viewfriends">
		<s:hidden name="email" value="%{email}" />
		<s:submit value="View Friends"></s:submit>
	</s:form>
	<s:form action="addFriend">
		<s:hidden name="email" value="%{email}" />
		<s:textfield name="emailoffriend" label="Email of friend" />
		<s:submit value="Add a friend" />
	</s:form>
	<br />
	<h1>
		Hello and welcome
		<s:property value="email" />
	</h1>
	<br />
	<br />

	<s:form action="post">

		<s:hidden name="email" value="%{email}" />
		<s:textfield name="emailoftarget" label="On who's wall to post" />

		<s:textarea name="message" cols="40" rows="10" label="Your message"
			value="What's in your mind?" />
		<s:submit value="Publish"></s:submit>
	</s:form>

	<s:form action="viewWall">
		<s:textfield name="wallname" label="View someone's wall" />
		<s:submit value="View" />
	</s:form>

</body>
</html>