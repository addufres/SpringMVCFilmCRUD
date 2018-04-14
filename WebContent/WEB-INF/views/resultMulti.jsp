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
						<td>Film id:</td>
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
						<td>Year Released:</td>
						<td>${film.releaseYear}</td>
					</tr>
					<tr>
						<td>Language:</td>
						<td>${film.languageId}</td>
					</tr>
					<tr>
						<td>Duration of rental:</td>
						<td>${film.rentalDuration}</td>
					</tr>
					<tr>
						<td>Rental rate:</td>
						<td>${film.rentalRate}</td>
					</tr>
					<tr>
						<td>Length of film:</td>
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
				</table>
				<br>
				<form action="delete.do" method="POST">
				Enter the id for this film to delete it
					<input type="text" name="filmId"> <input type="submit"
						value="delete this film"/>
				</form>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<p>No film found</p>
		</c:otherwise>
	</c:choose>
	<br>
	<a href="home.do">Return home</a>

</body>
</html>