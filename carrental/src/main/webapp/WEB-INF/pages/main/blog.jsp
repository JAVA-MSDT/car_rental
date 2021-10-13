<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Blog Page</title>
</head>
<body>
	<jsp:include page="../common/navbar.jsp" />
	<h1>Blog Page</h1>
	<%= request.getAttribute("blog_post") %>
</body>
</html>