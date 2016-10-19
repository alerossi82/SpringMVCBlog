<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="blog-masthead">
	<div class="container">
		<nav class="blog-nav">
			<a class="blog-nav-item" href="${pageContext.request.contextPath}/home">Home</a>
			
			<!-- check if a user is logged in and change the options on the masthead accordingly -->

			<c:choose>
				<c:when test="${user=='anonymousUser'}">
					<a class="blog-nav-item"
						href="${pageContext.request.contextPath}/login">Log-in </a>
				</c:when>

				<c:otherwise>
					<a class="blog-nav-item"
						href="${pageContext.request.contextPath}/logout">Log-out </a>
					<a class="blog-nav-item"
						href="${pageContext.request.contextPath}/admin">Admin </a>
				</c:otherwise>
			</c:choose>

			<%-- <c:if test="${not empty pageContext.request.userPrincipal}">
				<c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
					<a class="blog-nav-item"
						href="${pageContext.request.contextPath}/logout">Log-out </a>
					<a class="blog-nav-item"
						href="${pageContext.request.contextPath}/admin">Admin </a>
    			</c:if>
			</c:if>
			
			<c:if test="${role}">
				<a class="blog-nav-item"
					href="${pageContext.request.contextPath}/logout">Log-out </a>
				<a class="blog-nav-item"
					href="${pageContext.request.contextPath}/admin">Admin </a>
			</c:if>
			
			<c:if test="${not role}">
				<a class="blog-nav-item"
					href="${pageContext.request.contextPath}/login">Log-in </a>
			</c:if> --%>

	<%-- 		<c:choose>
				<c:when test="${isAdmin}">
					<a class="blog-nav-item"
						href="${pageContext.request.contextPath}/logout">Log-out </a>
					<a class="blog-nav-item"
						href="${pageContext.request.contextPath}/admin">Admin </a>
				</c:when>

				<c:otherwise>
					<a class="blog-nav-item"
						href="${pageContext.request.contextPath}/login">Log-in </a>
				</c:otherwise>

			</c:choose> --%>

		</nav>
	</div>
</div>
