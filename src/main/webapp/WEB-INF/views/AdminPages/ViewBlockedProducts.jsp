<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="adminheader.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<br>
	<h1 style="margin: auto; width: 95%; text-align: center;">Products</h1>	
	<form action="delProducts">
	<br>
	<table class="table table-striped" style="margin: auto; width: 95%;">
		<thead>
			<tr>
			<th>Select</th>
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
			<th>View</th>
			<th>Delete</th>
			</tr>
		</thead>
			
		<tbody>
			<c:forEach items="${productdata}" var="x">
			<tr>
			<td><input type="checkbox" value="${x.getId()}" name="SelectedId"></td>
			<td>${x.getCategoryname()}</td>
			<td>${x.getSubname()}</td>
			<td>${x.getProductname()}</td>
			<td>${x.getProductprice()}</td>
			<td><img src="${x.getProductimage()}" width="200px"></td>
			<td>${x.getProductdescription()}</td>
			<td>${x.getProductquantity()}</td>
			<td>${x.getProductdiscount()}</td>
			<td>${x.getActive()}</td>
			<td>${x.getSupplierid()}</td>
			<td><a href="${pageContext.request.contextPath}/ViewOneProduct/${x.getId()}" class="btn btn-primary">View</a></td>
			<td><a href="${pageContext.request.contextPath}/UnblockOneProduct/${x.getId()}" class="btn btn-success">Unblock</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</form>
<jsp:include page="adminfooter.jsp"></jsp:include>