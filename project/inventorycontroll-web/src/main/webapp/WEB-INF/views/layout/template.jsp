<!DOCTYPE html>
<html class="no-js">
<head>
	<meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/main.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="${pageContext.request.contextPath}/resources/lib/jquery/dist/jquery-3.6.0.min.js"></script>
    
	<script type="text/javascript">
	</script>
	<c:set var="titleKey">
	    <tiles:insertAttribute name="title" ignore="true" />
	</c:set>
	<title><spring:message code="${titleKey}" text="Inventory Controll System" /></title>
</head>
<body>
   	<header>
   		<tiles:insertAttribute name="header" />
   	</header>
   	<section>
   		<tiles:insertAttribute name="left-sidebar" />
   		<div class="content-wrapper">
       		<tiles:insertAttribute name="body" />
     	</div>
     	<script src="${pageContext.request.contextPath}/resources/lib/jquery/dist/jquery.blockUI.js"></script>
	</section>
</body>
</html>