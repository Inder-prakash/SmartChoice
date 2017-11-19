<!DOCTYPE html>
<html lang="en">
  <head>
    <title>ADMIN PANEL</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 	<link href="${pageContext.request.contextPath}/resources/css/MyCss.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style-responsive.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  </head>

  <body>

  <section id="container" >
   
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a href="#"class="logo"><b >WELCOME ADMIN</b></a>
            
                
            </div>
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="${pageContext.request.contextPath}/logout">Logout</a></li>
            	</ul>
            </div>
        </header>
   

      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><img src="${pageContext.request.contextPath}/resources/images/ui-sam.jpg" class="img-circle" width="100"></p>
              	  <h5 class="centered">Inder Singh</h5>
              	  	
                  <li class="mt">
                      <a class="active" href="${pageContext.request.contextPath}/index">
                          <i class="fa fa-dashboard"></i>
                          <span>Home</span>
                      </a>
                  </li>

                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-desktop"></i>
                          <span>UI Elements</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="${pageContext.request.contextPath}/general.html">Carousel</a></li>
                          <li><a  href="${pageContext.request.contextPath}/buttons.html">Categories</a></li>
                          <li><a  href="${pageContext.request.contextPath}/panels.html">Change Picture</a></li>
                      </ul>
                  </li>

                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-cogs"></i>                   
                          <span>Add Components</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="${pageContext.request.contextPath}/AddCategory">Category</a></li>
                          <li><a  href="${pageContext.request.contextPath}/AddSubCategory">Sub-Category</a></li>
                      </ul>
                  </li>   
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-th"></i>
                          <span>Data Tables</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="${pageContext.request.contextPath}/ViewProducts">Products</a></li>
                          <li><a  href="${pageContext.request.contextPath}/ViewCategories">Categories</a></li>
                          <li><a  href="${pageContext.request.contextPath}/ViewCustomers">Customers</a></li>
                          <li><a  href="${pageContext.request.contextPath}/ViewSuppliers">Suppliers</a></li>
                          <li><a  href="${pageContext.request.contextPath}/ViewAdmins">Administrators</a></li> 
                          <li><a  href="${pageContext.request.contextPath}/ViewLoginHistory">Login History</a></li> 
                      </ul>              
                  </li>   
                    
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-lock"></i>
                          <span>Blocked</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="${pageContext.request.contextPath}/ViewBlockedSuppliers">Blocked Suppliers</a></li>  
                          <li><a  href="${pageContext.request.contextPath}/ViewBlockedCustomers">Blocked Users</a></li>
                          <li><a  href="${pageContext.request.contextPath}/ViewBlockedProducts">Blocked Products</a></li>  
                      </ul>
                  </li>
          </div>
      </aside>
  
      <section id="main-content">