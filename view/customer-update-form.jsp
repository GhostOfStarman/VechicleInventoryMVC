<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>

<head>
	<title>Update Vehicle</title>
	
	<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/UpdateCustomerFormCSS.css">
	
	<style>
		.errors{
			font-size: 13px;
			color:red;
		}
	</style>
	
	
</head>

<body>
		<div id="updateCustTitle">
			<img src="${pageContext.request.contextPath}/resources/images/UpdateVehHeader.svg"/>    
		</div>
		
		<div class="container">
			<form:form action="updateCustomerAccountSave" modelAttribute="CustomerAccount" method="POST">
			
				<table>
					<tbody>
					
					<tr>
						<td><label>First Name: </label>
						<form:input path="firstName" />
						<form:errors path="firstName" cssClass="errors" /></td>
					</tr>
					
					<tr>
						<td><label>Last Name:</label>
						<form:input path="lastName" />
						<form:errors path="lastName" cssClass="errors" /></td>
					</tr>
					
					<tr>
						<td><label>Username:</label>
						<form:input path="username" />
						<form:errors path="username" cssClass="errors" /></td>
					</tr>
					
					<tr>
						<td><label>Password:</label>
						<form:input path="password" />
						<form:errors path="password" cssClass="errors" /></td>
					</tr>
					
					<tr>
						<td><label>Email:</label>
						<form:input path="emailAddress" />
						<form:errors path="emailAddress" cssClass="errors" /></td>
					</tr>
					
					<tr>
						<td><label>Phone Number:</label>
						<form:input path="phoneNumber" />
						<form:errors path="phoneNumber" cssClass="errors" /></td>
					</tr>
					
					<tr>
						<td><label>Mailing Address: </label>
						<form:input path="mailingAddress" />
						<form:errors path="mailingAddress" cssClass="errors" /></td>
					</tr>
					
					<tr>
						<td><input type="submit" value="Update Details" /></td>
					</tr>
					
					</tbody>
				</table>


			
			</form:form>
	
			<p>
				<a href="${pageContext.request.contextPath}/inventory/listAll" class="inventory">Back to Inventory</a>
			</p>
			</div>
</body>

</html>








