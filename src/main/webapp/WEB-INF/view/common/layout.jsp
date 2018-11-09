<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>
	<%@ include file="/WEB-INF/view/common/basicLib.jsp" %>

<script src="/js/jquery-3.3.1.min.js"></script>
<link href="/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<script src="https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js"></script> <!-- js cookie : https://github.com/js-cookie/js-cookie -->

<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
</head>

<body>


	<%-- 지시자 --%>
<%-- 	<%@ include file="/WEB-INF/view/common/header.jsp" %> --%>
	<tiles:insertAttribute name="header"/>

	<div class="container-fluid">
		<div class="row">

	<%-- 지시자 --%>
<%-- 	<%@ include file="/WEB-INF/view/common/left.jsp" %> --%>
	<tiles:insertAttribute name="left"/>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<tiles:insertAttribute name="content"/>
				
				
			</div>
		</div>
	</div>
</body>
</html>




		
