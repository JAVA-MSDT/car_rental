<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car List</title>
</head>
<body>
	<jsp:include page="../common/navbar.jsp" />
	<h1>Cars List Page</h1>
	<%-- Cars Table --%>
	<div class="container">
		<div class="tableContainer">
			<table class="table table-striped">
				<thead class="thead-dark">
					<tr>
						<th>
							<h3>id</h3>
						</th>
						<th>
							<h3>Company</h3>
						</th>
						<th>
							<h3>Color</h3>
						</th>
						<th>
							<h3>Model</h3>
						</th>
						<th>
							<h3>Release Year</h3>
						</th>
						<th>
							<h3>View Car</h3>
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach varStatus="loop" var="car" items="${requestScope.cars}">
						<tr>
							<td>
								<h4>${loop.count}</h4>
							</td>
							<td>
								<h4>${car.carCompany}</h4>
							</td>
							<td>
								<h4>${car.carColor}</h4>
							</td>
							<td>
								<h4>${car.carModel}</h4>
							</td>
							<td>
								<h4>${car.carReleaseYear}</h4>
							</td>
							<td>
								<div class="view-book">
									<form name="view-car" action="car-rental" method="post">
										<input type="hidden" name="controller" value="viewCar">
										<input class="btn btn-success" type="submit" name="view"
											value="View Car" /> <input
											type="hidden" name="carId"
											value="<c:out value="${car.carId}"/>" />
									</form>
								</div>
							</td>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>