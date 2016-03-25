<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Auth - Add User</title>
	<link href='<c:url value="/lib/main.css" />' rel="stylesheet"/>
</head>
<body>
	<jsp:include page="../home.jsp" />
	<table border="1" cellpadding="15" width="80%" align="center">
	<tr>
	<td>
	Update User <br/>
	<div style="color:red">
	<c:if test="${not empty error}">
	   Error: ${error}
	</c:if>	
	</div>
	<form:form method="post" modelAttribute ="user" >
		Login* : <form:input path="username" /> 
		<form:errors path="username" cssStyle="color:red;"/><br/>
		First Name* : <form:input path="ufname" /> 
		<form:errors path="ufname" cssStyle="color:red;"/><br/>
		Middle Name : <form:input path="umname" /> <br/>
		Last Name* : <form:input path="ulname" />  
		<form:errors path="ulname" cssStyle="color:red;"/><br/>
		Date of Birth* : <form:select path="udobdd">
		    <form:options items="${user.UDD}" />
		</form:select>/<form:select path="udobmm">
		    <form:options items="${user.UMM}" />
		</form:select>/<form:select path="udobyyyy">
		    <form:options items="${user.UDOBY}" />
		</form:select>  
		<form:errors path="udobdd" cssStyle="color:red;"/><br/>
		Start Date* : <form:select path="ustartdatedd">
		    <form:options items="${user.UDD}" />
		</form:select>/<form:select path="ustartdatemm">
		    <form:options items="${user.UMM}" />
		</form:select>/<form:select path="ustartdateyyyy">
		    <form:options items="${user.UYYYY}" />
		</form:select>  
		<form:errors path="ustartdatedd" cssStyle="color:red;"/><br/>
		End Date : <form:select path="uenddatedd">
		    <form:options items="${user.UDD}" />
		</form:select>/<form:select path="uenddatemm">
		    <form:options items="${user.UMM}" />
		</form:select>/<form:select path="uenddateyyyy">
		    <form:options items="${user.UYYYY}" />
		</form:select>  
		<form:errors path="uenddatedd" cssStyle="color:red;"/><br/>
		Status* : <form:select path="enabled">
		    <form:options items="${user.ENABLEDS}" />
		</form:select>  
		<form:errors path="enabled" cssStyle="color:red;"/><br/>
		Email* : <form:input path="uemail" /> 
		<form:errors path="uemail" cssStyle="color:red;"/><br/>
		Password* : <form:input path="password" /> 
		<form:errors path="password" cssStyle="color:red;"/><br/>
		Location* : <form:select path="ulocation">
		    <form:options items="${user.ULOCATIONS}" />
		</form:select> 
		<form:errors path="ulocation" cssStyle="color:red;"/><br/>
		<input type="submit"/>
	</form:form>
	</td>
	</tr>
	</table>	
</body>
</html>