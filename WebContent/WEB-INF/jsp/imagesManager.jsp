<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Images manager</title>
</head>

<body>

	<!-- display all images available in the folder -->
	<c:forEach var="imgName" items="${imgsNames}">
		<p> <img src="${pageContext.request.contextPath}/resources/img/${imgName}" height="100" width="150"/> </p>
		<p>${imgName}</p>
	</c:forEach>

	<form action="${pageContext.request.contextPath}/imagesManager" method="post" enctype="multipart/form-data">
		File name: <input type="file" name="file" /> 
		<p> <input type="submit" value="upload" /> </p>
	</form>

</body>

</html>