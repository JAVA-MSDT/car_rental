<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>Server Error</title>
<style type="text/css">
.error-container {
	background-image: url("/img/500.png");
	background-repeat: round;
	background-size: cover;
	color: white;
}
</style>
</head>
<body>
	<jsp:include
		page="${pageContext.request.contextPath}/WEB-INF/pages/common/navbar.jsp" />

	<div
		class="container-fluid d-flex align-items-center justify-content-center h-100 bg-success error-container">

	</div>
</body>
</html>