<%-- 
    Document   : listpolls
    Created on : 24-Apr-2012, 08:43:04
    Author     : kviiri
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kaikki kyselyt</title>
    </head>
    <body>
        <a href="${pageContext.request.contextPath}/home">Takaisin etusivulle</a>
        
        <h1>Kyselyt:</h1>
        <c:forEach var="poll" items="${polls}">
            <h3>${poll.title} (${poll.numOfAnswers} vastausta)</h3>
            <ul>
            <c:forEach var="pollOption" items="${poll.pollOptions}">
                <li>${pollOption.optionDescription}, ${pollOption.numOfVotes} ääntä</li>
            </c:forEach>
            </ul>
        </c:forEach>
    </body>
</html>
