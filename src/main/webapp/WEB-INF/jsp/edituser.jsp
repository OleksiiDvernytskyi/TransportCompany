<%-- 
    Document   : edituser
    Created on : 09.04.2015, 10:13:03
    Author     : amd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="resources/css/default.css" media="screen"/>
<!DOCTYPE html>


<%@include file="/WEB-INF/layout/head.jsp" %>  
<%@include file="/WEB-INF/layout/message.jsp" %> 

<div class="item">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;  charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            span.error {
            color: red;
        }
</style>
    </head>
    <body>
        <form:form commandName="editUserForm" method="post">

<h1>USER  ${editUserForm.username}</h1>
    
<table>
        
     <tr>
         <td><h5>  Username: </h5></td><td>${editUserForm.username} 
                                    <form:hidden path="username" /></td>
            <td></td>
    </tr>
    
    <tr><td><span class="error"><form:errors path="firstname" /></span></td></tr>
    
    <tr>
        <td><h5>  First Name*: </h5></td><td><form:input path="firstname" /></td>
            
    </tr>

    <tr><td><span class="error"><form:errors path="lastname" /></span></td></tr>
    <tr>
         <td><h5>  Last Name*: </h5></td><td><form:input path="lastname" /></td>

    </tr>

    <tr><td><span class="error"><form:errors path="phone" /></span></td></tr>
    <tr>
        <td><h5> Phone*: </h5></td><td><form:input path="phone"/></td>

    </tr>

    <tr><td><span class="error"><form:errors path="password" /></span></td></tr>
    <tr>
        <td><h5>  Password*: </h5></td><td><form:password path="password"/></td>

    </tr>

    <tr><td><span class="error"><form:errors path="confirmPassword" /></span></td></tr>
    <tr>
        <td><h5>Confirm Password*: </h5></td><td><form:password path="confirmPassword" /></td>

    </tr>
    <tr>
        <td><h5> Disable user </h5></td> <td><form:checkbox path="disabled"/></td>
    </tr><tr>
    <td><h5> User role :</h5></td>
        <td>
            <form:radiobutton path="role" value="ADMIN" />Admin
            <form:radiobutton path="role" value="DISPATCHER"/>Dispatcher
            <form:radiobutton path="role" value="DRIVER" />Driver
        </td> 
    </tr>
</table>
    
        <center><input type="submit" value="Submit" /> </center>   

</form:form>
    </body>
</html>
</div>

<%@include file="/WEB-INF/layout/sidenav.jsp"%>
<%@include file="/WEB-INF/layout/footer.jsp"%>