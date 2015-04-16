<%-- 
    Document   : message
    Created on : 15.04.2015, 20:37:31
    Author     : amd
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <%@include file="/WEB-INF/layout/head.jsp" %>  
    <%@include file="/WEB-INF/layout/message.jsp" %> 
	<div class="item">

            <h1> <spring:message code="${message}"/></h1>
 
        </div>

    <%@include file="/WEB-INF/layout/sidenav.jsp"%>
    <%@include file="/WEB-INF/layout/footer.jsp"%>