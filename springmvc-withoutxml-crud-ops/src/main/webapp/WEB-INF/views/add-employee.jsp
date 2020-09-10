<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>
  .error{color:red}
</style>
<html>
<body>

	<form:form action="${pageContext.request.contextPath}/details/addData"
		method="post" modelAttribute="employeeData">
  Name <form:input path="employeeName" />
  <form:errors path="employeeName" class="error"/>
		<br>
		<br>
  
Department <form:select path="deptId">
			<form:option value="1">HR</form:option>
			<form:option value="2">Devops</form:option>
			<form:option value="3">Accounts</form:option>
		</form:select>
		<form:errors path="deptId" class="error"/>
		<br>
		<br>
Salary <form:input path="salary" />
<form:errors path="salary" class="error"/>
		<br>
		<br>

Address Of employee<br>
		<br>

City <form:input path="city" />
<form:errors path="city" class="error"/>
		<br>
		<br>

Street <form:input path="street" />
<form:errors path="street" class="error"/>
		<br>
		<br>

Pincode <form:input path="zipCode" />
<form:errors path="zipCode" class="error"/>
		<br>
		<br>

		<input type="submit" value="Add Employee" />
	</form:form>

</body>

</html>