<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- Barra superior com os menus de navegação -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp">Página principal</a>
				<!-- nome que estará no menu, e o href chama outra paginca -->
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="controller.do?command=ListarAlunosReiniciar">Aluno</a></li>
					<!-- Quando clicar ele direciona para a outra pagina criada em HTML -->
					<li><a href="controller.do?command=ListarCursoInformaticaReiniciar">Curso Informática </a></li>
					<!-- montamos os nomes que terão no nosso menu bar -->
					<li><a href="controller.do?command=ListarCursoArtesReiniciar">Curso Artes </a></li>
					<li><a href="controller.do?command=ListarMatriculaReiniciar">Matrícula</a></li>
					<li><a href="#">Cursos escolhidos de artes</a></li>
				
				</ul>
			</div>
		</div>
	</nav>
	<br>
	<br>