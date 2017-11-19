  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="supplierheader.jsp"></jsp:include>
<div>
  <br>
  <br>
  <br>
  <br>
<form:form method="post" enctype="multipart/form-data" modelAttribute="Product" action="${pageContext.request.contextPath}/UpdateProductToDB" style="width: 20%;margin: auto;">
  <h1 style="margin: auto; width: 80%; text-align: center;">Update Product</h1>
    <br>
  <form:input path="id" type="hidden" value="${Product.getId()}" />   
  <form:input path="active" type="hidden" value="${Product.getActive()}" /> 
  <input type="hidden" value="${Product.getImagepublicid()}" name="pid"> 
  <input type="hidden" value="${Product.getProductimage()}" name="url">   
  <form:input path="supplierid" name="supplierid" type="hidden" value="${supplierdata.getId()}" /> 
  
  <div class="form-group">
    <label>Product Name :</label>
    <form:input path="productname" type="text" required="required" placeholder="Product Name" class="form-control" />
  </div>
  
  <div class="form-group">
    <label>Select Category :</label>
	<form:select required="required" path="categoryid" class="form-control">
	<c:forEach items="${categoriesdata}" var="x">
	<option title="${x.getCategorydescription() }"  value="${x.getId()}">${x.getCategoryname()}</option>
	</c:forEach>
	</form:select>
  </div>
  
   <div class="form-group">
    <label>Select Sub Category :</label>
	<form:select required="required" path="subcategoryid" class="form-control">
	<c:forEach items="${subcategoriesdata}" var="x">
	<option value="${x.getId()}">${x.getSubname()}</option>
	</c:forEach>
	</form:select>
  </div>
  
  <div class="form-group">
    <label>Price :</label>
    <form:input path="productprice" type="number"  required="required" placeholder="Price" class="form-control" />
  </div>
  
	
	<div style="text-align: center;">
   <img   name="file" src="${Product.getProductimage()}" style="width: 150px;" />
    </div>
  
  <div class="form-group">
   
    <label>Add Image :</label>
    <input value="Upload" type="file" name="file" >
  </div>
  <div class="form-group">
    <label>Description :</label>
    <form:textarea path="productdescription" rows="5" required="required"  placeholder="Description" class="form-control" cols="4" ></form:textarea>
  </div>
  
  <div class="form-group">
  <label>Quantity :</label>
  <form:input type="number" maxlength="2" pattern="([1-9]|[0-9]|)" required="required" path="productquantity" />
  </div>
  
  <div class="form-group">
  <label>Discount :</label>
  <form:input type="number" maxlength="2" pattern="([1-9]|[0-9]|)" required="required" path="productdiscount" />
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
</div>
<jsp:include page="supplierfooter.jsp"></jsp:include>
