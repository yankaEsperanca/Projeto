package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ListarAluno;
import model.ListarTodosCursosInformaticaArtesModel;
import to.AlunoTO;
import to.ListagemCursoMatriculaInsercaoTO;

public class ListarTodosCursosInformaticaArtes implements Command  {
 
		@Override
		public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			//String chave = request.getParameter("data[search]");
			
			//busca informatica e artes
		 	ListarTodosCursosInformaticaArtesModel listagem = new ListarTodosCursosInformaticaArtesModel();
			ArrayList<ListagemCursoMatriculaInsercaoTO> lista = null;
		
			//busca alunos
			ListarAluno lA = new ListarAluno();
			ArrayList<AlunoTO> listaAluno = null;
			
		 	HttpSession session = request.getSession();
			HttpSession session1 = request.getSession();
			listaAluno = lA.listarAluno();
			lista = listagem.listarCursos();
			session.setAttribute("listaCursos", lista);		
			session1.setAttribute("listaAluno", listaAluno);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CadastrarMatricula.jsp");
			dispatcher.forward(request, response);
			
	 
			 
		}

	}


