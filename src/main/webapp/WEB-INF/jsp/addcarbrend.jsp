<%-- 
    Document   : addcarbrend
    Created on : 16.04.2015, 15:12:41
    Author     : a
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
        <form:form commandName="newCarBrendForm" method="post" >

<center><h1><spring:message code="new_brend"/></h1></center>

<table width="98%">
    <tr><td><span class="error"><form:errors path="brendName" /></span></td></tr>
    <tr>
        <td><h5> <spring:message code="car_brend"/> : </h5></td> <td><form:input path="brendName" /></td><td><input type="submit" value="<spring:message code="submit"/>" /></td>
             
    </tr>

</table>
        

</form:form>
    </body>
</html>
</div>


<%@include file="/WEB-INF/layout/sidenav.jsp"%>
<%@include file="/WEB-INF/layout/footer.jsp"%>