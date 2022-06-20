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
  
  <!-- <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/css/jquery.dataTables.css">
  <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/css/jquery.dataTables_themeroller.css">
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.7.1.min.js"></script>
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/jquery.dataTables.min.js"></script> -->
</head>
<body>
<div class="container">
		<h2>Cinema Room List</h2>
		<div>
		<a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/addCinemaRoom">Add new sss</a>
		<!-- <button class="btn btn-success"></button> -->
		</div>
		<%-- <div style="float:right">
		<form action="${pageContext.request.contextPath}/" method="GET">
		<input type ="submit" value = "Search">
		<input type="text" name="keyword">
		</form>
		</div> --%>
		<table class="table table-striped" class="dataTable123" id="dataTable">
			<thead>
				<th scope="row">#</th>
				<th scope="row">Cinema Room ID</th>
				<th scope="row">Cinema Room</th>
				<th scope="row">Seat quantity</th>
				<th scope="row">Seat Detail</th>
			</thead>
			<tbody>
				<c:set var="i" value="${0}"/>
				<c:forEach var="cinemaRoom" items="${cinemaRoomList}">
				
					<tr>
					<td><c:out value="${i=i+1}"/></td>
					<td>${cinemaRoom.cinemaRoomId}</td>
					<td>${cinemaRoom.cinemaRoomName}</td>
					<td>60</td>
					 <td ><a  href="${pageContext.request.contextPath}/seatDetail">Seat detail</a></td>
					<!-- <td><a href="seat_detail"></a>Seat detail</td>${cinemaRoom.cinemaRoomId} -->
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
		
		
		<div>
		
		<!-- cach 2 -->
		<%-- <a role="button" href="${pageContext.request.contextPath}/page/${currentPage - 1}/${totalPages}">
			Previous
		</a>
		<a role="button" href="${pageContext.request.contextPath}/listPage/${currentPage}+'${a}'">
			<span>${currentPage}</span> 
			<span style="visibility: hidden;">${totalPages}</span>
		<!-- </a> -->
		<a role="button" href="${pageContext.request.contextPath}/page/${currentPage + 1}/${totalPages}">
			Next
		</a> --%>
		
		
		<!--cach 1  -->
		    <%-- <c:if test="${currentPage > 1 }">
			<a role="button" href="${pageContext.request.contextPath}/listPage/${currentPage - 1}">
			Previous
			</a>
			</c:if>
			 
			<c:forEach var="j" begin="1" end  = "${totalPages}" >
			<c:if test ="${j != currentPage}">
			<a role="button" href="${pageContext.request.contextPath}/listPage/${j}">
			<c:out value ="${j}"/>
			</a>
			</c:if>
			</c:forEach>
			<c:if test="${currentPage < totalPages }">
			<a role="button" href="${pageContext.request.contextPath}/listPage/${currentPage + 1}">
			Next
			</a>
			</c:if> --%>
		</div>
		
	</div>
	
</body>
<!-- <script type="text/javascript">
		$(document).ready(function() {
		    $('#example').dataTable({"sPaginationType": "full_numbers"});
		});
		</script> -->
</html>
