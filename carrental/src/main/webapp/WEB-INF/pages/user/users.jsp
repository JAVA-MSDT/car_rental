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
							<h3>User Name</h3>
						</th>
						<th>
							<h3>Email</h3>
						</th>
						<th>
							<h3>Address</h3>
						</th>
						<th>
							<h3>User Status</h3>
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach varStatus="loop" var="user" items="${requestScope.users}">
						<tr>
							<td>
								<h4>${loop.count}</h4>
							</td>
							<td>
								<h4>${user.userName}</h4>
							</td>
							<td>
								<h4>${user.userEmail}</h4>
							</td>
							<td>
								<h4>${user.userAddress}</h4>
							</td>
							<td>
								<h4>${user.userBlocked}</h4>
							</td>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>