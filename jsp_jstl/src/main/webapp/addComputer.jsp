<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Computer</title>
</head>
<body>
<h3>Add Computer</h3>
<form action="computers" method="post">

<div><label for="id">ComputerId</label><input type="text" name="id"/></div>
<div><label for="brand">Brand</label><input type="text" name="brand"/></div>
<div><label for="model">Model</label><input type="text" name="model"/></div>
<div><label for="processor">Processor</label><input type="text" name="processor"/></div>
<div><label for="price">Price</label><input type="text" name="price" /></div>

<input type="submit" value="Add Computer" />

<a href="findComputer.jsp">Find Computer</a> 

</form>  
</body>
</html>