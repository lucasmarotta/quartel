<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="templates/header.jsp" />

<h1>Login</h1>

<form action="${basePath}/login" method="POST">
	<input type="text" name="login" placeholder="login">
	<input type="password" name="senha" placeholder="senha">
	<input type="submit" value="Logar">
</form>


<jsp:include page="templates/footer.jsp" />