package model;

import daoMatricula.MatriculaDAO;
import to.MatriculaTO;

public class ManterMatricula {
	protected String data, valor, statusPagamento, statusMatricula, aluno, curso;
	protected int codigo;

	public ManterMatricula() {
	}

	public ManterMatricula(String data, String valor, String statusPagamento, String statusMatricula, String aluno,
			String curso, int codigo) {
		this.data = data;
		this.valor = valor;
		this.statusPagamento = statusPagamento;
		this.statusMatricula = statusMatricula;
		this.aluno = aluno;
		this.curso = curso;
		this.codigo = codigo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public String getStatusMatricula() {
		return statusMatricula;
	}

	public void setStatusMatricula(String statusMatricula) {
		this.statusMatricula = statusMatricula;
	}

	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	// criar
	public void cadastrar() {
		MatriculaDAO dao = new MatriculaDAO();
		MatriculaTO to = getTO();
		dao.inserir(to);
		this.codigo = to.getCodigo();
	}

	public MatriculaTO getTO() {
		MatriculaTO to = new MatriculaTO();
		to.setCodigo(codigo);
		to.setData(data);
		to.setValor(valor);
		to.setStatusPagamento(statusPagamento);
		to.setStatusMatricula(statusMatricula);
		to.setAluno(aluno);
		to.setCurso(curso);
		return to;
	}

	public void alterar() {
		MatriculaDAO dao = new MatriculaDAO();
		MatriculaTO to = getTO();
		dao.alterar(to);
	}

	public void deletar() {
		MatriculaDAO dao = new MatriculaDAO();
		MatriculaTO to = new MatriculaTO();
		to.setCodigo(codigo);
		dao.deletar(to);
	}

	public void carregar() {
		MatriculaDAO dao = new MatriculaDAO();
		MatriculaTO armazenaCodigo = new MatriculaTO();
		armazenaCodigo.setCodigo(codigo);
		MatriculaTO to = dao.carregar(armazenaCodigo);

		codigo = to.getCodigo();
		data = to.getData();
		valor = to.getValor();
		statusPagamento = to.getStatusPagamento();
		statusMatricula = to.getStatusMatricula();
		aluno = to.getAluno();
		curso = to.getCurso();
	}

	public MatriculaTO consultar() {
		MatriculaDAO dao = new MatriculaDAO();
		MatriculaTO armazenaCodigo = new MatriculaTO();
		armazenaCodigo.setCodigo(codigo);
		MatriculaTO to = dao.carregar(armazenaCodigo);

		return to;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ManterMatricula other = (ManterMatricula) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (codigo != other.codigo)
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (statusMatricula == null) {
			if (other.statusMatricula != null)
				return false;
		} else if (!statusMatricula.equals(other.statusMatricula))
			return false;
		if (statusPagamento == null) {
			if (other.statusPagamento != null)
				return false;
		} else if (!statusPagamento.equals(other.statusPagamento))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	
	
}
