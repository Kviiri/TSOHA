<%-- 
    Document   : course
    Created on : 04-Mar-2012, 18:40:59
    Author     : kviiri
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course addition</title>
    </head>
    <body>
        <h1>L'home des courses.</h1>
        <h2>Ajoutes un course</h2>
        <form:form commandName="course" action="${pageContext.request.contextPath}/admin/course" method="POST">
            Course name: <form:input path="name" /><form:errors path="name" /> <br />
            <input type="submit"/>
        </form:form>
        <a href="${pageContext.request.contextPath}/admin/home">Retourner</a>
    </body>
</html>