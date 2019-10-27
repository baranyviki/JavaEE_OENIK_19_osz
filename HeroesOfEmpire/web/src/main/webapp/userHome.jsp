<%-- 
    Document   : UserHome
    Created on : 2019.09.30., 21:46:59
    Author     : Viki
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
        <div style="padding-left:30px">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
        ${user.name}'s Heroes and Empires 
           <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    
    </head>
    <body>
        <h1>Heroes</h1>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th>-</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="hero" items="${heroes}">
                    <tr>
                <form method="get" action="modHero" >
                    <input type="hidden"  value="${hero.id}" name="heroid"/>
                    <td>${hero.name}</td>
                    <td>${hero.description}</td>
                    <td><input type="submit" value="Modify"/></td>
                </form>
                <form method="post" action="deleteHero">                
                    <input type="hidden"  value="${hero.id}" name="heroid"/>
                    <td><input type="submit" value="Delete"/></td>
                </form>
            </tr>
        </c:forEach>
    </tbody>
</table>
<h2>
    Add new Hero
</h2>
<form method="post" action="newHero">            
    Hero Name:<input type="text" name ="name"/>
    Description:<input type="type" name="desc"/>
    <br/>
    <c:forEach var="spc" items="${species}">
        ${spc.name}<input type="text" name="${spc.name}">                
    </c:forEach>                
    <input type="submit" value="OK"/>
</form>      


<br/>                

<h1>Empires</h1>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Level</th>
            <th>Environment</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="emp" items="${empires}">
            <tr>
                <td>${emp.name}</td>
                <td>${emp.description}</td>
                <td>${emp.level}</td>                
                <td>${emp.environmentType}</td>
        <form method="get" action="manageEmpire">            
            <input type="hidden"  value="${emp.id}" name="empireid"/>
            <td><input type="submit" value="View"/></td>
        </form>
        <form method="post" action="manageEmpire">                
            <input type="hidden"  value="${emp.id}" name="empireid"/>
            <td><input type="submit" value="Modify"/></td>
        </form>
        <form method="post" action="deleteEmpire">                
            <input type="hidden"  value="${emp.id}" name="empireid"/>
            <td><input type="submit" value="Delete"/></td>
        </form>
    </tr>
</c:forEach>    
</tbody>    
</table>
<h2>Add new Empire</h2>
<form method="post" action="newEmpire">            
    Empire Name:<input type="text" name ="name"/></br>
    Description:<input type="type" name="desc"/><br/>
    <select name="envlist">  
        <option value="Mountainous">Mountainous</option>
        <option value="Flatlands">Flatlands</option>
        <option value="Forest">Forest</option>
        <option value="Budapest">Budapest</option>
        <option value="Beach">Beach</option>
    </select>
    <input type="submit" value="OK"/>
</form>      

</body>
</div>
</html>