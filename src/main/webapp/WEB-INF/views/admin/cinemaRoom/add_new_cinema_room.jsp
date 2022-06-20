<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container">
	<h2>Add New Cinema Room</h2>
	<form:form method="POST" action="${pageContext.request.contextPath }/saveCinemaRoom" modelAttribute="cinemaRoom" ccsClass="form">
	
	<div class="form-group">
	<label>CinemaRoomID</label>
	<form:input path="cinemaRoomId" cssClass="form-control" id="cinemaRoomId"/>
	<%-- <form:errors path="id" cssClass="error" style="color:red" /> --%>
	</div>
	<div class="form-group">
	<label>Cinema Room Name</label>
	<form:input path="cinemaRoomName" cssClass="form-control" id="cinemaRoomName"/>
	<%-- <form:errors path="cinemaRoomName" cssClass="error" style="color:red" /> --%>
	</div>
	<button type="submit" class="btn btn-primary">Save</button>
	</form:form>
	</div>
</body>
</html>