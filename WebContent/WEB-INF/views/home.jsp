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
	Film ID: 
	<input type="text" name="ID"/> <br>
	Film Title: 
	<input type="text" name="title"/> <br>
	Film Description:
	<input type="text" name="description"/> <br>
	Release Year: 
	<input type="text" name="year"/> <br>
	Language ID:
	<input type="text" name="languageID"/> <br>
	Rental Duration:
	<input type="text" name="rentalduration"/> <br>
	Rental Rate:
	<input type="text" name="rentalrate"/> <br>
	Film Length: 
	<input type="text" name="length"/> <br>
	Replacement Cost:
	<input type="text" name="cost"/> <br>
	Film Rating:
	<input type="text" name="rating"/> <br>
	Special Features:
	<input type="text" name="features"/> <br>
	
	</form>
</body>
</html>
