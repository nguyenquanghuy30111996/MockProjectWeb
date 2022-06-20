<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">
<style>
.error{
color:red;
margin-left: 3pc;
}
</style>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/member/login" method="post" modelAttribute="member">
<h3 class="title">LOGIN</h3>
<div>
<form:input class="input1"  placeholder="Username" type="text" path="username"/>
<form:errors cssClass="error" path="username" />
</div>
<div>
<form:input class="input1" placeholder="Password" type="password" path="password"/>
<form:errors cssClass="error" path="password" />
</div>
<div>
<input class="input2" placeholder="Password" type="submit" value="Login" >
</div>
</form:form>
<div>
<h3 class="action">Don't have an account yet?<a href="${pageContext.request.contextPath}/member/register">Register now!</a></h3>

</div>
</body>
</html>