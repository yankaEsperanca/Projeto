<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Buscar Artes</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">

        </head>

        <body>
            <!-- Modal -->
            <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title" id="modalLabel">Excluir Artes</h4>
                        </div>
                        <div class="modal-body">
                            Deseja realmente excluir este curso?
                        </div>
                        <div class="modal-footer">
                            <form action="ManterCursoArtesController.do" method="post">
                                <input type="hidden" name="id" id="id_excluir" />
                                <button type="submit" class="btn btn-primary" name="acao" value="Excluir">Sim</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
          
          
	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />
	
            <!-- Container Principal -->
            <div id="main" class="container-fluid">
                <form action="listar_curso_artesController.do" method="post">
                    <div id="top" class="row">
                        <div class="col-md-3">
                            <h2>Curso Artes</h2>
                        </div>

                        <div class="col-md-6">
                            <div class="input-group h2">
                                <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Curso artes (deixe vazio para trazer todos)">
                                <span class="input-group-btn">
                <button class="btn btn-primary" type="submit">
                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                                </span>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <a href="CadastrarArtes.jsp" class="btn btn-primary pull-right h2">Novo Curso</a>
                        </div>
                    </div>
                    <!-- /#top -->
                </form>
                <hr />
                	<c:if test="${not empty lista}">
                <div id="list" class="row">

                    <div class="table-responsive col-md-12">
                        <table class="table table-striped" cellspacing="0" cellpadding="0">
                            <thead>
                                <tr>
                               
							<th>Código:</th>
							<th>Nome:</th>
							<th>Data início:</th>
							<th>Data término:</th>
							<th>Horário:</th>
							<th>Numero de vagas:</th>
							<th>Valor:</th>
							<th>Descrição do material:</th>
							<th>Nome dos livros utilizados: </th>
							<th>Disponibilidade:</th>
							
							<th class="actions">Ações</th>


                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="artesTO" items="${lista}">
						<tr>
							<td>${artesTO.codigo}</td>
							<td>${artesTO.nome}</td>
							<td>${artesTO.dataInicio}</td>
							<td>${artesTO.dataTermino}</td>
							<td>${artesTO.horario}</td>
							<td>${artesTO.numeroVagas}</td>
							<td>${artesTO.valor}</td>
							<td>${artesTO.descricaoMaterial}</td>
							<td>${artesTO.nomeLivrosUtilizados}</td>
							<td>${artesTO.disponibilidade}</td>

                                       <td class="actions"><a class="btn btn-success btn-xs"
								href="ManterCursoArtesController.do?acao=Consultar&codigo=${artesTO.codigo}">Visualizar</a>
								<a class="btn btn-warning btn-xs"
								href="ManterCursoArtesController.do?acao=Editar&codigo=${artesTO.codigo}">Editar</a>
								
								<button id="btn${artesTO.codigo}" type="button"
									class="btn btn-danger btn-xs" data-toggle="modal"
									data-target="#delete-modal" data-cliente="${artesTO.codigo}">Excluir</button>
							</td>
						</tr>
					</c:forEach>

                            </tbody>
                        </table>

                    </div>
                </div>
                <!-- /#list -->

                <div id="bottom" class="row">
                    <div class="col-md-12">
                        <!-- paginação ainda não foi implementada -->
                        <ul class="pagination">
                            <li class="disabled"><a>&lt; Anterior</a>
                            </li>
                            <li class="disabled"><a>1</a>
                            </li>
                            <li><a href="#">2</a>
                            </li>
                            <li><a href="#">3</a>
                            </li>
                            <li class="next"><a href="#" rel="next">Próximo &gt;</a>
                            </li>
                        </ul>
                        <!-- /.pagination -->

                    </div>
                </div>
                </c:if>
                <!-- /#bottom -->
            </div>
            <!-- /#main -->
            <script src="js/jquery.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script type="text/javascript">
                $("#delete-modal").on('show.bs.modal', function(event) {
                    var button = $(event.relatedTarget); //botao que disparou a modal
                    var recipient = button.data('cliente');
                    $("#id_excluir").val(recipient);
                });
            </script>
        </body>

        </html>


