<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:head>New User</t:head>
<t:ADMIN>
	<form action="${pageContext.request.contextPath}/ControllerUser" method="post">
		<h2>CREATE NEW ACCOUNT</h2>
		<input type="hidden" name="action" value="newAccount" />

		<table class="newAccountTable">
			<tr>
				<td>E-MAIL</td>
				<td><input type="text" name="email" value="" /></td>
			</tr>
			<tr>
				<td>PASSWORD</td>
				<td><input type="password" name="password" value="" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="ok" class="btn btn-default"/></td>
			</tr>
			<tr>
				<td colspan="2"><a href="${pageContext.request.contextPath}/ControllerAdmin" class="btn btn-default">Back</a></td>
			</tr>
		</table>
	</form>
	
	<p>${model.message}</p>
</t:ADMIN>