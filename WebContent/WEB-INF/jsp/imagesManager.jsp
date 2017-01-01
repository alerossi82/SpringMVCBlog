<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:head>Images manager</t:head>

<t:ADMIN>
	<!-- loop through all files in img folder -->
	<c:forEach var="imgName" items="${imgsNames}">
	
		<!-- display all images available in the folder -->
		<c:set var="imgURL" value="${pageContext.request.contextPath}/resources/img/${imgName}" />
		<img src= "${imgURL}" height="100" width="150"/>
		
		<!-- add delete command for each image -->
		<form action="${pageContext.request.contextPath}/imagesManager/delete" method="post">
			<input type="hidden" name="imgName" value="${imgName}">
			<input type="submit" value="DELETE" />
		</form>
	</c:forEach>

	<!-- save new file on HD -->
	<form action="${pageContext.request.contextPath}/imagesManager/upload" method="post" enctype="multipart/form-data">

		File name: <input type="file" name="file" /> 
		
		<p>${error}</p>  
		
		<p> <input type="submit" value="upload" /> </p>
	</form>

</t:ADMIN>