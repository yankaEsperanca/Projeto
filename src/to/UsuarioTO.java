package to;

public class UsuarioTO {
	private static final long serialVersionUID = 1L;
	
	private String usuario;
	private String senha;
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
	@Override
	public String toString() {
		return "UsuarioTO [usuario=" + usuario + ", senha=" + senha + "]";
	}
	
	
}
