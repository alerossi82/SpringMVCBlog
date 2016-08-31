<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:head>Home</t:head>

<t:TEMPLATE>
	<!-- generate blog post based on HomeViewModel attribute (hvm) from HomepageController-->
	<!-- cicle through all Articolo objects in listaArticolo -->
	<c:forEach var="articolo" items="${hvm.listaArticoliRM}">
		<div class="blog-post">
		
		<!-- click on article title to open the article -->
			<a
				href="${pageContext.request.contextPath}/viewArticle?ID=${articolo.id}">
				<h2 class="blog-post-title">${articolo.ristorante}</h2>
			</a>
			
			<p class="blog-post-meta">${articolo.data}</p>

			<p class="voto">
				RATING:
				<!-- add as many stars as per IDVoto -->
				<c:forEach begin="1" end="${articolo.voto.ID}">
					<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
				</c:forEach>
				
				<!-- remaining stars are empty -->
				<c:forEach begin="1" end="${5-articolo.voto.ID}">
					<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
				</c:forEach>
			</p>
			
			<!-- add img from folder resources -->
			<img src= "<c:url value="/resources/img/${articolo.foto}"/>"
				style="width: 300px; float: left; margin-right: 20px;"
				class="img-thumbnail">

			<dl>
				<dt>Cuisine:</dt>
				<dd>${articolo.cucina.nome}</dd>
				<dt>Location:</dt>
				<dd>${articolo.area.nome}</dd>
				<dt>Price:</dt>
				<dd>${articolo.prezzo.nome}</dd>
			</dl>

			<!-- set body of the article -->
			<p>${articolo.articolo}</p>
		</div>
		<!-- /.blog-post -->
	</c:forEach>

	<nav>
	<ul class="pager">
		<!-- if page 1, show button Next only -->
		<!-- if last page, show button Previous only -->
		<!-- otherwise, show both buttons -->

		<c:choose>
			<c:when test="${hvm.currentPage>1}">
				<!-- get current page from controller,decrease it by 1 and forward to controller -->
				<li><a href="/SpringMVCBlog/home?page=${hvm.currentPage-1}">Previous</a></li>
			</c:when>
		</c:choose>

		<c:choose>
			<c:when test="${hvm.currentPage<hvm.totPages}">
				<!-- get current page from controller,increase it by 1 and forward to controller -->
				<li><a href="/SpringMVCBlog/home?page=${hvm.currentPage+1}">Next</a></li>
			</c:when>
		</c:choose>

	</ul>
	</nav>
</t:TEMPLATE>