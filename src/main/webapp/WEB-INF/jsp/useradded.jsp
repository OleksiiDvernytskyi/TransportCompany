<%-- 
    Document   : useradded
    Created on : 04.04.2015, 21:28:45
    Author     : amd
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="com.epam.rd.transportcompany.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="/WEB-INF/layout/head.jsp" %>  
<%@include file="/WEB-INF/layout/message.jsp" %> 

 
    <div class="item">
        
	<h1><spring:message code="user_added"/></h1>
        <table border="2" cellspacing="1" width ="98%">

            <tr>
                <td><h3><spring:message code="username"/></h3> </td><td><h4> ${newUser.username}</h4></td>
            </tr>
             <tr>
                <td><h3><spring:message code="fname"/></h3> </td><td><h4> ${newUser.firstname}</h4> </td>
            </tr>
             <tr>
                 <td><h3><spring:message code="lname"/></h3>  </td><td> <h4>${newUser.lastname}</h4> </td>
            </tr>
             <tr>
                 <td><h3><spring:message code="pnumber"/></h3> </td><td> <h4>${newUser.phone}</h4> </td>
            </tr>
            
            
        </table>   
    </div>



<%@include file="/WEB-INF/layout/sidenav.jsp"%>
<%@include file="/WEB-INF/layout/footer.jsp"%>
