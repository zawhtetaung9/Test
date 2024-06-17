<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="register" method="post" modelAttribute="user">
<table>
	<tr>
		<td>Name</td>
		<td><form:input path="name"/></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><form:input path="email"/></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><form:password path="password"/></td>
	</tr>
	<tr>
		<td>Confirm Password</td>
		<td><form:password path="password"/></td>
	</tr>
	<tr>
		<td>role </td>
		<td><form:password path="role"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="Send"></td>
	</tr>
</table>
</form:form>
</body>
</html>