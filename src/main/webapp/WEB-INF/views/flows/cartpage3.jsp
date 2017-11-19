<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart Page3</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>

</head>


<body ng-app="myApp" ng-controller="myCtrl">


<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<br>
<br>
<h1 style="margin: auto; width: 80%; text-align: center;">Invoice</h1>

<a href="${flowExecutionUrl}&_eventId=submitBillingAndShipping" class="btn btn-success" style=" float:left; margin-left:50px; margin-top:45px">Previous</a>

<a href="${flowExecutionUrl}&_eventId=confirmOrder" class="btn btn-success" style="float:right ;margin-right:50px; margin-top:10px">Next</a>

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
		<td width="20%">{{x.pname}}</td>
		<td width="40%">{{x.pdesc}}</td>
		<td width="2%"><img src='{{x.pimg}}' width="150"></td>
		<td>{{x.qty}}</td>
		<td>{{x.pprice}}</td>
		<td>{{x.pprice * x.qty}}</td>
		<td><button ng-click="Delete(x.id)" class="btn btn-danger">Delete</button></td>
		</tr>
		
		<tr>
		<Td></Td>
		<Td><h3>Shipping Address:</h3></Td>
		<Td></Td>
		<Td><h3>Billing Address:</h3></Td>
		<Td></Td>
		<Td><h3>Total:</h3></Td>
		</tr>
		
		<tr>
		<Td></Td>
		<Td><h3>{{data[0].shipaddr}}</h3></Td>
		<Td></Td>
		<Td><h3>{{data[0].billaddr}}</h3></Td>
		<Td></Td>
		<Td><h3>{{total}}</h3></Td>
		</tr>
	</tbody>

</table>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<script>

var app = angular.module("myApp", []).controller("myCtrl", function($scope,$http) {
    
$scope.data = [];
    
    $scope.total = 0;
    
    $http(	{
    			method: 'POST',
	      		url: 'getAllCartItems',
	      		 headers : {'Content-Type':'application/x-www-form-urlencoded'}
    			}).then(function(response){
			    	console.log(response.data);
			    
			    	$scope.data = response.data;
			    	
			    	for( var x = 0; x < $scope.data.length ; x++ )
			    	{
			    		$scope.total += $scope.data[x].pprice *  $scope.data[x].qty;
			    	}
			    	
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