package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ManterMatricula;
import to.MatriculaTO;


public class CadastrarMatricula implements Command  {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MatriculaTO matriculaTO = new MatriculaTO();
		
 		String pCodigo = request.getParameter("codigo");
 		matriculaTO.setData(request.getParameter("data"));
 		matriculaTO.setValor(request.getParameter("valor")); // nome do parametro do formulário 
 		matriculaTO.setStatusPagamento(request.getParameter("statusPagamento"));
 		matriculaTO.setStatusMatricula(request.getParameter("statusMatricula")); // nome do parametro do formulário 
 		matriculaTO.setAluno(request.getParameter("aluno"));
 		matriculaTO.setCurso(request.getParameter("curso")); // nome do parametro do formulário
		int codigo = -1;
		try {
			codigo = Integer.parseInt(pCodigo);
			matriculaTO.setCodigo(codigo);
		} catch (NumberFormatException e) {

		}

		ManterMatricula manterMatricula = new ManterMatricula(matriculaTO);
		HttpSession session = request.getSession(); // aqui estamos inicializando uma seção, com nome de session

		manterMatricula.cadastrar();
		ArrayList<MatriculaTO> lista = new ArrayList<>();
		lista.add(manterMatricula.getTO());
		session.setAttribute("lista", lista);
		RequestDispatcher view = request.getRequestDispatcher("ListarMatricula.jsp");		
		view.forward(request, response);
		
	}
}

	

