<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Books</title>
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

<table>
	<tr>
		<th>Author Name</th>
		<th>Book Name</th>
		<th>Book Number</th>
		<th>Price</th>
	</tr>
<body>	<%-- <c:out value="${book}"></c:out>  // one Book --%>
	<c:forEach items="${books}" var="eachBooks">
	<tr>
		<td><c:out value="${eachBooks.authorName}"></c:out></td>
		<td><c:out value="${eachBooks.bookName}"></c:out></td>
		<td><c:out value="${eachBooks.bookNumber}"></c:out></td>
		<td><c:out value="${eachBooks.price}"></c:out></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>