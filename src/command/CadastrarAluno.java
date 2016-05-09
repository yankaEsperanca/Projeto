package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ManterAluno;
import to.AlunoTO;

public class CadastrarAluno implements Command {
	

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
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
		HttpSession session = request.getSession();
				
		manterAluno.cadastrar();
		ArrayList<AlunoTO> lista = new ArrayList<>();
		lista.add(manterAluno.getTO());	
		session.setAttribute("lista", lista);

		RequestDispatcher view = request.getRequestDispatcher("ListarAluno.jsp");
		view.forward(request, response);

	}
	
}
