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
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapminCSS" />
<link href="${bootstrapminCSS}" rel="stylesheet" />

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<spring:url value="/resources/css/ie10-viewport-bug-workaround.css" var="bugworkaroundCSS" />
<link href="${bugworkaroundCSS}" rel="stylesheet" />

<!-- JQUERY-UI stylesheet -->
 <spring:url value="/resources/css/jquery-ui.css" var="jqcss" />
<link href="${jqcss}" rel="stylesheet" />
 
<!-- Custom styles for this template -->
<spring:url value="/resources/css/blog.css" var="blogCSS" />
<link href="${blogCSS}" rel="stylesheet" />

<!-- JQUERY -->
<spring:url value="/resources/js/jquery.js" var="jq" />
<script src="${jq}"></script>

<spring:url value="/resources/js/jquery-ui.js" var="jqui" />
<script src="${jqui}"></script>



<!-- JAVASCRIPT -->

<!-- sidebar -->
<script>
	/* the sidebar initially shows 3 articles only */
	$(document).ready(function() {
		
		/* clicking on more, the full list is displayed, button more disappears and button less shows up */
		$(".more").click(function() {
			$(".more").hide();
			$(".hidden_items").slideDown("slow");
		});
		/* clicking less, hidden_items hides and button less hide, button more shows up */
		$(".less").click(function() {
			$(".hidden_items").hide();
			$(".more").show();
		});
	});
</script>

<!-- datepicker -->
<script>
	$(document).ready(function() {
		$("#datepicker").datepicker({
			dateFormat : "dd/mm/yy"
		});
	});
</script>


</head>
