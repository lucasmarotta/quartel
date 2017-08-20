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
				<h3 class="card-title">Reservas</h3>
			</div>
		</div>
	</div>

<jsp:include page="../templates/footer.jsp" />