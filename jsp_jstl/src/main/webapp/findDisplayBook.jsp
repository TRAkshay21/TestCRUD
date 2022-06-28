<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Book</title>
<style type="text/css" >
table{
	border: 1px solid black;
}

th{
	border: 1px solid blue;
}
tr,td{
	border: 1px solid grey;
}
</style>
</head>
<body>
<%-- ${find} --%>
<h3>List of Books</h3>
<table>
	<tr>
		<th>Id</th>
		<th>Brand</th>
		<th>Model</th>
		<th>Processor</th>
		<th>Price</th>
	</tr>
<%-- 	<c:out value="${find}"></c:out> --%>
	<tr>
	<td><c:out value="${find.authorName}"></c:out></td>
		<td><c:out value="${find.bookName}"></c:out></td>
		<td><c:out value="${find.bookNumber}"></c:out></td>
		<td><c:out value="${find.price}"></c:out></td>
	</tr>
<%-- </c:forEach> --%>
</table>
</body>
</html>