<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Auth - Add Role</title>
	<link href='<c:url value="/lib/main.css" />' rel="stylesheet"/>
	<script language="Javascript">
		function transfer(srcBox,destBox)
		{
			if (srcBox.selectedIndex > -1)
			{
				var selOption = srcBox.options[srcBox.selectedIndex];
				destBox.add(selOption);
			}	
		}
	</script>

</head>
<body>
	<jsp:include page="../home.jsp" />
	<table border="1" cellpadding="15" width="80%" align="center">
	<tr>
	<td>
	Add Roles for User<br/>
	<form:form method="post" modelAttribute ="userrole" >
		<table>
		<tr>
			<td colspan=3>
			Username : ${userrole.username}
			</td>
		</tr>
		<tr>
			<td>
				<table border="1">
					<tr>
						<th align="center">Select Role</td>
						<th align="center">Role Name</td>
						<th align="center">Role Enabled</td>
					</tr>
					<c:forEach items="${userrole.srids}" var="srid" varStatus="c">
					<tr>
						<td align="center">
						   <input type="checkbox" name="srids[${c.index}].selected" ${srid.selected} <c:if test="${not empty srid.selected}">disabled</c:if>/>
						</td>
						<td>${srid.role}
							<input type="hidden" name="srids[${c.index}].roleid" value="${srid.roleid}" />
							<input type="hidden" name="srids[${c.index}].upsertid" value="${srid.upsertid}" />
						</td>
						<td align="center"><input type="checkbox" name="srids[${c.index}].stren" checked <c:if test="${not empty srid.selected}">disabled</c:if>/></td>
					</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan=3 align="center">
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