<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<c:set var="curPage"
	value="${requestScope['javax.servlet.forward.request_uri']}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Quartel</title>
<link rel="stylesheet"
	href="${basePath}/public/vendor/font_awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${basePath}/public/vendor/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="${basePath}/public/css/main.css">
<style>
body {
	background-image: url(${basePath}/public/img/background.jpg);
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
</head>
<body>

	<div class="container">
		<div class="row">
			<form class="form-box margin-top-100" action="${basePath}/login"
				method="POST">
				<h3>LOGIN</h3>
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">
							<span class="fa fa-user"></span>
						</div>
						<input type="text" class="form-control" name="login" value=""
							placeholder="Usuário" required>
					</div>
				</div>
				<div class="form-group">
					<label class="sr-only">Senha</label>
					<div class="input-group">
						<div class="input-group-addon">
							<span class="fa fa-lock"></span>
						</div>
						<input type="password" class="form-control" name="senha" value=""
							placeholder="Senha" required>
					</div>
				</div>
				<button type="submit" class="btn btn-block btn-green"
					style="margin-bottom: 10px; display: block">Entrar</button>
				<c:if test="${param.error}">
					<br>
					<div class="alert alert-danger" role="alert">Login e/ou senha
						incorretos</div>
				</c:if>
			</form>
		</div>
	</div>

	<script src="${basePath}/public/vendor/jquery/jquery.min.js"></script>
	<script src="${basePath}/public/vendor/popper.js/popper.min.js"></script>
	<script src="${basePath}/public/vendor/bootstrap/bootstrap.min.js"></script>
	<script src="${basePath}/public/js/main.js"></script>
</body>
</html>
