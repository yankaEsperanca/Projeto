package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;
import to.AlunoTO;



/**
 * Servlet implementation class listar_alunos
 */
@WebServlet("/listar_alunosController.do")
public class listar_alunosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    request.setCharacterEncoding("UTF-8");
			String chave = request.getParameter("data[search]");
			String acao = request.getParameter("acao");
			ListarAluno lA = new ListarAluno();
			ArrayList<AlunoTO> lista = null;
			HttpSession session = request.getSession();
			if(acao.equals("buscar")){
				if(chave != null && chave.length() > 0){
					lista = lA.listarAluno(chave);
				}
				else {				
					lista = lA.listarAluno();
				}
				session.setAttribute("lista", lista);		
			}
			else if (acao.equals("reiniciar")) {
				session.setAttribute("lista", null);
			}
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarAluno.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


	