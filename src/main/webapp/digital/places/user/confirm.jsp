<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Auth - Confirm User Added</title>
	<link href='<c:url value="/lib/main.css" />' rel="stylesheet"/>
</head>
<body>
	<jsp:include page="../home.jsp" />
	<table border="1" cellpadding="15" width="80%" align="center">
	<tr>
	<td>Auth - Confirm User Added<br/>
	<form:form method="get" action="/auth/role/add" modelAttribute ="uname" >
		<input name="username" value="${username}" readonly/> added successfully
		<input type="submit" name="Add Roles"/>

	</form:form>
	</td>
	</tr>
	</table>	

</body>
</html>