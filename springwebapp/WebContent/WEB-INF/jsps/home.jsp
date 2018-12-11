<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>

<p> <a href="${pageContext.request.contextPath}/customers">List Of Customer</a></p>




<sec:authorize access="hasAuthority('ROLE_ADMIN')">
<p><a href="<c:url value = "/admin"/>">Admin</a></p>
</sec:authorize>


<sec:authorize access="!isAuthenticated()">
<p><a href="<c:url value = "/addnewaccount"/>">Sign In</a></p>
<p><a href="<c:url value = "/login"/>">Log In</a></p>
	

</sec:authorize>
<sec:authorize access="isAuthenticated()">
<p><a href="${pageContext.request.contextPath}/addcustomer">Add A New Customer</a></p>

<c:url var="logoutUrl" value="/logout" />
	<form action="${logoutUrl}" method="post">
		<input type="submit" value="Logout" /> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>

</sec:authorize>


</body>
</html>