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
				<h3 class="card-title"><span class="fa fa-user"></span> Usuários</h3>
				<a href="${basePath}/usuario/cadastrar" class="btn btn-secondary float-right">Cadastrar Usuário</a>
			</div>
			<div class="card-body">
				<table class="table table-striped table-bordered" cellspacing="0" width="100%">
					<thead><tr>
						<th>Nome</th>
						<th>Login</th>
						<th>Email</th>
						<th>Ativo</th>
						<th style="width:50px;"></th>
						<th style="width:50px;"></th>
					</tr></thead>
					<tbody>

						<c:forEach items="${usuarios}" var="usuario">
							<tr>
								<td>${usuario.getNome()}</td>
								<td>${usuario.getLogin()}</td>
								<td>${usuario.getEmail()}</td>
								<td>${usuario.getAtivo() ? 'Ativo':'Inativo'}</td>
								<td class="action"><a href="${basePath}/usuario/editar?id=${usuario.getId()}"><span class="fa fa-pencil"></span></a></td>
								<td class="action"><a href="${basePath}/usuario/deletar?id=${usuario.getId()}"><span class="fa ${usuario.getAtivo() ? 'fa-times':'fa-check'}"></span></a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>

<jsp:include page="../templates/footer.jsp" />