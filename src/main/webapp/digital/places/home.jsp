<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<link href="/digital/places/main.css" rel="stylesheet"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
	String url = request.getRequestURL().toString();
	String uri = request.getRequestURI().toString();
	String context = request.getContextPath().toString();
	
	String home = url.substring(0,url.indexOf(uri)) + context;
%>	

	<c:url value="/o/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>


<h5><a href="<%= home %>">Home</a></h5>
<h5 align="right"><a href="javascript:formSubmit()">Logout</a></h5>
