<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
</head>
<script>
	$(document).ready(function() {

		var success = eval("${success}");

		if (success) {
			$('#sendSuccess').text('Successfully sent movie.');
			$(':input[type=text]', '#addMovieForm').val('');
			$('#sendSuccess').fadeOut(5000);
		}

	});
</script>

<body>
	<jsp:include page="../jspFragments/header.jsp" />

	<div class="container">
		<center>
			<h2>Add a movie to the database:</h2>
			<span id="sendSuccess"></span>
		</center>
		<spring:url value="/add" var="action" />
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<form:form id="addMovieForm" method="POST" action="${action}"
					modelAttribute="movie">
					<div class="form-group">
						<label for="name">Name</label>
						<form:input id="name" path="name" name="name"
							cssClass="form-control" />
						<form:errors path="name"></form:errors>
					</div>
					<div class="form-group">
						<label for="year">Year</label>
						<form:input path="year" cssClass="form-control" />
						<form:errors path="year"></form:errors>
					</div>
					<div class="form-group">
						<label for="genre">Genre</label>
						<form:input path="genre" cssClass="form-control" />
						<form:errors path="genre"></form:errors>
					</div>
					<div class="form-group">
						<label for="director">Director</label>
						<form:input path="director" cssClass="form-control" />
						<form:errors path="director"></form:errors>
					</div>
					<div class="form-group">
						<label for="runtime">Runtime</label>
						<form:input path="runtime" cssClass="form-control" />
						<form:errors path="runtime"></form:errors>
					</div>
					<input class="btn btn-primary" type="submit" value="Add Movie" />
				</form:form>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<jsp:include page="../jspFragments/footer.jsp" />
</body>
</html>