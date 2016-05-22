package model;


import java.util.ArrayList;

import daoMatricula.MatriculaDAO;
import to.MatriculaTO;


public class ListarMatricula {
	
	public ArrayList<MatriculaTO> listarMatricula(){
		ArrayList<MatriculaTO> lista;
		MatriculaDAO dao = new MatriculaDAO();
		lista = dao.listarMatricula();
		return lista;
	}

	public ArrayList<MatriculaTO> listarMatricula(String chave){
		ArrayList<MatriculaTO> lista;
		MatriculaDAO dao = new MatriculaDAO();
		lista = dao.listarMatriculaCodigo(chave);

		return lista;
	}
}





