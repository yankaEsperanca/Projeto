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


public class ExcluirAluno implements Command {

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
		HttpSession session = request.getSession();


		manterAluno.deletar();
		@SuppressWarnings("unchecked")
		ArrayList<AlunoTO> lista = (ArrayList<AlunoTO>)session.getAttribute("lista");
		lista.remove(busca(manterAluno, lista));
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarAluno.jsp");			
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
