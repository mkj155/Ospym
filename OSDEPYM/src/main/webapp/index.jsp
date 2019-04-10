<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<jsp:include page="WEB-INF/views/header.jsp" />


<body>
	<spring:url value="/contacto/${param.idAfiliado}/${param.nombreAfiliado}" var="canalDeContactoUrl" />
    <button type="button" class="btn btn-link" onclick="location.href='${canalDeContactoUrl}'">Canal De Contacto</button>
</body>
</html>