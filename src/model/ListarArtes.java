package model;


import java.util.ArrayList;
import daoArtes.*;
import to.ArtesTO;


public class ListarArtes {
	
	
	public ArrayList<ArtesTO> listarArtes(){
		ArrayList<ArtesTO> lista;
		ArtesDAO dao = new ArtesDAO();
		lista = dao.listarCursoArtes();
		return lista;
	}

	public ArrayList<ArtesTO> listarArtes(String chave){
		ArrayList<ArtesTO> lista;
		ArtesDAO dao = new ArtesDAO();
		lista = dao.listarCursoArtes(chave);

		return lista;
	}
}





