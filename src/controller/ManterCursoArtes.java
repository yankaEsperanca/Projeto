package controller;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import daoArtes.*;
import to.*;
import javax.swing.*;

/**
 * Servlet implementation class ManterCursoArtes
 */
@WebServlet("/manter_curso_artes.do")
public class ManterCursoArtes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManterCursoArtes() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Para poder exibir os textos.
		PrintWriter out = response.getWriter();

		ArtesTO artesTO = new ArtesTO();
		ArtesDAO artesDAO = new ArtesDAO();

		artesTO.setCodigo(request.getParameter("codigo")); // nome do parametro do formulário 
		artesTO.setNome(request.getParameter("nome"));
		artesTO.setDataInicio(request.getParameter("dataIni")); // nome do parametro do formulário 
		artesTO.setDataTermino(request.getParameter("dataTerm"));
		artesTO.setHorario(request.getParameter("horario")); // nome do parametro do formulário 
		artesTO.setNumeroVagas(request.getParameter("numVagas"));
		artesTO.setValor(request.getParameter("valor")); // nome do parametro do formulário 
		artesTO.setDescricaoMaterial(request.getParameter("descricaoMat"));
		artesTO.setNomeLivrosUtilizados(request.getParameter("nomeLivros"));
		artesTO.setDisponibilidade(request.getParameter("disp"));

		String pAcao = request.getParameter("acao");

		if(pAcao.equals("Cadastrar")){
			artesDAO.inserir(artesTO);
			out.println( "Curso cadastrado com sucesso");
		}

		if(pAcao.equals("Consultar")){
			String codigo = (JOptionPane.showInputDialog(null, "Digite o código para busca:"));
		
			if (codigo == null || codigo.equals("")) {
				JOptionPane.showMessageDialog(null,	"Você não inseriu nenhum dado");
			}
			else {
				artesTO.setCodigo(codigo);	
				artesTO = (artesDAO.consultar(artesTO));
				out.println("**Dados do curso consultado** \n\n\n" + "Código:" + artesTO.getCodigo() + "\n" + "Nome:" + artesTO.getNome() + "\n" + "Data início:" + artesTO.getDataInicio() + "\n" + "Data término:" + artesTO.getDataTermino() + "\n"+ "Horario:" + artesTO.getHorario() + "\n"+ "Npumero de vagas:" + artesTO.getNumeroVagas() + "\n"+ "Valor:" + artesTO.getValor() + "\n" +"Descrição material:" + artesTO.getDescricaoMaterial()+ "\n" +"Nomes dos livros utilizados:" + artesTO.getNomeLivrosUtilizados() + "\n" +"Disponibilidade:" + artesTO.getDisponibilidade());
			}
		}
		
		if(pAcao.equals("Deletar")){
			artesDAO.deletar(artesTO);	
			out.println( "Curso deletado com sucesso");
		}

		if(pAcao.equals("Alterar")){
		}			

	}

}
