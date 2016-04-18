<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<title> Alunos </title>

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
	
<!-- container principal -->
	<div id="main" class="container">
		<h2>Cadastro de alunos</h2>
		
		<form action="ManterAlunoController.do" method = "post">     <!--coloca o .do para indicar que faz algo  --> 

	  <div class="row">
    
			<div class="form-group col-md-6">
				<label for="Nome" >Nome: </label><br>
				<input type="text" class="form-control" name="nome" size="40" maxlength="50" placeholder="nome">
			</div>
			
			<div class="form-group col-md-6">
				<label for="email"> E-mail:  </label>  <br>
				<input type="text" class="form-control" name="email" size="40" maxlength="50" placeholder="e-mail">
			</div>
	
				<div class="form-group col-md-6">
				<label for="cpf"> CPF: </label>  <br>
				 <input type="text" class="form-control" name="cpf" size="40" maxlength="20" placeholder="CPF" required>
			</div>
	
			<div class="form-group col-md-6">
				<label for="rg"> RG:  </label> <br>
				 <input type="text" class="form-control" name="rg" size="40" maxlength="20" placeholder="RG">
			</div>
			
			<div class="form-group col-md-6">
				<label for="endereco"> EndereÃ§o: </label><br>
				 <input type="text" class="form-control" name="endereco" size="40" maxlength="50" placeholder="endereÃ§o">
			</div>
			
			
			<div class="form-group col-md-6">
				<label for="telefone"> Telefone: </label> <br>
				 <input type="text" class="form-control" name="telefone" size="40" maxlength="20" placeholder="telefone">
			</div>
	
			<div class="form-group col-md-6">
				<label for="usuario"> UsuÃ¡rio: </label> <br> 
				<input type="text" class="form-control" name="usuario" size="40" maxlength="20" placeholder="usuÃ¡rio">
			</div>
	
			<div class="form-group col-md-6">
				<label for="senha"> Senha: </label> <br> 
				<input type="password"  class="form-control" name="senha" size="40" maxlength="20" placeholder="senha">
			</div>
			
			
			<div class="form-group col-md-6">
			<button type="submit"  name="acao" value="Criar" class="btn btn-primary">Cadastrar
    			<span class="glyphicon glyphicon-floppy-save" aria-hidden="true"></span> 
    		</button>
    		
    		<a href="listar_aluno.html" class="btn btn-default btn-default  active  "> Cancelar 
    		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 	
 			</a>
 			 </div>
 			
    </div>
</form>   

    
</div>     
</body>
</html>