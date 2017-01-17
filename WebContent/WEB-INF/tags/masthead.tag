<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="blog-masthead">
	<div class="container">
		<nav class="blog-nav">
			<a class="blog-nav-item" href="${pageContext.request.contextPath}/home">Home</a>
			
			<!-- LOGIN link -->
			<sec:authorize access="!isAuthenticated()">
				<a class="blog-nav-item"
					href="${pageContext.request.contextPath}/login">Log-in </a>
			</sec:authorize>

			<!-- if logged user is Admin, display LOGOUT and ADMIN links -->
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<a class="blog-nav-item"
					href="${pageContext.request.contextPath}/logout">Log-out </a>
				<a class="blog-nav-item"
					href="${pageContext.request.contextPath}/admin">Admin </a>
			</sec:authorize>

		</nav>
	</div>
</div>
