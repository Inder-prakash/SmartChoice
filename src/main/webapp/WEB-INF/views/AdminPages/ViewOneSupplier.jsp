<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="adminheader.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<br>
	<h1 style="margin: auto; width: 80%; text-align: center;">${Supplierdata.getFirstname()} ${Supplierdata.getLastname()}</h1>
	<br>	
	<form method="post" action="${pageContext.request.contextPath}/changeRole">
	<br>
	<input type="hidden" name="id" value="${Supplierdata.getId()}" >
	<table class="table table-striped" style="margin: auto; width: 95%;">
		<thead>
			<tr>
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
			</tr>
		</thead>
		<tbody>
			<tr>
			<td>${Supplierdata.getFirstname()}</td>
			<td>${Supplierdata.getLastname()}</td>
			<td>${Supplierdata.getEmail()}</td>
			<td>${Supplierdata.getPassword()}</td>
			<td>${Supplierdata.getAddress1()}</td>
			<td>${Supplierdata.getAddress2()}</td>
			<td>${Supplierdata.getCity()}</td>
			<td>${Supplierdata.getPincode()}</td>
			<td><div>Rs.${Supplierdata.getWallet()}</div>
			<input type="Number" style="width:80px" required value="${Supplierdata.getWallet()}" name="wallet"></td>
			<td><div>${Supplierdata.getRole()}</div>
			<select name="role">
			<option>ROLE_USER</option>
			<option>ROLE_ADMIN</option>
			<option>ROLE_SUPPLIER</option>
			</select>
			</td>
			<td>${Supplierdata.isActive()}</td>
			</tr>
			<tr>
			<td colspan="10"></td>
			<td><input Value="Update Changes" class="btn btn-primary" type="submit" ></td>
			</tr>
		</tbody>
	</table>
	</form>
<jsp:include page="adminfooter.jsp"></jsp:include>