<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<title>Vehicle Inventory Management</title>
	
	<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/AllInvVehiclesCSS.css">
	
</head>

<body>
	<!-- <h1>Vehicle Inventory Management</h1> -->

	<div id="inventoryTitle">
		<img src="${pageContext.request.contextPath}/resources/images/VIheader.svg"/>    
	</div>

		<div id="carInv">
		
			<table id="buttonRowTable">
				<tr>
				<td><input type="button" value="Add Vehicle" onclick="window.location.href='addVehicle'; return false;" />   
				<input type="button" value="Customer Accounts" onclick="window.location.href='listAccounts'; return false;" />
				<input type="button" value="Financing Records" onclick="window.location.href='showFinanceRecords'; return false;" /></td>
				</tr>
			</table>
		<br>
			<table id="allCars">
				<tr>
					<th>VIN</th>
					<th>MAKE</th>
					<th>MODEL</th>
					<th>YEAR</th>
					<th>COLOR</th>
					<th>MILEAGE</th>
					<th>COND.</th>
					<th>PRICE</th>
					<th>details</th>
					<th>update</th>
					<th>delete</th>
					<th>finance</th>
				</tr>

				<!-- loop over and print users, in the items attribute, refer to the VehController class
				(listUsers method) -->
				<c:forEach var="car" items="${Vehicles}">
				
					<!-- update link for customers -->
					<c:url var="detailsLink" value="/inventory/showFullDetails">
						<c:param name="vehicleIdNumber" value="${car.vehicleIdNumber}" />
					</c:url>
					
					<c:url var="updateLink" value="/inventory/showUpdateForm">
						<c:param name="vehicleIdNumber" value="${car.vehicleIdNumber}" />
					</c:url>
					
					<!-- delete link for customers -->
					<c:url var="deleteLink" value="/inventory/delete">
						<c:param name="vehicleIdNumber" value="${car.vehicleIdNumber}" />
					</c:url>
					
					<!-- finance record link for customers -->
					<c:url var="financeLink" value="/inventory/showFinanceForm">
						<c:param name="vehicleIdNumber" value="${car.vehicleIdNumber}" />
					</c:url>
					
					<tr>
						<td id ="vinCell">${car.vehicleIdNumber}</td>
						<td>${car.make}</td>
						<td>${car.model}</td>
						<td>${car.year}</td>
						<td>${car.exteriorColor}</td>
						<td>${car.mileage}</td>
						<td>${car.condition}</td>
						<td>$${car.price}</td>
						
						<td>
						<a href="${detailsLink}">view</a>
						</td>
						<td>
						<a href="${updateLink}">update</a>
						</td>
						<td>
						<a href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this vehicle? Changes cannot be undone.'))) return false"> delete</a>
						</td>
						<td>
						<a href="${financeLink}">
							record</a>
						</td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
		<br>
		<div style="text-align:center"><font size ="2">an Andy Szeto creation | 2020 - 2022</font></div>

</body>

</html>









