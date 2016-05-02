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
import javax.servlet.http.HttpSession;

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

		request.setCharacterEncoding("UTF-8");
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
		HttpSession session = request.getSession();
		
		if (pAcao.equals("Criar")) {
			manterAluno.cadastrar();
			ArrayList<AlunoTO> lista = new ArrayList<>();
			lista.add(manterAluno.getTO());	
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarAluno.jsp");
		} else if (pAcao.equals("Excluir")) {
			manterAluno.deletar();
			ArrayList<AlunoTO> lista = (ArrayList<AlunoTO>)session.getAttribute("lista");
			lista.remove(busca(manterAluno, lista));
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarAluno.jsp");			
		} else if (pAcao.equals("Alterar")) {
			manterAluno.alterar();
			ArrayList<AlunoTO> lista = (ArrayList<AlunoTO>)session.getAttribute("lista");
			int pos = busca(manterAluno, lista);
			lista.remove(pos);
			lista.add(pos, manterAluno.getTO());
			session.setAttribute("lista", lista);
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
	
	public int busca(ManterAluno manterAluno, ArrayList<AlunoTO> lista) {
		AlunoTO to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getCpf() == manterAluno.getCpf()){
				return i;
			}
		}
		return -1;
	}
}
