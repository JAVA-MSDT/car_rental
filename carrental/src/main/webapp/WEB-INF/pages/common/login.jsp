<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>Car Rental Login</title>
<meta charset="utf-8">
<meta name="description" content="Car Rental Project">
<meta name="author" content="Ahmed Samy">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css">
.container-background {
	background-image: url("/img/jumb.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	height: 100%;
}
</style>
</head>

<body>

	<jsp:include
		page="${pageContext.request.contextPath}/WEB-INF/pages/common/navbar.jsp" />

	<div
		class="container-background container-fluid h-100 d-flex justify-content-center align-items-center">

		<div class="border broder-black rounded rounded-3 p-4 w-50 bg-light">
			<div
				class="d-flex flex-column justify-content-center align-items-center">
				<div>
					<img src="${pageContext.request.contextPath}/img/Welcome.png"
						width="250" height="250">
				</div>
				<div class="error-message m-2">
					<c:if test="${not empty requestScope.invalidLogin}">
						<br>
						<h2 style="color: brown">Invalid user Name or Password</h2>
					</c:if>
					<c:if test="${not empty requestScope.blocked}">
						<h2 style="color: brown">User Blocked, Please contact Admin</h2>
					</c:if>
				</div>
			</div>
			<form name="LoginForm" action="car-rental" method="POST">
				<input type="hidden" name="controller" value="login" />
				<div class="mb-3">
					<h3 id="userName-label" class="form-label">User Name</h3>
					<input type="text" class="form-control form-control-lg"
						aria-labelledby="userName-label" id="userName"
						aria-describedby="emailHelp" name="userName"
						pattern="[a-zA-z0-9]+">
					<div id="emailHelp" class="form-text">We'll never share your
						email with anyone else.</div>
				</div>
				<div class="mb-3">
					<h3 id="password-label" class="form-label">Password</h3>
					<input type="password" class="form-control form-control-lg"
						aria-labelledby="password-label" id="password" name="password"
						pattern="^([a-zA-Z0-9@*#]{4,10})$">
				</div>
				<button id="submit" type="submit" class="btn btn-primary">Submit</button>

			</form>
		</div>

	</div>
</body>
</html>