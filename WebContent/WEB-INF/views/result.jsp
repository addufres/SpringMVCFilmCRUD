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
<h1>Here is the film</h1>
<h3>ID</h3>
	${film.id}<br>
<h3>TITLE</h3>
	${film.title}<br>
<h3>DESCRIPTION</h3>
	${film.description}<br>
<h3>YEAR</h3>
	${film.releaseYear}<br>
<h3>LANGUAGE ID</h3>
	${film.languageId}<br>
<h3>RENTAL DURATION</h3>
	${film.rentalDuration}<br>
<h3>RENTAL RATE</h3>
	${film.rentalRate}<br>
<h3>LENGTH</h3>
	${film.length}<br>
<h3>REPLACEMENT COST</h3>
	${film.replacementCost}<br>
<h3>RATING</h3>
	${film.rating}<br>
	

</body>
</html>