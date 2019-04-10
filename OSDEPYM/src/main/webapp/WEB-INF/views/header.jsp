<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<head>
<title>Spring MVC Example</title>

<link href="/OSDEPYM/resources/core/css/bootstrap.min.css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<script src="/OSDEPYM/resources/core/js/bootstrap.min.js"></script>
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/persona/add" var="urlAddPersona" />

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">Spring MVC - Bootstrap Example</a>
		</div>
		<!--  <div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlAddPersona}">Agregar Persona</a></li>
			</ul>
		</div>-->
	</div>
</nav>