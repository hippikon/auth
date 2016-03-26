<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Auth - Sitemap</title>
</head>
<body>
	<jsp:include page="/digital/places/home.jsp" />
	<h3 align="center">Sitemap</h3>
	<table width="50%" align="center" border="1">
		<tr>
			<td align="center" >
				Add user
			</td>
			<td>
				<a href="http://localhost:8080/auth/user/add">http://localhost:8080/auth/user/add</a>
			</td>
		</tr>
		<tr>
			<td align="center" >
				Update user
			</td>
			<td>
				<a href="http://localhost:8080/auth/user/update">http://localhost:8080/auth/user/update</a>
			</td>
		</tr>
		<tr>
			<td align="center" >
				Search for user
			</td>
			<td>
				<a href="http://localhost:8080/auth/user/search">http://localhost:8080/auth/user/search</a>
			</td>
		</tr>
	</table>
</body>
</html>