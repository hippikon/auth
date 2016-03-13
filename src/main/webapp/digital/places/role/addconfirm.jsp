<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Auth - Confirm Roles Added for User</title>
	<link href='<c:url value="/lib/main.css" />' rel="stylesheet"/>
</head>
<body>
	<jsp:include page="../home.jsp" />
	<table border="1" cellpadding="15" width="80%" align="center">
	<tr>
	<td>Auth - Confirm Roles Added for User<br/>
		<input name="username" value="${userrole.username}" readonly/> added successfully
		<input type="submit" />
	</td>
	</tr>
	</table>	

</body>
</html>