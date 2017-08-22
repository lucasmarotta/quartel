<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<c:set var="curPage" value="${requestScope['javax.servlet.forward.request_uri']}"/>

<jsp:include page="../templates/header.jsp" />

	<div class="container">
		<div class="card">
			<div class="card-body">
				<h3 class="card-title"><span class="fa fa-male"></span> Militares</h3>
				<a href="${basePath}/militar/cadastrar" class="btn btn-secondary float-right">Cadastrar Militar</a>
			</div>
			<div class="card-body">
				<table class="table table-striped table-bordered" cellspacing="0" width="100%">
					<thead><tr>
						<th>Reserva</th>
						<th>Login</th>
						<th>Posto</th>
						<th>Nome de Guerra</th>
						<th style="width:50px;"></th>
					</tr></thead>
					<tbody>

						<c:forEach items="${militares}" var="militar">
							<tr>
								<td>${militar.getReserva().getSigla()}</td>
								<td>${militar.getUsuario().getLogin()}</td>
								<td>${militar.getPosto().getNome()}</td>
								<td>${militar.getNomeGuerra()}</td>
								<td class="action"><a href="${basePath}/militar/editar?id=${militar.getId()}"><span class="fa fa-pencil"></span></a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>

<jsp:include page="../templates/footer.jsp" />