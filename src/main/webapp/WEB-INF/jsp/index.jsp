<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <%@include file="/WEB-INF/layout/head.jsp" %>  
    <%@include file="/WEB-INF/layout/message.jsp" %> 
	<div class="item">
                 
            <h1>Please sign in</h1>
                                
                <form:form commandName="loginForm" method="post">
                    <form:input path="j_username" />
                    <form:password path="j_password" />
                    <form:button class="btn btn-lg btn-primary btn-block" type="submit">Войти</form:button>
                </form:form>
                    
            
      	</div>

    <%@include file="/WEB-INF/layout/sidenav.jsp"%>
    <%@include file="/WEB-INF/layout/footer.jsp"%>