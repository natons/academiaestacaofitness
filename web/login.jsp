<%-- 
    Document   : login
    Created on : 09/06/2015, 15:54:50
    Author     : Natanael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="UTF-8">
	<title>Login Estação Fitness</title>
	<link rel="stylesheet" href="inicial/css/font-awesome.min.css">
	<link rel="stylesheet" href="inicial/css/bootstrap.min.css">
	<link rel="stylesheet" href="inicial/css/animate.min.css">
	<link rel="stylesheet" href="inicial/css/style.css">
	<link rel="stylesheet" href="inicial/css/responsive.css">           
        <link rel="shortcut icon" href="painel/img/favicon.png" type="image/x-icon">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,800,700,300' rel='stylesheet' type='text/css'>
	<script src="inicial/js/modernizr.js"></script>
	<!--[if lt IE 9]>
	    <script src="inicial/js/html5shiv.js"></script>
	    <script src="inicial/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
	
	<!-- ====================================================
	header section -->
	<header class="top-header">
		<div class="container" >
			<div class="row">
				<!-- nav starts here -->
				<div class="col-md-12">					
					<nav class="navbar navbar-default">
						<div class="container-fluid nav-bar">
						    <div class="navbar-header">
						      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						        <span class="sr-only">Barra de Navegação</span>
						        <span class="icon-bar"></span>
						        <span class="icon-bar"></span>
						        <span class="icon-bar"></span>
						      </button>
						      <img src="inicial/img/iconeAcademia.png" alt="" class="img-responsive logo" style="padding-top:0px;">
						    </div>
						    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						      <ul class="nav navbar-nav navbar-right">
						        <li><a href="index.html" class="efeitoNav">Home</a></li>
						        <li><a href="index.html#precos" class="efeitoNav">Preços</a></li>
						        <li><a href="index.html#about" class="efeitoNav">sobre nós</a></li>
						        <li><a href="index.html#depoimentos" class="efeitoNav">Depoimentos</a></li>
						        <li><a href="index.html#contato" class="efeitoNav">Contato</a></li>
						      </ul>
						    </div>
						</div>
					</nav>
				</div>
			</div>
		</div>
	</header><!-- end of header section -->
		
		
		<div class="container login" id="login">
			<div id="map"></div>
			<img src="inicial/img/logoAcademia.png">
                        <form action="mvc?logica=LoginLogica" method="POST">
				<input type="text" placeholder="Matrícula" name="matricula"><br>
				<input type="password" placeholder="Senha"  name="senha"><br>
				<input type="submit" value="Login" >
			</form>
		</div>
		<!-- footer starts here -->
		<footer class="footer text-center">
			<div class="container">
				<div class="row">
					<div class="col-md-12">  
					    <p>COPYRIGHT &copy; 2015 Academia Estação Fitness todos os direitos reservados</p>
					</div>
				</div>
			</div>
		</footer>

	<!-- script tags
	============================================================= -->
	<script src="inicial/js/jquery-2.1.1.js"></script>
	<script src="inicial/js/smoothscroll.js"></script>
	<script src="inicial/js/bootstrap.min.js"></script>
	<script src="inicial/js/custom.js"></script>
	<script src="inicial/js/wow.js"></script>
	<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
	<script src="inicial/js/gmaps.js"></script>

	
	<script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>
</body>
</html>
