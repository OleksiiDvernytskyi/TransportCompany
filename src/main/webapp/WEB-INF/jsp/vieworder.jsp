<%-- 
    Document   : vieworder
    Created on : 16.04.2015, 10:53:52
    Author     : amd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<%@include file="/WEB-INF/layout/head.jsp" %>  
<%@include file="/WEB-INF/layout/message.jsp" %> 

 
    <div class="item">
                            
	<h1><spring:message code="order"/> </h1>
           
        <table border="2" cellspacing="1" width ="98%">
           
            <tr>
                <td><h3><spring:message code="date_and_time"/> </h3> </td><td><h4> ${order.date}</h4> </td>
            </tr>
            <tr>
                <td><h3><spring:message code="pnumber"/> </h3> </td><td><h4> ${order.phone}</h4></td>
            </tr>
            <tr>
                <td><h3><spring:message code="from"/> </h3> </td><td><h4> ${order.fromWhere}</h4> </td>
            </tr>
             <tr>
                 <td><h3><spring:message code="to"/></h3>  </td><td> <h4>${order.toWhere}</h4> </td>
            </tr>
             <tr>
                 <td><h3><spring:message code="passengers"/> </h3> </td><td> <h4>${order.passengers}</h4> </td>
            </tr>
            <tr>
                 <td><h3><spring:message code="car_cat"/> </h3> </td><td> <h4>${order.carCategory}</h4> </td>
            </tr>
            <c:if test="${order.driver != null}">
            <tr>
                 <td><h3><spring:message code="d_fname"/></h3> </td><td> <h4>${order.driver.firstname}</h4> </td>
            </tr>
            <tr>
                 <td><h3><spring:message code="d_lname"/> </h3> </td><td> <h4>${order.driver.lastname}</h4> </td>
            </tr>
            <tr>
                 <td><h3><spring:message code="d_phone"/></h3> </td><td> <h4>${order.driver.phone}</h4> </td>
            </tr>
            </c:if>
            
        </table> 
        

           
    </div>



<%@include file="/WEB-INF/layout/sidenav.jsp"%>
<%@include file="/WEB-INF/layout/footer.jsp"%>
