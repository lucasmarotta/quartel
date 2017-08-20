<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<c:set var="curPage" value="${requestScope['javax.servlet.forward.request_uri']}"/>']}"/>

<jsp:include page="templates/header.jsp" />


	<div class="container">
		<div class="card">
			<div class="card-header">
				<h4 class="card-title">Configuração Inicial - Cadastra-se como usuário</h4>
			</div>
			<div class="card-body">
				
				<form action="${basePath}/registra_usuario_inicial_form" method="POST">
					
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon fa fa-user"></span>
							<input type="text" name="login" class="form-control" placeholder="Login" required>							
						</div>
					</div>

					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon fa fa-user"></span>
							<input type="text" name="nome" class="form-control" placeholder="Nome" required>							
						</div>
					</div>					

					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon fa fa-lock"></span>
							<input type="text" name="senha" class="form-control" placeholder="Senha" required>							
						</div>
					</div>					

					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon fa fa-lock"></span>
							<input type="text" name="senha_confirma" class="form-control" placeholder="Confirme a senha" required>							
						</div>
					</div>

					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon fa fa-envelope"></span>
							<input type="text" name="email" class="form-control" placeholder="Email" required>							
						</div>
					</div>					
					
					<button type="submit" class="btn btn-green">Prosseguir <span class="fa fa-arrow-right"></span></button>

				</form>

			</div>
		</div>
	</div>


<jsp:include page="templates/footer.jsp" />
