	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Film List</title>
</head>
<body>
	<c:choose>
		<c:when test="${! empty film}">
			<c:forEach var="film" items="${film}">
				<h3>Film:</h3>
				<br>
				<table>
					<tr>
						<td>Film ID:</td>
						<td>${film.id}</td>
					</tr>
					<tr>
						<td>Title:</td>
						<td>${film.title}</td>
					</tr>
					<tr>
						<td>Description:</td>
						<td>${film.description}</td>
					</tr>
					<tr>
						<td>Release Year:</td>
						<td>${film.releaseYear}</td>
					</tr>
					<tr>
						<td>Language:</td>
						<td>${film.languageId}</td>
					</tr>
					<tr>
						<td>Rental Duration:</td>
						<td>${film.rentalDuration}</td>
					</tr>
					<tr>
						<td>Rental Rate:</td>
						<td>${film.rentalRate}</td>
					</tr>
					<tr>
						<td>Film Length:</td>
						<td>${film.length}</td>
					</tr>
					<tr>
						<td>Replacement Cost:</td>
						<td>${film.replacementCost}</td>
					</tr>
					<tr>
						<td>Rating:</td>
						<td>${film.rating}</td>
					</tr>
					<tr>
						<td>Cast:</td>
						<td>${film.cast}</td>
					</tr>
					<tr>
						<c:forEach var="category" items="${film.categories}">
							<td>Category: </td>
							<td>${category.name}</td>
						</c:forEach>
					</tr>
					</table>
					</c:forEach>
				<br>
				<form action="delete.do" method="POST">
				To Delete This Film, Enter the Film ID and Select 'Delete' 
					<input type="text" name="filmId"> <input type="submit"
						value="DELETE"/>
				</form>
		</c:when>
		<c:otherwise>
			<p>Your search query did not return any results.</p>
		</c:otherwise>
	</c:choose>
	<br>
	<a href="home.do">Return to Homepage</a>
</body>
</html>