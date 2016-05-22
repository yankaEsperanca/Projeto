package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;

public class FazerLogin implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("usuario");
		String senha = request.getParameter("senha");

		Usuario usuario = new Usuario(nome, senha);
		HttpSession session = request.getSession();
		if (usuario.validar()) {
			session.setAttribute("logado", usuario.getTO());
			System.out.println("Logou " + usuario.getTO());
		} else {
			System.out.println("N�o Logou " + usuario.getTO());
			throw new ServletException("Usuarrio/Senha invalidos");
		}
		response.sendRedirect("index.jsp");
	}

}
