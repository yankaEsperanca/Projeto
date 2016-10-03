package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListarArtes;
import model.ManterCursoArtes;
import to.ArtesTO;
import util.JSonFacadeCursoArtes;

 
@WebServlet("/artes")
public class ServicoManterCursoArtes extends HttpServlet {
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

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String chave = request.getParameter("chave");
		ListarArtes listarArtes = new ListarArtes();
		ArrayList<ArtesTO> lista = null;

		PrintWriter out = response.getWriter();

		try {
			if (chave != null && chave.length() > 0) {
				lista = listarArtes.listarArtes(chave);
			} else {
				lista = listarArtes.listarArtes();
			}
			out.println(JSonFacadeCursoArtes.listToJSon(lista));
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacadeCursoArtes.errorToJSon(e));
		}
		
	}
	

	//incluir artes
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//do post e do get chama o metodo execute
		StringBuilder sb = JSonFacadeCursoArtes.montaJSon(request);
		PrintWriter out = response.getWriter();

		try {
			ManterCursoArtes manterCursoArtes = JSonFacadeCursoArtes.jSonToArtes(sb.toString());
			manterCursoArtes.cadastrar();
			//retorna o cliente cadastrado com o id atribuido pelo banco
			out.println(JSonFacadeCursoArtes.ArtesTOJSon(manterCursoArtes));
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacadeCursoArtes.errorToJSon(e));
		}
	}


		//atualizar informatica
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StringBuilder sb = JSonFacadeCursoArtes.montaJSon(request);
		PrintWriter out = response.getWriter();

		try {
			ManterCursoArtes manterCursoArtes = JSonFacadeCursoArtes.jSonToArtes(sb.toString());
			 manterCursoArtes.atualizar();
			//retorna o cliente atualizado
			out.println(JSonFacadeCursoArtes.ArtesTOJSon(manterCursoArtes));
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacadeCursoArtes.errorToJSon(e));
		}
	}

	//excluir cliente
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = JSonFacadeCursoArtes.montaJSon(request);
		PrintWriter out = response.getWriter();

		try {
			ManterCursoArtes manterCursoArtes = JSonFacadeCursoArtes.jSonToArtes(sb.toString());
			manterCursoArtes.deletar(); 
			//retorna dados null se o cliente foi deletado
			out.println(JSonFacadeCursoArtes.ArtesTOJSon(manterCursoArtes));
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacadeCursoArtes.errorToJSon(e));
		}
	}
	

}



