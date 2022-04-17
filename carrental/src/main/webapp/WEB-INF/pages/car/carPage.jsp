<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Page</title>
</head>
<body>
	<jsp:include page="../common/navbar.jsp" />
	<div class="container mt-5">
		<div class="row border border-dark rounded">
			<div
				class="col-4 d-flex flex-column justify-content-center align-items-center p-4">
				<div class="mb-5">
					<img class="w-100 h-100"
						src="${pageContext.request.contextPath}/img/redCar.png">
				</div>

				<button class="btn btn-success mt-4">Place Order</button>

			</div>
			<div class="col-8">
				<h2 class="my-4">Car Details</h2>
				<table class="table table-striped">
					<tbody>
						<tr>
							<td>
								<h4>
									<b>Model</b>
								</h4>
							</td>
							<td>
								<h5>${car.carModel}</h5>
							</td>
						</tr>
						<tr>
							<td>
								<h4>
									<b>Release Year</b>
								</h4>
							</td>
							<td>
								<h5>${car.carReleaseYear}</h5>
							</td>
						</tr>
						<tr>
							<td>
								<h4>
									<b>Color</b>
								</h4>
							</td>
							<td>
								<h5>${car.carColor}</h5>
							</td>
						</tr>
						<tr>
							<td>
								<h4>
									<b>Company</b>
								</h4>
							</td>
							<td>
								<h5>${car.carCompany}</h5>
							</td>
						</tr>
						<tr>
							<td>
								<h4>
									<b>Availability</b>
								</h4>
							</td>
							<td class="${car.quantity gt 0 ? 'bg-success' : 'bg-secondary'}">
								<h5 class="text-white">${car.quantity gt 0 ? 'Available' : 'Not Available'}</h5>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>