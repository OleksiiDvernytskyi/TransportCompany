<%-- 
    Document   : caradded
    Created on : 12.04.2015, 0:16:35
    Author     : amd
--%>


<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="com.epam.rd.transportcompany.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="/WEB-INF/layout/head.jsp" %>  
<%@include file="/WEB-INF/layout/message.jsp" %> 

 
    <div class="item">
        
	<h1>Car added !</h1>
        <table border="2" cellspacing="1" width ="98%">
<!--            <tr>
                <td>id </td><td> ${newCar.carId}</td>
            </tr>-->
           
            <tr>
                <td><h3>Car Model</h3> </td><td><h4> ${newCar.carModel}</h4></td>
            </tr>
             <tr>
                <td><h3>Number of passengers</h3> </td><td><h4> ${newCar.passengers}</h4> </td>
            </tr>
             <tr>
                 <td><h3>Cargo capacity</h3>  </td><td> <h4>${newCar.cargo}</h4> </td>
            </tr>

            
        </table>   
    </div>



<%@include file="/WEB-INF/layout/sidenav.jsp"%>
<%@include file="/WEB-INF/layout/footer.jsp"%>
