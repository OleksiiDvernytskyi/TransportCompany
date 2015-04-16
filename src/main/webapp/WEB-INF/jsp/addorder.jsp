<%-- 
    Document   : addorder
    Created on : 05.04.2015, 20:56:13
    Author     : amd
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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

<center><h1><spring:message code="new_order"/></h1></center>

<table wigth="98%">
    <tr><td><span class="error"><form:errors path="phone"/></span></td></tr>
    <tr>
        <td><h5> <spring:message code="pnumber"/>*: </h5></td> <td><form:input path="phone" /></td>
             
    </tr>
    
    <tr><td><span class="error"><form:errors path="fromWhere" /></span></td></tr>
    <tr>
        <td><h5>  <spring:message code="from"/>*: </h5></td><td><form:input path="fromWhere" /></td>
            
    </tr>
    
    <tr><td><span class="error"><form:errors path="toWhere" /></span></td></tr>
    <tr>
        <td><h5>  <spring:message code="to"/>: </h5></td><td><form:input path="toWhere" /></td>
            
    </tr>
    
    <tr><td><span class="error"><form:errors path="passengers" /></span></td></tr>
    <tr>
        <td><h5>  <spring:message code="passengers"/>: </h5></td><td><form:input path="passengers"/></td>
            
    </tr>
    
    <tr><td><span class="error"><form:errors path="carCategory" /></span></td></tr>
    <tr>
        <td><h5>  <spring:message code="car_cat"/>: </h5></td><td><form:input path="carCategory"/></td>
            
    </tr>
</table>

<p>
* <spring:message code="req_fields"/>
</p>
        <center><input type="submit" value="<spring:message code="submit"/>" /> </center>   


</form:form>
    </body>
</html>
</div>


<%@include file="/WEB-INF/layout/sidenav.jsp"%>
<%@include file="/WEB-INF/layout/footer.jsp"%>