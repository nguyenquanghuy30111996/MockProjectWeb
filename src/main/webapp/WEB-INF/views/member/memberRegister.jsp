<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/register.css">
<style>
.error{
color:red;
margin-left: 3pc;
}
</style>
</head>
<body>

<form:form action="${pageContext.request.contextPath}/member/register" method="post" modelAttribute="member">
<h3>REGISTER ACCOUNT</h3>
<div>
<form:input class="input1"  placeholder="Account" type="text" path="username" value="${employee.username}"/>
<form:errors cssClass="error" path="username" />
</div>
<div>
<form:input class="input1"  placeholder="Password" type="password"  path="password" value="${employee.password}"/>
<form:errors cssClass="error" path="password" />
</div>
<div>
<form:input class="input1"  placeholder="Confirm password" type="password"  path="rePassword" value="${employee.rePassword}"/>
<form:errors cssClass="error" path="rePassword" />
</div>
<div>
<form:input class="input1"  placeholder="Full name" type="text"  path="fullName" value="${employee.fullName}"/>
<form:errors cssClass="error" path="fullName" />
</div>
<div>
<form:input class="input1"  placeholder="Date of birth" type="text"  path="dateOfBirth" value="${employee.dateOfBirth}"/>
<form:errors cssClass="error" path="dateOfBirth" />
</div>
<div>
<input class="input2" id="gender" type="radio" name="gender" checked>
<label for="gender">Male</label>
<input class="input2" id="gender" type="radio" name="gender" >
<label for="gender">Female</label>

</div>
<div>
<form:input class="input1"  placeholder="Identity card" type="text"  path="identityCard" value="${employee.identityCard}"/>
<form:errors cssClass="error" path="identityCard" />
</div>
<div>
<form:input class="input1"  placeholder="Email" type="text"  path="email" value="${employee.email}"/>
<form:errors cssClass="error" path="email" />
</div>
<div>
<form:input class="input1"  placeholder="Address" type="text"  path="address" value="${employee.address}"/>
<form:errors cssClass="error" path="address" />
</div>
<div>
<form:input class="input1"  placeholder="Phone number" type="text"  path="phoneNumber" value="${employee.phoneNumber}"/>
<form:errors cssClass="error" path="phoneNumber" />
</div>
<div>
<input class="input3"  type="submit" value="Register" >

</div>
</form:form>
<h3>Have an account already?  <a href="${pageContext.request.contextPath}/member/login">Login</a></h3>
</body>
</html>