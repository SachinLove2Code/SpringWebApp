<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>

<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css" />

<title>Login Page</title>
</head>
<body onload='document.f.username.focus();'>
	<h3>Login with Username and Password</h3>
	
	<c:if test="${param.error != null}">
	<p style="color: red"> <b>Login Failed ! User name or password are incorrect</b> </p> 
	</c:if>
	<form name='f' action='${pageContext.request.contextPath}/login'
		method='POST'>
		<table class="customers">
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<!-- <tr>
				<td>Remember Me:</td>
				<td><input type= "checkbox" name='_spring_security_remember_me' checked="checked" /></td>
			</tr> -->
			<tr>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
			</tr>

		</table>
	</form>
	
	
</body>
</html>