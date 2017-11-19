<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="header.jsp"></jsp:include>
<div>
<br>
<form:form method="post" action="AddCustomerToDb" style="width: 20%;margin: auto;" modelAttribute="Customers">
  <div class="form-group">
    <label>First Name :</label>
    <form:input path="firstname" type="text" placeholder="First Name.... " class="form-control" />
  	<form:errors cssStyle="color:red" path="firstname"/>
  </div>
  
   <div class="form-group">
    <label>Last Name :</label>
    <form:input path="lastname" type="text" placeholder="Last Name.... " class="form-control" />
  	<form:errors cssStyle="color:red" path="lastname"/>
  </div>
  
  <div class="form-group">
    <label>Email :</label>
    <form:input name="email" path="email" type="text" placeholder="Email Addresss...." class="form-control" />
    <form:errors cssStyle="color:red" path="email"/><span Style="color:red" >${Emailmatch}</span>
  </div>
  
  <div class="form-group">
    <label>Password :</label>
    <form:input name="pass" path="password" type="password" placeholder="Password" class="form-control" />
     <form:errors cssStyle="color:red" path="password"/>
  </div>
  
  <div class="form-group">
    <label>Confirm Password :</label>
    <input required="required" name="cpass" type="password" placeholder="Confirm Password" class="form-control">
    <span Style="color:red" >${passerror}</span>
  </div>
  
  <div class="form-group">
    <label>Phone :</label>
    <form:input path="phone" type="text" placeholder="Phone" class="form-control" />
    <form:errors cssStyle="color:red" path="phone"/>
  </div>
  
  <div class="form-group">
    <label>First Address :</label>
    <form:textarea path="address1" rows="5" cols="5" placeholder="Primary Address...." class="form-control" ></form:textarea>
 	<form:errors cssStyle="color:red" path="address1"/>
  </div>
  
  <div class="form-group">
    <label>Second Address :</label>
    <form:textarea path="address2" rows="5" cols="5" placeholder="Second Address (OPTIONAL)" class="form-control" ></form:textarea>
  </div>
  
  <div class="form-group">
  <label>Select City :</label>
  <form:select path="city">
  <option value="Mumbai">Mumbai</option>
  <option value="Delhi">Delhi</option>
  <option value="Gujarat">Gujarat</option>
  <option value="Uttar Pradesh">Uttar Pradesh</option>
  <option value="Punjab">Punjab</option>
  <option value="Rajasthan">Rajasthan</option>
  </form:select>
  </div>

  <div class="form-group">
    <label>Enter Pin-code :</label>
    <form:input path="pincode" type="number" maxlength="6"  placeholder="Pin code...." class="form-control" />
    <form:errors cssStyle="color:red" path="pincode"/>
  </div>
  
  <div style="text-align: center;" class="form-group">
  <button type="submit"  class="btn btn-primary">Submit</button>
  </div>

</form:form>
</div>
</body>
</html>