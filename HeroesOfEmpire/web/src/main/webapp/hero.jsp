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
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    </head>
    <body>        
        <form method="post" action="modHero">
            Hero Name:<label>${selectedHero.name}</label>
            <input type="hidden" name ="heroid" value="${selectedHero.id}"/></br>
            Description:<input type="text" name="desc" value="${selectedHero.description}" /></br>
            <c:forEach var="hyb" items="${hybrids}">
                ${hyb.species.name}<input type="text" name="${hyb.species.name}" value="${hyb.percent}"><br/>
            </c:forEach>
            <input type="submit" value="OK"/>
        </form>      
        
    </body>
</html>
