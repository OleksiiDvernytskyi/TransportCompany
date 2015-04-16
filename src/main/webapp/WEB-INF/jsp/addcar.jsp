<%-- 
    Document   : addcar
    Created on : 08.04.2015, 21:30:41
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
        <form:form commandName="newCarForm" method="post" >

<center><h1><spring:message code="new_car"/></h1></center>

<table width="98%">
    <tr><td><span class="error"><form:errors path="brendId" /></span></td></tr>
    <tr>
        <td><h5> <spring:message code="car_brend"/>: </h5></td> <td><form:select path="brendId" >
                                                <form:option value="0" label="--- Select ---" />
                                                <form:options items="${carBrends}" />
                                            </form:select>
        </td>
             
    </tr>
    <tr><td><span class="error"><form:errors path="carModel" /></span></td></tr>
    <tr>
        <td><h5> <spring:message code="car_model"/> *: </h5></td> <td><form:input path="carModel" /></td>
             
    </tr>
    <tr><td><span class="error"><form:errors path="passengers" /></span></td></tr>
    <tr>
        <td><h5>  <spring:message code="passengers"/> *: </h5></td><td><form:input path="passengers" /></td>
            
    </tr>
    <tr><td><span class="error"><form:errors path="carCategory" /></span></td></tr>
    <tr>
        <td><h5>  <spring:message code="car_cat"/> *: </h5></td><td><form:input path="carCategory" /></td>
            
    </tr>

</table>
<p>
* <spring:message code="req_fields"/>
</p>
        <center><input type="submit" value="<spring:message code="submit"/>" /> </center>   
<!--                <input type="reset" value="Reset"  />-->

</form:form>
    </body>
</html>
</div>


<%@include file="/WEB-INF/layout/sidenav.jsp"%>
<%@include file="/WEB-INF/layout/footer.jsp"%>