
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin-sivu</title>
    </head>
    <body>
        <h1><i>Admin</i></h1>
        <br>
        <a href="${pageContext.request.contextPath}/home">Palaa etusivulle</a>
        <p><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></p>
        <b>${deleteMessage}</b>
        <h1>Kyselyt:</h1>
        <c:forEach var="poll" items="${polls}">
            <p>${poll.title} (${poll.numOfAnswers} vastausta) <i><a href="${pageContext.request.contextPath}/admin/delete/${poll.id}">Poista kysely</i></a></p>
        </c:forEach>
        
    </body>
</html>
