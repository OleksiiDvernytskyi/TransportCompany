<%-- 
    Document   : menu
    Created on : 01.04.2015, 16:27:01
    Author     : a
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="resources.bundle"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="resources/css/default.css" media="screen"/>

                    <%  //session.setAttribute("username", "user");
                        //session.setAttribute("userRole", "Admin");
                        session.setAttribute("userRole", "Dispetcher");
                    %>     
			    
                            <%//  if(session.getAttribute("userRole").equals("Admin")){  %>     
                    <h1>Administrator</h1>
			<ul>
				<li><a href="adduser.html">Add user</a></li>
				<li><a href="showusers.html">Show all users</a></li>
				<!--<li><a href="index.html">Edit user</a></li>-->
				<!--<li><a href="index.html">convallis</a></li>-->
			</ul>
                            <%// }
                            //if(session.getAttribute("userRole").equals("Dispetcher")){  %>
                            
			<h1>Dispatcher</h1>
			<ul>
				<li><a href="addorder.html">New order</a></li>
				<li><a href="showactiveorders.html">Active orders</a></li>
<!--				<li><a href="index.html">semper</a></li>
				<li><a href="index.html">sociis natoque</a></li>-->
			</ul>
                            <%// }
                            //if(session.getAttribute("userRole").equals("Driver")){  %>
			<h1>Driver </h1>
			<ul>
				<li><a href="index.html">sociis natoque</a></li>
				<li><a href="index.html">magna sed purus</a></li>
				<li><a href="index.html">pellentesque</a></li>
				<li><a href="addcar.html">Add car</a></li>
			</ul>
                        <%
                        // } 
                        //}
                        %>
<!--			<h1>Search</h1>
			<form action="index.html">
			<div>
                            
				<input type="text" name="search" class="styled" /> <input type="submit" value="" class="button" />
			</div>
			</form>-->
