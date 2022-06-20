<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String list[]={"A","B","C","D","E","F"};
	request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<style>
	square{
	width: 30px;
	height:30px;
	background-color: black;
	border: 2px;
	}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	  <%-- <c:forEach var="i" begin="1" end  = "10" >
	 	<div>
	 	
	 	<c:forEach var = "k" items="${list}">
	 		<div class="square"><a href="#"><c:out value = "${i}${k}" /></a> </div>
	 	</c:forEach>
	 	
	 	</div>
	 </c:forEach>   --%>

	 <table>
	 <tbody>
	 <c:forEach var="i" begin="1" end  = "10" >
	 	<tr>
	 	<%-- <c:forEach var = "j" begin = "1" end = "6"> --%>
	 	<c:forEach var = "k" items="${list}">
	 		<td ><a type="button" class="square"><c:out value = "${i}${k}" /></a> </td>
	 	</c:forEach>
	 	<%-- </c:forEach> --%>
	 	</tr>
	 </c:forEach>
	 </tbody>
	</table> 
</body>
</html>