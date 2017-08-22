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
			<h4 class="card-title">${hideMenu ? 'Configuração Inicial - Cadastro de seus dados militares': 'Cadastro de militar'}</h4>
		</div>
		<div class="card-body">

			<form:form
				action="${basePath}${hideMenu ? '/login/registra_militar_inicial': '/militar/cadastrar'}"
				method="POST" modelAttribute="militarForm">

				<spring:bind path="reserva">
					<div class="form-group">
						<label for="reserva">Reserva</label>
						<div class="input-group ${status.error ? 'is-invalid':''}">
							<span class="input-group-addon fa fa-archive"></span>
							<form:select path="reserva" items="${reservaSelect}"
								class="form-control ${status.error ? 'is-invalid':''}"
								required="true" />
						</div>
						<div class="invalid-feedback ${status.error ? 'is-invalid':''}">
							<form:errors path="reserva"></form:errors>
						</div>
					</div>
				</spring:bind>

				<c:if test="${!usuarioSelect.isEmpty()}">
					<spring:bind path="usuario">
						<div class="form-group">
							<label for="usuario">Login ${usuarioSelect.size() > 1 ? 'Opcional':''}</label>
							<div class="input-group ${status.error ? 'is-invalid':''}">
								<span class="input-group-addon fa fa-user"></span>
								<form:select path="usuario" items="${usuarioSelect}"
									class="form-control ${status.error ? 'is-invalid':''}" />
							</div>
							<div class="invalid-feedback ${status.error ? 'is-invalid':''}">
								<form:errors path="usuario"></form:errors>
							</div>
						</div>
					</spring:bind>
				</c:if>

				<spring:bind path="posto">
					<div class="form-group">
						<label for="posto">Posto/Graduação</label>
						<div class="input-group ${status.error ? 'is-invalid':''}">
							<span class="input-group-addon fa fa-mortar-board"></span>
							<form:select path="posto" items="${postoSelect}"
								class="form-control ${status.error ? 'is-invalid':''}"
								required="true" />
						</div>
						<div class="invalid-feedback ${status.error ? 'is-invalid':''}">
							<form:errors path="posto"></form:errors>
						</div>
					</div>
				</spring:bind>

				<spring:bind path="nomeGuerra">
					<div class="form-group">
						<div class="input-group ${status.error ? 'is-invalid':''}">
							<span class="input-group-addon fa fa-male"></span>
							<form:input type="text" path="nomeGuerra"
								class="form-control ${status.error ? 'is-invalid':''}"
								placeholder="Nome de Guerra"></form:input>
						</div>
						<div class="invalid-feedback ${status.error ? 'is-invalid':''}">
							<form:errors path="nomeGuerra"></form:errors>
						</div>
					</div>
				</spring:bind>

				<c:choose>
					<c:when test="${hideMenu}">
						<button type="submit" class="btn btn-green">
							Prosseguir <span class="fa fa-arrow-right"></span>
						</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn btn-block btn-green">Cadastrar</button>
					</c:otherwise>
				</c:choose>

			</form:form>

		</div>
	</div>
</div>

<jsp:include page="../templates/footer.jsp" />
