<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<style type ="text/css">
	<%@include file="../css/VehicleSalesFormCSS.css" %>
	</style>
<title>Move To Sold</title>
</head>
<body>

	<h1>SALES DETAILS</h1>
	
	<div id = "listCars"><a id = "listCarsLink" href = "/listCars">BACK TO INVENTORY</a></div>
	<div id = "mainMenu"><a id = "mainMenuLink" href = "mainMenu">MAIN MENU</a></div>
	
	<div id = "inputfields">
		<form action="/action_page.php">
		<label for="vin">VIN:</label>
	    <input type="text" id="vin" name="VIN" placeholder="VIN">
		<br>
		<br>
	    <label for="customerId">Customer ID:</label>
	    <input type="text" id="customerId" name="CUSTOMERID" placeholder="Customer ID">
	    <br>
		<br>
	    <label for="sellingPrice">Selling Price:</label>
	    <input type="text" id="sellingPrice" name="SELLINGPRICE" placeholder="Selling Price">
        </form>
         
         <br>
         <input type="submit" value="SUBMIT" width = 30%>
	</div>
	
	
<div style="text-align:center"><font size ="1">an Andy Szeto creation | 2020 - 2022</font></div>
</body>
</html>