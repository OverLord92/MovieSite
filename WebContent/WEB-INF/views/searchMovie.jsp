<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	src="<spring:url value="/resources/js/search.js"/>"></script>
	
<script>

$(document).ready(function(){

	function success(data) {
		
		$("#movieResult").find("tr:gt(0)").remove();
		
		var movies = data.movies;
		for(var i = 0; i < movies.length; i++) {
			$('#movieResult').append('<tr><td>' + data.movies[i].name + '</td>' +
			'<td>' + data.movies[i].year + '</td>' +
			'<td>' + data.movies[i].genre + '</td>' +
			'<td>' + data.movies[i].director + '</td>' +
			'<td>' + data.movies[i].runtime + '</td>' +
			'</tr>');
		}
	}
	
	function error(data) {
		alert('An Error ocurred during the AJAX call.');
	}
	
	$('#submitButton').click(function(event){
		event.preventDefault();
		
		var name = $('#name').val();
		var fromYear = $('#fromYear').val();
		var toYear = $('#toYear').val();
		var genre = $('#genre').val();
		
		$.ajax({
			'type': 'POST',
			'url': '<c:url value="/searchMoviez" />', 
			'data': JSON.stringify({
				'name': name,
				'fromYear': fromYear,
				'toYear': toYear,
				'genre': genre,
				'director': director
			}),
			accept: 'application/json',
			'dataType': 'json',
			"success": success,
			"error": error,
			contentType: "application/json",
			dataType: "json"
		});
	});
});
</script>

</head>
<body>
	<jsp:include page="../jspFragments/header.jsp" />

	<div class="container">
		<h1>Search for Movies:</h1>

		<form action="search" class="form-inline">
			<div class="form-group">
				<label>Name:</label> 
				<input class="form-control" id="name" type="text" name="name" />
			</div>
			<div class="form-group">
				<label>From Year:</label> 
				<input class="form-control" id="fromYear" type="text" name="fromYear" />
			</div>
			<div class="form-group">
				<label>To Year:</label> 
				<input class="form-control" id="toYear" type="text" name="toYear" />
			</div>
			<div class="form-group">
				<label>Genre:</label> 
				<select class="form-control" id="genre"
					name="genre">
					<option value=""></option>
					<option value="action">Action</option>
					<option value="adventure">Adventure</option>
					<option value="comedy">Comedy</option>
					<option value="crime">Crime</option>
					<option value="drama">Drama</option>
					<option value="fantasy">Fantasy</option>
					<option value="western">Western</option>
				</select>
			</div>
			<br><br><br>
			<center><input type="submit" id="submitButton" class="btn btn-primary"></center>
		</form>
	</div>
	<br><br>
	<div class="container" id="searchResult">
		<h2>Search Results:</h2>
		<table class="table hover-table" id="movieResult">
		<tr><th>Name</th><th>Year</th><th>Genre</th><th>Director</th><th>Runtime</th></tr>
		</table>
	</div>

	<br><br><br><br>
	<jsp:include page="../jspFragments/footer.jsp" />
</body>
</html>