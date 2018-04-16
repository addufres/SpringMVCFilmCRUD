<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Homepage</title>
</head>
<body>

<h2>WELCOME TO 'LE THEATRE</h2>
<br>
<h3>ADD A FILM:</h3>
	<form action="addfilm.do" method="POST">
	Film Title: 
	<input type="text" name="title"/> <br>
	Film Description:
	<input type="text" name="description"/> <br>
	Release Year (1900 or Later): 
	<input type="text" name="year"/> <br>
	Language ID:
	<select id="languageID" name="languageID">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
</select> <br>
	<!-- <input type="text" name="languageID"/> <br> -->
	Rental Duration:
		<select id="rentalduration" name="rentalduration">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
  <option value="6">6</option>
  <option value="7">7</option>
  <option value="8">8</option>
  <option value="9">9</option>
  <option value="10">10</option>
</select> <br>
	<!-- <input type="text" name="rentalduration"/> <br> -->
	Rental Rate ($49.99 or Less):
	<input type="text" name="rentalrate"/> <br>
	Film Length: 
	<input type="text" name="length"/> <br>
	Replacement Cost:
	<input type="text" name="cost"/> <br>
	Film Rating:
			<select id="rating" name="rating">
  <option value="G">G</option>
  <option value="PG">PG</option>
  <option value="PG13">PG13</option>
  <option value="R">R</option>
  <option value="NC17">NC17</option>
  
</select> <br>
<!-- 	<input type="text" name="rating"/> <br> -->
	<input type="submit" value="Submit">
	</form>
	
<h3>SEARCH FOR FILM BY ID</h3>
	<form action="result.do" method="GET">
	<input type="text" name="ID">
	<input type="submit" value="SEARCH">
	</form>
<h3>SEARCH FOR FILM BY KEYWORD:</h3>
	<form action="search.do" method="GET">
	<input type="text" name="search">
	<input type="submit" value="SEARCH">
	</form>
	
	<h3>UPDATE FILM INFORMATION:</h3>
	<form action="update.do" method="POST">
	ID for Film to update:
	<input type="text" name="id"/><br>
	Updated Title: 
	<input type="text" name="title"/> <br>
	Updated Description:
	<input type="text" name="description"/> <br>
	Updated Release Year(1900 or Later): 
	<input type="text" name="year"/> <br>
	Updated Language ID:
		<select id="languageID" name="languageID">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
</select> <br>
	Updated Rental Duration:
			<select id="rentalduration" name="rentalduration">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
  <option value="6">6</option>
  <option value="7">7</option>
  <option value="8">8</option>
  <option value="9">9</option>
  <option value="10">10</option>
</select> <br>
	Updated Rental Rate($49.99 or Less):
	<input type="text" name="rentalrate"/> <br>
	Updated Film Length: 
	<input type="text" name="length"/> <br>
	Updated Replacement Cost:
	<input type="text" name="cost"/> <br>
	Updated Film Rating:
		<select id="rating" name="rating">
  <option value="G">G</option>
  <option value="PG">PG</option>
  <option value="PG13">PG13</option>
  <option value="R">R</option>
  <option value="NC17">NC17</option>
  
</select> <br>
	<input type="submit" value="Submit"/>
	</form>
	
	<a href="https://github.com/addufres/SpringMVCFilmCRUD/blob/master/README.md" target="_blank">Github README</a>
</body>
</html>
