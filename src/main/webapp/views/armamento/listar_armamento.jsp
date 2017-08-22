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
		<div class="card-body">
			<h3 class="card-title">
				<span class="fa fa-fire"></span> Armamento
			</h3>
			<a href="${basePath}/armamento/cadastrar"
				class="btn btn-secondary float-right">Cadastrar Armamento</a>
		</div>
		<div class="card-body">
			<table class="table table-striped table-bordered" cellspacing="0"
				width="100%">
				<thead>
					<tr>
						<th>Reserva</th>
						<th>Série</th>
						<th>Usuário Cadastro</th>
						<th>Modelo</th>
						<th>Fabricante</th>
						<th>Ativo</th>
						<th style="width: 50px;"></th>
						<th style="width: 50px;"></th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${armamentos}" var="armamento">
						<tr>
							<td>${armamento.getReserva().getSigla()}</td>
							<td>${armamento.getSerie()}</td>
							<td>${armamento.getUsuario().getLogin()}</td>
							<td>${armamento.getModelo()}</td>
							<td>${armamento.getFabricante()}</td>
							<td>${armamento.getAtivo() ? 'Ativo':'Inativo'}</td>
							<td class="action"><a
								href="${basePath}/armamento/editar?id=${armamento.getId()}"><span
									class="fa fa-pencil"></span></a></td>
							<td class="action"><a
								href="${basePath}/armamento/deletar?id=${armamento.getId()}"><span
									class="fa ${armamento.getAtivo() ? 'fa-times':'fa-check'}"></span></a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
</div>

<jsp:include page="../templates/footer.jsp" />