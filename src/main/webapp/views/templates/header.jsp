<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<c:set var="curPage" value="${requestScope['javax.servlet.forward.request_uri']}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Quartel</title>
    <link rel="stylesheet" href="${basePath}/public/vendor/font_awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${basePath}/public/vendor/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="${basePath}/public/vendor/datatables/datatables.min.css">
    <link rel="stylesheet" href="${basePath}/public/css/main.css">
</head>
<body>

	<div class="container">
		<div class="card menu" ${hideMenu ? 'hidden':''}>

			<div class="card-header">
				<h3 class="card-title color-green">
					<span class="fa fa-home"></span> Quartel, ${usuario}
					<a href="${basePath}/logout" class="color-green"><span class="fa fa-sign-out"></span> Sair</a>
				</h3>
			</div>
			<div class="card-body">
				<nav class="navbar navbar-expand-lg">
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item ${curPage.startsWith('/usuario') ? 'active':''}">
								<a class="nav-link btn btn-lg btn-green" href="/usuario"><span class="fa fa-user"></span><br>Usuário</a>
							</li>
							<li class="nav-item ${curPage.startsWith('/reserva') ? 'active':''}">
								<a class="nav-link btn btn-lg btn-green" href="/reserva"><span class="fa fa-archive"></span><br>Reserva</a>
							</li>
							<li class="nav-item ${curPage.startsWith('/armamento') ? 'active':''}">
								<a class="nav-link btn btn-lg btn-green" href="/armamento"><span class="fa fa-fire"></span><br>Armamento</a>
							</li>
							<li class="nav-item ${curPage.startsWith('/municao') ? 'active':''}">
								<a class="nav-link btn btn-lg btn-green" href="/municao"><span class="fa fa-bolt"></span><br>Munição</a>
							</li>
							<li class="nav-item ${curPage.startsWith('/acessorio') ? 'active':''}">
								<a class="nav-link btn btn-lg btn-green" href="/acessorio"><span class="fa fa-binoculars"></span><br>Acessórios</a>
							</li>
							<li class="nav-item ${curPage.startsWith('/militar') ? 'active':''}">
								<a class="nav-link btn btn-lg btn-green" href="/militar"><span class="fa fa-male"></span><br>Militar</a>
							</li>
							<li class="nav-item ${curPage.startsWith('/cautela') ? 'active':''}">
								<a class="nav-link btn btn-lg btn-green" href="/cautela"><span class="fa fa-cubes"></span><br>Cautela</a>
							</li>									      			      			      			      
						</ul>
					</div>
				</nav>				
			</div>	
		</div>
	</div>
