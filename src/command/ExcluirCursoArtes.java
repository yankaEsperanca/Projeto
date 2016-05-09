package command;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ManterCursoArtes;
import to.ArtesTO;

public class ExcluirCursoArtes implements Command{
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		ArtesTO artesTO = new ArtesTO();

		String pCodigo = request.getParameter("codigo");
		artesTO.setNome(request.getParameter("nome"));
		artesTO.setDataInicio(request.getParameter("dataIni")); // nome do parametro do formul�rio 
		artesTO.setDataTermino(request.getParameter("dataTerm"));
		artesTO.setHorario(request.getParameter("horario")); // nome do parametro do formul�rio 
		artesTO.setNumeroVagas(request.getParameter("numVagas"));
		artesTO.setValor(request.getParameter("valor")); // nome do parametro do formul�rio 
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

		manterArtes.deletar();
		@SuppressWarnings("unchecked")
		ArrayList<ArtesTO> lista = (ArrayList<ArtesTO>)session.getAttribute("lista");
		lista.remove(busca(manterArtes, lista));
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarArtes.jsp");	
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







