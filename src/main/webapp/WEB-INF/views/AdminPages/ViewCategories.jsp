<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="adminheader.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<br>
<h1 style=" margin: auto; width: 80%; text-align: center;">Categories</h1>	
	<form action="deletcategories">
	<div style="margin:auto; width: 80%;">
	<input class="btn btn-danger" Value="Delete Selected" type="submit">
	</div>
	<br> 
	<table class="table table-striped" style="margin: auto; width: 80%;">
		<thead>
			<tr >
			<th>Select</th>
			<th>Name</th>
			<th>Image</th>
			<th>Description</th>
			<th>View</th>
			<th>Update</th>
			<th>Delete</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${categoriesdata}" var="x">
			<tr>
			<td><input type="checkbox" value="${x.getId()}" name="SelectedId"></td>
			<td>${x.getCategoryname()}</td>
			<td><img src="${x.getCategoryimage()}" style="width: 200px;"></td>
			<td>${x.getCategorydescription()}</td>
			<td><a href="ViewOneCategory/${x.getId()}" class="btn btn-primary">View</a></td>
			<td><a href="UpdateOneCategory/${x.getId()}" class="btn btn-success">Update</a></td>
			<td><a href="DeleteOneCategory/${x.getId()}" class="btn btn-danger">Delete</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</form>
<jsp:include page="adminfooter.jsp"></jsp:include>
