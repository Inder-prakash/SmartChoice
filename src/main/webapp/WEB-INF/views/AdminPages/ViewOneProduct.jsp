<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="adminheader.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<br>
	<h1 style="margin: auto; width: 95%; text-align: center;">${productdata.getProductname()}</h1>	
	<form action="delProducts">
	<br>
	<table class="table table-striped" style="margin: auto; width: 95%;">
		<thead>
			<tr>
			<th>Category</th>
			<th>Sub-Category</th>
			<th>Name</th>
			<th>Price</th>
			<th>Image</th>
			<th>Description</th>
			<th>Quantity</th>
			<th>Discount</th>
			<th>Status</th>
			<th>Supplier</th>
			</tr>
		</thead>
			
		<tbody>
			<tr>
			<td>${productdata.getCategoryname()}</td>
			<td>${productdata.getSubname()}</td>
			<td>${productdata.getProductname()}</td>
			<td>Rs.${productdata.getProductprice()}</td>
			<td><img src="${productdata.getProductimage()}" width="200px"></td>
			<td>${productdata.getProductdescription()}</td>
			<td>${productdata.getProductquantity()}</td>
			<td>${productdata.getProductdiscount()}</td>
			<td>${productdata.getActive()}</td>
			<td>${productdata.getSupplierid()}</td>
			</tr>
		</tbody>
	</table>
	</form>
<jsp:include page="adminfooter.jsp"></jsp:include>