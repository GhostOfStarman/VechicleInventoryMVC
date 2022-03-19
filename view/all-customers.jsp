<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<title>Customer Accounts</title>
	
	<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/AllCustomerAccountsCSS.css">
	
</head>

<body>
	<!-- <h1>Customer Accounts</h1> -->
	<div id="custTitle">
			<img src="${pageContext.request.contextPath}/resources/images/CustomerAccountsHeader.svg"/>    
	</div>

		<div id="container">
		
			<table id="buttonRowTable">
				<tr>
				<td><input type="button" value="Add User" onclick="window.location.href='addCustomerAccount'; return false;" />   
				<input type="button" value="List Vehicles" onclick="window.location.href='listAll'; return false;" />
				<input type="button" value="Financing Records" onclick="window.location.href='showFinanceRecords'; return false;" /></td>
				</tr>
			</table>
		<br>
			<table id="allCustomers">
				<tr>
					<th>ID</th>
					<th>USERNAME</th>
					<th>FIRST NAME</th>
					<th>LAST NAME</th>
					<th>EMAIL</th>
					<th>PHONE</th>
					<th>ADDRESS</th>
					<th>update</th>
					<th>records</th>
					<th>delete</th>
				</tr>

				<!-- loop over and print users, in the items attribute, refer to the VehController class
				(listUsers method) -->
				<c:forEach var="customer" items="${CustomerAccounts}">
				
					<!-- update link for customers -->
					<c:url var="detailsLink" value="/inventory/showFullDetails">
						<c:param name="customerId" value="${customer.customerId}" />
					</c:url>
					
					<c:url var="updateLink" value="/inventory/showCustomerUpdateForm">
						<c:param name="customerId" value="${customer.customerId}" />
					</c:url>
					
					<!-- delete link for customers -->
					<c:url var="deleteLink" value="/inventory/deleteCustomerAccount">
						<c:param name="customerId" value="${customer.customerId}" />
					</c:url>
					
					<tr>
						<td id ="idCell">${customer.customerId}</td>
						<td>${customer.username}</td>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.emailAddress}</td>
						<td>${customer.phoneNumber}</td>
						<td>${customer.mailingAddress}</td>
						<td>
						<a href="${updateLink}">update</a>
						</td>
						<td>
						<a href="${detailsLink}">view/edit</a>
						</td>
						<td>
						<a href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this user? Changes cannot be undone.'))) return false"> delete</a>
						</td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
		<br>
		<div style="text-align:center"><font size ="1">an Andy Szeto creation | 2020 - 2022</font></div>

</body>

</html>









