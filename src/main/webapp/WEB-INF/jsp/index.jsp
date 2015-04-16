<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <%@include file="/WEB-INF/layout/head.jsp" %>  
    <%@include file="/WEB-INF/layout/message.jsp" %> 
	<div class="item">
                
            <h1><spring:message code="Please_login"/></h1>
                
            <form class="login-form" action="j_spring_security_check" method="post">
		 	
                        <input id="j_username" name="j_username" size="20" maxlength="20" type="text"  placeholder="<spring:message code="username"/>"/>

			<input id="j_password" name="j_password" size="20" maxlength="20" type="password" placeholder="<spring:message code="password"/>" />
			
			<input type="submit" value="<spring:message code="login"/> " />
            </form>
            
            
                    
            
      	</div>

    <%@include file="/WEB-INF/layout/sidenav.jsp"%>
    <%@include file="/WEB-INF/layout/footer.jsp"%>