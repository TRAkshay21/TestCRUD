<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Computer</title>
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
<table>
	<h3>Computer Details</h3>
	<tr>
		<th>Id</th>
		<th>Computer Brand</th>
		<th>Computer Model</th>
		<th>Processor</th>
		<th>Price</th>
	</tr>

	<%-- <c:out value="${computer}" /> --%>
	<c:forEach items="${computer}" var="eachComputer">
		<tr>
			<td><c:out value="${eachComputer.id}"></c:out></td>
			<td><c:out value="${eachComputer.brand}"></c:out></td>
			<td><c:out value="${eachComputer.model}"></c:out></td>
			<td><c:out value="${eachComputer.processor}"></c:out></td>
			<td><c:out value="${eachComputer.price}"></c:out></td>
		</tr>
</c:forEach>

</table>
</body>
</html>