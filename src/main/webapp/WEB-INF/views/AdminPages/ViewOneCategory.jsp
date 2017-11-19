<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="adminheader.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<br>
	<h1 style="margin: auto; width: 80%; text-align: center;">${categoriesdata.getCategoryname()}</h1>
	<br>
	<table style="margin: auto; width: 80%;">
		<thead>
			<tr>
			<th>Name</th>
			<th>Image</th>
			<th>Description</th>
			</tr>
		</thead>
		<tbody>
		
			<tr>
			<td>${categoriesdata.getCategoryname()}</td> 
			<td><img src="${categoriesdata.getCategoryimage()}" style="width: 150px;" ></td>
			<td>${categoriesdata.getCategorydescription()}</td>
			</tr>		
		</tbody>
	</table>
<jsp:include page="adminfooter.jsp"></jsp:include>