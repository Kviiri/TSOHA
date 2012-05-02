<%-- 
    Document   : register
    Created on : 18-Apr-2012, 10:26:28
    Author     : kviiri
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Luo uusi tunnus</title>
    </head>
    <h1>Luo tunnus:</h1>
        <form:form commandName="createuser" action="${pageContext.request.contextPath}/createuser" method="POST">
            Nimi: <form:input path="name" /><form:errors path="name" /> <br />
            Käyttäjätunnus: <form:input path="username" /><form:errors path="username" /> <br />
            Salasana: <form:input path="password" /><form:errors path="password" /><br />
            Varmista salasana: <form:input path="confirmPassword" /><form:errors path="password" /><br />
            <input type="submit"/>
        </form:form>
</html>