<%-- 
    Document   : estagiario-perfil
    Created on : 18/06/2015, 23:52:47
    Author     : Luciana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=ISO-8859-1" %> 
<!DOCTYPE html>
<!--
BeyondAdmin - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.1
Version: 1.2.2
Purchase: http://wrapbootstrap.com
-->

<html xmlns="http://www.w3.org/1999/xhtml">
<!-- Head -->


<head>
    <META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Painel Administrativo Perfil </title>

    <meta name="description" content="Estagiario-Perfil" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="shortcut icon" href="painel/img/favicon.png" type="image/x-icon">


    <!--Basic Styles-->
    <link id="bootstrap-rtl-link" href="#" rel="stylesheet" />
    <link href="painel/css/font-awesome.min.css" rel="stylesheet" />
    <link href="painel/css/weather-icons.min.css" rel="stylesheet" />

    <!--Beyond styles-->
    <link href="painel/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="painel/css/demo.min.css" rel="stylesheet" />
    <link href="painel/css/typicons.min.css" rel="stylesheet" />
    <link href="painel/css/animate.min.css" rel="stylesheet" />
    <link id="skin-link" href="#" rel="stylesheet" type="text/css" />

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
                    <a href="mvc?logica=LstEstagiarioPrincipal" class="navbar-brand">
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
                                <a class=" dropdown-toggle" data-toggle="dropdown" title="D�vidas" href="#">
                                    <i class="icon fa fa-envelope"></i>
                                </a>
                                <!--Sugest�es Dropdown-->
                                <ul class="pull-right dropdown-menu dropdown-arrow dropdown-notifications">
                                    <c:forEach var="sugestao" items="${novasSugestoes}">
                                        <li>
                                            <div class="clearfix">
                                                <div class="row">
                                                    <div class="col-lg-12">
                                                        <div class="notification-icon">
                                                            <i class="glyphicon glyphicon-bookmark bg-themeprimary white"></i>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-lg-12">
                                                        <div class="notification-body text-justify">
                                                            <span class="title">${sugestao.descricao}</span>
                                                            <span class="description">${sugestao.data}</span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                    <li class="dropdown-footer">
                                        <a href="mvc?logica=ListaSugestaoLogica" class="btn btn-link"> Mostrar todas </a>
                                            <span class="pull-right">
                                                <i class="fa fa-angle-down"></i>
                                            </span>
                                        
                                    </li>
                                </ul>
                                <!--/Sugest�es Dropdown-->
                            </li>
                            
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
                                    <li class="email"><a>Estagi�rio</a></li>
                                    <!--Avatar Area-->
                                    <li>
                                        <div class="avatar-area">
                                            <img src="${usuario.urlFoto}" class="avatar">
                                            <a href="mvc?logica=LstEstagiarioPerfil&id=${usuario.idEstagiario}" class="caption">
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
            <!-- Page Content -->
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <!-- Page Breadcrumb -->
                <div class="page-breadcrumbs">
                    <ul class="breadcrumb">
                        <li>
                            <i class="fa fa-home"></i>
                            <a href="mvc?logica=LstEstagiarioPrincipal">Home</a>
                        </li>
                        <li class="active">Perfil</li>
                    </ul>
                </div>
                <!-- /Page Breadcrumb -->
                <!-- Page Header -->
                <div class="page-header position-relative">
                    <div class="header-title">
                        <h1>
                            Perfil
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
                                    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                        <div class="databox bg-white radius-bordered">
                                            <div class="databox-left bg-themesecondary">
                                                <div class="databox-piechart"> 
                                                    <i class="fa fa-question"></i>
                                                </div>
                                            </div>
                                            <div class="databox-right">
                                                <span class="databox-number themesecondary">${qtdSugestoes}</span>
                                                <div class="databox-text darkgray">Sugest�es</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                        <div class="databox bg-white radius-bordered">
                                            <div class="databox-left bg-themethirdcolor">
                                                <div class="databox-piechart">
                                                    <i class="fa fa-users"></i>
                                                </div>
                                            </div>
                                            <div class="databox-right">
                                                <span class="databox-number themethirdcolor">${qtdAluno}</span>
                                                <div class="databox-text darkgray">Clientes</div>
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
                                                <div class="databox-text darkgray">PERSONAL TRAINNER</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div id="perfil" class="profile-container">
                                <div class="profile-header row">
                                    <div class="col-lg-2 col-md-4 col-sm-12 text-center">
                                        <img src="${estagiario.urlFoto}" alt="" class="header-avatar" />
                                    </div>
                                    <div class="col-lg-5 col-md-8 col-sm-12 profile-info">
                                        <div class="header-fullname"><h1>${estagiario.nome}</h1></div>
                                    </div>
                                    <div class="col-lg-5 col-md-12 col-sm-12 col-xs-12 profile-stats">
                                        <div class="row">
                                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12 stats-col">
                                                <div class="stats-value darkcarbon">${estagiario.cpf}</div>
                                                <div class="stats-title">CPF</div>
                                            </div>
                                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 stats-col">
                                                <div class="stats-value darkcarbon">${estagiario.status}</div>
                                                <div class="stats-title">Status</div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-4 inlinestats-col">
                                                <i class="glyphicon glyphicon-map-marker"></i> ${estagiario.endereco}
                                            </div>
                                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 inlinestats-col">
                                                Tipo: <strong>Estagi�rio</strong>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="profile-body">
                                    <div class="col-lg-12">
                                        <div id="settings" class="tab-pane">
                                            
                                                <div class="form-title">
                                                    Dados pessoais
                                                </div>
                                                <div class="row">
                                                    <div class="col-sm-6">
                                                        <div class="form-group">
                                                            <span class="input-icon icon-right">
                                                                <input type="text" class="form-control" value="${estagiario.nome}" disabled/>
                                                                    <i class="fa fa-user blue"></i>
                                                            </span>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6">
                                                            <div class="form-group">
                                                                <span class="input-icon icon-right">
                                                                    <input class="form-control" value="${estagiario.cpf}" type="text" disabled/>
                                                                        <i class="fa fa-ticket"></i>
                                                                </span>
                                                            </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <c:forEach var="telefone" items="${estagiario.telefones}">
                                                        <div class="col-sm-6">
                                                            <div class="form-group">

                                                                <span class="input-icon icon-right">
                                                                    <input type="text" class="form-control" value="${telefone.numero}" disabled=""/>
                                                                    <i class="glyphicon glyphicon-earphone yellow"></i>
                                                                </span>

                                                            </div>
                                                        </div>
                                                    </c:forEach>
                                                </div>
                                                <div class="row">
                                                    <div class="col-sm-6">
                                                        <div class="form-group">
                                                            <span class="input-icon icon-right">
                                                                <input type="text" class="form-control" value="${estagiario.matricula}" disabled="">
                                                                    <i class="fa fa-barcode"></i>
                                                            </span>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <div class="form-group">
                                                            <span class="input-icon icon-right">
                                                                <input type="text" class="form-control" value="${estagiario.endereco}" disabled="">
                                                                    <i class="glyphicon glyphicon-home palegreen"></i>
                                                            </span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <hr class="wide">
                                                    <div class="row">
                                                        <div class="col-sm-5">
                                                            <div class="form-group">
                                                                <span class="input-icon icon-right">
                                                                    <input type="password" class="form-control" value="${estagiario.senha}" readonly>
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5">
                                                            <div class="form-group">
                                                                <span class="input-icon icon-right">
                                                                    <form action="mvc?logica=FotoUploadEstagiario&idEstagiario=${estagiario.idEstagiario}" method="POST" enctype="multipart/form-data" >
                                                                        <i class="glyphicon glyphicon-camera"></i>
                                                                        <input type="file" id="file" name="file" size="150"/>
                                                                        <button type="submit" class="btn btn-sm btn-warning">Salvar Foto
                                                                        <i class="fa fa-check right"></i></button>
                                                                    </form>
                                                                </span>
                                                            </div>
                                                        </div>
                                                                
                                                    </div>
                                                    <a href="mvc?logica=MostraEstagiarioPerfil&id=${usuario.idEstagiario}" class="btn btn-primary">Editar</a>
                                        </div>
                                    </div>
                                </div>
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
    <script src="painel/js/beyond.min.js"></script>



</body>
<!--  /Body -->


</html>



