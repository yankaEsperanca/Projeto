package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ListarInformatica;
import to.InformaticaTO;

public class ListarCursoInformaticaBuscar implements Command  {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String chave = request.getParameter("data[search]");

		ListarInformatica lI = new ListarInformatica();
		ArrayList<InformaticaTO> lista =null;
		HttpSession session = request.getSession();  // temos que iniciar a seção

		if(chave != null && chave.length() > 0){
			lista = lI.listarInformatica(chave);
		} else {				
			lista = lI.listarInformatica();
		}
		session.setAttribute("lista", lista);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarInformatica.jsp");
		dispatcher.forward(request, response);
	}
}


