<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="header.jsp"></jsp:include>

<style type="text/css">

tr.lovelyrow:hover{
  background-color: hsl(0,0%,90%);
  cursor: pointer;
}

table.nogap{
  border-collapse: collapse;
}
</style>
	<br>
	<br>
	<table cellpadding="8" class="table table.nogap" style="margin: auto; width: 60%;" >
		<thead>
			<tr>
			<th>Image</th>
			<th>Name</th>
			<th>Price</th>
			<th>Description</th>
			<th>Discount</th>
			</tr>
		</thead>
			
		<tbody>
			<c:forEach items="${productdata}" var="x">
			
			<tr class="lovelyrow" onclick="location.href='${pageContext.request.contextPath}/product/${x.getId()} '">
			<td><img class="proimage" src="${x.getProductimage()}" height="200px" ></td>
			<td>${x.getProductname()}</td>
			<td>Rs.${x.getProductprice()}</td>
			<td width="500px">${x.getProductdescription()}</td>
			<td>${x.getProductdiscount()}%</td>	
			</tr>
			
			</c:forEach>
		</tbody>
	</table>