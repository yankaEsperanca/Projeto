<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="to.ArtesTO" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Curso artes</title>
</head>
<body>



<%ArtesTO to =(ArtesTO) request.getAttribute("manterArtes"); %>
	
	
	<%= "Dados" %> <br> 
    C�digo: <input value= <%= to.getCodigo()  %>  ><br>
	Nome: <input value= <%= to.getNome()  %>  ><br>
	Data in�cio: <input  value= <%= to.getDataInicio()  %>  ><br>
	Data t�rmino: <input value= <%= to.getDataTermino() %> ><br>
	Hor�rio: <input value= <%= to.getHorario()  %> ><br>
	N�mero de vagas: <input value= <%= to.getNumeroVagas() %> ><br>
	Valor: <input value= <%= to.getValor()  %> ><br>
	Descri��o material: <input value= <%= to.getDescricaoMaterial()  %> ><br>
	Nomes dos livros utilizados: <input value= <%= to.getNomeLivrosUtilizados()  %>  ><br>
	Disponibilidade: <input value= <%= to.getDisponibilidade()  %> ><br>
	

</body>
</html>