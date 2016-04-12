package controller;


import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import to.*;
import model.ListarArtes;

/**
 * Servlet implementation class listar_curso_artesController
 */
@WebServlet("/listar_curso_artesController.do")
public class listar_curso_artesController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chave = request.getParameter("data[search]");
		ListarArtes lA = new ListarArtes();
		ArrayList<ArtesTO> lista;
		if(chave != null && chave.length() > 0){
			lista = lA.listarArtes(chave);
		}
		else {				
			lista = lA.listarArtes();
		}
		request.setAttribute("lista", lista);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarArtes.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

}
