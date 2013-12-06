<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="utf-8">
<title>Test</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<style>
#sortable {
	list-style-type: none;
	margin: 0;
	padding: 0;
	width: 100%;
}

#sortable li {
	margin: 0 3px 3px 3px;
	padding: 0.4em;
	padding-left: 1.5em;
	font-size: 1.4em;
	height: 18px;
}

#sortable li span {
	position: absolute;
	margin-left: -1.3em;
}
</style>
<script>
	$(function() {
		$("#sortable").sortable();
		$("#sortable").disableSelection();
	});

	$(document).ready(function() {
		$('#sortable').sortable({
			update : function(event, ui) {
				var newOrder = $(this).sortable('toArray').toString();
				$.post('updatepositions', {
					order : newOrder
				});
			}
		});
	});
</script>
</head>
<body>
<body>
	<h2>Persistent sort</h2>
	<c:choose>
		<c:when test="${not empty objects}">
			<ul id="sortable">
				<c:forEach var="object" items="${objects}">
					<li class="ui-state-default" id="object-${object.id}">${object.content}</li>
				</c:forEach>
			</ul>
		</c:when>
		<c:otherwise>
			<p>No objects found.</p>
		</c:otherwise>
	</c:choose>
</body>
</html>