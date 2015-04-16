<%-- 
    Document   : menu
    Created on : 01.04.2015, 16:27:01
    Author     : a
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="resources.bundle"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="resources/css/default.css" media="screen"/>

                    
                    <sec:authorize ifAllGranted="ROLE_ADMIN">

                        <h1>Administrator, <sec:authentication property="principal.username"/> </h1>
                       
			<ul>
                                
				<li><a href="adduser.html">Add user</a></li>
				<li><a href="showusers.html">Show all users</a></li>
                                <li><a href="userprofile.html">Profile</a></li>
				<!--<li><a href="index.html">Edit user</a></li>-->
				<!--<li><a href="index.html">convallis</a></li>-->
                                <li><a href="j_spring_security_logout">Loguot</a></li>
			</ul>
                    </sec:authorize>        

                    <sec:authorize ifAllGranted="ROLE_DISPATCHER">        
			<h1>Dispatcher, <sec:authentication property="principal.username"/></h1>
			<ul>
                                
				<li><a href="addorder.html">New order</a></li>
				<li><a href="showactiveorders.html">Active orders</a></li>
				<li><a href="showarchiveorders.html">Archive orders</a></li>
				<li><a href="userprofile.html">Profile</a></li>
                                <!--<li><a href="index.html">sociis natoque</a></li>-->
                                <li><a href="j_spring_security_logout">Loguot</a></li>
			</ul>
                    </sec:authorize>      
                    <sec:authorize ifAllGranted="ROLE_DRIVER">
			<h1>Driver, <sec:authentication property="principal.username"/> </h1>
			<ul>
				
				<li><a href="userprofile.html">Profile</a></li>
                                <li><a href="editOrder.html">Orders</a></li>
                                <li><a href="addcar.html">Add car</a></li>
                                <li><a href="j_spring_security_logout">Loguot</a></li>
				
				
			</ul>
                    </sec:authorize> 

                        <!--			<h1>Search</h1>
			<form action="index.html">
			<div>
                            
				<input type="text" name="search" class="styled" /> <input type="submit" value="" class="button" />
			</div>
			</form>-->
