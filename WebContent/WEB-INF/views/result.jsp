<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Results</title>
</head>
<body>
<h3> Results</h3>

<c:choose>

<c:when test="${! empty film}">
ID:			${film.id}<br>
Title:		${film.title}<br>
Description:	${film.description}<br>
Release Year:	${film.releaseYear}<br>
Language ID:	${film.languageId}<br>
Rental Duration:	${film.rentalDuration}<br>
Rental Rate:	${film.rentalRate}<br>
Film Length:	${film.length}<br>
Replacement Cost:	${film.replacementCost}<br>
Rating:		${film.rating} <br>
<c:forEach var="film" items="${film.categories}">
<table>
<tr>
<td></td>
<td>${film }</td>
</tr>
</table>
</c:forEach>
Cast:
<c:forEach var="film" items="${film.cast}">
<table>
<tr>
<td></td>
<td>${film }</td>
</tr>
</table>
</c:forEach>

<br> <br> <br>
<form action="delete.do" method="POST">
To Delete This Film, Enter the Film ID and Select 'Delete' 
<input type="text" name="filmId">

<input type="submit" value="Delete"></form><br>
</c:when>
<c:otherwise>
<p>Your search query did not return any results.</p>
</c:otherwise>


</c:choose>

<br>
<br>
<br>	
<a href="home.do">Return to Homepage</a>

</body>
</html>