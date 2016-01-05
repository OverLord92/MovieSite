<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="sec" --%>
<%-- 	uri="http://www.springframework.org/security/tags"%> --%>
<div class="navbar navbar-static-top">
	<div class="container">
	
		<p class="navbar-brand">Movie Database</p>

		<button class="navbar-toggle" data-toggle="collapse"
			data-target=".navHeaderCollapse">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>

		<div class="collapse navbar-collapse navHeaderCollapse">
			<ul class="nav navbar-nav navbar-right">

				<li class="active">
				<c:url value="/home" var="homeUrl" /> 
					<a href="${homeUrl}">Home</a>
				</li>
				
<!-- 				<sec:authorize access="isAuthenticated()"> -->
					<li><c:url value="/add" var="addUrl" /> 
					<a href="${addUrl}">Add Movie</a></li>
<!-- 				</sec:authorize> -->
				
<!-- 				<sec:authorize access="!isAuthenticated()"> -->
					<li><c:url value="/movies" var="moviesUrl" /> 
					<a href="${moviesUrl}">List of Movies</a></li>
<!-- 				</sec:authorize> -->
				
<!-- 				<sec:authorize access="isAuthenticated()"> -->
					<li><c:url value="/movies" var="moviesUrl" /> 
					<a href="${moviesUrl}">Edit and Delete Movies</a></li>
<!-- 				</sec:authorize> -->
				
				<li><c:url value="/search" var="searchUrl" /> 
				<a href="${searchUrl}">Search Movies</a></li>
				
<!-- 				<sec:authorize access="!isAuthenticated()"> -->
					<li><c:url value="/login" var="loginUrl" /> 
					<a href="${loginUrl}">Login</a></li>
<!-- 				</sec:authorize> -->

<!-- 				<sec:authorize access="isAuthenticated()"> -->
					<li><c:url value="/logout" var="logoutUrl" />
						<a href="${logoutUrl}">Logout</a></li>
<!-- 				</sec:authorize> -->
				
<!-- 				<sec:authorize access="!isAuthenticated()"> -->
					<li><c:url value="/register" var="registerUrl" />
						<a href="${registerUrl}">Register</a></li>
<!-- 				</sec:authorize> -->
			</ul>
		</div>
	</div>
	<hr>
</div>
