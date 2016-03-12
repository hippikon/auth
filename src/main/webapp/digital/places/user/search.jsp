<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Auth - Search User</title>
	<link href='<c:url value="/lib/main.css" />' rel="stylesheet"/>
</head>
<body>
	<jsp:include page="../home.jsp" />
	
	<form:form method="post">
		<input type="text" name="username"/>
		<input type="submit"/>&nbsp;
	</form:form>

	<form:form method="post" action="/auth/role/add">
	<c:forEach items="${searchUser}" var="item">
		<input type="hidden" name="user" value="${item.username}"/>
		<input type="Submit" value="Edit Roles"/>&nbsp;
	    ${item.username}
	    <br>
	</c:forEach>
	</form:form>

	<br/>


</body>
</html>