<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css"/>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <c:forEach var= "row" items="${custlist}">


    Name: ${row.custName}<br/>
    Email : ${row.custEmail} <br/>.
</c:forEach> --%>

	<h1>add</h1>
	<sf:form class="addform" method="Post"
		action="${pageContext.request.contextPath}/doaddcustomer"
		commandName="customerDetailsBean">
		<table>
			<tr>
				<td class="lable">Customer Name :</td>
				<td><sf:input  class = "control" name="custName" type="text" path="custName" /><br/><sf:errors path="CustName" cssClass ="error" ></sf:errors></td>
			</tr>
			<tr>
				<td class="lable">Email :</td>
				<td><sf:input class = "control" name="custEmail" type="text" path="custEmail" /><br/><sf:errors path="CustEmail" cssClass ="error" ></sf:errors></td>
			</tr>
			<tr>
				<td class="lable">City :</td>
				<td><sf:input class = "control" name="city" type="text" path="City" /><br/><sf:errors path="City" cssClass ="error" ></sf:errors></td>
			</tr>
			<tr>
				<td class="lable"></td>
				<td><input class = "control" value="Submit" type="submit" /></td>
			</tr>
		</table>


	</sf:form>



	<c:url var="logoutUrl" value="/logout" />
	<form action="${logoutUrl}" method="post">
		<input type="submit" value="Logout" /> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>


</body>
</html>