<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alterar Curso Informática</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>

	<c:import url="Menu.jsp"/>

	<!-- Container Principal -->
	<div id="main" class="container">
	
		<h3 class="page-header"> Alterar Curso código: ${infoTO.codigo}</h3>
		<!-- Formulario para alteração de aluno -->
		
		<form action="controller.do" method="post">
			<!-- area de campos do form -->

			<input type="hidden" name="codigo" value="${infoTO.codigo}" />

		<div class="form-group col-md-6">
			<label for="nome" >Nome: </label><br>
			<input type="text" class="form-control" name="nome" size="40" maxlength="30" placeholder="nome" value="${infoTO.nome}">
		</div>
	
		<div class="form-group col-md-6">
			<label for="dataIni" >Data início: </label><br> 
			<input type="text" class="form-control" name="dataIni" size="40" maxlength="20" placeholder="data início" value="${infoTO.dataInicio}">
		</div>
	
		<div class="form-group col-md-6">
			<label for="dataTerm" >Data término: </label><br>
			<input type="text" class="form-control" name="dataTerm" size="40" maxlength="20" placeholder="data de término" value="${infoTO.dataTermino}">
		</div>
		
		<div class="form-group col-md-6">
			<label for="horario" >Horário: </label><br> 
			<input type="text" class="form-control" name="horario" size="40" maxlength="10" placeholder="horário" value="${infoTO.horario}">
		</div>
			
		<div class="form-group col-md-6">
			<label for="numVagas" >Número de vagas: </label><br>
		 	<input type="text" class="form-control" name="numVagas" size="40" maxlength="10" placeholder="número de vagas" value="${infoTO.numeroVagas}">
		</div>
			
			
		<div class="form-group col-md-6">
			<label for="valor" >Valor: </label><br>
			<input type="text" class="form-control" name="valor" size="40" maxlength="10" placeholder="preço" value="${infoTO.valor}">
		</div>
	
		<div class="form-group col-md-6">
			<label for="numLab" >Número laboratório: </label><br>
			<input type="text" class="form-control" name="numLab" size="40" maxlength="45" placeholder="Número laboratório"value="${infoTO.numeroLab}">
		</div>
	
		<div class="form-group col-md-6">
			<label for="registroSoft" >Registro software: </label><br>
			<input type="text" class="form-control"  name="registroSoft" size="40" maxlength="45" placeholder="Registro software" value="${infoTO.registroSoft}">
		</div>

		<div class="form-group col-md-6">
			<label for="disp" >Disponibilidade: </label><br> 
			<input type="text" class="form-control" name="disp" size="40" maxlength="20" placeholder="disponibilidade" value="${infoTO.disponibilidade}">
		</div>

	<hr />
	<div id="actions" class="row">
		<div class="col-md-12">
			<button type="submit" class="btn btn-primary" name="command" value="AlterarCursoInformatica">Salvar</button>
			<a href="ListarInformatica.jsp" class="btn btn-default">Cancelar</a>
		</div>
	</div>
	
	</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>