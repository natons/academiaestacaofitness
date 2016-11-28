<%-- 
    Document   : professores
    Created on : 11/06/2015, 22:09:08
    Author     : Natanael
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=ISO-8859-1" %> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- Head -->
<head>
    <META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
    <title>Painel Administrativo Professores</title>

    <meta name="description" content="Recepcionista-Professores" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


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

    <!-- Tabelas CSS -->
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
                    <a href="mvc?logica=LstRecepcionistaPrincipal" class="navbar-brand">
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
                                <a class=" dropdown-toggle" data-toggle="dropdown" title="Sugest�es" href="#">
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
                                    <li class="email"><a>Recepcionista</a></li>
                                    <!--Avatar Area-->
                                    <li>
                                        <div class="avatar-area">
                                            <img src="${usuario.urlFoto}" class="avatar">
                                            <a href="mvc?logica=LstRecepcionistaPerfil&id=${usuario.idRecepcionista}" class="caption">
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
                    <div class="searchhelper">Procurar por Alunos, Estagi�rios, Nutricionistas e Professores</div>
                </div>
                <!-- /Page Sidebar Header -->
                <!-- Sidebar Menu -->
                <ul class="nav sidebar-menu">
                    <!--Geral-->
                    <li>
                        <a href="mvc?logica=LstRecepcionistaPrincipal">
                            <i class="menu-icon glyphicon glyphicon-home"></i>
                            <span class="menu-text"> Geral </span>
                        </a>
                    </li>
                    <!--Databoxes-->
                    <li>
                        <a href="mvc?logica=ListaAlunoLogica">
                            <i class="menu-icon fa fa-tag"></i>
                            <span class="menu-text"> Alunos </span>
                        </a>
                    </li>
                    <li>
                        <a href="mvc?logica=ListaEstagiarioLogica">
                            <i class="menu-icon fa fa-tag"></i>
                            <span class="menu-text"> Estagi�rios </span>
                        </a>
                    </li>
                    <li>
                        <a href="mvc?logica=ListaNutricionistaLogica">
                            <i class="menu-icon fa fa-tag"></i>
                            <span class="menu-text"> Nutricionistas </span>
                        </a>
                    </li>
                    <li class="active">
                        <a href="mvc?logica=ListaProfessorLogica">
                            <i class="menu-icon fa fa-tag"></i>
                            <span class="menu-text"> Professores </span>
                        </a>
                    </li>
                    <li>
                        <a href="mvc?logica=ListaSugestaoLogica">
                            <i class="menu-icon fa fa-envelope"></i>
                            <span class="menu-text"> Sugest�es </span>
                        </a>
                    </li>
                    <li>
                        <a href="mvc?logica=ListaLembreteLogica&id=${usuario.idRecepcionista}">
                            <i class="menu-icon fa fa-calendar"></i>
                            <span class="menu-text"> Lembretes </span>
                        </a>
                    </li>
                    <li>
                        <a href="mvc?logica=LstRecepcionistaPerfil&id=${usuario.idRecepcionista}">
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
                            <a href="alunos.html">Home</a>
                        </li>
                        <li class="active">Professores</li>
                    </ul>
                </div>
                <!-- /Page Breadcrumb -->
                <!-- Page Header -->
                <div class="page-header position-relative">
                    <div class="header-title">
                        <h1>
                            Professores
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
                                                <i class="fa fa-calendar"></i>
                                            </div>
                                        </div>
                                        <div class="databox-right">
                                            <span class="databox-number themesecondary">${qtdLembretes}</span>
                                            <div class="databox-text darkgray">LEMBRETES</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                    <div class="databox bg-white radius-bordered">
                                        <div class="databox-left bg-themethirdcolor">
                                            <div class="databox-piechart">
                                                <i class="fa fa-envelope-o"></i>
                                            </div>
                                        </div>
                                        <div class="databox-right">
                                            <span class="databox-number themethirdcolor">${qtdNovasSugestoes}</span>
                                            <div class="databox-text darkgray">SUGEST�ES</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                    <div class="databox bg-white radius-bordered">
                                        <div class="databox-left bg-themeprimary">
                                            <div class="databox-piechart">
                                                <i class="fa fa-users"></i>
                                            </div>
                                        </div>
                                        <div class="databox-right">
                                            <span class="databox-number themeprimary">${qtdUsuarios}</span>
                                            <div class="databox-text darkgray">USU�RIOS</div>
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
                                            <div class="databox-text darkgray">Recepcionista</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Tabela de Alunos -->
                    <div class="row">
                        <div class="col-xs-12 col-md-12">
                            <div class="widget">
                                <div class="widget-header ">
                                    <span class="widget-caption">Tabela de Professores</span>
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
                                    <div class="table-toolbar">
                                        <a href="mvc?logica=MostraProfessor" class="btn btn-default">
                                            Novo Professor
                                        </a>
                                    </div>
                                    <div class="table-scrollable">
                                        <table class="table table-striped table-hover table-bordered font-90" id="editabledatatable">
                                            <thead>
                                                <tr role="row">
                                                    <th>
                                                        Nome
                                                    </th>
                                                    <th>
                                                        Matr�cula
                                                    </th>
                                                    <th>
                                                        CPF
                                                    </th>
                                                    <th>
                                                        Endere�o
                                                    </th>
                                                    <th>
                                                        Telefone
                                                    </th>
                                                    <th>
                                                        Status
                                                    </th>
                                                    <th>
                                                        Senha
                                                    </th>
                                                    <th>

                                                    </th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <form action="mvc?logica=AlteraProfessorLogica" method="POST">
                                                    <tr>
                                                        <!-- HIDDENS VALORES -->
                                                        <input type="hidden" value="${professor.idProfessor}" name="idProfessor"/>

                                                        <td>
                                                            <input name="nome" class="input-small small" type="text" value="${professor.nome}"/>
                                                        </td>
                                                        <td>
                                                            <input name="matricula" class="input-small small" type="text" value="${professor.matricula}"/>
                                                        </td>
                                                        <td>
                                                            <input name="cpf" class="input-small small" type="text" value="${professor.cpf}"/>
                                                        </td>
                                                        <td>
                                                            <input name="endereco" class="input-small small" type="text" value="${professor.endereco}"/>
                                                        </td>
                                                        <td> 
                                                            <c:choose>
                                                                <c:when test="${professor == null}">
                                                                    <input name="telefone1" type="text" class="input-small small" value="" />
                                                                    <input name="telefone2" type="text" class="input-small small" value="" />
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <c:forEach var="telefone" items="${professor.telefones}" varStatus="nome">
                                                                        <input name="telefone${nome.count}" type="text" class="input-small small" value="${telefone.numero}" />

                                                                        <!-- passando id do telefone -->
                                                                        <input type="hidden" value="${telefone.idTelefone}" name="id${nome.count}"/>

                                                                        <!-- Contagem de quantos telefones se tem e enviando para a servlet -->
                                                                        <c:if test="${nome.last == true}">
                                                                            <input type="hidden" value="${nome.count}" name="contador"/>
                                                                        </c:if>
                                                                    </c:forEach>
                                                                </c:otherwise>
                                                            </c:choose>       
                                                        </td>
                                                        <td>
                                                            <select name="status" class="input-small small">
                                                                <option value="Ativado">Ativado</option>
                                                                <option value="Desativado">Desativado</option>
                                                            </select>
                                                        </td>
                                                        <td>
                                                            <input name="senha" class="input-small small" type="password" value="${professor.senha}" />
                                                        </td>
                                                        <td>
                                                            <button type="submit" class="btn btn-info btn-xs edit">
                                                                <i class="fa fa-edit"></i> 
                                                                Salvar
                                                            </button>
                                                            <a href="mvc?logica=ListaProfessorLogica" class="btn btn-warning btn-xs cancel">
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
                    <!-- Fim da Tabela de Alunos -->
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

    <!-- Tabelas -->
    <!-- <script src="painel/js/datatable/jquery.dataTables.min.js"></script>
    <script src="painel/js/datatable/ZeroClipboard.js"></script>
    <script src="painel/js/datatable/dataTables.tableTools.min.js"></script>
    <script src="painel/js/datatable/dataTables.bootstrap.min.js"></script>
    <script src="painel/js/datatable/datatables-init.js"></script>
    <script>
        InitiateEditableDataTable.init();
    </script>
    -->


</body>
<!--  /Body -->


</html>


