<%-- 
    Document   : message
    Created on : 04.04.2015, 12:24:06
    Author     : amd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <% 
        String message = request.getParameter("message");
    %>
                    <% if(message != null){ %>
			<div class="item">
                            <% out.print(""+message); %>
			</div>
                    <% } %>
			