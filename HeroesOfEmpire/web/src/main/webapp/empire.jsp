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
           <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    
    </head>
    <body>
        <h1>View your empire</h1>
        <form method="post" action="manageEmpire">
            Name:<label>${selectedEmpire.name}</label></br>
            <input type="hidden" name="empireName" value="${selectedEmpire.name}" /></br>
            Description:<label  name="level" >${selectedEmpire.description}</label></br>
            Level:<label  name="level" >${selectedEmpire.level}</label></br>
            Environment:<label name="envtype" >${selectedEmpire.environmentType}</label></br> 
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
                
                Buildings:<br/>
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Description</th>
                            
                        </tr>                         
                    </thead>
                    <tbody>
                        <c:forEach var="bul" items="${selectedEmpire.buildings}">
                          <tr>
                                <td>${bul.name}</td>
                                <td>${bul.description}</td>                                
                          </tr>
                        </c:forEach>
                    </tbody>
                <table/>
                </br>                
        </form>
          <h3>Construct a new building</h3>
                <form method="post" action="newBuilding">
                    <select name="buildinglist">  
                       <option value="Barrack">Barrack</option>
                       <option value="Farm">Farm</option>
                       <option value="Blacksmith">Blacksmith</option>
                       <option value="Mine">Mine</option>
                       <option value="Lumberyard">Lumberyard</option>
                       <option value="Townhall">Townhall</option>
                   </select>
                   <input type="hidden" value="${selectedEmpire.id}" name="empireid"/>
                   <input type="submit" value="OK"/>                       
                    
                </form>      
    </body>
</html>
