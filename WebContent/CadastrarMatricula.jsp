<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<title>Matrícula</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>

	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />

	<!-- container principal -->
	<div id="main" class="container">
		<h2>Cadastro de matrículas</h2>

		<form action="controller.do" method="post">
			<!--coloca o .do para indicar que faz algo  -->

			<div class="row">

				<div class="form-group col-md-12">

					<div class="dropdown">
						<button class="btn btn-default dropdown-toggle" type="button"
							id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="true">
							Aluno <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul>
					</div>
				</div>

				<div class="form-group col-md-12">

					<div class="dropdown">
						<button class="btn btn-default dropdown-toggle" type="button"
							id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="true">
							Curso <span class="caret" ></span>
						</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul>
					</div>

				</div>

				<div class="form-group col-md-6">
					<label for="valor"> Valor: </label> <br> <input type="text"
						class="form-control" name="valor" size="40" maxlength="20"
						placeholder="Valor da matrícula" required>
				</div>

				<div class="form-group col-md-6">
					<label for="data"> Data: </label> <br> <input type="text"
						class="form-control" name="data" size="40" maxlength="20"
						placeholder="Data">
				</div>

				<div class="form-group col-md-6">
					<label for="statusPagamento"> Status Pagamento: </label><br> <input
						type="text" class="form-control" name="statusPagamento" size="40"
						maxlength="50" placeholder="Status do pagamento">
				</div>


				<div class="form-group col-md-6">
					<label for="statusMatricula"> Status Matrícula: </label> <br>
					<input type="text" class="form-control" name="statusMatricula"
						size="40" maxlength="20" placeholder="Status da matrícula">
				</div>


				<div class="form-group col-md-6">
					<button type="submit" name="command" value="CadastrarMatricula"
						class="btn btn-primary">
						Cadastrar <span class="glyphicon glyphicon-floppy-save"
							aria-hidden="true"></span>
					</button>

					<a href="ListarAlunos.jsp"
						class="btn btn-default btn-default  active"> Cancelar <span
						class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					</a>
				</div>

			</div>
		</form>


	</div>
</body>
</html>