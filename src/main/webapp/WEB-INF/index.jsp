
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Demo JSP</title>
    </head>
<body>
	<a href="/product/new">Create New Product</a> <br/> 
	<a href="/category/new">Create New Category</a> <br/>
	<div style="display:flex;">
	<table class="table">
		<c:forEach var="prod" items="${products}">
		<tr>
			<td>
				<a href="/product/${prod.id}"><c:out value="${prod.name }"/></a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<table class="table">
		<c:forEach var="cat" items="${categories}">
		<tr>
			<td>
				<a href="/category/${cat.id}"><c:out value="${cat.name }"/></a>
			</td>
		</tr>
		</c:forEach>
	</table>
	</div>
	
</body>
</html>