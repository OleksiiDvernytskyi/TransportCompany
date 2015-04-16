<%-- 
    Document   : addcar
    Created on : 08.04.2015, 21:30:41
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
        <form:form commandName="newCarForm" method="post" >

<center><h1>New car</h1></center>

<table width="98%">
    <tr><td><span class="error"><form:errors path="carModel" /></span></td></tr>
    <tr>
        <td><h5> Car Model *: </h5></td> <td><form:input path="carModel" /></td>
             
    </tr>
    <tr><td><span class="error"><form:errors path="passengers" /></span></td></tr>
    <tr>
        <td><h5>  Passengers *: </h5></td><td><form:input path="passengers" /></td>
            
    </tr>
    <tr><td><span class="error"><form:errors path="carCategory" /></span></td></tr>
    <tr>
        <td><h5>  CarCategory *: </h5></td><td><form:input path="carCategory" /></td>
            
    </tr>

</table>
<p>
* Required Fields
</p>
        <center><input type="submit" value="Submit" /> </center>   
<!--                <input type="reset" value="Reset"  />-->

</form:form>
    </body>
</html>
</div>


<%@include file="/WEB-INF/layout/sidenav.jsp"%>
<%@include file="/WEB-INF/layout/footer.jsp"%>