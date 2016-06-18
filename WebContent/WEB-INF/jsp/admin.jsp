<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:head>Articles list</t:head>
<t:ADMIN>

<%-- 	<p>
		<a href="${pageContext.request.contextPath}/newAccount.jsp"><h3>CREATE
				NEW USER</h3></a>
	</p> --%>
	
	<!-- display update/insert/delete message -->
	<p>${message}</p>
	
	<!-- link to ArticleManagerController for new article -->
	<p>
		<a href="${pageContext.request.contextPath}/ArticleManager?IDarticolo=0"> <h3>INSERT NEW ARTICLE</h3></a>
	</p>

	<!-- from AdminController -->
	<!-- cicle through hvm.listAllArticoli to generate list of all articles -->
	<!-- for each article, create link to pass its ID to ArticleManagerController -->
	<table>
		<c:forEach items="${hvm.listaAllArticoli}" var="art">
			<tr>
				<td>${art.ristorante}</td>
				<td><a
					href="${pageContext.request.contextPath}/ArticleManager?IDarticolo=${art.id}">edit</a></td>
			</tr>
		</c:forEach>
	</table>
</t:ADMIN>