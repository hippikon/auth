<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Auth - View All Pages</title>
</head>
<body>
	<jsp:include page="../home.jsp" />
	<table border="1" cellpadding="15" width="30%" align="center">
	<tr>
	<td>
		User Names Added so far : <br/>
		<sql:query var="rs" dataSource="jdbc/userie">
		select username from users
		</sql:query>
		
		<c:forEach var="row" items="${rs.rows}">
		    ${row.username}<br/>
		</c:forEach>
		
		<a href="/auth/user/add">Return to add user</a>
	</td>
	</tr>
	</table>	
</body>
</html>