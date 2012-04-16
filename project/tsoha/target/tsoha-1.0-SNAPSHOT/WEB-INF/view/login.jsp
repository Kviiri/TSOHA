<%-- 
    Document   : login
    Created on : 04-Mar-2012, 12:14:32
    Author     : kviiri
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login-sivu</title>
    </head>
    <h1>Login</h1>
        <form action="j_spring_security_check" method="POST">
            Käyttäjätunnus: <input type="text" name="j_username" /> <br />
            Salasana: <input type="text" name="j_password" />
            <input type="submit" value="Lähetä" />
        </form>
</html>
