package model;


import daoArtes.*;
import to.ArtesTO;



public class ManterCursoArtes {
	int codigo;
	String nome, dataInicio, dataTermino, horario, numeroVagas, valor, descricaoMaterial, nomeLivrosUtilizados,disponibilidade;  


	public ManterCursoArtes (ArtesTO artesTO){

		this.codigo = artesTO.getCodigo();
		this.nome = artesTO.getNome();
		this.dataInicio =  artesTO.getDataInicio();
		this.dataTermino = artesTO.getDataTermino();
		this.horario = artesTO.getHorario();
		this.numeroVagas =  artesTO.getNumeroVagas();
		this.valor = artesTO.getValor();
		this.descricaoMaterial = artesTO.getDescricaoMaterial();
		this.nomeLivrosUtilizados = artesTO.getNomeLivrosUtilizados();
		this.disponibilidade= artesTO.getDisponibilidade();

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


	public String getDescricaoMaterial() {
		return descricaoMaterial;
	}


	public void setDescricaoMaterial(String descricaoMaterial) {
		this.descricaoMaterial = descricaoMaterial;
	}


	public String getNomeLivrosUtilizados() {
		return nomeLivrosUtilizados;
	}


	public void setNomeLivrosUtilizados(String nomeLivrosUtilizados) {
		this.nomeLivrosUtilizados = nomeLivrosUtilizados;
	}


	public String getDisponibilidade() {
		return disponibilidade;
	}


	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	

	
	// criar
		public void cadastrar() {
			ArtesDAO dao = new ArtesDAO();
			ArtesTO to = getTO();
			dao.inserir(to);
			this.codigo = to.getCodigo();
		}
		public ArtesTO getTO() {
			ArtesTO to = new ArtesTO();
			to.setCodigo(codigo);
			to.setNome(nome);
			to.setDataInicio(dataInicio);
			to.setDataTermino(dataTermino);
			to.setHorario(horario);
			to.setNumeroVagas(numeroVagas);
			to.setValor(valor);
			to.setDescricaoMaterial(descricaoMaterial);
			to.setNomeLivrosUtilizados(nomeLivrosUtilizados);
			to.setDisponibilidade(disponibilidade);
			return to;
		}
		
		public void alterar() {
			ArtesDAO dao = new ArtesDAO();
			ArtesTO to = getTO();
			dao.alterar(to);
		}

		public void deletar() {
			ArtesDAO dao = new ArtesDAO();
			ArtesTO to = new ArtesTO();
			to.setCodigo(codigo);
			dao.deletar(to);
		}

		public void carregar() {
			ArtesDAO dao = new ArtesDAO();
			ArtesTO armazenaCodigo = new ArtesTO();
			armazenaCodigo.setCodigo(codigo);
			ArtesTO to = dao.carregar(armazenaCodigo);

			codigo = to.getCodigo();
			nome = to.getNome();
			dataInicio =  to.getDataInicio();
			dataTermino = to.getDataTermino();
			horario = to.getHorario();
			numeroVagas =  to.getNumeroVagas();
			valor = to.getValor();
			descricaoMaterial = to.getDescricaoMaterial();
			nomeLivrosUtilizados = to.getNomeLivrosUtilizados();
			disponibilidade= to.getDisponibilidade();

			
		}

		
		public ArtesTO consultar() {
			ArtesDAO dao = new ArtesDAO();
			ArtesTO armazenaCodigo = new ArtesTO();
			armazenaCodigo.setCodigo(codigo);
			ArtesTO to = dao.carregar(armazenaCodigo);

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
			ManterCursoArtes other = (ManterCursoArtes) obj;
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
			if (descricaoMaterial == null) {
				if (other.descricaoMaterial != null)
					return false;
			} else if (!descricaoMaterial.equals(other.descricaoMaterial))
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
			if (nomeLivrosUtilizados == null) {
				if (other.nomeLivrosUtilizados != null)
					return false;
			} else if (!nomeLivrosUtilizados.equals(other.nomeLivrosUtilizados))
				return false;
			if (numeroVagas == null) {
				if (other.numeroVagas != null)
					return false;
			} else if (!numeroVagas.equals(other.numeroVagas))
				return false;
			if (valor == null) {
				if (other.valor != null)
					return false;
			} else if (!valor.equals(other.valor))
				return false;
			return true;
		}


		

}
