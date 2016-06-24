<%-- 
    Document   : index
    Created on : Jun 20, 2016, 12:22:40 AM
    Author     : curtiscavalier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p style="color:red;">${incorrect_error}</p>
        <form method="post" action="Login">
            Username: <input type="text" name="username"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit" value="Login"> </form>
    </body>
</html>
