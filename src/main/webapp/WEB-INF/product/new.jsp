
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

<form:form action="/product" method="post" modelAttribute="product">
   <h1>New Product</h1>
    <p>
        <form:label path="name">name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="description">description</form:label>
        <form:errors path="description"/>
        <form:input path="description"/>
    </p>
    <p>
        <form:label path="price">price</form:label>
        <form:errors path="price"/>
        <form:input type="number" path="price"/>
    </p>
 
    <input type="submit" value="create"/>
</form:form>    
</body>
</html>