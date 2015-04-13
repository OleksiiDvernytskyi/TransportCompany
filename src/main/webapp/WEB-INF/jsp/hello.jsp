<%-- 
    Document   : hello
    Created on : 02.04.2015, 12:22:02
    Author     : amd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String username = request.getParameter("username11");
%>    
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h2><% out.print(username);%></h2>
        <h3>${message}</h3>
    </body>
</html>
