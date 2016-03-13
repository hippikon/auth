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

	<form:form method="get" action="/auth/role/add">
	<c:forEach items="${searchUser}" var="item" varStatus="index">
		<input type="Submit" value="Edit Roles" id="${item.username}" onClick="document.getElementById('username').value='${item.username}';"/>&nbsp;
	    ${item.username}
	    <br>
	</c:forEach>
		<input type="hidden" name="username" id="username" value=""/>
	</form:form>

	<br/>


</body>
</html>