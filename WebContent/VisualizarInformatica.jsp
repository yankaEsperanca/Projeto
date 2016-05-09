<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

       <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Visualizar Curso Informática</title>

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
                                <h4 class="modal-title" id="modalLabel">Excluir Curso</h4>
                            </div>
                            <div class="modal-body">
                                Deseja realmente excluir?
                            </div>
                            <div class="modal-footer">
                                <form action="controller.do" method="post">
                                    <input type="hidden" name="id" value="${infoTO.codigo}" />
                                    <button type="submit" class="btn btn-primary" name="command" value="ExcluirCursoInformatica">Sim</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Barra superior com os menus de navegação -->
				<c:import url="Menu.jsp"/>               
                
                <!-- Container Principal -->
                <div id="main" class="container">
                    <h3 class="page-header">Visualizar Curso, Código: ${infoTO.codigo}</h3>
                    <div class="row">
                        
                          <div class="col-md-12">
                            <p><strong>Código:</strong>
                             ${infoTO.codigo}
                            </p>
                        </div>
                        
                            <div class="col-md-12">
                            <p><strong>Nome:</strong>
                             ${infoTO.nome}
                            </p>
                        </div>
                        
                        <div class="col-md-12">
                            <p><strong>Data início:</strong>
                             ${infoTO.dataInicio}
                            </p>
                        </div>
                        
                          <div class="col-md-12">
                            <p><strong>Data término:</strong>
                             ${infoTO.dataTermino}
                            </p>
                        </div>
                        
                          <div class="col-md-12">
                            <p><strong>Horário:</strong>
                             ${infoTO.horario}
                            </p>
                        </div>
                       
                          <div class="col-md-12">
                            <p><strong>Número de vagas:</strong>
            				${infoTO.numeroVagas}
                            </p>
                        </div>
                        
                          <div class="col-md-12">
                            <p><strong>Valor:</strong>
                             ${infoTO.valor}
                            </p>
                        </div>
                        
                          <div class="col-md-12">
                            <p><strong>Número labratório:</strong>
                             ${infoTO.numeroLab}
                            </p>
                        </div>
                        
                        
                          <div class="col-md-12">
                            <p><strong>Registro de software:</strong>
                           ${infoTO.registroSoft}
                            </p>
                        </div>
                        
                          <div class="col-md-12">
                            <p><strong>Disponibilidade:</strong>
                             ${infoTO.disponibilidade}
                           
                            </p>
                        </div>         
                          </div>
                    <hr />
                    
                    <div id="actions" class="row">
                        <div class="col-md-12">
                            <a href="controller.do?command=EditarCursoInformatica&codigo=${infoTO.codigo}" class="btn btn-primary">Editar</a>
                            <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#delete-modal">Excluir</a>
                            <a href="ListarInformatica.jsp" class="btn btn-default">Voltar</a>
                        </div>
                    </div>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html>