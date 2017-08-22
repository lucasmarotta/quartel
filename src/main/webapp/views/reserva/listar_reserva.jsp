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
				<h3 class="card-title"><span class="fa fa-archive"></span> Reservas</h3>
				<a href="${basePath}/reserva/cadastrar" class="btn btn-secondary float-right">cadastrar nova reserva</a>
			</div>
			<div class="card-body">
				<table class="table table-striped table-bordered" cellspacing="0" width="100%">
					<thead><tr>
						<th>Sigla</th>
						<th>Descrição</th>
						<th style="width:50px;">Ação</th>
					</tr></thead>
					<tbody>
						<c:forEach items="${reservas}" var="reserva">
							<tr>
								<th>${reserva.getSigla()}</th>
								<th>${reserva.getDescricao()}</th>
								<th class="action"><a href="${basePath}/reserva/editar?id=${reserva.getId()}"><span class="fa fa-pencil"></span></a></th>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>

<jsp:include page="../templates/footer.jsp" />