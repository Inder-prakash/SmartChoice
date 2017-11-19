<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="${pageContext.request.contextPath}/resources/css/style-responsive.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Alex+Brush" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet" />
<title>SmartChoice</title>
</head>
<body>
<body>
<jsp:include page="header.jsp" />  
 <div>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
      <li data-target="#myCarousel" data-slide-to="4"></li>
      <li data-target="#myCarousel" data-slide-to="5"></li>
      <li data-target="#myCarousel" data-slide-to="6"></li>
      <li data-target="#myCarousel" data-slide-to="7"></li>
      <li data-target="#myCarousel" data-slide-to="8"></li>
    </ol>

 
    <div class="carousel-inner">
      <div class="item active">
        <img src="resources/images/Coursel1.jpg" alt="1" style="width:100%;">
      </div>

      <div class="item">
        <img src="resources/images/Coursel2.jpg" alt="2" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="resources/images/Coursel3.jpg" alt="3" style="width:100%;">
      </div>
        
      <div class="item">
        <img src="resources/images/Coursel4.jpg" alt="4" style="width:100%;">
      </div>
        
      <div class="item">
        <img src="resources/images/Coursel5.jpg" alt="5" style="width:100%;">
      </div>
      
      <div class="item">
        <img src="resources/images/Coursel6.jpg" alt="6" style="width:100%;">
      </div>
      
      <div class="item">
        <img src="resources/images/Coursel7.jpg" alt="7" style="width:100%;">
      </div>
      
      <div class="item">
        <img src="resources/images/Coursel8.jpg" alt="8" style="width:100%;">
      </div>
      
      <div class="item">
        <img src="resources/images/Coursel9.jpg" alt="9" style="width:100%;">
      </div>
      
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
    </div>

   <div style="height:20px; " class="row">
        <div class="col-sm-4"></div>
    </div>
  </div>
   
  <div style="width: 100%;" class="row catimage-div">
    <c:forEach items="${category}" var="x">   
    <div align="center" class="col-sm-3">
      <a href="ViewProduct/${x.getId()}"><img src="${x.getCategoryimage()}" class="img-responsive indexcatimage" width="204" height="186"></a>
    </div>
    </c:forEach>
  </div>
  
 
  
  
  <div style="width: 100%;" class="row catimage-div"> 
    <div align="center" class="col-sm-3">
      <a href="${pageContext.request.contextPath}/productbysubcat/1">
      <img src="resources/images/electronics/phones.jpg" class="img-responsive indexcatimage" width="204" height="186"></a>  
  </div>
   <div align="center" class="col-sm-3">
      <a href="${pageContext.request.contextPath}/productbysubcat/3">
      <img src="resources/images/electronics/laptops.jpg" class="img-responsive indexcatimage" width="204" height="186"></a>
  </div>
   <div align="center" class="col-sm-3">
      <a href="${pageContext.request.contextPath}/productbysubcat/5">
      <img src="resources/images/electronics/games.jpg" class="img-responsive indexcatimage" width="204" height="186"></a>  
  </div>
   <div align="center" class="col-sm-3">
      <a href="${pageContext.request.contextPath}/productbysubcat/4">
      <img src="resources/images/electronics/camera.jpg" class="img-responsive indexcatimage" width="204" height="186"></a>
  </div>
 </div>
  
  
  <div style="width: 100%;" class="row catimage-div"> 
    <div align="center" class="col-sm-3">
      <a href="${pageContext.request.contextPath}/productbysubcat/2">
      <img src="resources/images/electronics/tv.jpg" class="img-responsive indexcatimage" width="204" height="186"></a>  
  </div>
   <div align="center" class="col-sm-3">
      <a href="${pageContext.request.contextPath}/productbysubcat/6">
      <img src="resources/images/Men/shirts.jpg" class="img-responsive indexcatimage" width="204" height="186"></a>
  </div>
   <div align="center" class="col-sm-3">
      <a href="${pageContext.request.contextPath}/productbysubcat/7">
      <img src="resources/images/Men/tshirts.jpg" class="img-responsive indexcatimage" width="204" height="186"></a>  
  </div>
   <div align="center" class="col-sm-3">
      <a href="${pageContext.request.contextPath}/productbysubcat/8">
      <img src="resources/images/Men/lowers.jpg" class="img-responsive indexcatimage" width="204" height="186"></a>
  </div>
 </div>
  
  
  <div style="width: 100%;" class="row catimage-div"> 
    <div align="center" class="col-sm-3">
      <a href="${pageContext.request.contextPath}/productbysubcat/10">
      <img src="resources/images/Men/watches.jpg" class="img-responsive indexcatimage" width="204" height="186"></a>  
  </div>
   <div align="center" class="col-sm-3">
      <a href="${pageContext.request.contextPath}/productbysubcat/9">
      <img src="resources/images/Men/boots.jpg" class="img-responsive indexcatimage" width="204" height="186"></a>
  </div>
   <div align="center" class="col-sm-3">
      <a href="${pageContext.request.contextPath}/productbysubcat/11">
      <img src="resources/images/women/shirts.jpg" class="img-responsive indexcatimage" width="204" height="186"></a>  
  </div>
   <div align="center" class="col-sm-3">
      <a href="${pageContext.request.contextPath}/productbysubcat/13">
      <img src="resources/images/women/tshirt.jpg" class="img-responsive indexcatimage" width="204" height="186"></a>
  </div>
 </div>
  
  
  
  <div style="width: 100%;" class="row catimage-div"> 
   <div align="center" class="col-sm-3">
      <a href="${pageContext.request.contextPath}/productbysubcat/12">
      <img src="resources/images/women/jeans.jpg" class="img-responsive indexcatimage" width="204" height="186"></a>  
  </div>
   <div align="center" class="col-sm-3">
      <a href="${pageContext.request.contextPath}/productbysubcat/14">
      <img src="resources/images/women/boot.jpg" class="img-responsive indexcatimage" width="204" height="186"></a>
  </div>
   <div align="center" class="col-sm-3">
      <a href="${pageContext.request.contextPath}/productbysubcat/15">
      <img src="resources/images/women/watch.jpg" class="img-responsive indexcatimage" width="204" height="186"></a>  
  </div>
   <div align="center" class="col-sm-3">
      <a href="${pageContext.request.contextPath}/productbysubcat/23">
      <img src="resources/images/book/child.jpg" class="img-responsive indexcatimage" width="204" height="186"></a>
  </div>
 </div>
 
 
   <div style="width: 100%;" class="row catimage-div"> 
  <div align="center" class="col-sm-3">
      <a href="${pageContext.request.contextPath}/productbysubcat/20">
      <img src="resources/images/book/academic.jpg" class="img-responsive indexcatimage" width="204" height="186"></a>
  </div>
   <div align="center" class="col-sm-3">
      <a href="${pageContext.request.contextPath}/productbysubcat/21">
      <img src="resources/images/book/fiction1.jpg" class="img-responsive indexcatimage" width="204" height="186"></a>
  </div>
   <div align="center" class="col-sm-3">
      <a href="${pageContext.request.contextPath}/productbysubcat/22">
      <img src="resources/images/book/drama.jpg" class="img-responsive indexcatimage" width="204" height="186"></a>
  </div>
   <div align="center" class="col-sm-3">
      <a href="${pageContext.request.contextPath}/productbysubcat/23">
      <img src="resources/images/book/comics.jpg" class="img-responsive indexcatimage" width="204" height="186"></a>
  </div>
 </div>
 
 
   <div class="panel panel-default" >
  <div style="text-align: center;" class="panel-heading">
  <p class="panel-title" style="font-size:45px; font-weight:bold; font-family: 'Alex Brush' ;" >Latest Products</p>
  </div>
  <div style="width: 100%;" class="row catimage-div">
    <c:forEach items="${latestproduct}" var="x">   
    <div align="center" class="col-sm-3">
      <a href="${pageContext.request.contextPath}/product/${x.getId()}"><img src="${x.getProductimage()}" class="img-responsive indexcatimage" width="150" ></a>
    </div>
    </c:forEach>
  </div>
 </div>
 
  
 
<style>

  .logo-small {
      color: #f4511e;
      font-size: 50px;
  }

</style>
<!-- Container (Services Section) -->
<div style="background-color: rgb(230, 230, 230);" class="container-fluid text-center">
  <h2>SERVICES</h2>
  <h4>What we offer</h4>
  <br>
  <div class="row">
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-off logo-small"></span>
      <h4>POWER</h4>
      <p>Best manpower quotes selected by thousands of our users!</p>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-heart logo-small"></span>
      <h4>LOVE</h4>
      <p>Showing customers the love and respect they deserve has never been more critical.</p>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-lock logo-small"></span>
      <h4>JOB DONE</h4>
      <p>Choose a job you love, and you will never have to work a day in your life.</p>
    </div>
  </div>
  <br><br>
  <div class="row">
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-leaf logo-small"></span>
      <h4>GREEN</h4>
      <p>The future will either be green or not at all.</p>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-certificate logo-small"></span>
      <h4>CERTIFIED</h4>
      <p>Officially recognize as possessing certain qualifications or meeting certain standards.</p>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-wrench logo-small"></span>
      <h4 style="color:#303030;">HARD WORK</h4>
      <p>Some people dream of success while others wake up and work hard at it.</p>
    </div>
  </div>
</div>


<!-- Container (Contact Section) -->
<div style="background-color: rgb(230, 230, 230);" class="container-fluid bg-grey">
<div class="container">
  <h2 style="margin-top: 80px;" class="text-center">CONTACT</h2>
  <div " class="row">
    <div class="col-sm-5">
      <p>Contact us and we'll get back to you within 24 hours.</p>
      <p><span class="glyphicon glyphicon-map-marker"></span> India , New Delhi</p>
      <p><span class="glyphicon glyphicon-phone"></span>9716923847</p>
      <p><span class="glyphicon glyphicon-envelope"></span> Inder.Singh@hotmail.com</p> 
    </div>
    <div class="col-sm-7">
      <div class="row">
        <div class="col-sm-6 form-group">
          <input class="form-control" id="name" name="name" placeholder="Name" type="text" required>
        </div>
        <div class="col-sm-6 form-group">
          <input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
        </div>
      </div>
      <textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5"></textarea><br>
      <div class="row">
        <div class="col-sm-12 form-group">
          <button class="btn btn-default pull-right" type="submit">Send</button>
        </div>
      </div> 
    </div>
  </div>
  </div>
</div>

  
 


</body>
</html>