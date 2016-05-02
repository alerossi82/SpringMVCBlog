<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title><jsp:doBody /></title>

<!-- Map css files using tag spring:url -->

<!-- Bootstrap core CSS -->
<spring:url value="/resources/bootstrap.min.css" var="bootstrapminCSS" />
<link href="${bootstrapminCSS}" rel="stylesheet" />

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<spring:url value="/resources/ie10-viewport-bug-workaround.css" var="bugworkaroundCSS" />
<link href="${bugworkaroundCSS}" rel="stylesheet" />

<!-- Custom styles for this template -->
<spring:url value="/resources/blog.css" var="blogCSS" />
<link href="${blogCSS}" rel="stylesheet" />

<!-- JQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js">
</script>

<script>
	/* JQuery function for sidebar */
	/* the sidebar initially shows 3 articles only */
	$(document).ready(function() {
		/* clicking on more, the full list is displayed, button more disappears and button less shows up */
		$(".more").click(function() {
			$(".more").hide();
			$(".hidden_items").slideDown("slow");
		});
		/* clicking less, hidden_items hides and less hide, more shows up */
		$(".less").click(function() {
			$(".hidden_items").hide();
			$(".more").show();
		});
	});
</script>

<script>
	$(document).ready(function() {
		$("#user").click(function() {
			$(".blog-nav-list").toggle();
		});
	});
</script>

</head>
