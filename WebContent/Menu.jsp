<!-- Barra superior com os menus de navega��o -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp">P�gina principal</a>
				<!-- nome que estar� no menu, e o href chama outra paginca -->
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="listar_alunosController.do?acao=reiniciar">Aluno</a></li>
					<!-- Quando clicar ele direciona para a outra pagina criada em HTML -->
					<li><a href="listar_curso_artesController.do?acao=reiniciar">Curso Artes</a></li>
					<!-- montamos os nomes que ter�o no nosso menu bar -->
					<li><a href="listar_curso_informaticaController.do?acao=reiniciar">Curso Inform�tica</a></li>
					<li><a href="#">Pa�ses</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<br>
	<br>