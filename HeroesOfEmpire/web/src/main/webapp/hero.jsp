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
        <form method="post" action="modHero">
            Hero Name:<label>${selectedHero.name}</label><input type="hidden" name ="heroname" value="${selectedHero.name}"/></br>
            Description:<input type="text" name="desc" value="${selectedHero.description}" /></br>
            <c:forEach var="hyb" items="${hybrids}">
                ${hyb.species.name}<input type="text" name="${hyb.species.name}" value="${hyb.percent}"><br/>
            </c:forEach>
            <input type="submit" value="OK"/>
        </form>      
        
    </body>
</html>
