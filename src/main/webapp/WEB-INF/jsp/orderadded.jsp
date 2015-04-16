<%-- 
    Document   : orderadded
    Created on : 08.04.2015, 22:54:26
    Author     : amd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<%@include file="/WEB-INF/layout/head.jsp" %>  
<%@include file="/WEB-INF/layout/message.jsp" %> 

 
    <div class="item">
                            
	<h1>Order added !</h1>
           
        <table border="2" cellspacing="1" width ="98%">
           
            <tr>
                <td><h3>Phone number </h3> </td><td><h4> ${newOrder.phone}</h4></td>
            </tr>
             <tr>
                <td><h3>From where </h3> </td><td><h4> ${newOrder.fromWhere}</h4> </td>
            </tr>
             <tr>
                 <td><h3>To where</h3>  </td><td> <h4>${newOrder.toWhere}</h4> </td>
            </tr>
             <tr>
                 <td><h3>Passengers </h3> </td><td> <h4>${newOrder.passengers}</h4> </td>
            </tr>
            <tr>
                 <td><h3>CarCategory </h3> </td><td> <h4>${newOrder.carCategory}</h4> </td>
            </tr>
            
            
        </table> 
        

           
    </div>



<%@include file="/WEB-INF/layout/sidenav.jsp"%>
<%@include file="/WEB-INF/layout/footer.jsp"%>
