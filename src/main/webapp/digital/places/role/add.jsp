<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Auth - Add Role</title>
	<link href='<c:url value="/lib/main.css" />' rel="stylesheet"/>
</head>
<body>
	<jsp:include page="../home.jsp" />
	<table border="1" cellpadding="15" width="80%" align="center">
	<tr>
	<td>
	Associate User with Roles<br/>
	<form:form method="post" modelAttribute ="userrole" >
		Username : <form:input path="username" /> 
		<form:errors path="username" cssStyle="color:red;"/><br/>
		Available Roles : 
		<form:select multiple="true" path="username" >
			<form:options items="${roles.role}" />
		</form:select>
		<form:errors path="availRoles" cssStyle="color:red;"/><br/>
		Selected Roles : 
		<form:select multiple="true" path="roleid" >
			<form:options items="${userroles.roleid}" />
		</form:select>
		<form:errors path="availRoles" cssStyle="color:red;"/><br/>
		<input type="submit"/>
	</form:form>
	</td>
	</tr>
	</table>	
</body>
</html>