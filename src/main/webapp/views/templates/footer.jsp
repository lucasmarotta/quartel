<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<c:set var="curPage" value="${requestScope['javax.servlet.forward.request_uri']}"/>
	
	<div class="versao color-white bg-green margin-bottom-05 margin-right-05"><b>Versão 1.0</b></div>
	<script src="${basePath}/public/vendor/jquery/jquery.min.js"></script>
	<script src="${basePath}/public/vendor/popper.js/popper.min.js"></script>
	<script src="${basePath}/public/vendor/bootstrap/bootstrap.min.js"></script>
	<script src="${basePath}/public/vendor/datatables/datatables.min.js"></script>
	<script src="${basePath}/public/js/main.js"></script>
</body>
</html>