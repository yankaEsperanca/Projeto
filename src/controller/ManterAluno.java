package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import daoAluno.*;
import to.*;
import to.AlunoTO;;

/**
 * Servlet implementation class Aluno
 */
@WebServlet("/manter_Aluno.do")

public class ManterAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManterAluno() {
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

		AlunoTO alunoTO = new AlunoTO();
		AlunoDAO alunoDAO = new AlunoDAO();

		alunoTO.setNome(request.getParameter("nome")); // nome do parametro do formulário 
		alunoTO.setEndereco(request.getParameter("endereco"));
		alunoTO.setTelefone(request.getParameter("telefone")); // nome do parametro do formulário 
		alunoTO.setCpf(request.getParameter("cpf"));
		alunoTO.setRg(request.getParameter("rg")); // nome do parametro do formulário 
		alunoTO.setEmail(request.getParameter("email"));
		alunoTO.setLogin(request.getParameter("usuario")); // nome do parametro do formulário 
		alunoTO.setSenha(request.getParameter("senha"));

		String pAcao = request.getParameter("acao");

		if(pAcao.equals("Cadastrar")){
			alunoDAO.inserir(alunoTO);
			out.println( "Aluno cadastrado com sucesso");
		}

		if(pAcao.equals("Consultar")){
			//			alunoTO.setCpf(JOptionPane.showInputDialog("Buscar aluno", "Digite o CPF para busca:"));
			alunoTO = (alunoDAO.consultarCPF(alunoTO));
			out.println("**Dados do aluno consultado** \n\n\n" + "Nome:" + alunoTO.getNome() + "\n" + "Endereço:" + alunoTO.getEndereco() + "\n" + "Telefone:" + alunoTO.getTelefone() + "\n" + "CPF:" + alunoTO.getCpf() + "\n"+ 	"RG:" + alunoTO.getRg() + "\n"+ "E-mail:" + alunoTO.getEmail() + "\n"+ "Login:" + alunoTO.getLogin() + "\n" +"Senha:" + alunoTO.getSenha());
		}

		if(pAcao.equals("Deletar")){
			alunoDAO.deletar(alunoTO);	
			out.println( "Cliente deletado com sucesso");
		}
		
		if(pAcao.equals("Alterar")){
		}			
			
			/*
			ClienteDAO dao = new ClienteDAO();
			String resp = dao.consultarTodos();
			out.println("<html><head><title>Todos os clientes</title></head><body>");
			out.println(resp);
			out.println("</body></html>");
		}
		else{ 
			cliente.atualizar();
			//	cliente.carregar();
			out.println( "Cliente atualizado com sucesso");
		}

		//out.println( "id: "+cliente.getId()+"<br>");
		//out.println( "nome: "+cliente.getNome()+"<br>");
		//out.println( "fone: "+cliente.getFone()+"<br>");




		*/

	}

}