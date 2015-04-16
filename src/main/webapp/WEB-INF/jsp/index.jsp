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
                
            <form class="login-form" action="j_spring_security_check" method="post">
		 	
                        <input id="j_username" name="j_username" size="20" maxlength="20" type="text"  placeholder="Username"/>

			<input id="j_password" name="j_password" size="20" maxlength="20" type="password" placeholder="Password" />
			
			<input type="submit" value="Login" />
            </form>
            
            
                    
            
      	</div>

    <%@include file="/WEB-INF/layout/sidenav.jsp"%>
    <%@include file="/WEB-INF/layout/footer.jsp"%>