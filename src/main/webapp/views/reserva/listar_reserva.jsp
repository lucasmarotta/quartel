<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../templates/header.jsp" />
<h1>Listar Reserva - ${usuario.getLogin()}</h1>
<a href="${basePath}/logout">Sair</a>
<jsp:include page="../templates/footer.jsp" />