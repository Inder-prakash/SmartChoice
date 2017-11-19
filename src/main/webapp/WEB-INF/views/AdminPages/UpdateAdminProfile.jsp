<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="adminheader.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<br>
		<h1 style="margin: auto; width: 80%; text-align: center;">Update Profile</h1>
	<br>
	<form:form modelAttribute="profiledata" action="${pageContext.request.contextPath}/UpdateAdminToDB" method="post" style="margin: auto; width: 20%; text-align: center;">
		<form:input path="id" type="hidden"/>
		<form:input path="username" type="text" class="form-control" />
		<br>	
		<form:input path="email" type="text" class="form-control"/>
		<br>
		<form:input path="password" type="text" class="form-control"/>
		<br>
		<form:input path="phone" type="text" class="form-control" />
		<br>
		<form:input path="address" type="text" class="form-control"/>
		<br>
		<input type="submit" value="Update" class="btn btn-primary">
	</form:form>
<jsp:include page="adminfooter.jsp"></jsp:include>