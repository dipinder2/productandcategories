
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title><c:out value="${category.name}"/></title>
    </head>
<body>
	
	

	<!--  Display whatever categories it has -->
	
	<h1><c:out value="${category.name}"/></h1>
	<c:forEach var="prod" items="${category.products}">
		<li>${prod.name}</li>
	</c:forEach>
	  
	 <!-- ------------------------------------ --> 
	
	<form action="/addRelation/${category.id }" method="post">
		<select name="pId">
		<c:forEach var="i" items="${products}">
			<option value="${i.id}">
				<c:out value="${i.name}"/>
			</option>
		</c:forEach>
		</select>
	<input type="submit" value="add product">	
	
	</form>
	
</body>
</html>