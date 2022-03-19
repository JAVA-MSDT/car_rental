<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style type="text/css">
.jumbotron-style {
	background-image: url("/img/jumb.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	height: 100%;
	color: white;
}
</style>
</head>
<body class="body">
	<jsp:include page="/WEB-INF/pages/common/navbar.jsp" />
	<div class="container-fluid p-0">

		<div class="jumbotron jumbotron-fluid jumbotron-style">
			<div class="container">
				<h1 class="display-4"><b>Car Rental Project</b></h1>
				<p class="lead">Project written in JAVA as the Back End & JSP as
					the Front End.</p>
			</div>
		</div>
		<div class="container">
			<h2>Project Description</h2>
			<p>
				Video Tutorial for the <a target="_blank"
					href="https://youtube.com/playlist?list=PLiY06-DY3fPHNqyOoGd5Srfkfe4HLCPl2">Project</a>
				and the <a target="_blank"
					href="https://youtube.com/playlist?list=PLiY06-DY3fPH-I0xsb2Cmb6xvTJJpNsJO">Design
					Patterns</a> on <a target="_blank"
					href="https://www.youtube.com/c/AHMEDSAMY">YouTube</a> are in
				<b>Arabic</b> Language
			</p>
			<p>Project on <a target="_blank" href="https://github.com/JAVA-MSDT/car_rental"> GitHub </a> is divided into branches, Each branch is related to one of the videos</p>
			<h3>Project Structure</h3>
			<ul>
				<li>It is an MVC Design</li>
				<ul>
					<li><a target="_blank"
						href="https://youtu.be/ekYoruuPCPM?list=PLiY06-DY3fPH-I0xsb2Cmb6xvTJJpNsJO">MVC,
							Model-View-Controller {Arabic} for all programming language</a></li>
					<li><a target="_blank"
						href="https://youtu.be/XoPTfzbqdXQ?list=PLiY06-DY3fPH-I0xsb2Cmb6xvTJJpNsJO">
							MVC- 01 - Dao Design , Data Access Object {Arabic} for Java
							language</a></li>
					<li><a target="_blank"
						href="https://youtu.be/XOWqd5IHxk0?list=PLiY06-DY3fPH-I0xsb2Cmb6xvTJJpNsJO">
							MVC - 02 - Dao Practical, Data Access Object {Arabic} Java
							language</a></li>
					<li><a target="_blank"
						href="https://youtu.be/smTHnKWTKYs?list=PLiY06-DY3fPH-I0xsb2Cmb6xvTJJpNsJO">
							MVC - Service {Arabic} for Java language</a></li>
				</ul>
				<li>Each layer is divided into it's own package</li>
				<li>Using Front-Controller Pattern to communicate between
					Back-End and Front-End</li>
				<ul>
					<li><a target="_blank"
						href="https://youtu.be/kRxKLV-plFs?list=PLiY06-DY3fPHJ8K1j1Zlk4sLDd5d24U6L">Servlet
							Front Controller</a></li>
					<li><a target="_blank"
						href="https://youtu.be/UY9_n7KAB4Y?list=PLiY06-DY3fPHJ8K1j1Zlk4sLDd5d24U6L">{
							01 } - practical Servlet Front Controller</a></li>
					<li><a target="_blank"
						href="https://youtu.be/399a90Ibobc?list=PLiY06-DY3fPHJ8K1j1Zlk4sLDd5d24U6L">{
							02 } - practical Servlet Front Controller</a></li>
					<li><a target="_blank"
						href="https://youtu.be/FIWhFWoK2WM?list=PLiY06-DY3fPHJ8K1j1Zlk4sLDd5d24U6L">{
							03 } - practical Servlet Front Controller</a></li>
					<li><a target="_blank"
						href="https://youtu.be/huU84I3RnWw?list=PLiY06-DY3fPHJ8K1j1Zlk4sLDd5d24U6L">{
							04 } - practical Servlet Front Controller</a></li>
				</ul>
				<li>Using Bootstrap for Front-End CSS</li>
				<li>Using EmbeddedPostgres for Database test</li>
				<li><b>Work Still on Progress</b></li>
			</ul>
		</div>
	</div>

</body>
</html>