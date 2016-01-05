<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	type="text/css" />
<link rel="stylesheet"
	href="<spring:url value="/resources/CSS/custom.css"/>" type="text/css" />
<link rel="stylesheet"
	href="<spring:url value="/resources/CSS/slide.css"/>" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="<spring:url value="/resources/js/jquery.core.js"/>"></script>
<script type="text/javascript"
	src="<spring:url value="/resources/js/imageSlider.js"/>"></script>
</head>
<body>
	<jsp:include page="../jspFragments/header.jsp" />
	<div class="container">
		<div class="jumbotron">
			<center>
				<h1>Stranica za filmove</h1>
				<h2>Look ma, no web.xml</h2>
			</center>
		</div>

		<div class="row">
			<div class="col-md-6">
				<div id="slider">
					<ul class="slides">
						<li class="slide"><img src="resources/pictures/movie1.jpg"></li>
						<li class="slide"><img src="resources/pictures/movie2.jpg"></li>
						<li class="slide"><img src="resources/pictures/movie3.jpg"></li>
						<li class="slide"><img src="resources/pictures/movie4.jpg"></li>
						<li class="slide"><img src="resources/pictures/movie5.jpg"></li>
						<li class="slide"><img src="resources/pictures/movie6.jpg"></li>
					</ul>
				</div>
			</div>
			<div class="col-md-6">
				<h2>Spring framework</h2>
				<p>Stranica sluzi za vjezbanje dosada stecenog znanja iz Spring
					framework-a. Koristio sam vise modula Springa.</p>
					
				<p>U pocetku je projekat bio podesen sa web.xml-om. U toku razvoja
				sam projekat sa web.xml-a prebacio na Java baziranu konfiguraciju.</p>
				
				<p>Stranicu sam podesio tako da ju obicni posjetioc i prijavljeni 
				korisnici vide na razlicit nacin. Tj prijavljeni korisnik ima dodatne 
				mogucnosti, kao npr dodavanje novih filmova, editovanje i brisanje 
				postojecih filmova.</p>

				Za back end:
				<ul>
					<li>Java</li>
					<li>Spring:
						<ul>
							<li>Core</li>
							<li>Beans</li>
							<li>Context</li>
							<li>Web</li>
							<li>WebMvc</li>
							<li>Jdbc</li>
							<li>Security</li>
							<li>Security Web</li>
						</ul>
					</li>
				</ul>

				Za front end:
				<ul>
					<li>HTML</li>
					<li>CSS:
						<ul>
							<li>Bootstrap</li>
						</ul>
					</li>
					<li>Javascript:
						<ul>
							<li>jQuery</li>
							<li>AJAX</li>
						</ul>
					</li>
				</ul>
				
				Ako zelite mozete posjetiti moj GitHub profil. Link se nalazi footeru.
			</div>
		</div>
	</div>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<jsp:include page="../jspFragments/footer.jsp" />

</body>
</html>