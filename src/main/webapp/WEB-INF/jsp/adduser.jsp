<%-- 
    Document   : adduser
    Created on : 02.04.2015, 23:13:59
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
        <title>JSP Page</title>
        <style type="text/css">
            span.error {
            color: red;
        }
</style>
    </head>
    <body>
        <form:form commandName="newUserForm" method="post">

            <center><h1><spring:message code="u_reg"/></h1></center>
            <table>
                <tr><td><span class="error"><form:errors path="username" /></span></td></tr>
                <tr>
                    <td><h5> <spring:message code="username"/>*: </h5></td> <td><form:input path="username" /></td>

                </tr>
                <tr><td><span class="error"><form:errors path="firstname" /></span></td></tr>
                <tr>
                    <td><h5>  <spring:message code="fname"/>*: </h5></td><td><form:input path="firstname" /></td>

                </tr>
                <tr><td><span class="error"><form:errors path="lastname" /></span></td></tr>
                <tr>
                     <td><h5>  <spring:message code="lname"/>*: </h5></td><td><form:input path="lastname" /></td>

                </tr>
                <tr><td><span class="error"><form:errors path="phone" /></span></td></tr>    
                <tr>
                    <td><h5> <spring:message code="pnumber"/>*: </h5></td><td><form:input path="phone"/></td>

                </tr>
                <tr><td><span class="error"><form:errors path="password" /></span></td></tr>
                <tr>
                    <td><h5>  <spring:message code="password"/>*: </h5></td><td><form:password path="password"/></td>

                </tr>
                <tr><td><span class="error"><form:errors path="confirmPassword" /></span></td></tr>
                <tr>
                    <td><h5><spring:message code="conf_pass"/>*: </h5></td><td><form:password path="confirmPassword" /></td>

                </tr>
                <tr>
                    <td><h5><spring:message code="u_role"/> :</h5></td>
                    <td>
                            <form:radiobutton path="role" value="ADMIN" /><spring:message code="admin"/>
                            <form:radiobutton path="role" value="DISPATCHER"/><spring:message code="disp"/>
                            <form:radiobutton path="role" value="DRIVER" /><spring:message code="driver"/>
                    </td>

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