<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<body>

	<form:form action="${pageContext.request.contextPath}/details/editData"
		method="post" modelAttribute="empBean">
		ID <form:input path="employeeId" readonly="true"/>
		<br><br>
  Name <form:input path="employeeName"/>
		<br>
		<br>
  
Department <form:select path="deptId">
			<form:option value="1">HR</form:option>
			<form:option value="2">Devops</form:option>
			<form:option value="3">Accounts</form:option>
		</form:select>
		<br>
		<br>
Salary <form:input path="salary" />
		<br>
		<br>

Address Of employee<br>
		<br>

City <form:input path="city" />
		<br>
		<br>

Street <form:input path="street" />
		<br>
		<br>

Pincode <form:input path="zipCode" />
		<br>
		<br>

		<input type="submit" value="Edit Employee" />
	</form:form>

</body>

</html>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
