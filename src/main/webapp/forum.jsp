<%-- 
    Document   : forum
    Created on : Jun 21, 2016, 2:21:51 PM
    Author     : curtiscavalier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forum</title>
    </head>
    <body>
       
          <textarea name ="post" form ="postform"> Enter post here ... </textarea>
          <form method="post" action="makePost" id ="postform" >
          <input type="hidden" name="username" value = ${username} ><br>
          
          <input type="submit" value="Submit Post"> </form>
          
          <a href=getPost>Click here to view post</a>
          
    </body>
</html>
