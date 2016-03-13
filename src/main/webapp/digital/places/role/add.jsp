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
		<table>
		<tr>
			<td colspan=2>
			Username : <form:input path="username" /> 
			<form:errors path="username" cssStyle="color:red;"/>
			</td>
		</tr>
		<tr>
			<td>
				Available Roles<br/>
				<form:select multiple="true" path="role" style="width:150px;height:100px">
					<form:options items="${roles}" />
				</form:select>
				<form:errors path="role" cssStyle="color:red;"/>
			</td>
			<td>
				Selected Roles<br/> 
				<form:select multiple="true" path="selectedRoles" style="width:150px;height:100px" >
					<form:options items="${userroles}" />
				</form:select>
				<form:errors path="role" cssStyle="color:red;"/><br/>
			</td>
		</tr>
		<tr>
			<td colspan=2 align="center">
			<input type="submit"/>
			</td>
		</tr>
		</table>
	</form:form>
	</td>
	</tr>
	</table>	
</body>
</html>