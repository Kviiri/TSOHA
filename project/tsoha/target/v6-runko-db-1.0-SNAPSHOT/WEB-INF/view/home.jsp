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
        <h1>L'home des personnes tres casual.</h1>
        <p><a href="student/home">L'home d'étudiants!</a></p>
        <p><a href="admin/home">L'home d'admin!</a></p>

        <h2>Pour les étudiants</h2>
        <c:forEach var="student" items="${students}">
            ${student.name} <sec:authorize access="hasRole('lecturer')">, username: ${student.username}</sec:authorize><br />
        </c:forEach>
            
        <h2>Les courses</h2>
        <c:forEach var="course" items="${courses}">
            ${course.name}, attending: ${course.attending}, lectured by: ${course.lecturer.name} <sec:authorize access="hasRole('student')"><a href="student/course/${course.id}">Sign up</a></sec:authorize> <br />
        </c:forEach>
            
        <p><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></p>
    </body>
</html>
