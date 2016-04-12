<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="to.AlunoTO" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Visualizar Aluno</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">
        </head>

        <body>
            <%AlunoTO to=(AlunoTO)request.getAttribute("alunoTO"); %>
                <!-- Modal -->
                <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                                </button>
                                <h4 class="modal-title" id="modalLabel">Excluir Aluno</h4>
                            </div>
                            <div class="modal-body">
                                Deseja realmente excluir este aluno?
                            </div>
                            <div class="modal-footer">
                                <form action="ManterAlunoController.do" method="post">
                                    <input type="hidden" name="cpf" value="<%=to.getCpf()%>" />
                                    <button type="submit" class="btn btn-primary" name="acao" value="Excluir">Sim</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.modal -->
                
              
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
                    <h3 class="page-header">Visualizar Aluno, CPF: <%=to.getCpf() %></h3>
                    <div class="row">
                        <div class="col-md-12">
                            <p><strong>Nome:</strong>
                             <%=to.getNome()%>
                            </p>
                        </div>
                        
                          <div class="col-md-12">
                            <p><strong>Endereço:</strong>
                             <%=to.getEndereco()%>
                            </p>
                        </div>
                        
                          <div class="col-md-12">
                            <p><strong>Telefone:</strong>
                             <%=to.getTelefone()%>
                            </p>
                        </div>
                        
                          <div class="col-md-12">
                            <p><strong>CPF:</strong>
                             <%=to.getCpf()%>
                            </p>
                        </div>
                        
                          <div class="col-md-12">
                            <p><strong>RG:</strong>
                             <%=to.getRg()%>
                            </p>
                        </div>
                        
                          <div class="col-md-12">
                            <p><strong>E-mail:</strong>
                             <%=to.getEmail()%>
                            </p>
                        </div>
                        
                        
                          <div class="col-md-12">
                            <p><strong>Usuário:</strong>
                           <%=to.getLogin()%>
                            </p>
                        </div>
                        
                          <div class="col-md-12">
                            <p><strong>Senha:</strong>
                             <%=to.getSenha()%>
                            </p>
                        </div>         
                          </div>
                    <hr />
                    
                    <div id="actions" class="row">
                        <div class="col-md-12">
                            <a href="ManterAlunoController.do?acao=Editar&cpf=<%=to.getCpf()%>" class="btn btn-primary">Editar</a>
                            <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#delete-modal">Excluir</a>
                            <a href="listar_aluno.html" class="btn btn-default">Voltar</a>
                        </div>
                    </div>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html>