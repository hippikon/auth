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
						<th align="center">Select Role</th>
						<th align="center">Role Name</th>
						<th align="center">Start Date</th>
						<th align="center">End Date</th>
						<th align="center">Role Enabled</th>
					</tr>
					<c:forEach items="${userrole.allroles}" var="urole" varStatus="c">
					<tr>
						<td align="center">
						   <input type="checkbox" name="allroles[${c.index}].selected" ${urole.selected} <c:if test="${not empty urole.selected}">disabled</c:if>/>
						</td>
						<td>${urole.roleName}
							<input type="hidden" name="allroles[${c.index}].roleid" value="${urole.roleid}" />
							<input type="hidden" name="allroles[${c.index}].upsertid" value="${urole.upsertid}" />
						</td>
						<td>
							<c:choose>
								<c:when test="${not empty urole.selected}">
								  ${urole.rolestartdate}
								</c:when>
								<c:otherwise>
									<form:select path="rolesddd">
									<form:options items="${urole.UDD}" />
									</form:select>/<form:select path="rolesdmm">
									<form:options items="${urole.UMM}" />
									</form:select>/<form:select path="rolesdyyyy">
									<form:options items="${urole.UYYYY}" />
									</form:select>  
									<form:errors path="rolesddd" cssStyle="color:red;"/><br/>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${not empty urole.selected}">
								  ${urole.roleenddate}
								</c:when>
								<c:otherwise>
									<form:select path="roleeddd">
									<form:options items="${urole.UDD}" />
									</form:select>/<form:select path="roleedmm">
									<form:options items="${urole.UMM}" />
									</form:select>/<form:select path="roleedyyyy">
									<form:options items="${urole.UYYYY}" />
									</form:select>  
									<form:errors path="roleeddd" cssStyle="color:red;"/><br/>
								</c:otherwise>
							</c:choose>
						</td>
						<td align="center"><input type="checkbox" name="allroles[${c.index}].strenabled" checked <c:if test="${not empty role.selected}">disabled</c:if>/></td>
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