<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:head>View Article</t:head>
<t:TEMPLATE>
	<div class="blog-post">
		<h2 class="blog-post-title">${hvm.articolo.ristorante}</h2>
		<p class="blog-post-meta">${hvm.articolo.data}</p>

		<p class="voto">
			RATING:
			<!-- add as many stars as per IDVoto -->
			<c:forEach begin="1" end="${hvm.articolo.voto.ID}">
				<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
			</c:forEach>
			<!-- remaining stars are empty -->
			<c:forEach begin="1" end="${5-hvm.articolo.voto.ID}">
				<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
			</c:forEach>
		</p>

		<img src="${pageContext.request.contextPath}/resources/img/${hvm.articolo.foto}"
			style="width: 300px; float: left; margin-right: 20px;"
			class="img-thumbnail">

		<dl>
			<dt>Cuisine:</dt>
			<dd>${hvm.articolo.cucina.nome}</dd>
			<dt>Location:</dt>
			<dd>${hvm.articolo.area.nome}</dd>
			<dt>Price:</dt>
			<dd>${hvm.articolo.prezzo.nome}</dd>
		</dl>

		<!-- set body of the article -->
		<p>${hvm.articolo.articolo}</p>
	</div>
	<!-- /.blog-post -->

	<!-- Back button, return to the home page stored in session -->
	<nav>
	<ul class="pager">
		<li><a href="${pageContext.request.contextPath}/home?page=${sessionScope.page}">Back</a></li>
	</ul>
	</nav>

</t:TEMPLATE>