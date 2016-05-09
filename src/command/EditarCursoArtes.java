package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ManterCursoArtes;
import to.ArtesTO;

public class EditarCursoArtes implements Command{
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ArtesTO artesTO = new ArtesTO();

		String pCodigo = request.getParameter("codigo");
		artesTO.setNome(request.getParameter("nome"));
		artesTO.setDataInicio(request.getParameter("dataIni")); // nome do parametro do formulário 
		artesTO.setDataTermino(request.getParameter("dataTerm"));
		artesTO.setHorario(request.getParameter("horario")); // nome do parametro do formulário 
		artesTO.setNumeroVagas(request.getParameter("numVagas"));
		artesTO.setValor(request.getParameter("valor")); // nome do parametro do formulário 
		artesTO.setDescricaoMaterial(request.getParameter("descricaoMat"));
		artesTO.setNomeLivrosUtilizados(request.getParameter("nomeLivros"));
		artesTO.setDisponibilidade(request.getParameter("disp"));

		int codigo = -1;
		try {
			codigo = Integer.parseInt(pCodigo);
			artesTO.setCodigo(codigo);
		} catch (NumberFormatException e) {

		}

		ManterCursoArtes manterArtes = new ManterCursoArtes(artesTO);		
		RequestDispatcher view = null;
		manterArtes.carregar();
		request.setAttribute("artesTO", manterArtes.getTO());
		view = request.getRequestDispatcher("AlterarCursoArtes.jsp");		
		view.forward(request, response);


	}
}