<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="adminheader.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<br>
	<h1 style="margin: auto; width: 80%; text-align: center;">Admins</h1>
	<br>	
	<form action="deladmins">
	<div style="margin: auto; width: 95%;">
	<input class="btn btn-danger" Value="Delete Selected" type="submit">
	</div>
	<br>
	<table class="table table-striped" style="margin: auto; width: 95%;">
		<thead>
			<tr>
			<th>Select</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Address 1</th>
			<th>Address 2</th>
			<th>City</th>
			<th>Pin-code</th>
			<th>Wallet</th>
			<th>Role</th>
			<th>Status</th>
			<th>View</th>
			<th>Block</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${Adminsdata}" var="x">
			<tr>
			<td><input type="checkbox" value="${x.getId()}" name="SelectedId"></td>
			<td>${x.getFirstname()}</td>
			<td>${x.getLastname()}</td>
			<td>${x.getEmail()}</td>
			<td>${x.getPassword()}</td>
			<td>${x.getAddress1()}</td>
			<td>${x.getAddress2()}</td>
			<td>${x.getCity()}</td>
			<td>${x.getPincode()}</td>
			<td>Rs.${x.getWallet()}</td>
			<td>${x.getRole()}</td>
			<td>${x.isActive()}</td>
			<td><a href="ViewOneAdmin/${x.getId()}" class="btn btn-primary">View</a></td>
			<td><a href="UnblockOneAdmin/${x.getId()}" class="btn btn-success">Unblock</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</form>
<jsp:include page="adminfooter.jsp"></jsp:include>