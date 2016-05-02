package model;

import java.util.ArrayList;
import daoAluno.*;
import to.AlunoTO;

public class ListarAluno {
	
	public ArrayList<AlunoTO> listarAluno(){
		ArrayList<AlunoTO> lista;
		AlunoDAO dao = new AlunoDAO();
		lista = dao.listarAluno();
		return lista;
	}

	public ArrayList<AlunoTO> listarAluno(String chave){
		ArrayList<AlunoTO> lista;
		AlunoDAO dao = new AlunoDAO();
		if (Character.isDigit(chave.charAt(0))==true){
			lista = dao.listarAlunoCpf(chave);
		}
		else {
			lista = dao.listarAluno(chave);
		}

		return lista;
		
		
		
	}
			
	
		
		
	}
	
	
