<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tervetuloa Pollauspalveluun.</h1>
        <p><a href="listpolls">Katso kyselyitä</a></p>
        
        <p><a href="user/home">Käyttäjän sivu</a></p>
        <p><a href="admin/home">Ylläpitäjän sivu</a></p>
        
        <p><a href="createuser">Luo uusi käyttäjä</a></p>
        
        <p><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></p>
    </body>
</html>
