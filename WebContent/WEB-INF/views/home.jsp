<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>WELCOME TO 'LE THEATRE</h1>
<br>
<h3>FILL OUT THIS FORM TO ADD A FILM</h3>
	<form action="addfilm.do" method="POST">
	Film Title: 
	<input type="text" name="title"/> <br>
	Film Description:
	<input type="text" name="description"/> <br>
	(must be between 1900 - current year)Release Year: 
	<input type="text" name="year"/> <br>
	(1-5)Language ID:
	<input type="text" name="languageID"/> <br>
	Rental Duration:
	<input type="text" name="rentalduration"/> <br>
	(less than 50) Rental Rate:
	<input type="text" name="rentalrate"/> <br>
	Film Length: 
	<input type="text" name="length"/> <br>
	Replacement Cost:
	<input type="text" name="cost"/> <br>
	Film Rating:
	<input type="text" name="rating"/> <br>
	<input type="submit" value="Submit">
	</form>
	
<h3>ENTER AN ID TO SEARCH FOR A FILM</h3>
	<form action="result.do" method="GET">
	<input type="text" name="ID">
	<input type="submit" value="SEARCH">
	</form>
<h3>ENTER TEXT TO SEARCH FOR A FILM</h3>
	<form action="search.do" method="GET">
	<input type="text" name="search">
	<input type="submit" value="SEARCH">
	</form>
	
	<h3>FILL OUT THIS FORM TO UPDATE A FILM</h3>
	<form action="update.do" method="POST">
	ID for film to update:
	<input type="text" name="id"/><br>
	Updated Title: 
	<input type="text" name="title"/> <br>
	Updated Description:
	<input type="text" name="description"/> <br>
	(must be between 1900 - current year)Updated Release Year: 
	<input type="text" name="year"/> <br>
	(1-5)Updated Language ID:
	<input type="text" name="languageID"/> <br>
	Updated Rental Duration:
	<input type="text" name="rentalduration"/> <br>
	(less than 50) Updated Rental Rate:
	<input type="text" name="rentalrate"/> <br>
	Updated Film Length: 
	<input type="text" name="length"/> <br>
	Updated Replacement Cost:
	<input type="text" name="cost"/> <br>
	Updated Film Rating:
	<input type="text" name="rating"/> <br>
	<input type="submit" value="Submit"/>
	</form>
</body>
</html>
