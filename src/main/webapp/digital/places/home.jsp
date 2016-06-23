<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/" %>
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

	<table width="100%" cellspacing="2" cellpadding="2">
		<tr>
			<td width="5%">&nbsp;</td>
			<td>
				<h4><a href="<%= home %>">Home</a></h4>
			</td>
			<td>
				<h4 align="right"><a href="javascript:formSubmit()">Logout</a></h4>
			</td>
			<td width="5%">&nbsp;</td>
		</tr>
	</table>
