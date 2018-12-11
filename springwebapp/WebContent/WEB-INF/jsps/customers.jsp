<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>List of Customer</h1>
	<table class="customers">
		<tr>
			<td>Name</td>
			<td>Email</td>
			<td>City</td>
		</tr>
		<c:forEach var="customer" items="${custlist}">
			<%-- <p><c:out value="${customer}"></c:out></p> --%>
			<tr>
				<td><c:out value="${ customer.custName}"></c:out></td>
				<td><c:out value="${ customer.custEmail}"></c:out></td>
				<td><c:out value="${ customer.city}"></c:out></td>
			</tr>


		</c:forEach>
	</table>

</body>
</html>