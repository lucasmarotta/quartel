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
			<h4 class="card-title">${hideMenu ? 'Configuração Inicial - Cadastre uma reserva inicial': 'Cadastro de reserva'}</h4>
		</div>
		<div class="card-body">

			<form:form
				action="${basePath}${hideMenu ? '/login/registra_reserva_inicial': '/reserva/cadastrar'}"
				method="POST" modelAttribute="reservaForm">

				<spring:bind path="sigla">
					<div class="form-group">
						<div class="input-group ${status.error ? 'is-invalid':''}">
							<span class="input-group-addon fa fa-book"></span>
							<form:input type="text" path="sigla"
								class="form-control ${status.error ? 'is-invalid':''}"
								placeholder="Sigla" required="true"></form:input>
						</div>
						<div class="invalid-feedback ${status.error ? 'is-invalid':''}">
							<form:errors path="sigla"></form:errors>
						</div>
					</div>
				</spring:bind>

				<spring:bind path="descricao">
					<div class="form-group">
						<div class="input-group ${status.error ? 'is-invalid':''}">
							<span class="input-group-addon fa fa-align-justify"></span>
							<form:input type="text" path="descricao"
								class="form-control ${status.error ? 'is-invalid':''}"
								placeholder="Descrição" required="true"></form:input>
						</div>
						<div class="invalid-feedback ${status.error ? 'is-invalid':''}">
							<form:errors path="descricao"></form:errors>
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
