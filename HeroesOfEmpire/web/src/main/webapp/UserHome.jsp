<%-- 
    Document   : UserHome
    Created on : 2019.09.30., 21:46:59
    Author     : Viki
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
        ${user.name}'s Heroes and Empires 
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
                    <input type="hidden"  value="${hero.name}" name="heroname"/>
                    <td>${hero.name}</td>
                    <td>${hero.description}</td>
                    <td><input type="submit" value="Modify"/></td>
                </form>
                <form method="post" action="deleteHero">                
                    <input type="hidden"  value="${hero.name}" name="heroname"/>
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
            <input type="hidden"  value="${emp.name}" name="empirename"/>
            <td><input type="submit" value="View"/></td>
        </form>
        <form method="post" action="manageEmpire">                
            <input type="hidden"  value="${emp.name}" name="empirename"/>
            <td><input type="submit" value="Modify"/></td>
        </form>
        <form method="post" action="deleteEmpire">                
            <input type="hidden"  value="${emp.name}" name="empirename"/>
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
</html>