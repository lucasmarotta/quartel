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
			<h4 class="card-title">Cadastrar Armamento</h4>
		</div>
		<div class="card-body">

			<form:form action="${basePath}/armamento/cadastrar" method="POST"
				modelAttribute="armamentoForm">

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

				<spring:bind path="serie">
					<div class="form-group">
						<div class="input-group ${status.error ? 'is-invalid':''}">
							<span class="input-group-addon fa fa-barcode"></span>
							<form:input type="text" path="serie"
								class="form-control ${status.error ? 'is-invalid':''}"
								placeholder="Descrição" required="true"></form:input>
						</div>
						<div class="invalid-feedback ${status.error ? 'is-invalid':''}">
							<form:errors path="serie"></form:errors>
						</div>
					</div>
				</spring:bind>

				<spring:bind path="modelo">
					<div class="form-group">
						<div class="input-group ${status.error ? 'is-invalid':''}">
							<span class="input-group-addon fa fa-tag"></span>
							<form:input type="text" path="modelo"
								class="form-control ${status.error ? 'is-invalid':''}"
								placeholder="Modelo" required="true"></form:input>
						</div>
						<div class="invalid-feedback ${status.error ? 'is-invalid':''}">
							<form:errors path="modelo"></form:errors>
						</div>
					</div>
				</spring:bind>

				<spring:bind path="fabricante">
					<div class="form-group">
						<div class="input-group ${status.error ? 'is-invalid':''}">
							<span class="input-group-addon fa fa-tag"></span>
							<form:input type="text" path="fabricante"
								class="form-control ${status.error ? 'is-invalid':''}"
								placeholder="Fabricante" required="true"></form:input>
						</div>
						<div class="invalid-feedback ${status.error ? 'is-invalid':''}">
							<form:errors path="fabricante"></form:errors>
						</div>
					</div>
				</spring:bind>

				<button type="submit" class="btn btn-block btn-green">Cadastrar</button>

			</form:form>

		</div>
	</div>
</div>

<jsp:include page="../templates/footer.jsp" />
