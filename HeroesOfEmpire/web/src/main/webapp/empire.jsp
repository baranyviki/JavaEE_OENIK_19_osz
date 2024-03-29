<%-- 
    Document   : empire
    Created on : 2019.10.01., 22:02:34
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
        <h1>View your empire</h1>
        <form method="post" action="manageEmpire">
            Name:<label>${selectedEmpire.name}</label></br>
            <input type="hidden" name="empireName" value="${selectedEmpire.name}" /></br>
            Description:<label  name="level" >${selectedEmpire.description}</label></br>
            Level:<label  name="level" >${selectedEmpire.level}</label></br>
            Environment:<label name="envtype" >${selectedEmpire.environmentType}</label></br>
                Produce:<br/>
                <table>
                    <thead>
                        <tr>
                            <th>Asset Name</th>
                            <th>Description</th>
                            <th>Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="stock" items="${selectedEmpire.produce}">
                            <tr>                            
                                <td>${stock.asset.name}</td>
                                <td>${stock.asset.name}</td>
                                <td>${stock.quantity}</td>                            
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                Warehouse:<br/>
                <table>
                    <thead>
                        <tr>
                            <th>Asset Name</th>
                            <th>Description</th>
                            <th>Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="stock" items="${selectedEmpire.warehouse}">
                            <tr>                            
                                <td>${stock.asset.name}</td>
                                <td>${stock.asset.name}</td>
                                <td>${stock.quantity}</td>                            
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                Population:<br/>
                <table>
                    <thead>
                        <tr>
                            <th>People Name</th>
                            <th>People Description</th>
                            <th>Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pop" items="${selectedEmpire.population}">
                            <tr>                            
                                <td>${pop.people.name}</td>
                                <td>${pop.people.description}</td>
                                <td>${pop.quantity}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </br>
        </form>
    </body>
</html>
