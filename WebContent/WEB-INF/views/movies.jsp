<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	type="text/css" />
<link rel="stylesheet"
	href="<spring:url value="/resources/CSS/custom.css"/>" type="text/css" />
<title>Spisak svih filmova</title>
<script type="text/javascript"
	src="<spring:url value="/resources/js/jquery.core.js"/>"></script>
<script type="text/javascript"
	src="<spring:url value="/resources/js/jquery.validate.js"/>"></script>
<script type="text/javascript"
	src="<spring:url value="/resources/js/editMoviesScript.js"/>"></script>
</head>
<body>
	<jsp:include page="../jspFragments/header.jsp" />
	<div class="container">
	<h1>Movie List:</h1>
		<table class="table table-hover">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Year</th>
				<th>Genre</th>
				<th>Director</th>
				<th>Runtime</th>
				<th></th>
			</tr>
			<c:forEach var="movie" items="${movies}">
				<tr class="movieRow">
					<td>${movie.id}</td>
					<td>${movie.name}</td>
					<td>${movie.year}</td>
					<td>${movie.genre}</td>
					<td>${movie.director}</td>
					<td>${movie.runtime}</td>
					
<!-- 					<sec:authorize access="isAuthenticated()"> -->
					<td id="td_button"><button class="btn btn-warning editMovie">Edit</button></td>
					<td id="td_button"><a href="<spring:url value="/delete/${movie.id}"/>"><button
								class="btn btn-danger">Delete</button></a>
					</td>
<!-- 					</sec:authorize> -->
				</tr>
				<tr class="editMovieRow">
					<td colspan="2"></td>
					<td colspan="2">

						<form class="editMovie" id="editMovie" method="POST"
							action="<spring:url value="/edit/${movie.id}"/>">
							<div class="form-group">
								<label>Name: </label> <input name="name" class="form-control"
									value="${movie.name}" /> <span></span>
							</div>
							<div class="form-group">
								<label>Year: </label> <input name="year" class="form-control"
									value="${movie.year}" /> <span></span>
							</div>
							<div class="form-group">
								<label>Genre: </label> <input name="genre" class="form-control"
									value="${movie.genre}" />
							</div>
							<div class="form-group">
								<label>Director: </label> <input name="director"
									class="form-control" value="${movie.director}" />
							</div>
							<div class="form-group">
								<label>Runtime: </label> <input name="runtime"
									class="form-control" value="${movie.runtime}" />
							</div>
							<input type="submit" class="btn btn-warning form-control"
								value="Confirm Edit" />
						</form>
					</td>
					<td colspan="2"></td>
				</tr>

			</c:forEach>
		</table>
	</div>
	<br><br><br>
	<jsp:include page="../jspFragments/footer.jsp" />

</body>
</html>