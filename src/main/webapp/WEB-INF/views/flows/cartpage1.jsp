<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart Page1</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>

</head>

<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<body ng-app="myApp" ng-controller="myCtrl">


<br>
<a href="${pageContext.request.contextPath}/index" class="btn btn-success" style=" float:left; margin-left:50px; margin-top:45px">Previous</a>

<h2 align="center">Your Cart</h2>

<a href="${flowExecutionUrl}&_eventId=submitBillingAndShipping" class="btn btn-success" style="float:right ;margin-right:50px; margin-top:10px">Next</a>

<br>
<br>
<br>
<br>

<table class="table table-striped" style="margin: auto; width: 90%; text-align: center;">

	<thead>
		<tr>
		<th>Name</th>
		<th>Description</th>
		<th>Image</th>
		<th>Quantity</th>
		<th>Price</th>
		<th>Sub-Total</th>
		<th>Delete</th>
		</tr>
	</thead>
	
	<tbody>
		<tr ng-repeat="x in data">
		<th width="20%">{{x.pname}}</th>
		<th width="40%">{{x.pdesc}}</th>
		<th width="2%"><img src='{{x.pimg}}' width="150"></th>
		<th>{{x.qty}}</th>
		<th>{{x.pprice}}</th>
		<th>{{x.pprice * x.qty}}</th>
		<th><button ng-click="Delete(x.id)" class="btn btn-danger">Delete</button></th>
		</tr>
	</tbody>

</table>
<br>
<br>
<br>
<script>

var app = angular.module("myApp", []).controller("myCtrl", function($scope,$http) {
       
    $scope.data = [];
    
    $http(	{
    			method: 'POST',
	      		url: 'getAllCartItems',
	      		 headers : {'Content-Type':'application/x-www-form-urlencoded'}
    			}).then(function(response){
			    	console.log(response.data); 
			    	$scope.data = response.data; 	
    			});
  
    $scope.Delete=function(arg){
    	
    	alert(arg);
    	
    	var json={"id":arg};
    	
    	console.log( JSON.stringify(json) );
    	
    	$http(	{
			method: 'POST',
      		url: 'deletefromcart',
      		data:JSON.stringify(json),
      		 headers : {'Content-Type':'application/json'}
			}).then(function(response){
		    	console.log(response.data);
		    
		    	//Fetch Again
		    	$http(	{
	    			method: 'POST',
		      		url: 'getAllCartItems',
		      		 headers : {'Content-Type':'application/x-www-form-urlencoded'}
	    			}).then(function(response){
				    	console.log(response.data);
				    
				    	$scope.data = response.data;
				    	
	    			});
		    	
			});
    	
    }
    
});


</script>

</body>
</html>