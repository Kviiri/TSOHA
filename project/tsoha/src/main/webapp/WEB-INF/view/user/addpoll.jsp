<%-- 
    Document   : addpoll
    Created on : 22-Apr-2012, 20:00:24
    Author     : kviiri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uusi kysely</title>
    </head>
    <body>
        <h1><form action="addpoll" method="POST">
            Otsikko: <input type="text" name="PollQuestion" /> <br />
            Vastausvaihtoehto 1: <input type="text" name="pollOptions" /> <br />
            Vastausvaihtoehto 2: <input type="text" name="pollOptions" /> <br />
            Vastausvaihtoehto 3: <input type="text" name="pollOptions" /> <br />
            Vastausvaihtoehto 4: <input type="text" name="pollOptions" /> <br />
            <input type="submit" value="Lähetä" />
        </form></h1>
    </body>
</html>
