<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<c:set var="curPage"
	value="${requestScope['javax.servlet.forward.request_uri']}" />

<jsp:include page="../templates/header.jsp" />


<div class="container">
	<div class="card">
		<div class="card-header">
			<h4 class="card-title">Editar Usuário</h4>
		</div>
		<div class="card-body">

			<form:form action="${basePath}/usuario/editar" method="POST"
				modelAttribute="usuarioEditForm">

				<spring:bind path="id">
					<form:input type="hidden" path="id"></form:input>
				</spring:bind>

				<spring:bind path="login">
					<div class="form-group">
						<div class="input-group ${status.error ? 'is-invalid':''}">
							<span class="input-group-addon fa fa-user"></span>
							<form:input type="text" path="login"
								class="form-control ${status.error ? 'is-invalid':''}"
								placeholder="Login" required="true"></form:input>
						</div>
						<div class="invalid-feedback ${status.error ? 'is-invalid':''}">
							<form:errors path="login"></form:errors>
						</div>
					</div>
				</spring:bind>

				<spring:bind path="nome">
					<div class="form-group">
						<div class="input-group ${status.error ? 'is-invalid':''}">
							<span class="input-group-addon fa fa-user"></span>
							<form:input type="text" path="nome"
								class="form-control ${status.error ? 'is-invalid':''}"
								placeholder="Nome" required="true"></form:input>
						</div>
						<div class="invalid-feedback ${status.error ? 'is-invalid':''}">
							<form:errors path="nome"></form:errors>
						</div>
					</div>
				</spring:bind>

				<spring:bind path="senha">
					<div class="form-group">
						<div class="input-group ${status.error ? 'is-invalid':''}">
							<span class="input-group-addon fa fa-lock"></span>
							<form:input type="password" path="senha"
								class="form-control ${status.error ? 'is-invalid':''}"
								placeholder="Senha"></form:input>
						</div>
						<div class="invalid-feedback ${status.error ? 'is-invalid':''}">
							<form:errors path="senha"></form:errors>
						</div>
					</div>
				</spring:bind>

				<spring:bind path="senhaConfirma">
					<div class="form-group">
						<div class="input-group ${status.error ? 'is-invalid':''}">
							<span class="input-group-addon fa fa-lock"></span>
							<form:input type="password" path="senhaConfirma"
								class="form-control ${status.error ? 'is-invalid':''}"
								placeholder="Confirme a senha"></form:input>
						</div>
						<div class="invalid-feedback ${status.error ? 'is-invalid':''}">
							<form:errors path="senhaConfirma"></form:errors>
						</div>
					</div>
				</spring:bind>


				<spring:bind path="email">
					<div class="form-group">
						<div class="input-group ${status.error ? 'is-invalid':''}">
							<span class="input-group-addon fa fa-envelope"></span>
							<form:input type="text" path="email"
								class="form-control ${status.error ? 'is-invalid':''}"
								placeholder="Email" required="true"></form:input>
						</div>
						<div class="invalid-feedback ${status.error ? 'is-invalid':''}">
							<form:errors path="email"></form:errors>
						</div>
					</div>
				</spring:bind>

				<button type="submit" class="btn btn-block btn-green">Salvar</button>

			</form:form>

		</div>
	</div>
</div>

<jsp:include page="../templates/footer.jsp" />
