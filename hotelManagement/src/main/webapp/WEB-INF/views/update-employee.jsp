<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
	<div id="root">
		<div id="form">
			<form:form action="updateemployee" method="post" modelAttribute="updateemployee">
				<div>
					<label for="emp_id">Emp_id</label>
					<div>
						<form:input path="emp_id" />
					</div>
				</div>
				<div>
					<label for="f_name">F_name</label>
					<div>
						<form:input path="f_name" />
					</div>
				</div>
				<div>
					<label for="l_name">L_name</label>
					<div>
						<form:input path="l_name" />
					</div>
				</div>
				<div>
					<label for="phone">Phone</label>
					<div>
						<form:input path="phone" />
					</div>
				  </div>
				<label for="dob">Dob</label>
					<div>
						<form:input path="dob" />
					</div>
				    <div>
					<label for="address">Address</label>
					<div>
						<form:input path="address" />
					</div>
				</div>
				<div>
					<label for="gender">Gender</label>
					<div>
						<form:input path="gender" />
					</div>
				</div>
				<div>
				<div>
					<label for="email">Email</label>
					<div>
						<form:input path="email" />
					</div>
				</div>
				<div>
					<label for="qualification">Qualification</label>
					<div>
						<form:input path="qualification" />
					</div>
				</div>
				<div>
					<label for="role">Role</label>
					<div>
						<form:input path="role" />
					</div>
				</div>
				<div>
					<label for="date_of_joining">Date_of_joining</label>
					<div>
						<form:input path="date_of_joining" />
					</div>
				</div>
				<div>
					<label for="department">Department</label>
					<div>
						<form:input path="department" />
					</div>
				</div>
				<div>
					<label for="manager">Manager</label>
					<div>
						<form:input path="manager" />
					</div>
					<form:button>Update Employee</form:button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>