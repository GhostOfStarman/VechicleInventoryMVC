<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<style type ="text/css">
	<%@include file="../css/VehicleFinancingFormCSS.css" %>
	</style>
<title>Finance Form</title>
</head>
<body>

	<h1>ENTER FINANCING DETAILS</h1>
	
	<div id = "listCars"><a id = "listCarsLink" href = "/listCars">BACK TO INVENTORY</a></div>
	<div id = "mainMenu"><a id = "mainMenuLink" href = "mainMenu">MAIN MENU</a></div>
	
	<div id = "inputfields">
		<form action="/action_page.php">
		<label for="financeId">Finance ID:</label>
	    <input type="text" id="financeId" name="FINANCEID" placeholder="#">
		<label for="customerId">Customer ID:</label>
	    <input type="text" id="customerId" name="CUSTOMERID" placeholder="#">
	    <br>
		<br>
		<label for="vin">VIN:</label>
	    <input type="text" id="vin" name="VIN" placeholder="VIN">
		<br>
		<br>
		<label for="sellingPrice">Selling Price:</label>
	    <input type="text" id="sellingPrice" name="SELLINGPRICE" placeholder="$0.00">
	    <br>
		<br>
	    <label for="creditScore">Credit Score:</label>
	    <input type="text" id="creditScore" name="CREDITSCORE" placeholder="Score">
	    <br>
		<br>
	    <label for="interestRate">Interest Rate:</label>
	    <input type="text" id="interestRate" name="INTERESTRATE" placeholder="%">
	    <br>
		<br>
	    <label for="term">Term:</label>
	    <input type="text" id="term" name="TERM" placeholder="#">
	    <br>
		<br>
	    <label for="downPayment">Down Payment:</label>
	    <input type="text" id="downPayment" name="DOWNPAYMENT" placeholder="$0.00">

        </form>
         
         <br>
          <input type="submit" value="SUBMIT" width = 30%>
	</div>
	<div style="text-align:center"><font size ="1">an Andy Szeto creation | 2020 - 2022</font></div>
</body>
</html>