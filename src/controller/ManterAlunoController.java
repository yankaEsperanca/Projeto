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
import to.*;
import model.ManterAluno;
/**
 * Servlet implementation class Aluno
 */
@WebServlet("/ManterAlunoController.do")

public class ManterAlunoController extends HttpServlet {
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

		//Para poder exibir os textos.
		//	PrintWriter out = response.getWriter();

		String pAcao = request.getParameter("acao");

		AlunoTO alunoTO = new AlunoTO();

		alunoTO.setNome(request.getParameter("nome")); // nome do parametro do formulário 
		alunoTO.setEndereco(request.getParameter("endereco"));
		alunoTO.setTelefone(request.getParameter("telefone")); // nome do parametro do formulário 
		alunoTO.setCpf(request.getParameter("cpf"));
		alunoTO.setRg(request.getParameter("rg")); // nome do parametro do formulário 
		alunoTO.setEmail(request.getParameter("email"));
		alunoTO.setLogin(request.getParameter("usuario")); // nome do parametro do formulário 
		alunoTO.setSenha(request.getParameter("senha"));

		ManterAluno manterAluno = new ManterAluno(alunoTO);
		RequestDispatcher view = null;

		if (pAcao.equals("Criar")) {
			manterAluno.cadastrar();
			ArrayList<AlunoTO> lista = new ArrayList<>();
			lista.add(manterAluno.getTO());
			request.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarAluno.jsp");
		} else if (pAcao.equals("Excluir")) {
			manterAluno.deletar();
			view = request.getRequestDispatcher("listar_aluno.html");			
		} else if (pAcao.equals("Alterar")) {
			manterAluno.alterar();
			request.setAttribute("alunoTO", manterAluno.getTO());
			view = request.getRequestDispatcher("VisualizarAluno.jsp");			
		} else if (pAcao.equals("Consultar")) {
			manterAluno.carregar();
			request.setAttribute("alunoTO", manterAluno.getTO());
			view = request.getRequestDispatcher("VisualizarAluno.jsp");		
		} else if (pAcao.equals("Editar")) {
			manterAluno.carregar();
			request.setAttribute("alunoTO", manterAluno.getTO());
			view = request.getRequestDispatcher("AlterarAluno.jsp");		
		}

		view.forward(request, response);
	}
}
