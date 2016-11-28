<!DOCTYPE html>
<!--
BeyondAdmin - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.1
Version: 1.2.2
Purchase: http://wrapbootstrap.com
-->
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
                                        <span class="widget-caption"><h4>Sugestões de Hoje</h4></span>
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
                                        <table class="table table-striped table-hover table-bordered" >
                                            <thead>
                                                <tr role="row">
                                                    <th>
                                                        Sugestão
                                                    </th>
                                                    <th>
                                                        data
                                                    </th>
                                                    <th>
                                                        Área
                                                    </th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <c:forEach var="sugestao" items="${sugestoes}">
                                                    <tr class="small">
                                                        <td>
                                                            <textarea name="descricao" class="form-control"  rows="4" disabled="">${sugestao.descricao}</textarea>
                                                        </td>
                                                        <td>
                                                            <input name="data" class="input-transparente" type="hidden" value="${sugestao.data}" disabled=""/>
                                                            <fmt:formatDate value="${sugestao.data}" type="DATE" pattern="dd/MM/yyyy"/>
                                                        </td>
                                                        <td>
                                                            <input name="areaSugestao" class="input-small input-transparente" type="hidden" value="${sugestao.areaSugestao}" disabled=""/>
                                                            ${sugestao.areaSugestao}
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
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
                                        <div class="table-toolbar">
                                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#addAvaliacao">
                                                Nova Avaliação
                                            </button>
                                        </div>
                                        <c:if test="${mensagem2 != null}">
                                            <div class="alert alert-success fade in">
                                                <button class="close" data-dismiss="alert">
                                                    ×
                                                </button>
                                                <i class="fa-fw fa fa-check"></i>
                                                <c:out value="${mensagem2}" />
                                            </div>
                                        </c:if>
                                        <div class="modal fade" id="addAvaliacao" tabindex="-1" role="dialog" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="widget-body">
                                                        <div id="registration-form">
                                                            <form action="mvc?logica=AlteraProfessorAvaliacao" method="POST">
                                                                <input type="hidden" name="idAvaliacao" value="" />
                                                                <input type="hidden" name="idProfessor" value="${usuario.idProfessor}"/>
                                                                <div class="form-title">
                                                                    Criar uma nova avaliação
                                                                </div>
                                                                <div class="row">
                                                                    <div class="col-sm-12">
                                                                        <div class="form-group">
                                                                            <label for="idAlunoFK">Aluno</label>
                                                                            <span class="input-icon icon-right">
                                                                                <select id="avaliacao" class="form-control" name="idAlunoFK">
                                                                                    <c:forEach var="aluno" items="${alunos}">
                                                                                        <option value="${aluno.idAluno}" name="idAlunoFK">${aluno.matricula} - ${aluno.nome}</option>
                                                                                    </c:forEach>
                                                                                </select>
                                                                            </span>
                                                                            <hr class="wide">
                                                                            <label>Valor</label>
                                                                            <input type="text" name="valor" class="input-small small" value=""/>
                                                                            <label>Data</label>
                                                                            <input name="dataAvaliacao" class="input-small small" type="date" value="" />
                                                                            <label>Validade</label>
                                                                            <input name="dataValidade" class="input-small small" type="date" value="" />
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="row">
                                                                    <div class="col-sm-12">
                                                                        <div class="form-group">
                                                                            <label for="exampleInputEmail2">Resultado</label>
                                                                            <span class="input-icon icon-right">
                                                                                <textarea class="form-control" rows="4" name="resultado"></textarea>
                                                                                <i class="glyphicon glyphicon-briefcase danger"></i>
                                                                            </span>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <button type="submit" class="btn btn-danger">Enviar</button>
                                                                <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
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
                                                        Aluno
                                                    </th>
                                                    <th>
                                                    </th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <c:forEach var="avaliacao" items="${avaliacoes}">
                                                    <tr class="small">
                                                        <input type="hidden" value="${avaliacao.idAvaliacao}" name="idAvaliacao"/>
                                                        <td>
                                                            <input name="resultado" class="input-small input-transparente" type="hidden" value="${avaliacao.resultado}" disabled=""/>
                                                            ${avaliacao.resultado}
                                                        </td>
                                                        <td>
                                                            <input name="valor" class="input-small input-transparente" type="hidden" value="${avaliacao.valor}" disabled=""/>
                                                            ${avaliacao.valor}
                                                        </td>
                                                        <td>
                                                            <input name="validade" class="input-small input-transparente" type="hidden" value="${avaliacao.validade}" disabled=""/>
                                                            <fmt:formatDate value="${avaliacao.validade}" type="DATE" pattern="dd/MM/yyyy"/>
                                                        </td>
                                                        <td>
                                                            <input name="dataAvaliacao" class="input-small input-transparente" type="hidden" value="${avaliacao.dataAvaliacao}" disabled=""/>
                                                            <fmt:formatDate value="${avaliacao.dataAvaliacao}" type="DATE" pattern="dd/MM/yyyy"/>
                                                        </td>
                                                        <td>
                                                            <input name="idAluno" type="hidden" class="input-small input-transparente" value="${avaliacao.aluno.idAluno}" disabled/>
                                                            ${avaliacao.aluno.nome}
                                                        </td>
                                                        <td>
                                                            <a href="mvc?logica=MostraProfessorAvaliacao&id=${avaliacao.idAvaliacao}" class="btn btn-info btn-xs edit">
                                                                <i class="fa fa-edit"></i> 
                                                                Editar
                                                            </a>
                                                            <a href="mvc?logica=RemoveProfessorAvaliacao&id=${avaliacao.idAvaliacao}" class="btn btn-danger btn-xs delete">
                                                                <i class="fa fa-trash-o"></i> 
                                                                Deletar
                                                            </a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                        </div>
                    </div>                        
                    <div class="row">
                            <div class="col-lg-12 col-sm-12 col-xs-12">
                                <h4 class="row-title before-themeprimary"><i class="fa fa-cutlery themeprimary"></i>Exercício</h4>
                                <c:if test="${mensagem != null}">
                                    <div class="alert alert-success fade in">
                                        <button class="close" data-dismiss="alert">
                                            ×
                                        </button>
                                        <i class="fa-fw fa fa-check"></i>
                                        <c:out value="${mensagem}" />
                                    </div>
                                </c:if>
                                <div id="tabbedwizard" class="wizard wizard-tabbed" data-target="#tabbedwizardsteps">
                                    <ul class="steps">
                                        <li data-target="#tabbedwizardstep1" class="active"><span class="step">1</span>Aluno<span class="chevron"></span></li>
                                        <li data-target="#tabbedwizardstep2"><span class="step">2</span>Exercício 1<span class="chevron"></span></li>
                                        <li data-target="#tabbedwizardstep3"><span class="step">3</span>Exercício 2<span class="chevron"></span></li>
                                        <li data-target="#tabbedwizardstep4"><span class="step">4</span>Exercício 3<span class="chevron"></span></li>
                                        <li data-target="#tabbedwizardstep5"><span class="step">5</span>Exercício 4<span class="chevron"></span></li>
                                        <li data-target="#tabbedwizardstep6"><span class="step">OK</span></li>
                                    </ul>

                                </div>
                                <form action="mvc?logica=AlteraProfessorExercicio&idProfessor=${usuario.idProfessor}" method="POST">
                                <div class="step-content" id="tabbedwizardsteps">
                                    <div class="step-pane active" id="tabbedwizardstep1">
                                        <div class="widget">
                                            <div class="widget-body">
                                                Procurar por aluno:
                                                <select id="alunos-multselect" class="form-control" name="idAluno">
                                                    <c:forEach var="aluno" items="${alunos}">
                                                        <option value="${aluno.idAluno}" name="idAluno">${aluno.matricula} - ${aluno.nome}</option>
                                                    </c:forEach>
                                                </select>
                                            </div><!--Widget Body-->
                                        </div>
                                    </div>
                                    <div class="step-pane" id="tabbedwizardstep2">
                                        <div class="widget">
                                            <div class="widget-body">
                                                Exercício
                                                <select id="alimentos-multselect1" class="form-control" multiple="" name="Exercicio1Tipo">
                                                    <c:forEach var="tipo" items="${tipos}">
                                                        <option value="${tipo.idTipo}">${tipo.nome}</option>
                                                    </c:forEach>
                                                </select>

                                                <hr class="wide">   
                                                    <textarea class="form-control" rows="3" name="descricao1" id="form-field-8" placeholder="Inserir Descrição"></textarea>
                                            </div><!--Widget Body-->
                                        </div>
                                    </div>
                                    <div class="step-pane" id="tabbedwizardstep3">
                                        <div class="widget">
                                            <div class="widget-body">
                                                Exercício
                                                <select id="alimentos-multselect2" class="form-control" multiple="" name="Exercicio2Tipo">
                                                    <c:forEach var="tipo" items="${tipos}">
                                                        <option value="${tipo.idTipo}">${tipo.nome}</option>
                                                    </c:forEach>
                                                </select>

                                                <hr class="wide">   
                                                    <textarea class="form-control" rows="3" name="descricao2" id="form-field-8" placeholder="Inserir Descrição"></textarea>
                                            </div><!--Widget Body-->
                                        </div>
                                    </div>
                                    <div class="step-pane" id="tabbedwizardstep4">
                                        <div class="widget">
                                            <div class="widget-body">
                                                Exercício
                                                <select id="alimentos-multselect3" class="form-control" multiple="" name="Exercicio3Tipo">
                                                    <c:forEach var="tipo" items="${tipos}">
                                                        <option value="${tipo.idTipo}">${tipo.nome}</option>
                                                    </c:forEach>
                                                </select>

                                                <hr class="wide">   
                                                    <textarea class="form-control" rows="3" name="descricao3" id="form-field-8" placeholder="Inserir Descrição"></textarea>
                                            </div><!--Widget Body-->
                                        </div>
                                    </div>
                                    <div class="step-pane" id="tabbedwizardstep5">
                                        <div class="widget">
                                            <div class="widget-body">
                                                Exercício
                                                <select id="alimentos-multselect4" class="form-control" multiple="" name="Exercicio4Tipo">
                                                    <c:forEach var="tipo" items="${tipos}">
                                                        <option value="${tipo.idTipo}">${tipo.nome}</option>
                                                    </c:forEach>
                                                </select>

                                                <hr class="wide">   
                                                    <textarea class="form-control" rows="3" name="descricao4" id="form-field-8" placeholder="Inserir Descrição"></textarea>
                                            </div><!--Widget Body-->
                                        </div>
                                    </div>
                                    <div class="step-pane" id="tabbedwizardstep6">
                                        <h1 class="text-center success">Exercícios prontos, para confirmá-los clique em <bold class="danger"><button type="submit" class="btn btn-success">Enviar</button></bold>.</h1>
                                    </div>
                                </div>
                                </form>
                                <div class="actions actions-footer" id="tabbedwizard-actions">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default btn-sm btn-prev"> <i class="fa fa-angle-left"></i>Anterior</button>
                                        <button type="button" class="btn btn-default btn-sm btn-next" data-last="Clique acima">Próximo<i class="fa fa-angle-right"></i></button>
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
        
        <script src="painel/js/fuelux/wizard/wizard-custom.js"></script>

        <script type="text/javascript">
            jQuery(function ($) {
                $('#simplewizardinwidget').wizard();
                $('#simplewizard').wizard();
                $('#tabbedwizard').wizard().on('finished', function (e) {
                    Notify('Thank You! All of your information saved successfully.', 'bottom-right', '5000', 'blue', 'fa-check', true);
                });
                $('#WiredWizard').wizard();
            });
        </script>
        
        <script type="text/javascript" src="painel/js/bootstrap-multiselect.js"></script>
        
        <script type="text/javascript" src="painel/js/multiselect-init.js"></script>
        
        <!-- Tabelas -->
        <script src="painel/js/datatable/jquery.dataTables.min.js"></script>
        <script src="painel/js/datatable/ZeroClipboard.js"></script>
        <script src="painel/js/datatable/dataTables.tableTools.min.js"></script>
        <script src="painel/js/datatable/dataTables.bootstrap.min.js"></script>
        <script src="painel/js/datatable/datatables-init.js"></script>
        <script>
            InitiateEditableDataTable.init();
        </script>

        
    </body>
    <!--  /Body -->
</html>
