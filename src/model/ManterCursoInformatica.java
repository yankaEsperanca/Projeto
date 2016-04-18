package model;



import to.InformaticaTO;
import daoInformatica.*;

public class ManterCursoInformatica {
	
	String  nome, dataInicio, dataTermino, horario, numeroVagas, valor, numeroLab, registroSoft, disponibilidade;
	int codigo;
	InformaticaTO TO;

	public ManterCursoInformatica (InformaticaTO informaticaTO){
		
		this.codigo = informaticaTO.getCodigo();
		this.nome = informaticaTO.getNome();
		this.dataInicio =  informaticaTO.getDataInicio();
		this.dataTermino = informaticaTO.getDataTermino();
		this.horario = informaticaTO.getHorario();
		this.numeroVagas =  informaticaTO.getNumeroVagas();
		this.valor = informaticaTO.getValor();
		this.numeroLab = informaticaTO.getNumeroLab();
		this.registroSoft= informaticaTO.getRegistroSoft();
		this.disponibilidade= informaticaTO.getDisponibilidade();

	}

	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getNumeroVagas() {
		return numeroVagas;
	}

	public void setNumeroVagas(String numeroVagas) {
		this.numeroVagas = numeroVagas;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getNumeroLab() {
		return numeroLab;
	}

	public void setNumeroLab(String numeroLab) {
		this.numeroLab = numeroLab;
	}

	public String getRegistroSoft() {
		return registroSoft;
	}

	public void setRegistroSoft(String registroSoft) {
		this.registroSoft = registroSoft;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public InformaticaTO getTO() {
		InformaticaTO to = new InformaticaTO();
    
		to.setCodigo(codigo);
		to.setNome(nome);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorario(horario);
		to.setNumeroVagas(numeroVagas);
		to.setValor(valor);
		to.setNumeroLab(numeroLab);
		to.setRegistroSoft(registroSoft);
		to.setDisponibilidade(disponibilidade);
			
		return to;
	}
	
	// criar
	public void cadastrar() {
		InformaticaDAO dao = new InformaticaDAO();
		InformaticaTO to = new InformaticaTO();
		dao.inserir(to);
		this.codigo = to.getCodigo();

	}
	
	
	

	public void alterar() {
		InformaticaDAO dao = new InformaticaDAO();
		InformaticaTO to = new InformaticaTO();

		to.setCodigo(codigo);
		to.setNome(nome);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorario(horario);
		to.setNumeroVagas(numeroVagas);
		to.setValor(valor);
		to.setNumeroLab(numeroLab);
		to.setRegistroSoft(registroSoft);
		to.setDisponibilidade(disponibilidade);

		dao.alterar(to);
	}

	public void deletar() {
		InformaticaDAO dao = new InformaticaDAO();
		InformaticaTO to = new InformaticaTO();

		to.setCodigo(codigo);
		dao.deletar(to);
	}
/*public void carregar() {
		ClienteDAO dao = new ClienteDAO();
		ClienteTO to = dao.carregar(id);
		nome = to.getNome();
		fone = to.getFone();
		email = to.getEmail();
	}*/
	
	public void carregar() {
		InformaticaDAO dao = new InformaticaDAO();
	   InformaticaTO armazenaCodigo = new InformaticaTO();
	    armazenaCodigo.setCodigo(codigo);
		InformaticaTO to = dao.carregar(armazenaCodigo);

	    nome = to.getNome();
		dataInicio =  to.getDataInicio();
		dataTermino = to.getDataTermino();
		horario = to.getHorario();
		numeroVagas =  to.getNumeroVagas();
		valor = to.getValor();
		numeroLab = to.getNumeroLab();
		registroSoft = to.getRegistroSoft();
		disponibilidade= to.getDisponibilidade();
				
	}

	
	public InformaticaTO consultar() {
		InformaticaDAO dao = new InformaticaDAO();
		InformaticaTO armazenaCodigo = new InformaticaTO();
		armazenaCodigo.setCodigo(codigo);
		InformaticaTO TO = dao.carregar(armazenaCodigo);

		return TO;
	}
	/*
	public String consultarTodos(){
		InformaticaDAO dao = new InformaticaDAO();
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
		ManterCursoInformatica other = (ManterCursoInformatica) obj;
		if (codigo != other.codigo)
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (dataTermino == null) {
			if (other.dataTermino != null)
				return false;
		} else if (!dataTermino.equals(other.dataTermino))
			return false;
		if (disponibilidade == null) {
			if (other.disponibilidade != null)
				return false;
		} else if (!disponibilidade.equals(other.disponibilidade))
			return false;
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroLab == null) {
			if (other.numeroLab != null)
				return false;
		} else if (!numeroLab.equals(other.numeroLab))
			return false;
		if (numeroVagas == null) {
			if (other.numeroVagas != null)
				return false;
		} else if (!numeroVagas.equals(other.numeroVagas))
			return false;
		if (registroSoft == null) {
			if (other.registroSoft != null)
				return false;
		} else if (!registroSoft.equals(other.registroSoft))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}






	
}
