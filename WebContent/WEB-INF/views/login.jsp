<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	type="text/css" />
<link rel="stylesheet"
	href="<spring:url value="/resources/CSS/custom.css"/>" type="text/css" />
<title>Login Page</title>
<script type="text/javascript"
	src="<spring:url value="/resources/js/jquery.core.js"/>"></script>
	
<script>
$(document).ready(function(){
	var loginerror = eval("${param.loginerror}");
	
	if(loginerror){
		$("div.error").fadeOut(5000);
	}
	
});
</script>
</head>

<body onload='document.f.username.focus();'>
	<jsp:include page="../jspFragments/header.jsp" />


	<div class="container">
		<div class="error">
		<c:if test="${param.loginerror != null}">
			<h1 class="error">Login unsuccessful.</h1>
		</c:if>
		</div>

		<h3>Login with Username and Password</h3><br><br>
		<form name='f' action='${pageContext.request.contextPath}/login'
			method='POST'>
			<table>
				<tr>
					<td>Username:</td>
					<td><input type='text' name='username' value='' class="form-control"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' class="form-control" /></td>
				</tr>
				<tr>
					<td>Remember me:</td>
					<td><input type='checkbox' id="remember_me" name='remember-me'
						 /></td>
				</tr>
				<tr>
					<td colspan='2'>
					<input name="submit" type="submit"value="Login" class="btn btn-default" /></td>
				</tr>
			</table>
			
		</form>
	</div>
	<jsp:include page="../jspFragments/footer.jsp" />
</body>
</html>