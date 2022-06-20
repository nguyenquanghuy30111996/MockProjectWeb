<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie list</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<h1>Movie list</h1>
<button type="button" class="btn btn-primary">Add new</button>

<table class="table">
  <caption>
  <c:if test="${list.totalPages > 0}" >
  
  <ul class="pagination">
  <li class="page-item"><a class="page-link" href="#">Previous</a></li>
  <c:forEach var="pageNumbers" items="${pageNumbers }">
  <li class="page-item"><a class="page-link" href="#">${pageNumbers}</a></li>
  </c:forEach>
    <li class="page-item"><a class="page-link" href="#">Next</a></li>
  </ul>
  </c:if>
  </caption>
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Movie(ENG)</th>
      <th scope="col">Movie(VN)</th>
      <th scope="col">Release Date</th>
      <th scope="col">Movie Production Company</th>
      <th scope="col">Duration</th>
      <th scope="col">Version</th>
      <th scope="col">Detail</th>
      <th scope="col">Delete</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="model" items="${list.content }" varStatus="loop">
  <tr>
       <th scope="row">${loop.index+1}</th> 
     <td>${model.movieNameEnglish }</td> 
      <td>${model.movieNameVN }</td>
      <td>${model.fromDate }</td>
      <td>${model.movieProductionCompany }</td>
      <td>${model.duration }</td>
      <td>${model.version }</td>
      <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/edit?id=${model.id}">Edit</a> </td>
      <td><a class="btn btn-danger" href="${pageContext.request.contextPath}/delete/${model.id}">Delete</a></td>
    </tr>
  </c:forEach>
    
  </tbody>
</table>

</body>
</html>