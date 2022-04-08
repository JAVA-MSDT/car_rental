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
	<h1>User Profile</h1>
	<h2>Welcome Back:<b> "${sessionScope.user.userName}" </b></h2>
	<h3>With Email:<b> "${sessionScope.user.userEmail}" </b></h3>
	<h3>USER:<b> "${sessionScope.user}" </b></h3>
</body>
</html>