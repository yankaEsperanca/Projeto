package command;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ManterAluno;
import to.AlunoTO;


public class EditarAluno implements Command {

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
		RequestDispatcher view = null;

		
		
		manterAluno.carregar();
		request.setAttribute("alunoTO", manterAluno.getTO());
		view = request.getRequestDispatcher("AlterarAluno.jsp");	
		view.forward(request, response);
	
	}
}
