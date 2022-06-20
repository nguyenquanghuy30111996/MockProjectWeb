<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<title>Add new Employee</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main2.css">
<style>
.error{
 color:red;
}
</style>
</head>
<body>
	<form:form
		action="${pageContext.request.contextPath}/employee/edit?id=${employee.id}" modelAttribute = "employee"
		method="post">
		<div class="form1">
			<span>Account/Username: <strong>*</strong></span> <input
				class="disabled" placeholder="Account" type="text" name="username"
				value="${employee.username}" disabled>
		</div>
		
		<div class="form1">
			<span>Password: <strong>*</strong></span> 
			<form:input placeholder="Password" type="password" path="password" value="${employee.password}"/>
			<form:errors path="password" cssClass="error"></form:errors>
		</div>
		<div class="form1">
			<span>Confirm password: <strong>*</strong></span> 
			<form:input
				placeholder="Confirm password" type="password" path="rePassword"
				value="${employee.rePassword}"/>
				<form:errors path="rePassword" cssClass="error"></form:errors>
				
		</div>
		<div class="form1">
			<span>Full name: <strong>*</strong></span> <input
				placeholder="Full name" type="text" name="fullName"
				value="${employee.fullName}" />

		</div>
		<div class="form1">
			<span>Date of birth: <strong>*</strong></span> <input
				placeholder="Date of birth" type="date" name="dateOfBirth"
				value="${employee.dateOfBirth}">
		</div>

		<div class="form2">
			<span>Gender: <strong>*</strong></span> <input type="radio" id="male"
				name="gender" value="M" checked> <label for="male">Male</label>
			<input type="radio" id="female" name="gender" value="F" > <label
				for="female">Female</label>
		</div>

		<div class="form1">
			<span>Identity card: <strong>*</strong></span> <input
				placeholder="Identity card" type="text" name="identityCard"
				value="${employee.identityCard}" disabled>
		</div>
		<div class="form1">
			<span>Email: <strong>*</strong></span> <input placeholder="Email"
				type="email" name="email" value="${employee.email}" >
		</div>
		<div class="form1">
			<span>Address: <strong>*</strong></span> <input placeholder="Address"
				type="text" name="address" value="${employee.address}">
		</div>
		<div class="form1">
			<span>Phone number: <strong>*</strong></span> <input
				placeholder="Phone number" type="text" name="phoneNumber"
				value="${employee.phoneNumber}">
		</div>
		<div class="form1">
			<span>Image: </span> <input class="file" type="file" name="">
		</div>
	
			<input type="hidden" name="registerDate" value="${employee.registerDate}" />
		
		
		<div class="add">
			<input class="btn-add" type="submit" value="Save"> <a
				class="btn-add"
				href="${pageContext.request.contextPath}/employee/list">Back</a>
		</div>
	</form:form>