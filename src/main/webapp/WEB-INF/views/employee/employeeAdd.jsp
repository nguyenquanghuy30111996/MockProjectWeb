<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<title>Add new Employee</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main2.css">
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/employee/add"
		method="post" modelAttribute="employee">
		<div class="form1">
			<span>Account/Username: <strong>*</strong></span>
			<form:input placeholder="Account" id="username" type="text"
				path="username" value="${employee.username}" />
			<form:errors path="username" cssClass="error" />
		</div>
		
		<div class="form1">
			<span>Password: <strong>*</strong></span>
			<form:input placeholder="Password" type="password" id="password" path="password"
				value="${employee.password}" />
			<form:errors class="error" path="password" cssClass="error" />
		</div>
		<div class="form1">
			<span>Confirm password: <strong>*</strong></span>
			<form:input placeholder="Confirm password" type="password" id="rePassword"
				path="rePassword" value="${employee.rePassword}" />
			<form:errors path="rePassword" cssClass="error" />
		</div>
		<div class="form1">
			<span>Full name: <strong>*</strong></span>
			<form:input placeholder="Full name" type="text" path="fullName" />
			<form:errors path="fullName" cssClass="error" />
		</div>
		<div class="form1">
			<span>Date of birth: <strong>*</strong></span>
			<form:input type="date" path="dateOfBirth" />
			<form:errors class="error" path="dateOfBirth" cssClass="error" />
		</div>

		<div class="form2">
			<span>Gender: <strong>*</strong></span>
			 <input id="male" name="gender" type="radio" value="M" checked/>
				 <label for="male">Male</label>
			<input id="female" name="gender" type="radio" value="F" />
			  <label  for="female">Female</label>
			<form:errors class="error" path="gender" cssClass="error" />
		</div>

		<div class="form1">
			<span>Identity card: <strong>*</strong></span>
			<form:input placeholder="Identity card" type="text"
				path="identityCard" />
			<form:errors class="error" path="identityCard" cssClass="error" />
		</div>
		<div class="form1">
			<span>Email: <strong>*</strong></span>
			<form:input placeholder="Email" type="text" path="email" />
			<form:errors class="error" path="email" cssClass="error" />
		</div>
		<div class="form1">
			<span>Address: <strong>*</strong></span>
			<form:input placeholder="Address" type="text" path="address" />
			<form:errors class="error" path="address" cssClass="error" />
		</div>
		<div class="form1">
			<span>Phone number: <strong>*</strong></span>
			<form:input placeholder="Phone number" type="text" path="phoneNumber" />
			<form:errors class="error" path="phoneNumber" cssClass="error" />
		</div>
		<div class="form1">
			<span>Image: </span> <input class="file" type="file" name="file" />
		</div>
		<div class="form1">
			<span>Register date: <strong>*</strong></span>
			<form:input type="date" path="registerDate" />
			<form:errors class="error" path="registerDate" cssClass="error" />
		</div>
		<div class="add">
			<input class="btn-add" type="submit" value="Add" /> <a
				class="btn-add"
				href="${pageContext.request.contextPath}/employee/list">Back</a>
		</div>
<script src="../resources/js/checkPassword.js"></script>
	</form:form>