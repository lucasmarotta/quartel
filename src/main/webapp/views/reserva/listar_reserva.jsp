<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<c:set var="curPage" value="${requestScope['javax.servlet.forward.request_uri']}"/>

<jsp:include page="../templates/header.jsp" />

	<div class="container">
		<div class="card">
			<div class="card-body">
				<h3 class="card-title">Reservas</h3>
			</div>
		</div>
	</div>

<jsp:include page="../templates/footer.jsp" />