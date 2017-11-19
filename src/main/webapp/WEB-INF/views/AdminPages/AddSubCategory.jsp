  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="adminheader.jsp"></jsp:include>
<div>
<form:form method="post" modelAttribute="SubCategory" enctype="multipart/form-data"   action="AddSubCategoryToDb" style="width:300px; margin: auto;">
  <br>
  <br>
  <br>
  <br>
  <br>
  <h1 style="margin: auto; text-align: center;">Add Sub Category</h1>
  <br>
   <div class="form-group">
    <label>Select Category :</label>
	<form:select required="required" path="categoryid" class="form-control">
	<c:forEach items="${categoriesdata}" var="x">
	<option title="${x.getCategorydescription() }"  value="${x.getId()}">${x.getCategoryname()}</option>
	</c:forEach>
	</form:select>
  </div>
  
  <div class="form-group">
    <label>Name :</label>
    <form:input path="subname" type="text" required="required" placeholder="Sub-Catgory Name" class="form-control" />
  </div>

  <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
</div>
<jsp:include page="adminfooter.jsp"></jsp:include>
