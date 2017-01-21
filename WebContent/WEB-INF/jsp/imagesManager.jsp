<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:head> Images manager </t:head>

<!--  DROP-DOWN UPLOAD MENU  -->
<script>
	$(document).ready(function() {

		/* hide upload menu on page load */
		$("#file").hide();
		$("#submit").hide();

		/* when button is clicked, show upload menu */
		$("button").click(function() {
			$("#file").toggle(500);
			$("#submit").toggle(500);
		});

		/* when a file is selected, enable submit button and validate file size and extension */
		$("#file").on("change", function() {
					
			/* get file extension */
		    var filename = $(this).val();
		    var extension = filename.substr(filename.lastIndexOf('.')+1);
		    
		    /* get size of selected file */
			var size = this.files[0].size;
		    
		    /* if file is not an image, display error message and reset file input */
		    var array = ['jpeg', 'jpg', 'png', 'gif', 'bmp'];
		    
		    if ($.inArray (extension, array) == -1) {
		     alert ("This file format is not supported")
		   	 this.value = null;
		        }
		    
			/* if file>1MB, display error message and reset file input */
			else if (size > 1048576) {	
				alert("Allowed file size exceeded. (Max. 1 MB)")
				this.value = null;
				}
			
			/* if file size and type are ok, enable submit button */
			else {
				$("#submit").prop('disabled', !$(this).val());	
				}
			});
						
		});
</script>


<t:ADMIN>
	<!-- loop through all files in img folder -->
	<c:forEach var="imgName" items="${imgsNames}">
		<table>
		<tbody>
			<tr>
				<td>
					<!-- display all images available in the folder --> 
					<c:set var="imgURL" value="${pageContext.request.contextPath}/resources/img/${imgName}" />
					<img src="${imgURL}" height="100" width="150" />
				</td>

				<!-- add delete command for each image -->
					<td>
						<form
							action="${pageContext.request.contextPath}/imagesManager/delete"
							method="post">
							<input type="hidden" name="imgName" value="${imgName}"> 
							<input type="submit" onclick="if(!confirm('This file will be deleted')){return false;}" value="Delete" class="btn btn-danger"/>
						</form>
					</td>
				</tr>
		</tbody>
		</table>
	</c:forEach>
	
	<!-- save new file on HD -->
	<table>
		<tr>
			<td><button id="button" class="btn btn-success">
					<span class="glyphicon glyphicon-upload" aria-hidden="true">
					</span> Upload new image
				</button></td>
		</tr>

		<form action="${pageContext.request.contextPath}/imagesManager/upload"
			method="post" enctype="multipart/form-data">

			<tr>
				<td><input type="file" id="file" name="file" /></td>
			</tr>

			<tr>
				<td><input type="submit" id="submit" class="btn btn-success" disabled></td>
			</tr>
		</form>

	</table>
	
	<!-- display message for validation, succesfull upload or delete -->
	<p class="bg-warning">${message}</p>
	
	<!-- BACK button -->
	<FORM><INPUT Type="button" VALUE="BACK" onClick="history.go(-1);return true;"></FORM>

</t:ADMIN>