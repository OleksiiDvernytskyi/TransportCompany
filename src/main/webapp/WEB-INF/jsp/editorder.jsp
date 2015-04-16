<%-- 
    Document   : editorder
    Created on : 13.04.2015, 16:31:26
    Author     : amd
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags" %>
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
        <form:form commandName="editOrderForm" method="post">

<h1><spring:message code="order"/> </h1>
    
<table>
        
     <tr>
         <td><h5>  <spring:message code="order_n"/>  </h5></td><td>${editOrderForm.orderId} 
                                    <form:hidden path="orderId" /></td>
    </tr>
    
    
    <tr>
        <td><h5> <spring:message code="pnumber"/>  </h5></td><td>${editOrderForm.phone}
                                    <form:hidden path="phone" /></td>
    </tr>
    
    <tr><td><span class="error"></span></td></tr>
    
    <tr>
        <td><h5>  <spring:message code="from"/>  </h5></td><td>${editOrderForm.fromWhere}<form:hidden path="fromWhere" /></td>
            
    </tr>

    <tr>
        <td><h5>  <spring:message code="to"/>  </h5></td><td>${editOrderForm.toWhere}<form:hidden path="toWhere" /></td>

    </tr>
    <sec:authorize ifAllGranted="ROLE_DISPATCHER">
    <tr>
        <td><h5><spring:message code="car_select"/> </h5></td><td><form:select path="driverId" >
                                                <form:option value="0" label="--- Select ---" />
                                                <form:options items="${carMap}" />
                                            </form:select>
            </td>

    </tr>
    
    <tr>
        <td><h5> <spring:message code="cancel_o"/> </h5></td> <td><form:checkbox path="canceled"/></td>
    </tr>
    
    </sec:authorize>
    
    <sec:authorize ifAllGranted="ROLE_DRIVER">
        <tr>
            <td><h5> <spring:message code="order_compl"/> </h5></td> <td><form:checkbox path="complite"/></td>
        </tr>
    </sec:authorize>   
</table>
    
        <center><input type="submit" value="<spring:message code="submit"/>" /> </center>   

</form:form>
    </body>
</html>
</div>

<%@include file="/WEB-INF/layout/sidenav.jsp"%>
<%@include file="/WEB-INF/layout/footer.jsp"%>