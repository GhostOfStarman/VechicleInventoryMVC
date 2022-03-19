<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<title>Vehicle Inventory Management</title>
	
	<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/FullVehicleDetailsCSS.css">
	
</head>

<body>
		<img src="${pageContext.request.contextPath}/resources/images/DetailsHeader.svg"/>
		
		<div id="carInv">
		
		<c:url var="updateLink" value="/inventory/showUpdateForm">
				<c:param name="vehicleIdNumber" value="${car.vehicleIdNumber}" />
		</c:url>
		<c:url var="inventoryLink" value="/inventory/listAll">
				<c:param name="vehicleIdNumber" value="${car.vehicleIdNumber}" />
		</c:url>

		
		<table>
			<tr><td>VIN: ${car.vehicleIdNumber}</td></tr>

			<tr><td>Make: ${car.make}</td></tr>

			<tr><td>Model: ${car.model}</td></tr>

			<tr><td>Year: ${car.year}</td></tr>

			<tr><td>Exterior Color: ${car.exteriorColor}</td></tr>

			<tr><td>Interior Color: ${car.interiorColor}</td></tr>

			<tr><td>Mileage: ${car.mileage}</td></tr>

			<tr><td>Condition: ${car.condition}</td></tr>

			<tr><td>Title Status: ${car.titleStatus}</td></tr>

			<tr><td>Drivetrain: ${car.drivetrainType}</td></tr>

			<tr><td>Transmission: ${car.transmissionType}</td></tr>

			<tr><td>Fuel Type: ${car.fuelType}</td></tr>

			<tr><td>Price: $${car.price}</td></tr>

			</table>
			<p>
				<a href="${updateLink}" class="update">Update Vehicle</a>
				<br>

				<a href="${pageContext.request.contextPath}/inventory/listAll" class="inventory">Back to Inventory</a>
			</p>
	
		</div>


</body>

</html>
