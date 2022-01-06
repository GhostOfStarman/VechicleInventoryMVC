<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<style type ="text/css">
	<%@include file="../css/CompleteTransactionsCSS.css" %>
	</style>
 
<title>Transactions</title>
</head>
<body>
	<h1>TRANSACTION HISTORY</h1>
	<%@page import="java.sql.*"%>
	<%@page import="java.io.*"%>
	
	<%
	String driverName = "com.mysql.jdbc.Driver";
	try {
		Class.forName(driverName);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	Connection connection = null;
	Statement statement = null;
	ResultSet results = null;
	%>
	
	<div id = "listCars"><a id = "listCarsLink" href = "/listCars">TO INVENTORY</a></div>
	
	<div id = "table1"><table border="1">
	<tr>
	
	</tr >
	<tr style="background-color: lightblue">
	<th><b>TransID</b></th>
	<th><b>CustID</b></th>
	<th><b>VIN</b></th>
	<th><b>Make</b></th>
	<th><b>Model</b></th>
	<th><b>Year</b></th>
	<th><b>ExtColor</b></th>
	<th><b>IntColor</b></th>
	<th><b>Mileage</b></th>
	<th><b>Condition</b></th>
	<th><b>Asking Price</b></th>
	<th><b>Selling Price</b></th>
	<th><b>Completion Date</b></th>
	<th>DELETE</th>
	</tr>
	
	<%
	try{ 
		connection = DriverManager.getConnection();
		statement = connection.createStatement();
		String query = "SELECT * FROM VehicleInventory.CompletedTransactions";
		results = statement.executeQuery(query);
		while(results.next()){
	%>
			<!--each of these blocks is a row (tr tag)-->
			<tr> 
			
			<td><%=results.getInt("transID") %></td>
			<td><%=results.getInt("buyerID") %></td>
			<td><%=results.getString("vin") %></td>
			<td><%=results.getString("make") %></td>
			<td><%=results.getString("model") %></td>
			<td><%=results.getInt("modelYear") %></td>
			<td><%=results.getString("extColor") %></td>
			<td><%=results.getString("intColor") %></td>
			<td><%=results.getInt("mileage") %></td>
			<td><%=results.getString("soldCondition") %></td>
			<td><%="$" + results.getDouble("askingPrice") %></td>
			<td><%="$" + results.getDouble("sellingPrice") %></td>
			<td><%=results.getDate("completionDate") %></td>
			<td><a href = "/deleteCar">delete</a></td>
			</tr>
	
	<% 
		}
	
	} catch (Exception e) {
		e.printStackTrace();
	}
	%>
</table></div>

<div id = "mainMenu"><a id = "mainMenuLink" href = "mainMenu">MAIN MENU</a></div>
<div style="text-align:center"><font size ="1">an Andy Szeto creation | 2020 - 2022</font></div>

</body>
</html>