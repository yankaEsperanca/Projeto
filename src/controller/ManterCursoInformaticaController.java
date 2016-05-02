package controller;


import java.io.IOException;
//import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ManterCursoInformatica;
import to.InformaticaTO;

/**
 * Servlet implementation class ManterCursoInformatica
 */
@WebServlet("/ManterCursoInformaticaController.do")
public class ManterCursoInformaticaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pAcao = request.getParameter("acao");
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
		
		if (pAcao.equals("Criar")) {
			manterInformatica.cadastrar();
			ArrayList<InformaticaTO> lista = new ArrayList<>();
			lista.add(manterInformatica.getTO());
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarInformatica.jsp");		
		} else if (pAcao.equals("Excluir")) {
		
			manterInformatica.deletar();
			ArrayList<InformaticaTO> lista = (ArrayList<InformaticaTO>)session.getAttribute("lista");
			lista.remove(busca(manterInformatica, lista));
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarInformatica.jsp");
		} else if (pAcao.equals("Alterar")) {
			manterInformatica.alterar();
		    ArrayList<InformaticaTO> lista = (ArrayList<InformaticaTO>)session.getAttribute("lista");
		    int pos = busca(manterInformatica, lista);
			lista.remove(pos);
			lista.add(pos, manterInformatica.getTO());
			session.setAttribute("lista", lista);
			request.setAttribute("infoTO", manterInformatica.getTO());		
			view = request.getRequestDispatcher("VisualizarInformatica.jsp");
			
		} else if (pAcao.equals("Consultar")) {
			manterInformatica.carregar();
			request.setAttribute("infoTO", manterInformatica.getTO());
			view = request.getRequestDispatcher("VisualizarInformatica.jsp");		
		} else if (pAcao.equals("Editar")) {
			manterInformatica.carregar();
			request.setAttribute("infoTO", manterInformatica.getTO());
			view = request.getRequestDispatcher("AlterarCursoInformatica.jsp");		
		}

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
		
		
		
		
		