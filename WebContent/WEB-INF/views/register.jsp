<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	type="text/css" />
<link rel="stylesheet"
	href="<spring:url value="/resources/CSS/custom.css"/>" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="<spring:url value="/resources/js/jquery.core.js"/>"></script>
<script type="text/javascript"
	src="<spring:url value="/resources/js/jquery.validate.js"/>"></script>
<script type="text/javascript"
	src="<spring:url value="/resources/js/register.js"/>"></script>

</head>
<body>
	<jsp:include page="../jspFragments/header.jsp" />
	
	<div class="container">
	<h3>Register with Username and Password</h3>
	<form:form id="registerForm"
		action='${pageContext.request.contextPath}/createAccount'
		method='POST' modelAttribute="user">
		<table>
			<tr>
				<td>Username:</td>
				<td><form:input type='text' name='username' path="username" />
					<div>
						<span id="usernameAvailable" class="help-block"></span>
						<form:errors class="help-block" path="username" />
					</div></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input id="password_id" type='password'
						name='password' path="password" />
					<div>
						<form:errors class="help-block" path="password" />
					</div></td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><input id="confirmPassword_id" type='password'
					name='confirmPassword' /></td>
			</tr>
			<tr>
				<td colspan='2'><input class="btn btn-primary" name="submit" type="submit"
					value="register" /></td>
			</tr>
		</table>

	</form:form>
	</div>
	<jsp:include page="../jspFragments/footer.jsp" />
</body>
</html>