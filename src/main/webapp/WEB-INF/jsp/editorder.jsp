<%-- 
    Document   : editorder
    Created on : 13.04.2015, 16:31:26
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
        <form:form commandName="editOrderForm" method="post">

<h1>Order </h1>
    
<table>
        
     <tr>
         <td><h5>  Order number  </h5></td><td>${editOrderForm.orderId} 
                                    <form:hidden path="orderId" /></td>
    </tr>
    
    
    <tr>
        <td><h5> Phone  </h5></td><td>${editOrderForm.phone}
                                    <form:hidden path="phone" /></td>
    </tr>
    
    <tr><td><span class="error"></span></td></tr>
    
    <tr>
        <td><h5>  From where  </h5></td><td>${editOrderForm.fromWhere}<form:hidden path="fromWhere" /></td>
            
    </tr>

    <tr>
        <td><h5>  To where  </h5></td><td>${editOrderForm.toWhere}<form:hidden path="toWhere" /></td>

    </tr>

    <tr>
        <td><h5>Select a car </h5></td><td><form:select path="driverId" >
                                                <form:option value="0" label="--- Select ---" />
                                                <form:options items="${carMap}" />
                                            </form:select>
            </td>

    </tr>
    
    <tr>
        <td><h5> Cancel order </h5></td> <td><form:checkbox path="canceled"/></td>
    </tr><tr>

        
</table>
    
        <center><input type="submit" value="Submit" /> </center>   

</form:form>
    </body>
</html>
</div>

<%@include file="/WEB-INF/layout/sidenav.jsp"%>
<%@include file="/WEB-INF/layout/footer.jsp"%>