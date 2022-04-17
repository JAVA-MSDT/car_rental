<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/navbar.jsp" />
	<section class="h-100" style="background-color: #eee;">
		<div class="container py-5">
			<div class="row">
				<div class="col-lg-4">
					<div class="card mb-4">
						<div class="card-body text-center">
							<c:if test="${sessionScope.user.userRole eq 'ADMIN'}">
								<img src="${pageContext.request.contextPath}/img/admin.png"
									alt="avatar" class="rounded-circle img-fluid"
									style="width: 150px;">
							</c:if>
							<c:if test="${sessionScope.user.userRole eq 'USER'}">
								<img src="${pageContext.request.contextPath}/img/user.png"
									alt="avatar" class="rounded-circle img-fluid"
									style="width: 150px;">
							</c:if>
							<h5 class="my-3">${sessionScope.user.userName}</h5>
							<p class="text-muted mb-1">Full Stack Developer</p>
							<p class="text-muted mb-4">${sessionScope.user.userAddress}</p>
						</div>
					</div>
					<div class="card mb-4 mb-lg-0">
						<div class="card-body p-0">
							<ul class="list-group list-group-flush rounded-3">
								<li
									class="list-group-item d-flex justify-content-between align-items-center p-3">
									<i class="fas fa-globe fa-lg text-warning"></i>
									<p class="mb-0">https://mdbootstrap.com</p>
								</li>
								<li
									class="list-group-item d-flex justify-content-between align-items-center p-3">
									<i class="fab fa-github fa-lg" style="color: #333333;"></i>
									<button class="btn btn-primary">My Orders</button>
								</li>
								<li
									class="list-group-item d-flex justify-content-between align-items-center p-3">
									<i class="fab fa-twitter fa-lg" style="color: #55acee;"></i>
									<button class="btn btn-success">My Archived Orders</button>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-lg-8">
					<div class="card mb-4">
						<div class="card-body">
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Full Name</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${sessionScope.user.userName}</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Email</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${sessionScope.user.userEmail}</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Phone</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">(097) 234-5678</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Mobile</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">(098) 765-4321</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Address</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${sessionScope.user.userAddress}</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>