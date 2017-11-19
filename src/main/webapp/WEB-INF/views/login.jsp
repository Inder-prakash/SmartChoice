<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br>
<div>
<form method="post" action="login" style="width: 20%;margin: auto;">
  <div class="form-group">
    <input  type="email" required="required" placeholder="Email" class="form-control" name="email">
  </div>
 <div class="form-group">
    <input type="password" required="required" placeholder="Password" class="form-control" name="password">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</body>
</html>