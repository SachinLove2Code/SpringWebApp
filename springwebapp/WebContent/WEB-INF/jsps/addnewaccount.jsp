<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/script/main.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- <c:forEach var= "row" items="${custlist}">


    Name: ${row.custName}<br/>
    Email : ${row.custEmail} <br/>.
</c:forEach> --%>

	<h1>Create New Account</h1>
	<sf:form id="details" class="addform" method="Post"
		action="${pageContext.request.contextPath}/accountcreated"
		commandName="user">
		<table>
			<tr>
				<td class="lable">User Name :</td>
				<td><sf:input class="control" name="username" type="text"
						path="username" /><br />
				<div class="error">
						<sf:errors path="username" />
					</div></td>
			</tr>
			<tr>
				<td class="lable">Email :</td>
				<td><sf:input class="control" name="email" type="text"
						path="email" /><br />
				<div class="error">
						<sf:errors path="email" />
					</div>
					</td>
				
			</tr>
			<tr>
				<td class="lable">Password :</td>
				<td><sf:input id="password" class="control" name="password" type="text"
						path="password" /><br />
					<div class="error">
						<sf:errors path="password" />
					</div></td>

			</tr>
			<tr>
				<td class="lable">Confirm Password :</td>
				<td><input id="confirmpassword" class="control" name="confirm" type="text" /><div id="matchpass"></div></td>
			</tr>
			<tr>
				<td class="lable"></td>
				<td><input class="control" value="Create Account" type="submit" /></td>
			</tr>
		</table>


	</sf:form>



</body>
</html>