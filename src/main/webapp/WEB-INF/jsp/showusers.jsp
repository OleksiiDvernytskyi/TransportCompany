<%-- 
    Document   : showusers
    Created on : 09.04.2015, 16:35:31
    Author     : a
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.epam.rd.transportcompany.entities.User"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="/WEB-INF/layout/head.jsp" %>  
<%@include file="/WEB-INF/layout/message.jsp" %> 

 
    <div class="item">
        
        <h1><spring:message code="users"/> <table align="right"> 
            <tr><td><a href="showusers.html?p=${pageNumber -1}">Prev</a></td>
                <td>${pageNumber} of ${pagesCount}</td>
                <td><a href="showusers.html?p=${pageNumber +1}">Next</a></td></tr>
                        </table></h1>
            <form:form commandName="userSearchForm" method="post">
                <table>        
                    <td><h3><spring:message code="find_by_user"/> : </h3> </td><td><form:input path="username"/></td><td><input type="submit" value="<spring:message code="search"/>" /></td>
            
                </table>
            </form:form>
        <table border="2" cellspacing="1" width = "98%" align="centre">
            
             <tr>
                 <td><h3> <spring:message code="username"/> </h3></td>
                        <td><h3> <spring:message code="fname"/> </h3></td>
                            <td><h3> <spring:message code="lname"/> </h3></td>
                                <td><h3> <spring:message code="u_role"/> </h3></td>
            </tr>
       <c:forEach items = "${userList}" var="user" >
            <tr>
                <td><h4><a href="edituser.html?user=${user.username}"> ${user.username} </a></h4></td>
                    <td><h4> ${user.firstname} </h4></td><td><h4> ${user.lastname} </h4></td>
                        <td><h4><spring:message code="${user.userRole}"/>  </h4></td>
            </tr>
       </c:forEach>  
            
        </table>   
    </div>



<%@include file="/WEB-INF/layout/sidenav.jsp"%>
<%@include file="/WEB-INF/layout/footer.jsp"%>
