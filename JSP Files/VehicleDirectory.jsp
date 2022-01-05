<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<style type ="text/css">
	<%@include file="../css/VehicleInventoryCSS.css" %>
	</style>
 
<title>Inventory</title>
</head>
<body>
	<h1>VEHICLE INVENTORY</h1>
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
	
	<div class="searchBar">
	  <input type="text" placeholder="Search by VIN">
	</div> 
	
	<div id = "insertCar"><a id = "insertCarLink" href = "/insertCar">INSERT VEHICLE</a></div>
	
	<div id = "listCars"><a id = "listCarsLink" href = "/listCars">LIST ALL VEHICLES</a></div>
	
	<div id = "table1"><table border="1">
	<tr>
	
	</tr >
	<tr style="background-color: lightblue">
	<th><b>VIN</b></th>
	<th><b>Make</b></th>
	<th><b>Model</b></th>
	<th><b>Year</b></th>
	<th><b>ExtColor</b></th>
	<th><b>IntColor</b></th>
	<th><b>Mileage</b></th>
	<th><b>Condition</b></th>
	<th><b>Title Status</b></th>
	<th><b>Drivetrain</b></th>
	<th><b>Transmission</b></th>
	<th><b>Fuel Type</b></th>
	<th><b>Price</b></th>
	<th>EDIT</th>
	<th>DELETE</th>
	<th>FINANCE</th>
	<th>SOLD</th>
	</tr>
	
	<%
	try{ 
		connection = DriverManager.getConnection();
		statement = connection.createStatement();
		String query = "SELECT * FROM VehicleInventory.Cars";
		results = statement.executeQuery(query);
		while(results.next()){
	%>
			<!--each of these blocks is a row (tr tag)-->
			<tr> 
			
			<td><%=results.getString("vin") %></td>
			<td><%=results.getString("make") %></td>
			<td><%=results.getString("model") %></td>
			<td><%=results.getInt("modelYear") %></td>
			<td><%=results.getString("extColor") %></td>
			<td><%=results.getString("intColor") %></td>
			<td><%=results.getString("mileage") %></td>
			<td><%=results.getString("currCondition") %></td>
			<td><%=results.getString("title") %></td>
			<td><%=results.getString("driveTrain") %></td>
			<td><%=results.getString("transmission") %></td>
			<td><%=results.getString("fuel") %></td>
			<td><%="$" + results.getString("price") %></td>
			<td><a href = "/editCar">edit</a></td>
			<td><a href = "/deleteCar">delete</a></td>
			<td><a href = "finance">finance</a></td>
			<td><a href = "/sold">move to sold</a></td>
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