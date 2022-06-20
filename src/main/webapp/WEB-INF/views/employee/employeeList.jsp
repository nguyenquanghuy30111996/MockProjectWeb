<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Employee List Page</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js">

</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">  
<script>  
$(document).ready (function () {  
    $('#data').after ('<div id="nav"></div>');  
    var rowsShown = 2;  
    var rowsTotal = $('#data tbody tr').length;  
    var numPages = rowsTotal/rowsShown;  
    for (i = 0;i < numPages;i++) {  
        var pageNum = i + 1;  
        $('#nav').append ('<a href="#" rel="'+i+'">'+pageNum+'</a> ');  
    }  
    $('#data tbody tr').hide();
    $('#data tbody tr').slice (0, rowsShown).show();  
    $('#nav a:first').addClass('active');  
    $('#nav a').bind('click', function() {  
    $('#nav a').removeClass('active');  
   $(this).addClass('active');  
        var currPage = $(this).attr('rel');  
        var startItem = currPage * rowsShown;  
        var endItem = startItem + rowsShown;  
        $('#data tr').css('opacity','0.0').hide().slice(startItem, endItem).  
        css('display','table-row').animate({opacity:1}, 300);  
    });  
});  
</script>
<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#data tr td").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) - 1)
    });
  });
});
</script>

 
</head>
<body>

	<div>
		<h3>Employee list</h3>
		<c:if test="${not empty message}"></c:if>
		<div class="alert alert-success text-center">${message}</div>
	</div>


	<a class="btn btn-primary btn-sm"
		href="${pageContext.request.contextPath}/employee/add">Add new</a>

	<div class="search">
		<label for="search">Search : </label> <input id="myInput" type="search">
	</div>
	<div class="page" align="center">
		<table class="table table-hover table-bordered" id="data"  align="center">
			<thead >
				<tr >
					<th>#</th>
					<th>Username</th>
					<th>Full name</th>
					<th>Date of birth</th>
					<th>Gender</th>
					<th>Email</th>
					<th>Identity card</th>
					<th>Phone number</th>
					<th>Address</th>
					<th>Register date</th>
					<th>Edit</th>
					<th>Delete</th>

				</tr>
			</thead>
			<tbody >

				<c:forEach var="model" items="${list}">
					<tr id="data tr td">
						<td>${model.id}</td>
						<td>${model.username}</td>
						<td>${model.fullName}</td>
						<td>${model.dateOfBirth}</td>
						<td>${model.gender}</td>
						<td>${model.email}</td>
						<td></td>
						<td>${model.phoneNumber}</td>
						<td>${model.address}</td>
						<td>${model.registerDate}</td>
						<td><a
							href="${pageContext.request.contextPath}/employee/edit?id=${model.id}"><img
								class="edit" alt=""
								src="${pageContext.request.contextPath}/resources/img/edit.ico"></a></td>
						<td><a
							href="${pageContext.request.contextPath}/employee/delete?id=${model.id}"><img
								class="delete" alt=""
								src="${pageContext.request.contextPath}/resources/img/delete.ico"></a></td>
					</tr>


				</c:forEach>



			</tbody>


		</table>

	</div>
	
	
	
</body>
</html>