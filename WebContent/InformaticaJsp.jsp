<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="to.InformaticaTO" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Curso Inform�tica</title>
</head>
<body>

<%InformaticaTO to = (InformaticaTO) request.getAttribute("manterInfo"); %>
			
	<%= "Dados:" %> <br> 
    C�digo: <input value= <%= to.getCodigo()  %>  ><br>
	Nome: <input value= <%= to.getNome()  %>  ><br>
	Data in�cio: <input  value= <%= to.getDataInicio()  %>  ><br>
	Data t�rmino: <input value= <%= to.getDataTermino() %> ><br>
	Hor�rio: <input value= <%= to.getHorario()  %> ><br>
	N�mero de vagas: <input value= <%= to.getNumeroVagas() %> ><br>
	Valor: <input value= <%= to.getValor()  %> ><br>
	N�mero laborat�rio: <input value= <%= to.getNumeroLab()  %> ><br>
	Registro do software: <input value= <%= to.getRegistroSoft()  %>  ><br>
	Disponibilidade: <input value= <%= to.getDisponibilidade()  %> ><br>


</body>
</html>
