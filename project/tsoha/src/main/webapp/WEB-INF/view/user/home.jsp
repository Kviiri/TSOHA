<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenue</title>
    </head>
    <body>
        <h1>Tervetuloa</h1>
        <a href="${pageContext.request.contextPath}/user/addpoll">Lisää uusi kysely</a> <br />
        <a href="${pageContext.request.contextPath}/home">Takaisin etusivulle</a>
        <p><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></p>
       
    </body>
</html>
