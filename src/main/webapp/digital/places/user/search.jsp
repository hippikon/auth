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
		<input type="text" name="usearch"/>
		<input type="submit"/>&nbsp;
	</form:form>

	<form:form method="get" action="/auth/role/add">
		<c:forEach items="${searchUser}" var="item" varStatus="index">
			 <input type="radio" id="${item.username}" onClick="document.getElementById('uname').value='${item.username}';"/>&nbsp;
		    ${item.username}
		    <br>
		</c:forEach>

		<input type="hidden" name="uname" id="uname" value=""/>
		<input type="submit" value="Edit Roles" /> 
		<input type="submit" value="Update User" onClick="alert(document.getElementById('uname').value);document.forms(1).action='/auth/user/update'" /> 
	</form:form>

	<br/>


</body>
</html>