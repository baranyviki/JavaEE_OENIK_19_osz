<%-- 
    Document   : hero
    Created on : 2019.09.29., 23:18:04
    Author     : Viki
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <form method="post" action="newHero">
            
            Hero Name:<input type="text" name ="name"/></br>
            Description:<input type="type" name="desc"/></br>
            <input type="submit" value="OK"/>
            <c:forEach var="spc" items="${species}">
                ${spc.name}<input type="text" name="${spc.name}">                
            </c:forEach>
        </form>
    </body>
</html>
