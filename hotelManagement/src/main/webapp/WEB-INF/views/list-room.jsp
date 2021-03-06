<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Room List</title>
</head>
<body>
    <div id="Table root"></div>
    <table>
        <thead>
            <tr> 
                <th>Room_id</th>
                <th>Room_type</th>
                <th>Capacity</th>
                <th>Status</th>
                <th>Pay_dayrate</th>
                <th>With_toilet</th>
               
            </tr>
        </thead>
        <tbody>
            <c:forEach var="room" items="${allroom}">
                <!-- var-variables,items-collection -->
                <tr>
                    <td>${room.room_id}</td>
                    <td>${room.room_type}</td>
                    <td>${room.capacity}</td>
                    <td>${room.status}</td>
                    <td>${room.pay_dayrate}</td>
                    <td>${room.with_toilet}</td>
                   
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>