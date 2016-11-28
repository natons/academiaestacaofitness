<%-- 
    Document   : aluno-exercicio
    Created on : 16/06/2015, 01:45:25
    Author     : Natanael
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=ISO-8859-1" %> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- Head -->


<head>
    <meta charset="utf-8" />
    <title>Painel Administrativo Exerc�cios</title>

    <meta name="description" content="Aluno" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="shortcut icon" href="painel/img/favicon.png" type="image/x-icon">


    <!--Basic Styles-->
    <link href="painel/css/font-awesome.min.css" rel="stylesheet" />
    <link href="painel/css/weather-icons.min.css" rel="stylesheet" />

    <!--Beyond styles-->
    <link href="painel/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="painel/css/demo.min.css" rel="stylesheet" />
    <link href="painel/css/typicons.min.css" rel="stylesheet" />
    <link href="painel/css/animate.min.css" rel="stylesheet" />

    <!--Skin Script: Place this script in head to load scripts for skins and rtl support-->
    <script src="painel/js/skins.min.js"></script>


</head>
<!-- /Head -->
<!-- Body -->
<body>
    <!-- Loading Container -->
    <div class="loading-container">
        <div class="loader"></div>
    </div>
    <!--  /Loading Container -->
    <!-- Navbar -->
    <div class="navbar">
        <div class="navbar-inner">
            <div class="navbar-container">
                <!-- Navbar Barnd -->
                <div class="navbar-header pull-left">
                    <a href="aluno.html" class="navbar-brand">
                        <small>
                            <img src="painel/img/iconeAcademia.png" alt="" class="icone-topo"/>
                        </small>
                    </a>
                </div>
                <!-- /Navbar Barnd -->
                <!-- Sidebar Collapse -->
                <div class="sidebar-collapse" id="sidebar-collapse">
                    <i class="collapse-icon fa fa-bars"></i>
                </div>
                <!-- /Sidebar Collapse -->
                <!-- Account Area and Settings -->
                <div class="navbar-header pull-right">
                    <div class="navbar-account">
                        <ul class="account-area">
                            <li>
                                <a class="login-area dropdown-toggle" data-toggle="dropdown">
                                    <div class="avatar" title="View your public profile">
                                        <img src="${usuario.urlFoto}">
                                    </div>
                                    <section>
                                        <h2><span class="profile"><span>${usuario.nome}</span></span></h2>
                                    </section>
                                </a>
                                <!--Login Area Dropdown-->
                                <ul class="pull-right dropdown-menu dropdown-arrow dropdown-login-area">
                                    <li class="username"><a>${usuario.nome}</a></li>
                                    <li class="email"><a>Aluno</a></li>
                                    <!--Avatar Area-->
                                    <li>
                                        <div class="avatar-area">
                                            <img src="${usuario.urlFoto}" class="avatar">
                                            <a href="mvc?logica=LstAlunoPerfil&id=${usuario.idAluno}" class="caption">
                                                Perfil
                                            </a>
                                        </div>
                                    </li>
                                    
                                    <li class="dropdown-footer">
                                        <a href="mvc?logica=LoginInvalidaLogica">
                                            Sair
                                        </a>
                                    </li>
                                </ul>
                                <!--/Login Area Dropdown-->
                            </li>
                            <!-- /Account Area -->
                            <!--Note: notice that setting div must start right after account area list.
                            no space must be between these elements-->
                            <!-- Settings -->
                        </ul><div class="setting">
                            <a id="btn-setting" title="Setting" href="#">
                                <i class="icon glyphicon glyphicon-cog"></i>
                            </a>
                        </div><div class="setting-container">
                            <label>
                                <input type="checkbox" id="checkbox_fixednavbar">
                                <span class="text">Fixar Topo</span>
                            </label>
                            <label>
                                <input type="checkbox" id="checkbox_fixedsidebar">
                                <span class="text">Fixar menu lateral</span>
                            </label>
                            <label>
                                <input type="checkbox" id="checkbox_fixedbreadcrumbs">
                                <span class="text">Fixed Barra de T�tulo</span>
                            </label>
                        </div>
                        <!-- Settings -->
                    </div>
                </div>
                <!-- /Account Area and Settings -->
            </div>
        </div>
    </div>
    <!-- /Navbar -->
    <!-- Main Container -->
    <div class="main-container container-fluid">
        <!-- Page Container -->
        <div class="page-container">

            <!-- Page Sidebar -->
            <div class="page-sidebar" id="sidebar">
                <!-- Page Sidebar Header-->
                <div class="sidebar-header-wrapper">
                    <input type="text" class="searchinput" />
                    <i class="searchicon fa fa-search"></i>
                    <div class="searchhelper">Procurar por Dieta e exerc�cios</div>
                </div>
                <!-- /Page Sidebar Header -->
                <!-- Sidebar Menu -->
                <ul class="nav sidebar-menu">
                    <!--Geral-->
                    <li>
                        <a href="mvc?logica=LstAlunoPrincipal">
                            <i class="menu-icon glyphicon glyphicon-home"></i>
                            <span class="menu-text"> Geral </span>
                        </a>
                    </li>
                    <!--Databoxes-->
                    <li>
                        <a href="mvc?logica=LstAlunoDieta">
                            <i class="menu-icon fa fa-tag"></i>
                            <span class="menu-text"> Minha Dieta </span>
                        </a>
                    </li>
                    <li  class="active">
                        <a href="mvc?logica=LstAlunoExercicio">
                            <i class="menu-icon fa fa-tag"></i>
                            <span class="menu-text"> Meus exerc�cios </span>
                        </a>
                    </li>
                    <li>
                        <a href="mvc?logica=LstAlunoSugestao&id=${usuario.idAluno}">
                            <i class="menu-icon fa fa-tag"></i>
                            <span class="menu-text"> Minhas Sugest�es </span>
                        </a>
                    </li>
                    <li>
                        <a href="mvc?logica=LstAlunoAvaliacao">
                            <i class="menu-icon fa fa-tag"></i>
                            <span class="menu-text"> Minhas Avalia��es </span>
                        </a>
                    </li>
                    <li>
                        <a href="mvc?logica=LstAlunoPerfil&id=${usuario.idAluno}">
                            <i class="menu-icon fa fa-wrench"></i>
                            <span class="menu-text"> Perfil </span>
                        </a>
                    </li>
                    
                <!-- /Sidebar Menu -->
            </div>
            <!-- /Page Sidebar -->
            
            <!-- Page Content -->
            <div class="page-content">
                <!-- Page Breadcrumb -->
                <div class="page-breadcrumbs">
                    <ul class="breadcrumb">
                        <li>
                            <i class="fa fa-home"></i>
                            <a href="mvc?logica=LstAlunoPrincipal">Home</a>
                        </li>
                        <li class="active">Exerc�cios</li>
                    </ul>
                </div>
                <!-- /Page Breadcrumb -->
                <!-- Page Header -->
                <div class="page-header position-relative">
                    <div class="header-title">
                        <h1>
                            Exercic�os
                        </h1>
                    </div>
                    <!--Header Buttons-->
                    <div class="header-buttons">
                        <a class="sidebar-toggler" href="#">
                            <i class="fa fa-arrows-h"></i>
                        </a>
                        <a class="fullscreen" id="fullscreen-toggler" href="#">
                            <i class="glyphicon glyphicon-fullscreen"></i>
                        </a>
                    </div>
                    <!--Header Buttons End-->
                </div>
                <!-- /Page Header -->
                <!-- Page Body -->
                <div class="page-body">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <div class="databox bg-darkcarbon radius-bordered white text-right">
                                        <div class="row">
                                            <div class="col-lg-6">
                                                    <h1>VOC� MALHA H�</h1>
                                            </div>
                                            <div class="col-lg-3">
                                                <div class="databox bg-yellow text-center preto">
                                                    <h1>${qtdDias} DIAS</h1>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                    <div class="databox bg-white radius-bordered">
                                        <div class="databox-left bg-themesecondary">
                                            <div class="databox-piechart"> 
                                                <i class="fa fa-calendar"></i>
                                            </div>
                                        </div>
                                        <div class="databox-right">
                                            <span class="databox-number themesecondary">
                                                <fmt:formatDate value="${usuario.dieta.validade}" type="DATE" 
							pattern="dd/MM/yyyy"/>
                                            </span>
                                            <div class="databox-text darkgray">Validade da Dieta</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                    <div class="databox bg-white radius-bordered">
                                        <div class="databox-left bg-themethirdcolor">
                                            <div class="databox-piechart">
                                                <i class="fa fa-calendar"></i>
                                            </div>
                                        </div>
                                        <div class="databox-right">
                                            <span class="databox-number themethirdcolor">${proxAvaliacao}</span>
                                            <div class="databox-text darkgray">Pr�xima Avalia��o</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                    <div class="databox bg-white radius-bordered">
                                        <div class="databox-left bg-themeprimary">
                                            <div class="databox-piechart">
                                                <i class="fa fa-info"></i>
                                            </div>
                                        </div>
                                        <div class="databox-right">
                                            <span class="databox-number themeprimary">${usuario.matricula}</span>
                                            <div class="databox-text darkgray">Matr�cula</div>
                                        </div>
                                    </div>
                                </div> 
                                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                    <div class="databox bg-white radius-bordered">
                                        <div class="databox-left no-padding">
                                            <img src="${usuario.urlFoto}" style="width:65px; height:65px;">
                                        </div>
                                        <div class="databox-right padding-top-20">
                                            <div class="databox-text darkgray">${usuario.nome}</div>
                                            <div class="databox-text darkgray">ALUNO</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12 col-sm-12 col-xs-12">
                            <div class="well with-header bg-green bordered-right bordered-green">
                                <div class="header bordered-green bg-preto">Exerc�cios recomendados pelo professor</div>
                                <c:forEach var="exercicio" items="${usuario.exercicios}">
                                    <div class="row">
                                        <c:forEach var="tipo" items="${exercicio.tipos}">
                                            <div class="col-lg-4">
                                                <h3 class="block text-center">${tipo.nome}</h3>
                                                <img class="img-exercicios" src="${tipo.urlImagem}">
                                                    <hr class="wide"></hr>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <h4 class="row-title before-black">
                                                ${exercicio.descricao}
                                            </h4>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>    
                <!-- /Page Body -->
            </div>
            <!-- /Page Content -->

        </div>
        <!-- /Page Container -->
        <!-- Main Container -->

    </div>

    <!--Basic Scripts-->
    <script src="painel/js/jquery-2.0.3.min.js"></script>
    <script src="painel/js/bootstrap.min.js"></script>
    <script src="painel/js/slimscroll/jquery.slimscroll.min.js"></script>

    <!--Beyond Scripts-->
    <script src="painel/js/beyond.js"></script>


</body>
<!--  /Body -->


</html>
