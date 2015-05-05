<%-- 
    Document   : userprofile
    Created on : 15.04.2015, 11:36:35
    Author     : amd
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags" %>
<link rel="stylesheet" type="text/css" href="resources/css/default.css" media="screen"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <%@include file="/WEB-INF/layout/head.jsp" %>  
    <%@include file="/WEB-INF/layout/message.jsp" %> 
	<div class="item">
           
            <form:form commandName="editProfileForm" method="post">

                    <h1><spring:message code="user"/>  ${editProfileForm.username}</h1>
    
                    <table>

                         <tr>
                             <td><h5>  <spring:message code="username"/>: </h5></td><td>${editProfileForm.username} 
                                                        <form:hidden path="username" /></td>
                                <td></td>
                        </tr>
                        <sec:authorize ifAllGranted="ROLE_DRIVER">    
                        <tr>
                            <td><h5> <spring:message code="ready"/> : </h5></td><td><form:checkbox path="ready"/> </td>

                        </tr>
                        </sec:authorize>
                        <tr><td><span class="error"><form:errors path="phone" /></span></td></tr>
                        <tr>
                            <td><h5> <spring:message code="pnumber"/>: </h5></td><td><form:input path="phone"/></td>

                        </tr>

                        <tr><td><span class="error"><form:errors path="password" /></span></td></tr>
                        <tr>
                            <td><h5>  <spring:message code="password"/>: </h5></td><td><form:password path="password"/></td>

                        </tr>

                        <tr><td><span class="error"><form:errors path="confirmPassword" /></span></td></tr>
                        <tr>
                            <td><h5><spring:message code="conf_pass"/>: </h5></td><td><form:password path="confirmPassword" /></td>

                        </tr>
                        <sec:authorize ifAllGranted="ROLE_DRIVER">
                        <tr>
                            <td><h5><spring:message code="car"/>: </h5></td>
                                <td>
                                    <form:select path="carId" >
                                        <c:if test="${editProfileForm.carId == null}">
                                            <form:option value="0" label="--- Select ---" />
                                        </c:if>                
                                        <c:forEach items="${carList}" var="car">
                                            <form:option value="${car.carId}" label="${car.brend.brendName} ${car.carModel} " />
                                        </c:forEach>    
                                    </form:select>
                                </td>

                        </tr>                       
                        </sec:authorize>
                    </table>
    
                <center><input type="submit" value="<spring:message code="submit"/>" /> </center>   

            </form:form>
            
      	</div>

    <%@include file="/WEB-INF/layout/sidenav.jsp"%>
    <%@include file="/WEB-INF/layout/footer.jsp"%>