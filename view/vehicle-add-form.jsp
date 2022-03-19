<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>

<head>
	<title>Add Vehicle</title>
	
	<!-- Referencing CSS file -->
	<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/AddVehicleFormCSS.css">
	
	<style>
		.errors{
			font-size: 13px;
			color:red;
		}
	</style>
	
	
</head>

<body>
		<!-- <h1>Add Vehicle</h1> -->
		
		<div id="addVehTitle">
			<img src="${pageContext.request.contextPath}/resources/images/AddVehHeader.svg"/>    
		</div>
		
		<div class="container">
			<!-- Form -->
			<!-- This is mapped to the showAddVehicleForm method in the controller class -->
			<form:form action="addVehicleSave" modelAttribute="Vehicle" method="POST">
			
				<table>
					<tbody>
					
					<tr>
						<td><label>VIN:</label>
						<!-- When form is loaded/submitted, Spring MVC will call getter and setter methods for these fields -->
						<form:input path="vehicleIdNumber" />
						<form:errors path="vehicleIdNumber" cssClass="errors" /></td>
					</tr>
					
					<tr>
						<td><label>Make: </label>
						<form:input path="make" />
						<form:errors path="make" cssClass="errors" /></td>
					</tr>
					
					<tr>
						<td><label>Model:</label>
						<form:input path="model" />
						<form:errors path="model" cssClass="errors" /></td>
					</tr>
					
					<tr>
						<td><label>Year:</label>
						<form:input path="year" />
						<form:errors path="year" cssClass="errors" /></td>
					</tr>
					
					<tr>
						<td><label>Exterior Color:</label>
						<form:input path="exteriorColor" />
						<form:errors path="exteriorColor" cssClass="errors" /></td>
					</tr>
					
					<tr>
						<td><label>Interior Color:</label>
						<form:input path="interiorColor" />
						<form:errors path="interiorColor" cssClass="errors" /></td>
					</tr>
					
					<tr>
						<td><label>Mileage: </label>
						<form:input path="mileage" />
						<form:errors path="mileage" cssClass="errors" /></td>
					</tr>
					
					<tr>
						<td><label>Price:</label>
						<form:input path="price" /></td>
						<form:errors path="price" cssClass="errors" />
					</tr>
					
					<tr>
						<td><label for="drop">Condition:</label>
						<form:select path="condition">
							<form:option value="NEW" label="NEW"/>
							<form:option value="USED" label="USED"/>
						</form:select>
						</td>
					</tr>
					
					<tr>
						<td><label for="drop">Title Status:</label>
						<form:select path="titleStatus">
							<form:option value="CLEAN" label="CLEAN"/>
							<form:option value="CLEAR" label="CLEAR"/>
							<form:option value="SALVAGE" label="SALVAGE"/>
							<form:option value="REBUILT" label="REBUILT"/>
						</form:select>
						</td>
					</tr>
					
					<tr>
						<td><label for="drop">Drivetrain:</label>
							<form:select path="drivetrainType">
							<form:option value="AWD" label="AWD"/>
							<form:option value="FWD" label="FWD"/>
							<form:option value="RWD" label="RWD"/>
							<form:option value="4WD" label="4WD"/>
						</form:select>					
						</td>
					</tr>
					
					<tr>
						<td><label for="drop">Transmission:</label>
							<form:select path="transmissionType">
							<form:option value="AUTOMATIC" label="AUTOMATIC"/>
							<form:option value="MANUAL" label="MANUAL"/>
							<form:option value="CVT" label="CVT"/>
							<form:option value="DUAL-CLUTCH" label="DUAL-CLUTCH"/>
						</form:select>			
						</td>
					</tr>
					
					<tr>
						<td><label for="drop">Fuel Type:</label>
							<form:select path="fuelType">
							<form:option value="GAS" label="GAS"/>
							<form:option value="ELECTRIC" label="ELECTRIC"/>
							<form:option value="HYBRID" label="HYBRID"/>
					</form:select>
						</td>
					</tr>
					
					<tr>
					</tr>
					
					<tr>
						<td><input type="submit" value="Add to Inventory" /></td>
					</tr>
					
					</tbody>
				</table>


			
			</form:form>
	
			<!-- Link back to customer list -->
			<p>
				<a href="${pageContext.request.contextPath}/inventory/listAll" class="inventory">Back to Inventory</a>
			</p>
			</div>
</body>

</html>








