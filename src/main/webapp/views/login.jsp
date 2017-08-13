<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="templates/header.jsp" />
<ul>
	<c:forEach items="${test}" var="item">
		<li>${item}</li>
	</c:forEach>
</ul>
<jsp:include page="templates/footer.jsp" />