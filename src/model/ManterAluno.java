package model;


import daoAluno.*;
import to.AlunoTO;


public class ManterAluno {

	String nome, endereco, telefone, cpf, rg, email, login ,senha;

	public ManterAluno(AlunoTO alunoTO){
		this.nome = alunoTO.getNome();
		this.endereco = alunoTO.getEndereco();
		this.telefone = alunoTO.getTelefone();
		this.cpf = alunoTO.getCpf();
		this.rg = alunoTO.getRg();
		this.email = alunoTO.getEmail();
		this.login = alunoTO.getLogin();
		this.senha = alunoTO.getSenha();		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public AlunoTO getTO() {
		AlunoTO to = new AlunoTO();

		to.setNome(nome);
		to.setEndereco(endereco);
		to.setTelefone(telefone);
		to.setCpf(cpf);
		to.setRg(rg);
		to.setEmail(email);
		to.setLogin(login);
		to.setSenha(senha);
		return to;
	}
	
	// criar
	public void cadastrar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();

		to.setNome(nome);
		to.setEndereco(endereco);
		to.setTelefone(telefone);
		to.setCpf(cpf);
		to.setRg(rg);
		to.setEmail(email);
		to.setLogin(login);
		to.setSenha(senha);

		dao.inserir(to);
	}
	
	
	

	public void alterar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();

		to.setNome(nome);
		to.setEndereco(endereco);
		to.setTelefone(telefone);
		to.setCpf(cpf);
		to.setRg(rg);
		to.setEmail(email);
		to.setLogin(login);
		to.setSenha(senha);

		dao.alterar(to);
	}

	public void deletar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();

		to.setCpf(cpf);
		dao.deletar(to);
	}

	public void carregar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO armazenaCpf = new AlunoTO();
		armazenaCpf.setCpf(cpf);
		AlunoTO to = dao.consultarCPF(armazenaCpf);

		nome = to.getNome();
		endereco = to.getEndereco();
		telefone = to.getTelefone();
		cpf = to.getCpf();
		rg = to.getRg();
		email = to.getEmail();
		login = to.getLogin();
		senha = to.getSenha();

	}

	
	public AlunoTO consultar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO armazenaCpf = new AlunoTO();
		armazenaCpf.setCpf(cpf);
		AlunoTO to = dao.consultarCPF(armazenaCpf);

		return to;
	}
	
	public void atualizar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = getTO();
		dao.alterar(to);
	}
	/*
	public String consultarTodos(){
		AlunoDAO dao = new AlunoDAO();
		String resp = dao.consultarTodos();
		return resp;
	}*/

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ManterAluno other = (ManterAluno) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}


}
