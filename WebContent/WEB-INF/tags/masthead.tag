<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="blog-masthead">
	<div class="container">
		<nav class="blog-nav">
			<a class="blog-nav-item" href="${pageContext.request.contextPath}/home">Home</a>
			
			<!-- switch between login and logout if admin is logged in -->
			<c:choose>
				<c:when test="${user=='admin'}">
					<a class="blog-nav-item"
						href="${pageContext.request.contextPath}/logout">Log-out </a>
					<a class="blog-nav-item"
						href="${pageContext.request.contextPath}/admin">Admin </a>
				</c:when>

				<c:otherwise>
					<a class="blog-nav-item"
						href="${pageContext.request.contextPath}/login">Log-in </a>
				</c:otherwise>
			</c:choose>

		</nav>
	</div>
</div>
