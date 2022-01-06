<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<style type ="text/css">
	<%@include file="../css/UserDetailsFormCSS.css" %>
	</style>
<title>User Details Form</title>
</head>
<body>

	<h1>ENTER USER DETAILS</h1>
	
	<div id = "listUsers"><a id = "listUsersLink" href = "/listCars">BACK TO USER DIRECTORY</a></div>
	<div id = "mainMenu"><a id = "mainMenuLink" href = "mainMenu">MAIN MENU</a></div>
	
	<div id = "inputfields">
		<form action="/action_page.php">
		<label for="idno">IDNo:</label>
	    <input type="text" id="idno" name="IDNO" placeholder="#">
		<br>
		<br>
	    <label for="username">Username:</label>
	    <input type="text" id="username" name="USERNAME" placeholder="">
	    <br>
		<br>
	    <label for="password">Password:</label>
	    <input type="text" id="password" name="PASSWORD" placeholder="">
	    <br>
		<br>
	    <label for="firstName">First Name:</label>
	    <input type="text" id="firstName" name="FIRSTNAME" placeholder="">
	    <br>
		<br>
	    <label for="lastName">Last Name:</label>
	    <input type="text" id="lastName" name="LASTNAME" placeholder="">
	    <br>
		<br>
	    <label for="emailAddress">Email Address:</label>
	    <input type="text" id="emailAddress" name="EMAILADDRESS" placeholder="">
	    <br>
		<br>
	    <label for="mailAddress">Mailing Address:</label>
	    <input type="text" id="mailAddress" name="MAILADDRESS" placeholder="">
	    <br>
		<br>
	    <label for="phoneNo">Phone Number:</label>
	    <input type="text" id="phoneNo" name="PHONENO" placeholder="">
         </form>
         <br>
          <input type="submit" value="SUBMIT" width = 30%>
	</div>
	<div style="text-align:center"><font size ="1">an Andy Szeto creation | 2020 - 2022</font></div>
</body>
</html>