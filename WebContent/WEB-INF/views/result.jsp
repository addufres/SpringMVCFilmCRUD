<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Results</title>
</head>
<body>


    ${Film.id}<br>
    ${Film.title}<br>
    ${Film.description}<br>
    ${Film.releaseYear}<br>
    ${Film.languageId}<br>
    ${Film.rentalDuration}<br>
    ${Film.rentalRate}<br>
    ${Film.length}<br>
    ${Film.replacementCost}<br>
    ${Film.rating}<br>
    ${Film.specialFeatures}<br>


	${Film.ID}
	<br> ${Film.title}
	<br> ${Film.description}
	<br> ${Film.year}
	<br> ${Film.languageID}
	<br> ${Film.rentalduration}
	<br> ${Film.rentalrate}
	<br> ${Film.length}
	<br> ${Film.cost}
	<br> ${Film.rating}
	<br>

</body>
</html>