<%-- 
    Document   : menu
    Created on : 01.04.2015, 16:27:01
    Author     : a
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="resources.bundle"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="resources/css/default.css" media="screen"/>

                    
                    <sec:authorize ifAllGranted="ROLE_ADMIN">

                        <h1><spring:message code="admin"/>, <sec:authentication property="principal.username"/> </h1>
                       
			<ul>
                                
				<li><a href="adduser.html"><spring:message code="add_u"/></a></li>
				<li><a href="showusers.html"><spring:message code="show_all_u"/></a></li>
				<li><a href="addcarbrend.html"><spring:message code="new_brend"/></a></li>
                                <li><a href="addcar.html"><spring:message code="new_car"/></a></li>
                                <li><a href="userprofile.html"><spring:message code="profile"/></a></li>
                                <li><a href="j_spring_security_logout"><spring:message code="logout"/></a></li>
			</ul>
                    </sec:authorize>        

                    <sec:authorize ifAllGranted="ROLE_DISPATCHER">        
			<h1><spring:message code="disp"/>, <sec:authentication property="principal.username"/></h1>
			<ul>
                                
				<li><a href="addorder.html"><spring:message code="new_order"/></a></li>
				<li><a href="showactiveorders.html"><spring:message code="active_o"/></a></li>
				<li><a href="showarchiveorders.html"><spring:message code="archive"/></a></li>
				<li><a href="userprofile.html"><spring:message code="profile"/></a></li>
                                <li><a href="j_spring_security_logout"><spring:message code="logout"/></a></li>
			</ul>
                    </sec:authorize>      
                    <sec:authorize ifAllGranted="ROLE_DRIVER">
			<h1><spring:message code="driver"/>, <sec:authentication property="principal.username"/> </h1>
			<ul>
				
				<li><a href="userprofile.html"><spring:message code="profile"/></a></li>
                                <li><a href="editorder.html"><spring:message code="orders"/></a></li>
                                <li><a href="j_spring_security_logout"><spring:message code="logout"/></a></li>
				
				
			</ul>
                    </sec:authorize> 

                        <!--			<h1>Search</h1>
			<form action="index.html">
			<div>
                            
				<input type="text" name="search" class="styled" /> <input type="submit" value="" class="button" />
			</div>
			</form>-->
