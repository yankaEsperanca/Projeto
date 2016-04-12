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

import model.ListarAluno;
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
			String chave = request.getParameter("data[search]");
			ListarAluno lA = new ListarAluno();
			ArrayList<AlunoTO> lista;
			if(chave != null && chave.length() > 0){
				lista = lA.listarAluno(chave);
			}
			else {				
				lista = lA.listarAluno();
			}
						
			
			request.setAttribute("lista", lista);
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


	