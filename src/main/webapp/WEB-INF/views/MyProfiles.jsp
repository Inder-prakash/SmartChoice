<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="header.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<br>
	<h1 style="margin: auto; width: 80%; text-align: center;">${Customers.getFirstname()} ${Customers.getLastname()}</h1>
	<br>	
	<br>
	<table class="table table-striped" style="margin: auto; width: 95%;">
		<thead>
			<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Password</th>
			<th>Address 1</th>
			<th>Address 2</th>
			<th>City</th>
			<th>Pin-code</th>
			<th>Wallet</th>
			<th>Role</th>
			<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<tr>
			<td>${Customers.getFirstname()}</td>
			<td>${Customers.getLastname()}</td>
			<td>${Customers.getEmail()}</td>
			<td>${Customers.getPhone()}</td>
			<td>${Customers.getPassword()}</td>
			<td>${Customers.getAddress1()}</td>
			<td>${Customers.getAddress2()}</td>
			<td>${Customers.getCity()}</td>
			<td>${Customers.getPincode()}</td>
			<td>Rs.${Customers.getWallet()}</td>
			<td>${Customers.getRole()}</td>
			<td>${Customers.isActive()}</td>
			</tr>
		</tbody>
	</table>