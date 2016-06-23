<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/" %>
<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<td>Auth - Roles for <b>${userrole.username}</b> updated successfully
		<sql:query var="rs" dataSource="jdbc/userie">
		select r.role,ur.rolestartdate,ur.roleenddate,ur.enabled from user_roles ur, roles r where ur.username = '${userrole.username}' and ur.roleid = r.roleid
		</sql:query>
		<br/><br/>
		<table border="1">
		<tr>
		<th>Role</th>
		<th>Start Date</th>
		<th>End Date</th>
		<th>Enabled</th>
		</tr>
		<c:forEach var="row" items="${rs.rows}">
				<tr>
				<td>${row.role}</td>
				<td><fmt:formatDate value="${row.rolestartdate}" pattern="dd-MM-yyyy" /></td>
				<td><fmt:formatDate value="${row.roleenddate}" pattern="dd-MM-yyyy" /></td>
				<td>${row.enabled}</td>
				</tr>
		</c:forEach>
		</table>
		<br/>
	</td>
	</tr>
	</table>	

</body>
</html>