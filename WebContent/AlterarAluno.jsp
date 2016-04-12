<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="to.AlunoTO"%>
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
	<%AlunoTO to=(AlunoTO)request.getAttribute("alunoTO"); %>
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
				<a class="navbar-brand" href="listar_aluno.html">Alunos</a>
				<!-- nome que estará no menu, e o href chama outra paginca -->
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="listar_aluno.html">Aluno</a></li>
					<!-- Quando clicar ele direciona para a outra pagina criada em HTML -->
					<li><a href="listar_curso_artes.html">Curso Artes</a></li>
					<!-- montamos os nomes que terão no nosso menu bar -->
					<li><a href="listar_curso_informatica.html">Curso Informática</a></li>
					<li><a href="#">Países</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<br>
	<br>
	<br>


	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">
			Alterar Aluno CPF:<%=to.getCpf() %></h3>
		<!-- Formulario para alteração de aluno -->
		
		<form action="ManterAlunoController.do" method="post">
			<!-- area de campos do form -->

			<input type="hidden" name="cpf" value="<%=to.getCpf() %>" />


			<div class="form-group col-md-6">
				<label for="Nome">Nome: </label><br> <input type="text"
					class="form-control" name="nome" size="40" maxlength="50"
					placeholder="nome" value="<%=to.getNome()%>">
			</div>

			<div class="form-group col-md-6">
				<label for="email"> E-mail: </label> <br> <input type="text"
					class="form-control" name="email" size="40" maxlength="50"
					placeholder="e-mail" value="<%=to.getEmail()%>">
			</div>

			<div class="form-group col-md-6">
				<label for="cpf"> CPF: </label> <br> <input type="text"
					class="form-control" name="cpf" size="40" maxlength="20"
					placeholder="CPF" value="<%=to.getCpf()%>" required>
			</div>

			<div class="form-group col-md-6">
				<label for="rg"> RG: </label> <br> <input type="text"
					class="form-control" name="rg" size="40" maxlength="20"
					placeholder="RG"  value="<%=to.getRg()%>">
			</div>

			<div class="form-group col-md-6">
				<label for="endereco"> Endereço: </label><br> <input
					type="text" class="form-control" name="endereco" size="40"
					maxlength="50" placeholder="endereço" value="<%=to.getEndereco()%>">
			</div>


			<div class="form-group col-md-6">
				<label for="telefone"> Telefone: </label> <br> <input
					type="text" class="form-control" name="telefone" size="40"
					maxlength="20" placeholder="telefone" value="<%=to.getTelefone()%>">
			</div>

			<div class="form-group col-md-6">
				<label for="usuario"> Usuário: </label> <br> <input type="text"
					class="form-control" name="usuario" size="40" maxlength="20"
					placeholder="usuário" value="<%=to.getLogin()%>">
			</div>

			<div class="form-group col-md-6">
				<label for="senha"> Senha: </label> <br> <input type="password"
					class="form-control" name="senha" size="40" maxlength="20"
					placeholder="senha" value="<%=to.getSenha()%>">
			</div>
	
	<hr />
	<div id="actions" class="row">
		<div class="col-md-12">
			<button type="submit" class="btn btn-primary" name="acao"
				value="Alterar">Salvar</button>
			<a href="listar_aluno.html" class="btn btn-default">Cancelar</a>
		</div>
	</div>
	
	</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>