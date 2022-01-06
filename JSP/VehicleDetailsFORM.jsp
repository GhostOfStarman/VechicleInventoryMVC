<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<style type ="text/css">
	<%@include file="../css/VehicleDetailsFormCSS.css" %>
	</style>
<title>Vehicle Details Form</title>
</head>
<body>

	<h1>ENTER VEHICLE DETAILS</h1>
	
	<div id = "listCars"><a id = "listCarsLink" href = "/listCars">BACK TO INVENTORY</a></div>
	<div id = "mainMenu"><a id = "mainMenuLink" href = "mainMenu">MAIN MENU</a></div>
	
	<div id = "inputfields">
		<form action="/action_page.php">
		<label for="vin">VIN:</label>
	    <input type="text" id="vin" name="VIN" placeholder="VIN">
		<br>
		<br>
	    <label for="make">Make:</label>
	    <input type="text" id="make" name="MAKE" placeholder="Make">
	    <br>
		<br>
	    <label for="model">Model:</label>
	    <input type="text" id="model" name="MODEL" placeholder="Model">
	    <br>
		<br>
	    <label for="year">Year:</label>
	    <input type="text" id="make" name="YEAR" placeholder="Year">
	    <br>
		<br>
	    <label for="extColor">ExtColor:</label>
	    <input type="text" id="extColor" name="EXTCOLOR" placeholder="ExtColor">
	    <br>
		<br>
	    <label for="intColor">IntColor:</label>
	    <input type="text" id="intColor" name="INTCOLOR" placeholder="IntColor">
	    <br>
		<br>
	    <label for="mileage">Mileage:</label>
	    <input type="text" id="mileage" name="MILEAGE" placeholder="Mileage">
	    <br>
		<br>
	    <label for="currCondition">Condition:</label>
	    <input type="text" id="currCondition" name="CURRCONDITION" placeholder="Condition">
	    <br>
		<br>
	    <label for="titleStatus">Title Status:</label>
	    <input type="text" id="titleStatus" name="TITLESTATUS" placeholder="Title">
	    <br>
		<br>
	    <label for="driveTrain">Drivetrain:</label>
	    <input type="text" id="driveTrain" name="DRIVETRAIN" placeholder="Drivetrain">
		<br>
		<br>
	    <label for="transmission">Transmission:</label>
	    <input type="text" id="transmission" name="TRANSMISSION" placeholder="Transmission">
	    <br>
		<br>
	    <label for="fuelType">Fuel Type:</label>
	    <input type="text" id="fuelType" name="FUELTYPE" placeholder="Fuel">
	    <br>
		<br>
	    <label for="price">Price:</label>
	    <input type="text" id="price" name="PRICE" placeholder="Price">
	    
	    
	    
         </form>
         <br>
          <input type="submit" value="SUBMIT" width = 30%>
	</div>
	<div style="text-align:center"><font size ="1">an Andy Szeto creation | 2020 - 2022</font></div>
</body>
</html>