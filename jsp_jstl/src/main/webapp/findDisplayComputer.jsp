<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Computer</title>
</head>
<body>
<%-- ${find} --%>
<h3>List of Computer</h3>
<table>
	<tr>
		<th>Author Name</th>
		<th>Book Name</th>
		<th>Book Number</th>
		<th>Price</th>
	</tr>
<%-- 	<c:out value="${find}"></c:out> --%>
	<tr>
		<td><c:out value="${find.id}"/></td>
		<td><c:out value="${find.brand}"/></td>
		<td><c:out value="${find.model}"/></td>
		<td><c:out value="${find.processor}"/></td>
		<td><c:out value="${find.price}"/></td>
	</tr>
<%-- </c:forEach> --%>
</table>
</body>
</html>