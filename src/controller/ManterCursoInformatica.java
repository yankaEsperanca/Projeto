package controller;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import daoInformatica.*;
import to.*;

/**
 * Servlet implementation class ManterCursoInformatica
 */
@WebServlet("/manter_curso_informatica.do")
public class ManterCursoInformatica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManterCursoInformatica() {
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

		InformaticaTO infoTO = new InformaticaTO();
		InformaticaDAO infoDAO = new InformaticaDAO();

		infoTO.setCodigo(request.getParameter("codigo")); // nome do parametro do formul�rio 
		infoTO.setNome(request.getParameter("nome"));
		infoTO.setDataInicio(request.getParameter("dataIni")); // nome do parametro do formul�rio 
		infoTO.setDataTermino(request.getParameter("dataTerm"));
		infoTO.setHorario(request.getParameter("horario")); // nome do parametro do formul�rio 
		infoTO.setNumeroVagas(request.getParameter("numVagas"));
		infoTO.setValor(request.getParameter("valor")); // nome do parametro do formul�rio 
		infoTO.setNumeroLab(request.getParameter("numLab"));
		infoTO.setRegistroSoft(request.getParameter("registroSoft"));
		infoTO.setDisponibilidade(request.getParameter("disp"));
		
		String pAcao = request.getParameter("acao");

		if(pAcao.equals("Cadastrar")){

			String resp = infoDAO.inserir(infoTO);
			out.println(resp);
		}

		if(pAcao.equals("Consultar")){
			String codigo = (JOptionPane.showInputDialog(null, "Digite o c�digo para busca:"));
		
			if (codigo == null || codigo.equals("")) {
				JOptionPane.showMessageDialog(null,	"Voc� n�o inseriu nenhum dado");
			}
			else {
				infoTO.setCodigo(codigo);	
				infoTO = (infoDAO.consultar(infoTO));
				out.println("**Dados do curso consultado** \n\n\n" + "C�digo:" + infoTO.getCodigo() + "\n" + "Nome:" + infoTO.getNome() + "\n" + "Data in�cio:" + infoTO.getDataInicio() + "\n" + "Data t�rmino:" + infoTO.getDataTermino() + "\n"+ "Horario:" + infoTO.getHorario() + "\n"+ "Npumero de vagas:" + infoTO.getNumeroVagas() + "\n"+ "Valor:" + infoTO.getValor() + "\n" +"N�mero labprat�rio:" + infoTO.getNumeroLab()+ "\n" +"Registro do software:" + infoTO.getRegistroSoft() + "\n" +"Disponibilidade:" + infoTO.getDisponibilidade());
			}
		}
		
		
		if(pAcao.equals("Deletar")){
			infoDAO.deletar(infoTO);	
			out.println( "Curso deletado com sucesso");
		}
		
		if(pAcao.equals("Alterar")){
		}			
	
	
	}

}
