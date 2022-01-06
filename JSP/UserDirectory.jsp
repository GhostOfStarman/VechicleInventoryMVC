<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<style type ="text/css">
	<%@include file="../css/UserDirectoryCSS.css" %>
	</style>
 
<title>User Accounts</title>
</head>
<body>
	<h1>USER ACCOUNTS</h1>
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
	  <input type="text" placeholder="Search by User IDno.">
	</div> 
	
	<div id = "insertUser"><a id = "insertUserLink" href = "/insertCar">INSERT USER</a></div>
	
	<div id = "listUsers"><a id = "listUsersLink" href = "/listCars">LIST ALL USERS</a></div>
	
	<div id = "table1"><table border="1">
	<tr>
	
	</tr>
	<tr style="background-color: lightblue">
	<td><b>IDNo.</b></td>
	<td><b>Username</b></td>
	<td><b>Password</b></td>
	<td><b>First Name</b></td>
	<td><b>Last Name</b></td>
	<td><b>Email</b></td>
	<td><b>Phone #</b></td>
	<td><b>Mailing Address</b></td>
	<td><b>User Since</b></td>
	<td><b>EDIT</b></td>
	<td><b>DELETE</b></td>
	</tr>
	
	<%
	try{ 
		connection = DriverManager.getConnection();
		statement = connection.createStatement();
		String query = "SELECT * FROM VehicleInventory.ClientAccounts";
		resultSet = statement.executeQuery(query);
		while(resultSet.next()){
	%>
			<tr> 
			<td><%=resultSet.getInt("idNo") %></td>
			<td><%=resultSet.getString("username") %></td>
			<td><%=resultSet.getString("password") %></td>
			<td><%=resultSet.getString("firstName") %></td>
			<td><%=resultSet.getString("lastName") %></td>
			<td><%=resultSet.getString("emailAddress") %></td>
			<td><%=resultSet.getInt("phoneNumber") %></td>
			<td><%=resultSet.getString("mailingAddress") %></td>
			<td><%=resultSet.getDate("UserSince") %></td>
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
<div id = "mainMenu"><a id = "mainMenuLink" href = "mainMenu">MAIN MENU</a></div><br>
<div style="text-align:center"><font size ="1">an Andy Szeto creation | 2020 - 2022</font></div>
</body>
</html>