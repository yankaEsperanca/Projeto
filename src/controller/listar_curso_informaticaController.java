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
import model.ListarInformatica;
import to.*; 
/**
 * Servlet implementation class listar_curso_informaticaController
 */
@WebServlet("/listar_curso_informaticaController.do")
public class listar_curso_informaticaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chave = request.getParameter("data[search]");
		ListarInformatica lI = new ListarInformatica();
		ArrayList<InformaticaTO> lista;
		if(chave != null && chave.length() > 0){
			lista = lI.listarInformatica(chave);
		}
		else {				
			lista = lI.listarInformatica();
		}

		request.setAttribute("lista", lista);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarInformatica.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
