package controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import model.ManterCursoInformatica;
import to.InformaticaTO;

/**
 * Servlet implementation class ManterCursoInformatica
 */
@WebServlet("/manter_curso_informatica.do")
public class ManterCursoInformaticaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManterCursoInformaticaController() {
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

		ManterCursoInformatica manterInfo = new ManterCursoInformatica(infoTO);

		if(pAcao.equals("Cadastrar")){
			manterInfo.cadastrar();
			out.println( "Curso cadastrado com sucesso");
		}

		/*if(pAcao.equals("Consultar")){
			String codigo = (JOptionPane.showInputDialog(null, "Digite o c�digo para busca:"));

			if (codigo == null || codigo.equals("")) {
				JOptionPane.showMessageDialog(null,	"Voc� n�o inseriu nenhum dado");
			}
			else {
				infoTO.setCodigo(codigo);	
				infoTO = (manterInfo.consultar());
				out.println("**Dados do curso consultado** \n\n\n" + "C�digo:" + infoTO.getCodigo() + "\n" + "Nome:" + infoTO.getNome() + "\n" + "Data in�cio:" + infoTO.getDataInicio() + "\n" + "Data t�rmino:" + infoTO.getDataTermino() + "\n"+ "Horario:" + infoTO.getHorario() + "\n"+ "Npumero de vagas:" + infoTO.getNumeroVagas() + "\n"+ "Valor:" + infoTO.getValor() + "\n" +"N�mero laboratorio:" + infoTO.getNumeroLab()+ "\n" +"Registro de software:" + infoTO.getRegistroSoft() + "\n" +"Disponibilidade:" + infoTO.getDisponibilidade());
			}
		}*/
		
		if(pAcao.equals("Consultar")){
		infoTO = manterInfo.consultar();
		}

		if(pAcao.equals("Deletar")){
			manterInfo.deletar();	
			out.println( "Curso deletado com sucesso");
		}

		if(pAcao.equals("Alterar")){
			manterInfo.alterar();
		}			

		manterInfo.carregar();

		InformaticaTO toEnviarDados = new InformaticaTO();

		toEnviarDados.setCodigo(manterInfo.getCodigo());
		toEnviarDados.setNome(manterInfo.getNome());
		toEnviarDados.setDataInicio(manterInfo.getDataInicio());
		toEnviarDados.setDataTermino(manterInfo.getDataTermino());
		toEnviarDados.setHorario(manterInfo.getHorario());
		toEnviarDados.setNumeroVagas(manterInfo.getNumeroVagas());
		toEnviarDados.setValor(manterInfo.getValor());
		toEnviarDados.setNumeroLab(manterInfo.getNumeroLab());
		toEnviarDados.setRegistroSoft(manterInfo.getRegistroSoft());
		toEnviarDados.setDisponibilidade(manterInfo.getDisponibilidade());

		request.setAttribute("manterInfo", toEnviarDados);	

		RequestDispatcher view = request.getRequestDispatcher("InformaticaJsp.jsp");
		view.forward(request,response);

		
		
	}

}
