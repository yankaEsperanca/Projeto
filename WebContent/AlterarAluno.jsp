<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alterar Aluno</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp"/>
	
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">
			Alterar Aluno CPF: ${alunoTO.cpf}</h3>
		<!-- Formulario para alteração de aluno -->
		
		<form action="ManterAlunoController.do" method="post">
			<!-- area de campos do form -->

			<input type="hidden" name="cpf" value="${alunoTO.cpf}" />


			<div class="form-group col-md-6">
				<label for="Nome">Nome: </label><br> <input type="text"
					class="form-control" name="nome" size="40" maxlength="50"
					placeholder="nome" value="${alunoTO.nome}">
			</div>

			<div class="form-group col-md-6">
				<label for="email"> E-mail: </label> <br> <input type="text"
					class="form-control" name="email" size="40" maxlength="50"
					placeholder="e-mail" value="${alunoTO.email}">
			</div>

			<div class="form-group col-md-6">
				<label for="cpf"> CPF: </label> <br> <input type="text"
					class="form-control" name="cpf" size="40" maxlength="20"
					placeholder="CPF" value="${alunoTO.cpf}" required>
			</div>

			<div class="form-group col-md-6">
				<label for="rg"> RG: </label> <br> <input type="text"
					class="form-control" name="rg" size="40" maxlength="20"
					placeholder="RG"  value="${alunoTO.rg}">
			</div>

			<div class="form-group col-md-6">
				<label for="endereco"> Endereço: </label><br> <input
					type="text" class="form-control" name="endereco" size="40"
					maxlength="50" placeholder="endereço" value="${alunoTO.endereco}">
			</div>


			<div class="form-group col-md-6">
				<label for="telefone"> Telefone: </label> <br> <input
					type="text" class="form-control" name="telefone" size="40"
					maxlength="20" placeholder="telefone" value="${alunoTO.telefone}">
			</div>

			<div class="form-group col-md-6">
				<label for="usuario"> Usuário: </label> <br> <input type="text"
					class="form-control" name="usuario" size="40" maxlength="20"
					placeholder="usuário" value="${alunoTO.login}">
			</div>

			<div class="form-group col-md-6">
				<label for="senha"> Senha: </label> <br> <input type="password"
					class="form-control" name="senha" size="40" maxlength="20"
					placeholder="senha" value="${alunoTO.senha}">
			</div>
	
	<hr />
	<div id="actions" class="row">
		<div class="col-md-12">
			<button type="submit" class="btn btn-primary" name="acao"
				value="Alterar">Salvar</button>
			<a href="ListarAluno.jsp" class="btn btn-default">Cancelar</a>
		</div>
	</div>
	
	</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>