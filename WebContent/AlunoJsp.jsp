<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="to.AlunoTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro do aluno </title>
</head>
<body>

<%AlunoTO to =(AlunoTO) request.getAttribute("manterAluno"); %>
		Nome: <input value= <%= to.getNome()  %> > <br>
		Endereco: <%= to.getEndereco() %><br>
		Telefone: <%= to.getTelefone() %><br>
		CPF: <%= to.getCpf() %><br>
		RG: <%= to.getRg() %><br>
		E-mail: <%= to.getEmail() %><br>
		Usuário: <%= to.getLogin() %><br>
		Senha Aluno: <%= to.getSenha()%><br>

</body>
</html>