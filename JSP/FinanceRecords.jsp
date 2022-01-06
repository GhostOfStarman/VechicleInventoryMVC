<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<style type ="text/css">
	<%@include file="../css/FinanceRecordsCSS.css" %>
	</style>
 
<title>Current Plans</title>
</head>
<body>
	<h1>CURRENT FINANCING PLANS</h1>
	<%@page import="java.sql.*"%>
	<%@page import="java.io.*"%>
	
	<%
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	String driverName = "com.mysql.jdbc.Driver";
	
	try {
		Class.forName(driverName);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	%>
	
	<div class="searchBar">
	  <input type="text" placeholder="Search by VIN or UserID.">
	</div> 
	
	<div id = "insertRecord"><a id = "insertRecordLink" href = "/insertCar">INSERT NEW PLAN</a></div>
	
	<div id = "listRecords"><a id = "listRecordsLink" href = "/listCars">LIST ALL PLANS</a></div>
	
	<div id = "table1"><table border="1">
	<tr>
	
	</tr>
	<tr style="background-color: lightblue">
	<td><b>Plan ID</b></td>
	<td><b>Customer ID</b></td>
	<td><b>VIN</b></td>
	<td><b>Selling Price</b></td>
	<td><b>Credit Score</b></td>
	<td><b>Interest Rate</b></td>
	<td><b>Term(# mo.)</b></td>
	<td><b>Down Payment</b></td>
	<td><b>Total Owed</b></td>
	<td><b>Payments Made</b></td>
	<td><b>EDIT</b></td>
	<td><b>DELETE</b></td>
	</tr>
	
	<%
	try{ 
		connection = DriverManager.getConnection();
		statement = connection.createStatement();
		String query = "SELECT * FROM VehicleInventory.FinanceRecords";
		resultSet = statement.executeQuery(query);
		while(resultSet.next()){
	%>
			<tr> 
			<td><%=resultSet.getInt("FinanceID") %></td>
			<td><%=resultSet.getInt("CustomerID") %></td>
			<td><%=resultSet.getString("VehicleID") %></td>
			<td><%=resultSet.getDouble("VehicleCost") %></td>
			<td><%=resultSet.getString("CreditScore") %></td>
			<td><%=resultSet.getDouble("InterestRate") %></td>
			<td><%=resultSet.getInt("Term") %></td>
			<td><%=resultSet.getDouble("DownPayment") %></td>
			<td><%=resultSet.getDouble("TotalOwed") %></td>
			<td><%=resultSet.getString("PaymentsMade") %></td>
			<td><a href = "/editUser">edit</a></td>
			<td><a href = "deleteUser">delete</a></td>
			</tr>
	
	<% 
		}
	
	} catch (Exception e) {
		e.printStackTrace();
	}
	%>
</table></div>
<br>
<div id = "mainMenu"><a id = "mainMenuLink" href = "mainMenu">MAIN MENU</a></div>
<div style="text-align:center"><font size ="1">an Andy Szeto creation | 2020 - 2022</font></div>
</body>
</html>