<%-- 
    Document   : edituser
    Created on : 09.04.2015, 10:13:03
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
    <body>
        <form:form commandName="editUserForm" method="post">

<h1><spring:message code="user"/>  ${editUserForm.username}</h1>
    
<table>
        
     <tr>
         <td><h5>  <spring:message code="username"/>: </h5></td><td>${editUserForm.username} 
                                    <form:hidden path="username" /></td>
            <td></td>
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
        <td><h5><spring:message code="disable_u"/> </h5></td> <td><form:checkbox path="disabled"/></td>
    </tr><tr>
    <td><h5> <spring:message code="u_role"/> :</h5></td>
        <td>
            <form:radiobutton path="role" value="ADMIN" /><spring:message code="admin"/>
            <form:radiobutton path="role" value="DISPATCHER"/><spring:message code="disp"/>
            <form:radiobutton path="role" value="DRIVER" /><spring:message code="driver"/>
        </td> 
    </tr>
</table>
    
        <center><input type="submit" value="<spring:message code="submit"/>" /> </center>   

</form:form>
    </body>
</html>
</div>

<%@include file="/WEB-INF/layout/sidenav.jsp"%>
<%@include file="/WEB-INF/layout/footer.jsp"%>