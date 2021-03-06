<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hotel List</title>
</head>
<body>
    <div id="Table root"></div>
    <table>
        <thead>
            <tr> 
                <th>Emp_id</th>
                <th>F_name</th>
                <th>L_name</th>
                <th>Phone</th>
                <th>Dob</th>
                <th>Address</th>
                <th>Gender</th>
                <th>Email</th>
                <th>Qualification</th>
                <th>Role</th>
                <th>Date_of_joining</th>
                <th>Department</th>
                 <th>Manager</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="employee" items="${allemployee}">
                <!-- var-variables,items-collection -->
                <tr>
                    <td>${employee.emp_id}</td>
                    <td>${employee.f_name}</td>
                    <td>${employee.l_name}</td>
                    <td>${employee.phone}</td>
                    <td>${employee.dob}</td>
                    <td>${employee.address}</td>
                    <td>${employee.gender}</td>
                    <td>${employee.email}</td>
                    <td>${employee.qualification}</td>
                    <td>${employee.role}</td>
                    <td>${employee.date_of_joining}</td>
                    <td>${employee.department}</td>
                    <td>${employee.manager}</td>
                   
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>