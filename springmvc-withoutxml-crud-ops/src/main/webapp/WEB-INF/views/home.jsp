<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>

	<form:form>
		<table border="1" cellpadding="3" width="70%">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Department</th>
				<th>Salary</th>
				<th>City</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<core:forEach var="emp" items="${employeeList}">
				<tr>
					<td>${emp.employeeId}</td>
					<td>${emp.employeeName}</td>
					<td>${emp.department}</td>
					<td>${emp.salary}</td>
					<td>${emp.city}</td>
					<td><a href="${pageContext.request.contextPath}/details/edit/${emp.employeeId}">Edit</a></td>
					<td><a href="${pageContext.request.contextPath}/details/delete/${emp.employeeId}">Delete</a></td>
				</tr>
			</core:forEach>
		</table>
		<a href="${pageContext.request.contextPath}/details/add">Add a new Employee</a>
	</form:form>

</body>
</html>
