package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ManterCursoInformatica;
import to.InformaticaTO;

public class EditarCursoInformatica implements Command{
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		InformaticaTO infoTO = new InformaticaTO();

		String pCodigo = request.getParameter("codigo");
		infoTO.setNome(request.getParameter("nome"));
		infoTO.setDataInicio(request.getParameter("dataIni")); // nome do parametro do formulário 
		infoTO.setDataTermino(request.getParameter("dataTerm"));
		infoTO.setHorario(request.getParameter("horario")); // nome do parametro do formulário 
		infoTO.setNumeroVagas(request.getParameter("numVagas"));
		infoTO.setValor(request.getParameter("valor")); // nome do parametro do formulário 
		infoTO.setNumeroLab(request.getParameter("numLab"));
		infoTO.setRegistroSoft(request.getParameter("registroSoft"));
		infoTO.setDisponibilidade(request.getParameter("disp"));
		int codigo = -1;
		try {
			codigo = Integer.parseInt(pCodigo);
			infoTO.setCodigo(codigo);
		} catch (NumberFormatException e) {
		}

		ManterCursoInformatica manterInformatica = new ManterCursoInformatica(infoTO);
		RequestDispatcher view = null;
		manterInformatica.carregar();
		request.setAttribute("infoTO", manterInformatica.getTO());
		view = request.getRequestDispatcher("AlterarCursoInformatica.jsp");		
		view.forward(request, response);
	}

}
