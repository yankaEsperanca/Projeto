package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ListarArtes;
import to.ArtesTO;

public class ListarCursoArtesBuscar implements Command  {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String chave = request.getParameter("data[search]");
		ListarArtes lA = new ListarArtes();
		ArrayList<ArtesTO> lista = null;
		HttpSession session = request.getSession();

		if(chave != null && chave.length() > 0){
			lista = lA.listarArtes(chave);
		}
		else {				
			lista = lA.listarArtes();
		}
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarArtes.jsp");
		dispatcher.forward(request, response);
	}
}