<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cinema Room List</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
		<h2>Cinema Room List</h2>
		<table class="table table-striped">
			<thead>
				<th scope="row">#</th>
				<th scope="row">Cinema Room ID</th>
				<th scope="row">Cinema Room</th>
				<th scope="row">Seat quantity</th>
				<th scope="row">Seat Detail</th>
			</thead>
			<tbody>
			
				<c:forEach var="cinemaRoom" items="${cinemaRoomList}">
				
					<tr>
					<td></td>
					<td>${cinemaRoom.cinemaRoomId}</td>
					<td>${cinemaRoom.cinemaRoomName}</td>
					<td></td>
					<td ><a  href="${pageContext.request.contextPath}/Seatdetail">Seat detail</a></td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
		<%-- <a class="btn btn-primary" href="${pageContext.request.contextPath}/article/addArticle">Add New Cert</a> --%>
	</div>
</body>
</html>