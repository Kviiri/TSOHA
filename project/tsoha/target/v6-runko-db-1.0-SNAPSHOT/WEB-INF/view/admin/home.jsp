<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenue!</title>
    </head>
    <body>
        <h1><i>L'home d'admin.</i></h1>
        <h2>Ajoutez un étudiant</h2>
        <form:form commandName="studentform" action="${pageContext.request.contextPath}/admin/home" method="POST">
            Nom d'étudiant: <form:input path="name" /><form:errors path="name" /> <br />
            L'username d'étudiant: <form:input path="username" /><form:errors path="username" /> <br />
            Le mot de passe d'étudiant: <form:input path="password" /><form:errors path="password" /><br />
            <input type="submit"/>
        </form:form>
        <a href="${pageContext.request.contextPath}/admin/course">Add a course</a>
        <br>
        <a href="${pageContext.request.contextPath}/home">Retourner</a>
        <p><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></p>
    </body>
</html>
