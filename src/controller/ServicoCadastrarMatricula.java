package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ManterMatricula;
import util.JSonFacadeCursoInformatica;
import util.JSonFacadeMatricula;

@WebServlet("/matricula")
public class ServicoCadastrarMatricula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*
	 * configurar a request e a response para todos os mÃ©todos
	 * quando o tomCat executa o servlet  ele deve qual deve ser chamado, e esse método vai servir pra isso
	 * para saber qual outro metodo dessa página vai ser chamado 
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		super.service(request, response);
	}

	//Cadastrar Matrícula
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//do post e do get chama o metodo execute
		StringBuilder sb = JSonFacadeMatricula.montaJSon(request);
		PrintWriter out = response.getWriter();

		try {
			ManterMatricula manterMatricula = JSonFacadeMatricula.jSonToMatricula(sb.toString());
			manterMatricula.cadastrar();
			//retorna o cliente cadastrado com o id atribuido pelo banco
			out.println(JSonFacadeMatricula.MatriculaTOJSon(manterMatricula));
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacadeCursoInformatica.errorToJSon(e));
		}
	}



}



