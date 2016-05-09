package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ManterCursoInformatica;
import to.InformaticaTO;

public class ExcluirCursoInformatica implements Command {
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
		HttpSession session = request.getSession(); // aqui estamos inicializando uma seção, com nome de session
		
		manterInformatica.deletar();
		@SuppressWarnings("unchecked")
		ArrayList<InformaticaTO> lista = (ArrayList<InformaticaTO>)session.getAttribute("lista");
		lista.remove(busca(manterInformatica, lista));
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarInformatica.jsp");
		view.forward(request, response);
	}
	
	public int busca(ManterCursoInformatica manterInfo, ArrayList<InformaticaTO> lista) {
		InformaticaTO to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getCodigo() == manterInfo.getCodigo()){
				return i;
			}
		}
		return -1;
	}
}
		
		
		