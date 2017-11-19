  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="adminheader.jsp"></jsp:include>
<div>
<form:form method="post" modelAttribute="Category" enctype="multipart/form-data"   action="AddCategoryToDb" style="width:300px; margin: auto;">
  <br>
  <br>
  <br>
  <br>
  <br>
  <h1 style="margin: auto; width: 80%; text-align: center;">Add Category</h1>

  <div class="form-group">
    <label>Category Name :</label>
    <form:input path="categoryname" type="text" required="required" placeholder="Category Name" class="form-control"/>
  </div>
  <div class="form-group">
    <label>Add Image :</label>
    <input required value="Upload" accept="image/jpeg,image/x-png" type="file" name="file" >
  </div>
  <div class="form-group">
    <label>Description :</label>
    <form:textarea path="categorydescription" required="required" rows="5" placeholder="Description" class="form-control" cols="4" ></form:textarea>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
</div>
<jsp:include page="adminfooter.jsp"></jsp:include>
