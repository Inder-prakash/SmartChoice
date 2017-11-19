<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="adminheader.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<br>
	<h1 style="margin: auto; width: 80%; text-align: center;">${Admindata.getFirstname()} ${Admindata.getLastname()}</h1>
	<br>	
	<form method="post" action="${pageContext.request.contextPath}/changeRole">
	<br>
	<input type="hidden" name="id" value="${Admindata.getId()}" >
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
			<td>${Admindata.getFirstname()}</td>
			<td>${Admindata.getLastname()}</td>
			<td>${Admindata.getEmail()}</td>
			<td>${Admindata.getPassword()}</td>
			<td>${Admindata.getAddress1()}</td>
			<td>${Admindata.getAddress2()}</td>
			<td>${Admindata.getCity()}</td>
			<td>${Admindata.getPincode()}</td>
			<td><div>Rs.${Admindata.getWallet()}</div>
			<input type="Number" style="width:80px" required value="${Admindata.getWallet()}" name="wallet"></td>
			<td><div>${Admindata.getRole()}</div>
			<select name="role">
			<option>ROLE_USER</option>
			<option>ROLE_ADMIN</option>
			<option>ROLE_SUPPLIER</option>
			</select>
			</td>
			<td>${Admindata.isActive()}</td>
			</tr>
			<tr>
			<td colspan="10"></td>
			<td><input Value="Update Changes" class="btn btn-primary" type="submit" ></td>
			</tr>
		</tbody>
	</table>
	</form>
<jsp:include page="adminfooter.jsp"></jsp:include>