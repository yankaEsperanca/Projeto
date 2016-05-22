package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ListarMatricula;
import to.MatriculaTO;

public class ListarMatriculaBuscar implements Command{
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String chave = request.getParameter("data[search]");

		ListarMatricula listar = new ListarMatricula();
		ArrayList<MatriculaTO> lista =null;
		HttpSession session = request.getSession();  // temos que iniciar a seção

		if(chave != null && chave.length() > 0){
			lista = listar.listarMatricula(chave);
		} else {				
			lista = listar.listarMatricula();
		}
		session.setAttribute("lista", lista);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarMatricula.jsp");
		dispatcher.forward(request, response);
	}
}


