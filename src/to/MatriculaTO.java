package to;

public class MatriculaTO {

	protected String data, valor, statusPagamento, statusMatricula, aluno, curso;  
	protected int codigo;
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
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatriculaTO other = (MatriculaTO) obj;
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
