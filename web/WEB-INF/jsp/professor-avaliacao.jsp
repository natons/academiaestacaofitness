<%-- 
    Document   : professor-avaliacao
    Created on : 23/06/2015, 02:12:51
    Author     : Natanael
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=ISO-8859-1" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <!-- Head -->


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Painel Administrativo Professor</title>

        <meta name="description" content="Professor" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <link rel="shortcut icon" href="painel/img/favicon.png" type="image/x-icon">


            <!--Basic Styles-->
            <link href="painel/css/font-awesome.min.css" rel="stylesheet" />
            <link href="painel/css/weather-icons.min.css" rel="stylesheet" />

            <!--Beyond styles-->
            <link href="painel/css/style.css" rel="stylesheet" type="text/css"/>
            <link href="painel/css/demo.min.css" rel="stylesheet" />
            <link href="painel/css/typicons.min.css" rel="stylesheet" />
            <link href="painel/css/animate.min.css" rel="stylesheet" />
            
            <!-- Multselect -->
            <link rel="stylesheet" href="painel/css/bootstrap-multiselect.css" type="text/css"/>
            
            <!--Skin Script: Place this script in head to load scripts for skins and rtl support-->
            <script src="painel/js/skins.min.js"></script>
            
            <link href="painel/css/dataTables.bootstrap.css" rel="stylesheet" />

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
                        <a href="mvc?logica=LstProfessorPrincipal" class="navbar-brand">
                            <small>
                                <img src="painel/img/iconeAcademia.png" alt="" class="icone-topo"/>
                            </small>
                        </a>
                    </div>
                    <!-- /Navbar Barnd -->
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
                                        <li class="email"><a>Professor</a></li>
                                        <!--Avatar Area-->
                                        <li>
                                            <div class="avatar-area">
                                                <img src="${usuario.urlFoto}" class="avatar">
                                                    <a href="mvc?logica=LstProfessorPerfil&id=${usuario.idProfessor}" class="caption">
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
                            </ul>
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
                                <a href="mvc?logica=LstProfessorPrincipal">Home</a>
                            </li>
                            <li class="active">Exercícios</li>
                        </ul>
                    </div>
                    <!-- /Page Breadcrumb -->
                    <!-- Page Header -->
                    <div class="page-header position-relative">
                        <div class="header-title">
                            <h1>
                                Exercícios Alunos
                            </h1>
                        </div>
                        <!--Header Buttons-->
                        <div class="header-buttons">
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
                                                <div class="databox-text darkgray">Sugestões</div>
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
                                                <div class="databox-text darkgray">Matrícula</div>
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
                            <div class="col-xs-12 col-md-12">
                                <div class="widget">
                                    <div class="widget-header bg-danger">
                                        <span class="widget-caption"><h4>Tabela de Avaliações</h4></span>
                                        <div class="widget-buttons">
                                            <a href="#" data-toggle="maximize">
                                                <i class="fa fa-expand"></i>
                                            </a>
                                            <a href="#" data-toggle="collapse">
                                                <i class="fa fa-minus"></i>
                                            </a>
                                            <a href="#" data-toggle="dispose">
                                                <i class="fa fa-times"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="widget-body">
                                        <table class="table table-striped table-hover table-bordered" id="editabledatatable">
                                            <thead>
                                                <tr role="row">
                                                    <th>
                                                        Resultado
                                                    </th>
                                                    <th>
                                                        Valor
                                                    </th>
                                                    <th>
                                                        Validade
                                                    </th>
                                                    <th>
                                                        Data
                                                    </th>
                                                    <th>
                                                    </th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <form action="mvc?logica=AlteraProfessorAvaliacao" method="POST">
                                                    <tr class="small">
                                                        <input type="hidden" name="idProfessor" value="${usuario.idProfessor}" />
                                                        <input type="hidden" value="${avaliacao.idAvaliacao}" name="idAvaliacao"/>
                                                        <input name="idAlunoFK" type="hidden" class="input-small input-transparente" value="${avaliacao.aluno.idAluno}" />
                                                        <td>
                                                            <textArea name="resultado" rows="4" class="form-control">${avaliacao.resultado}</textArea>
                                                        </td>
                                                        <td>
                                                            <input name="valor" class="input-small" type="text" value="${avaliacao.valor}" />
                                                        </td>
                                                        <td>
                                                            <input name="dataValidade" class="input-small " type="date" value="${avaliacao.validade}" />
                                                        </td>
                                                        <td>
                                                            <input name="dataAvaliacao" class="input-small" type="date" value="${avaliacao.dataAvaliacao}" />
                                                        </td>
                                                        <td>
                                                            <button type="submit" class="btn btn-info btn-xs edit">
                                                                <i class="fa fa-edit"></i> 
                                                                Salvar
                                                            </button>
                                                            <a href="mvc?logica=LstProfessorPrincipal" class="btn btn-warning btn-xs cancel">
                                                                <i class="fa fa-times"></i> 
                                                                Cancelar
                                                            </a>
                                                        </td>
                                                    </tr>
                                                </form>
                                            </tbody>
                                        </table>
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
        <script src="painel/js/beyond.js"></script>
        
        <script type="text/javascript" src="painel/js/bootstrap-multiselect.js"></script>
        
        <script type="text/javascript" src="painel/js/multiselect-init.js"></script>

        
    </body>
    <!--  /Body -->
</html>
