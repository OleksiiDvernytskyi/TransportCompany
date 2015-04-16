<%-- 
    Document   : showactiveorders
    Created on : 13.04.2015, 12:23:04
    Author     : amd
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page import="com.epam.rd.transportcompany.entities.Order"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.epam.rd.transportcompany.entities.User"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="/WEB-INF/layout/head.jsp" %>  
<%@include file="/WEB-INF/layout/message.jsp" %> 

 
    <div class="item">
        
        <h1><spring:message code="active_o"/>  <table align="right"> 
            <tr><td><a href="showactiveorders.html?p=${pageNumber -1}&ph=${phone}">Prev</a></td>
                <td> ${pageNumber} of ${pagesCount} </td>
                <td><a href="showactiveorders.html?p=${pageNumber +1}&ph=${phone}">Next</a></td></tr>
                        </table></h1>
                        
            <form:form commandName="orderSearchForm" method="post">
                <table>        
                    <td><h3><spring:message code="find_by_phone"/> : </h3> </td><td><form:input path="phone"/></td><td><input type="submit" value="<spring:message code="search"/>" /></td>
            
                </table>
            </form:form>
        <table border="2" cellspacing="1" width = "98%" align="centre">
            
             <tr>
                 <td><h3>  <spring:message code="phone"/> </h3></td><td><h3><spring:message code="date"/></h3></td><td><h3>  <spring:message code="from"/> </h3></td><td><h3> <spring:message code="driver"/>  </h3></td>
            </tr>
       <c:forEach items = "${orderList}" var="order" >
            <tr>
                <td><h4><a href="editorder.html?o=${order.orderId}"> ${order.phone} </a></h4></td>
                    <td><h4> ${order.dateAndTime} </h4></td>
                    <td><h4> ${order.fromWhere} </h4></td>
                        <td><h4> ${order.driver.username} </h4></td>
            </tr>
       </c:forEach>  
            
        </table>   
    </div>



<%@include file="/WEB-INF/layout/sidenav.jsp"%>
<%@include file="/WEB-INF/layout/footer.jsp"%>
