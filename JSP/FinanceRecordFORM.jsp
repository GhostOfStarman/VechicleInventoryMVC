<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<style type ="text/css">
	<%@include file="../css/FinanceRecordsFormCSS.css" %>
	</style>
<title>Vehicle Details Form</title>
</head>
<body>

	<h1>EDIT FINANCE RECORD DETAILS</h1>
	
	<div id = "listCars"><a id = "listCarsLink" href = "/listCars">BACK TO INVENTORY</a></div>
	<div id = "mainMenu"><a id = "mainMenuLink" href = "mainMenu">MAIN MENU</a></div>
	
	<div id = "inputfields">
		<form action="/action_page.php">
		<label for="finId">Finance ID:</label>
	    <input type="text" id="finId" name="FINID" placeholder="#">
	    <br>
		<br>
		<label for="custId">Customer ID:</label>
	    <input type="text" id="custId" name="CUSTID" placeholder="#">
	    <br>
		<br>
		<label for="vin">VIN:</label>
	    <input type="text" id="vin" name="VIN" placeholder="VIN">
		<br>
		<br>
	    <label for="cost">Vehicle Cost:</label>
	    <input type="text" id="cost" name="COST" placeholder="$0.00">
	    <br>
		<br>
	    <label for="credit">Credit Score:</label>
	    <input type="text" id="credit" name="CREDIT" placeholder="#">
	    <br>
		<br>
	    <label for="modelYear">Year:</label>
	    <input type="text" id="modelYear" name="MODELYEAR" placeholder="">
	    <br>
		<br>
	    <label for="interestRate">Interest Rate:</label>
	    <input type="text" id="interestRate" name="INTERESTRATE" placeholder= "%0.00">
	    <br>
		<br>
	    <label for="term">Term Length:</label>
	    <input type="text" id="term" name="TERM" placeholder="#">
	    <br>
		<br>
	    <label for="downPay">Down Payment:</label>
	    <input type="text" id="downPay" name="DOWNPAY" placeholder="$0.00">
	    <br>
		<br>
	    <label for="principal">Principal:</label>
	    <input type="text" id="principal" name="PRINCIPAL" placeholder="$0.00">
		<br>
		<br>
	    <label for="totalOwed">Total Owed:</label>
	    <input type="text" id="totalOwed" name="TOTALOWED" placeholder="$0.00">
	    <br>
		<br>
	    <label for="paymentsMade">No. Payments Made:</label>
	    <input type="text" id="paymentsMade" name="PAYMENTSMADE" placeholder="#">
	    
	    
	    
         </form>
          <input type="submit" value="SUBMIT" width = 30%>
	</div>
	<div style="text-align:center"><font size ="1">an Andy Szeto creation | 2020 - 2022</font></div>
</body>
</html>