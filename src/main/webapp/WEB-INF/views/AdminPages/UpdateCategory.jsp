<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="adminheader.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<br>
	<h1 style="margin: auto; width: 80%; text-align: center;">Update Category</h1>
	<br>
	<form:form enctype="multipart/form-data" modelAttribute="categoriesdata" action="${pageContext.request.contextPath}/UpdateCategoryToDB" method="post" style="margin: auto; width: 20%; text-align: center;">
		<form:input path="id" type="hidden" />
		<input type="hidden" value="${categoriesdata.getImagepublicid()}" name="pid"> 
		<input type="hidden" value="${categoriesdata.getCategoryimage()}" name="url"> 
		<form:input path="categoryname" type="text"  class="form-control" />
		<br>
		<img class="dotted" src="${categoriesdata.getCategoryimage()}" style="width: 250px " />
		<br>
		<br>
		<input  type="file" name ="file">
		<br>
		<form:textarea path="categorydescription" class="form-control" />
		<br>
		<input type="submit" value="Update" class="btn btn-primary">
	</form:form>
<jsp:include page="adminfooter.jsp"></jsp:include>