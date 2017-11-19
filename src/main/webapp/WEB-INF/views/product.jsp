<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="header.jsp"></jsp:include>

<form action="${pageContext.request.contextPath}/AddCartToDB" method="post">
  <div  class="row">
    <div class="col-sm-2">
    </div>
    
    <div class="col-sm-8">
    
      <div style="margin: 20px;" class="row">
      	<div class="col-sm-5">
      		<img style=" box-shadow: 10px 10px 5px grey;" width="450px" class="img-responsive" src="${productdata.getProductimage()}">
      	</div> 	
      	<div class="col-sm-7">
     		<h1 style="text-align: center;">${productdata.getProductname()}</h1>
     		<input type="hidden" name="id" value="${productdata.getId()}">
     		<input type="hidden" name="userid" value="${user.getId()}">
     		<input type="hidden" name="address" value="${user.getAddress1()}">
     		<div style="padding: 20px">
     		 ${productdata.getProductdescription()}	 
     		</div>
      	</div> 	
      </div>
      <br>
      <div style="margin: 20px;" class="row">
      	<div class="col-sm-5">
      	</div> 
      	<div class="col-sm-7">
      	
         <table class="table">
      	 <tr>
      	 <td><h1>Rs.${productdata.getProductprice()}</h1></td>
      	 </tr>
      	 
      	 	<tr>
      	 	
      	 	<td width="300px" ><input name="quantity" onchange="myFunction()" style=" float:left; width: 300px;" class="form-control" type="range" id="myRange" min="1"  value="1" max="${productdata.getProductquantity()}" ></td>
      	 	<td><p style="font-size: large;" id="demo">1</p></td>
      	 	</tr>
      	 	<tr>
      	 	<td><input style=" float:none;" class="btn btn-success" type="submit" value="Add to Cart"></td>
      	 	</tr>
      	 </table>
      
      	</div>
      </div>
      
    </div>
    
    <div class="col-sm-2"> 
    </div>
  </div>
  
  <div  style="margin-top: 200px;" class="row">
  	
  </div>
  	</form>
<script>
function myFunction() {
    var x = document.getElementById("myRange").value;
    document.getElementById("demo").innerHTML = x;
}
</script>
</body>
</html>