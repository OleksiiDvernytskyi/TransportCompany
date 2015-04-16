<%-- 
    Document   : addorder
    Created on : 05.04.2015, 20:56:13
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
            span.error {
            color: red;
        }
</style>
    </head>
    <body>
        <form:form commandName="newOrderForm" method="post">

<center><h1>New order</h1></center>

<table wigth="98%">
    <tr><td><span class="error"><form:errors path="phone"/></span></td></tr>
    <tr>
        <td><h5> Phone*: </h5></td> <td><form:input path="phone" /></td>
             
    </tr>
    
    <tr><td><span class="error"><form:errors path="fromWhere" /></span></td></tr>
    <tr>
        <td><h5>  From where*: </h5></td><td><form:input path="fromWhere" /></td>
            
    </tr>
    
    <tr><td><span class="error"><form:errors path="toWhere" /></span></td></tr>
    <tr>
        <td><h5>  To where: </h5></td><td><form:input path="toWhere" /></td>
            
    </tr>
    
    <tr><td><span class="error"><form:errors path="passengers" /></span></td></tr>
    <tr>
        <td><h5>  Passengers: </h5></td><td><form:input path="passengers"/></td>
            
    </tr>
    
    <tr><td><span class="error"><form:errors path="carCategory" /></span></td></tr>
    <tr>
        <td><h5>  CarCategory: </h5></td><td><form:input path="carCategory"/></td>
            
    </tr>
</table>

<p>
* Required Fields
</p>
        <center><input type="submit" value="Submit" /> </center>   


</form:form>
    </body>
</html>
</div>


<%@include file="/WEB-INF/layout/sidenav.jsp"%>
<%@include file="/WEB-INF/layout/footer.jsp"%>