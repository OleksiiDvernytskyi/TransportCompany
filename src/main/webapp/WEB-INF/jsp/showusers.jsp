<%-- 
    Document   : showusers
    Created on : 09.04.2015, 16:35:31
    Author     : a
--%>

<%-- 
    Document   : useradded
    Created on : 04.04.2015, 21:28:45
    Author     : amd
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.epam.rd.transportcompany.entities.User"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="/WEB-INF/layout/head.jsp" %>  
<%@include file="/WEB-INF/layout/message.jsp" %> 

 
    <div class="item">
        
        <h1>Users  <table align="right"> 
            <tr><td><a href="showusers.html?p=${pageNumber -1}">Prev</a></td><td>${pageNumber}</td><td><a href="showusers.html?p=${pageNumber +1}">Next</a></td></tr>
                        </table></h1>
            <form:form commandName="userSearchForm" method="post">
                <table>        
                    <td><h3>Find by username : </h3> </td><td><form:input path="username"/></td><td><input type="submit" value="Search" /></td>
            
                </table>
            </form:form>
        <table border="2" cellspacing="1" width = "98%" align="centre">
            
             <tr>
                 <td><h3>  Username </h3></td><td><h3>  Firstname </h3></td><td><h3>  Lastname  </h3></td>
            </tr>
       <c:forEach items = "${userList}" var="user" >
            <tr>
                <td><h4><a href="edituser.html?user=${user.username}"> ${user.username} </a></h4></td>
                    <td><h4> ${user.firstName} </h4></td><td><h4> ${user.lastName} </h4></td>
            </tr>
       </c:forEach>  
            
        </table>   
    </div>



<%@include file="/WEB-INF/layout/sidenav.jsp"%>
<%@include file="/WEB-INF/layout/footer.jsp"%>