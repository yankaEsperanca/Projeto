package model;

import java.util.ArrayList;
import daoInformatica.*;
import to.InformaticaTO;

public class ListarInformatica {


	public ArrayList<InformaticaTO> listarInformatica(){
		ArrayList<InformaticaTO> lista;
		InformaticaDAO dao = new InformaticaDAO();
		lista = dao.listarCursoInformatica();
		return lista;
	}

	public ArrayList<InformaticaTO> listarInformatica(String chave){
		ArrayList<InformaticaTO> lista;
		InformaticaDAO dao = new InformaticaDAO();
		lista = dao.listarCursoInformatica(chave);
		return lista;
	}
}
