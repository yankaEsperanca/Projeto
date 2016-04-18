<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<title> Curso Informática </title>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
</head>
<body>

 <!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp"/>
<!--  menu -->

	<!-- Barra superior com os menus de navegação -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="listar_curso_informatica.html">Curso Informática</a>
				<!-- nome que estará no menu, e o href chama outra paginca -->
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="listar_aluno.html">Aluno</a></li>
					<!-- Quando clicar ele direciona para a outra pagina criada em HTML -->
					<li><a href="listar_curso_artes.html">Curso Artes</a></li>
					<!-- montamos os nomes que terão no nosso menu bar -->
					<li><a href="listar_curso_informatica.html">Curso Informática</a></li>
					<li><a href="#">Matrícula</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<br>
	<br>
	<br>
	

<!-- container principal -->
	<div id="main" class="container">
		<h2>Cadastro curso de informática</h2>
		
		<form action="ManterCursoInformaticaController.do" method = "post">     <!--coloca o .do para indicar que faz algo  --> 

	  <div class="row">
    
		<div class="form-group col-md-6">
			<label for="nome" >Nome: </label><br>
			<input type="text" class="form-control" name="nome" size="40" maxlength="30" placeholder="nome">
		</div>
	
		<div class="form-group col-md-6">
			<label for="dataIni" >Data início: </label><br> 
			<input type="text" class="form-control" name="dataIni" size="40" maxlength="20" placeholder="data início">
		</div>
	
		<div class="form-group col-md-6">
			<label for="dataTerm" >Data término: </label><br>
			<input type="text" class="form-control" name="dataTerm" size="40" maxlength="20" placeholder="data de término">
		</div>
		
		<div class="form-group col-md-6">
			<label for="horario" >Horário: </label><br> 
			<input type="text" class="form-control" name="horario" size="40" maxlength="10" placeholder="horário">
		</div>
			
		<div class="form-group col-md-6">
			<label for="numVagas" >Número de vagas: </label><br>
		 	<input type="text" class="form-control" name="numVagas" size="40" maxlength="10" placeholder="número de vagas">
		</div>
			
			
		<div class="form-group col-md-6">
			<label for="valor" >Valor: </label><br>
			<input type="text" class="form-control" name="valor" size="40" maxlength="10" placeholder="preço">
		</div>
	
		<div class="form-group col-md-6">
			<label for="numLab" >Número laboratório: </label><br>
			<input type="text" class="form-control" name="numLab" size="40" maxlength="45" placeholder="Número laboratório">
		</div>
	
		<div class="form-group col-md-6">
			<label for="registroSoft" >Registro software: </label><br>
			<input type="text" class="form-control"  name="registroSoft" size="40" maxlength="45" placeholder="Registro software">
		</div>

		<div class="form-group col-md-6">
			<label for="disp" >Disponibilidade: </label><br> 
			<input type="text" class="form-control" name="disp" size="40" maxlength="20" placeholder="disponibilidade">
		</div>
			</div>	
			 <div class="row">
			<div class="form-group col-md-6">
			<button type="submit"  name="acao" value="Criar" class="btn btn-primary">Cadastrar
    			<span class="glyphicon glyphicon-floppy-save" aria-hidden="true"></span> 
    		</button>
    		
    		<a href="listar_curso_informatica.html" class="btn btn-default btn-default  active  "> Cancelar 
    		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 	
 			</a>
			 </div>
	 	</div>
    
</form>   

    
</div>     
</body>
</html>
