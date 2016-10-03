package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListarInformatica;
import model.ManterCursoInformatica;
import to.InformaticaTO;
import util.JSonFacadeCursoInformatica;


@WebServlet("/informatica")
public class ServicoManterCursoInformatica extends HttpServlet {
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
	//listar informatica, fazer o select informatica
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String chave = request.getParameter("chave");
		ListarInformatica listarInfo = new ListarInformatica();
		ArrayList<InformaticaTO> lista = null;

		PrintWriter out = response.getWriter();

		try {
			if (chave != null && chave.length() > 0) {
				lista = listarInfo.listarInformatica(chave);
			} else {
				lista = listarInfo.listarInformatica();
			}
			out.println(JSonFacadeCursoInformatica.listToJSon(lista));
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacadeCursoInformatica.errorToJSon(e));
		}
		
	}

	//incluir informatica
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//do post e do get chama o metodo execute
		StringBuilder sb = JSonFacadeCursoInformatica.montaJSon(request);
		PrintWriter out = response.getWriter();

		try {
			ManterCursoInformatica manterCursoInformatica = JSonFacadeCursoInformatica.jSonToInformatica(sb.toString());
			manterCursoInformatica.cadastrar();
			//retorna o cliente cadastrado com o id atribuido pelo banco
			out.println(JSonFacadeCursoInformatica.InformaticaTOJSon(manterCursoInformatica));
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacadeCursoInformatica.errorToJSon(e));
		}
	}


		//atualizar informatica
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StringBuilder sb = JSonFacadeCursoInformatica.montaJSon(request);
		PrintWriter out = response.getWriter();

		try {
			ManterCursoInformatica manterCursoInformatica = JSonFacadeCursoInformatica.jSonToInformatica(sb.toString());
			 manterCursoInformatica.carregar();
			//retorna o cliente atualizado
			out.println(JSonFacadeCursoInformatica.InformaticaTOJSon(manterCursoInformatica));
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacadeCursoInformatica.errorToJSon(e));
		}
	}

	//excluir cliente
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = JSonFacadeCursoInformatica.montaJSon(request);
		PrintWriter out = response.getWriter();

		try {
			ManterCursoInformatica manterCursoInformatica = JSonFacadeCursoInformatica.jSonToInformatica(sb.toString());
			manterCursoInformatica.deletar(); 
			//retorna dados null se o cliente foi deletado
			out.println(JSonFacadeCursoInformatica.InformaticaTOJSon(manterCursoInformatica));
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacadeCursoInformatica.errorToJSon(e));
		}
	}
	

}



