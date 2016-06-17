<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:head>Log-in</t:head>

<t:ADMIN>

	<c:url var="loginUrl" value="/login" />
	<form action="${loginUrl}" method="post">
		
		<!-- if login failed, dispaly error message -->
		<c:if test="${not empty error}">
			<p>${error}</p>
		</c:if>
		
		<!-- if logged out, display logout message -->
		<c:if test="${not empty logout }">
			<p>${logout}</p>
		</c:if>

		<h2>LOG-IN</h2>

		<table>
			<tr>
				<td>USERNAME</td>
				<td><input type="text" name="username" value="" /></td>
			</tr>

			<tr>
				<td>PASSWORD</td>
				<td><input type="password" name="password" value="" /></td>
			</tr>

			<tr>
				<td colspan="2">
				<input type="submit" class="btn btn-default" value="Log in" />
				</td>
			</tr>
		</table>
	</form>
	
</t:ADMIN>
