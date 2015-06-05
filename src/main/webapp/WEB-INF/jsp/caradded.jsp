<%-- 
    Document   : caradded
    Created on : 12.04.2015, 0:16:35
    Author     : amd
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="com.amd.transportcompany.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@include file="/WEB-INF/layout/head.jsp" %>  
<%@include file="/WEB-INF/layout/message.jsp" %> 

 
    <div class="item">
        
	<h1><spring:message code="car_added"/></h1>
        <table border="2" cellspacing="1" width ="98%">

            <tr>
                <td><h3><spring:message code="car_model"/></h3> </td><td><h4> ${newCar.carModel}</h4></td>
            </tr>
             <tr>
                <td><h3><spring:message code="passengers"/></h3> </td><td><h4> ${newCar.passengers}</h4> </td>
            </tr>
             <tr>
                 <td><h3><spring:message code="car_cat"/></h3>  </td><td> <h4>${newCar.carCategory}</h4> </td>
            </tr>

            
        </table>   
    </div>



<%@include file="/WEB-INF/layout/sidenav.jsp"%>
<%@include file="/WEB-INF/layout/footer.jsp"%>
