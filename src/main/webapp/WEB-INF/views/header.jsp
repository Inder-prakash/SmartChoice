<%@page import="java.security.Principal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/MyCss.css">
<title>Insert title here</title>
</head>
<body>
<div> 


  <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a style="margin: 0px; padding: 0px;" class="navbar-brand" href="<c:url value="/index" />"><img  width="150px" src='${pageContext.request.contextPath}/resources/images/SmartChoiceLogo.png'></a>
    </div>
    
    
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="dropdown">
         <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-flash"> </span> ELECTRONICS<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="${pageContext.request.contextPath}/productbysubcat/1">Phones</a></li>
            <li><a href="${pageContext.request.contextPath}/productbysubcat/3">Laptop</a></li> 
            <li><a href="${pageContext.request.contextPath}/productbysubcat/4">Camera</a></li>
            <li><a href="${pageContext.request.contextPath}/productbysubcat/2">Television</a></li>   
            <li><a href="${pageContext.request.contextPath}/productbysubcat/5">Games</a></li>
          </ul>
        </li>
        
        
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-king"> </span> MEN<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="${pageContext.request.contextPath}/productbysubcat/6">Shirt</a></li>
            <li><a href="${pageContext.request.contextPath}/productbysubcat/7">Tshirt</a></li> 
            <li><a href="${pageContext.request.contextPath}/productbysubcat/8">Jeans</a></li>
            <li><a href="${pageContext.request.contextPath}/productbysubcat/9">Boot</a></li>   
            <li><a href="${pageContext.request.contextPath}/productbysubcat/10">Watches</a></li>
          </ul>
        </li>
        
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-queen"> </span> WOMEN<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="${pageContext.request.contextPath}/productbysubcat/11">Shirt</a></li>
            <li><a href="${pageContext.request.contextPath}/productbysubcat/13">Tshirt</a></li> 
            <li><a href="${pageContext.request.contextPath}/productbysubcat/12">Jeans</a></li>
            <li><a href="${pageContext.request.contextPath}/productbysubcat/14">Boot</a></li>   
            <li><a href="${pageContext.request.contextPath}/productbysubcat/15">Watches</a></li>
          </ul>
        </li>
        
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-book"> </span> BOOKS<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="${pageContext.request.contextPath}/productbysubcat/20">Academic</a></li>
            <li><a href="${pageContext.request.contextPath}/productbysubcat/21">Science Fiction</a></li> 
            <li><a href="${pageContext.request.contextPath}/productbysubcat/22">Drama</a></li>
            <li><a href="${pageContext.request.contextPath}/productbysubcat/23">Comics</a></li>   
          </ul>
        </li>
        
        <li>

          <form action="${pageContext.request.contextPath}/Searchdata" method="post" class="navbar-form navbar-left">
          
          <div class="form-group">
          <input type="text" style="width: 250px;" class="form-control" name="keytag" placeholder="Search">
          </div>
          <div class="form-group">
          <button type="submit" class="btn btn-info">Submit</button>
          </div>
          </form>
        </li>
            
       <%--  <li><a href="${pageContext.request.contextPath}/Aboutus">ABOUT US</a></li>
        <li><a href="${pageContext.request.contextPath}/Contatctus">CONTACT US</a></li> --%>
      </ul>
      
      
    
  	 
      	
      <ul class="nav navbar-nav navbar-right">
      <li>
      <a href="${pageContext.request.contextPath}/cart"><span class="glyphicon glyphicon-shopping-cart"></span>Cart</a>
      </li>  
      <c:choose>
      <c:when test="${userName==null}">
        <li><a href="${pageContext.request.contextPath}/SignUP"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="${pageContext.request.contextPath}/loginpage"><span class="glyphicon glyphicon-off"></span> Login</a></li>
      </c:when>
      <c:otherwise>
          
       <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Welcome ${userName.getFirstname()}<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="${pageContext.request.contextPath}/MyProfiles/${userName.getId()}">View Profile</a></li>
            <li><a href="${pageContext.request.contextPath}/UpdateProfile/${userName.getId()}">Edit Profile</a></li>           
          </ul>
        </li>           
        <li>
        <a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a>
        </li>
      </c:otherwise>
      </c:choose>
      </ul>
      
      
    </div>
  </div>
</nav>

</div>


</body>
</html>