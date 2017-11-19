<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="adminheader.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<br>
	<h1 style="margin: auto; width: 80%; text-align: center;">${Customerdata.getFirstname()} ${Customerdata.getLastname()}</h1>
	<br>	
	<form method="post" action="${pageContext.request.contextPath}/changeRole">
	<br>
	<input type="hidden" name="id" value="${Customerdata.getId()}" >
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
			<td>${Customerdata.getFirstname()}</td>
			<td>${Customerdata.getLastname()}</td>
			<td>${Customerdata.getEmail()}</td>
			<td>${Customerdata.getPassword()}</td>
			<td>${Customerdata.getAddress1()}</td>
			<td>${Customerdata.getAddress2()}</td>
			<td>${Customerdata.getCity()}</td>
			<td>${Customerdata.getPincode()}</td>
			<td><div>Rs.${Customerdata.getWallet()}</div>
			<input type="Number" style="width:80px" required value="${Customerdata.getWallet()}" name="wallet"></td>
			<td><div>${Customerdata.getRole()}</div>
			<select name="role">
			<option>ROLE_USER</option>
			<option>ROLE_ADMIN</option>
			<option>ROLE_SUPPLIER</option>
			</select>
			</td>
			<td>${Customerdata.isActive()}</td>
			</tr>
			<tr>
			<td colspan="10"></td>
			<td><input Value="Update Changes" class="btn btn-primary" type="submit" ></td>
			</tr>
		</tbody>
	</table>
	</form>
<jsp:include page="adminfooter.jsp"></jsp:include>