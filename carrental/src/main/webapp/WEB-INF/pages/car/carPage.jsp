<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Page</title>
<style type="text/css">
#order_container {
	visibility: visible;
	opacity: 1;
	transition: visibility 0s, opacity 0.5s linear;
}

#order_container.hide {
	visibility: hidden;
	opacity: 0;
}
</style>
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

				<button onclick="displayOrderForm()" id="place_order_btn"
					class="btn btn-success mt-4">Place Order</button>

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
								<h5>${requestScope.car.carModel}</h5>
							</td>
						</tr>
						<tr>
							<td>
								<h4>
									<b>Release Year</b>
								</h4>
							</td>
							<td>
								<h5>${requestScope.car.carReleaseYear}</h5>
							</td>
						</tr>
						<tr>
							<td>
								<h4>
									<b>Color</b>
								</h4>
							</td>
							<td>
								<h5>${requestScope.car.carColor}</h5>
							</td>
						</tr>
						<tr>
							<td>
								<h4>
									<b>Company</b>
								</h4>
							</td>
							<td>
								<h5>${requestScope.car.carCompany}</h5>
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

		<!-- Error & Confirming Messages Container -->
		<div class="container">
			<c:if test="${not empty requestScope.invalidLogin}">
				<h3 class="border border-danger">Please Login first Or Create Account</h3>
			</c:if>

			<c:if test="${not empty requestScope.orderSaved}">
				<h3  class="border border-success">Order Saved Successfully</h3>
			</c:if>
			<c:if test="${not empty requestScope.orderFailed}">
				<h3  class="border border-danger">Failed to Save Order</h3>
			</c:if>
		</div>

		<div id="order_container" class="hide row">

			<div class="container py-4">
				<form class="row" id="order_form" name="confirm-order"
					action="car-rental" method="post">
					<input type="hidden" name="controller" value="confirmOrder">
					<input type="hidden" name="carId"
						value="<c:out value="${requestScope.car.carId}"/>" />
					<div class="form-group col-4">
						<h3 class="label">Order Date</h3>
						<input class="form-control form-control-lg" type="date"
							name="order_date" id="order-date" required />
					</div>
					<div class="form-group col-4">
						<h3 class="label">Returning Date</h3>
						<input class="form-control form-control-lg" type="date"
							name=return_date id="returning-date" required />
					</div>
					<div class="form-group col-4  my-auto">
						<input style="width: 200px" class="btn btn-lg btn-primary"
							type="submit" name="order" value="Confirm Order" />
					</div>
					<!-- onclick="return orderFormValidation()"  -->
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		// Run when the page load auto
		(function() {

			let placeOrderBtn = document.getElementById('place_order_btn');
			let carQuantity = "${requestScope.car.quantity}";
			if (carQuantity <= 0 ) {
				placeOrderBtn.disabled = true;
			} else {
				placeOrderBtn.disabled = false;
			}
		})();

		// Run when it is called
		function displayOrderForm() {
			let user = "${sessionScope.user}";
			let orderContainer = document.getElementById('order_container');
			if (user) {
				orderContainer.classList.remove('hide');
			} else {
				alert("Please Login first Or Create Account to place an Order");
				orderContainer.classList.add('hide');
			}
		}
	</script>
</body>
</html>