package controller;


import model.ManterCursoArtes;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import to.*;


/**
 * Servlet implementation class ManterCursoArtes
 */
@WebServlet("/ManterCursoArtesController.do")
public class ManterCursoArtesController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Para poder exibir os textos.
	//	PrintWriter out = response.getWriter();
		
		String pAcao = request.getParameter("acao");
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
		HttpSession session = request.getSession();
		
		if (pAcao.equals("Criar")) {		
			manterArtes.cadastrar();
			ArrayList<ArtesTO> lista = new ArrayList<>();
			lista.add(manterArtes.getTO());
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarArtes.jsp");
		} else if (pAcao.equals("Excluir")) {
			manterArtes.deletar();
			ArrayList<ArtesTO> lista = (ArrayList<ArtesTO>)session.getAttribute("lista");
			lista.remove(busca(manterArtes, lista));
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarArtes.jsp");			
		} else if (pAcao.equals("Alterar")) {
			manterArtes.alterar();
			ArrayList<ArtesTO> lista = (ArrayList<ArtesTO>)session.getAttribute("lista");
			int pos = busca(manterArtes, lista);
			lista.remove(pos);
			lista.add(pos, manterArtes.getTO());
			session.setAttribute("lista", lista);
			request.setAttribute("artesTO", manterArtes.getTO());
			view = request.getRequestDispatcher("VisualizarArtes.jsp");			
		} else if (pAcao.equals("Consultar")) {
			manterArtes.carregar();
			request.setAttribute("artesTO", manterArtes.getTO());
			view = request.getRequestDispatcher("VisualizarArtes.jsp");		
		} else if (pAcao.equals("Editar")) {
			manterArtes.carregar();
			request.setAttribute("artesTO", manterArtes.getTO());
			view = request.getRequestDispatcher("AlterarCursoArtes.jsp");		
		}

		view.forward(request, response);
	}
	public int busca(ManterCursoArtes manterArtes, ArrayList<ArtesTO> lista) {
		ArtesTO to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getCodigo() == manterArtes.getCodigo()){
				return i;
			}
		}
		return -1;
	}
}
		
		
		
		
		
		
		
		
		
		
	