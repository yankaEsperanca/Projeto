package model;

import daoUsuario.UsuarioDAO;
import to.UsuarioTO;

public class Usuario {

	private String usuario;
	private String senha;
	
	public Usuario() {
	}

	public Usuario(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean validar(){
		UsuarioTO to = getTO();
		UsuarioDAO dao = new UsuarioDAO();
		return dao.validar(to);
	}
	public UsuarioTO getTO() {
		UsuarioTO to = new UsuarioTO();
		to.setUsuario(usuario);
		to.setSenha(senha);
		return to;
	}
}
