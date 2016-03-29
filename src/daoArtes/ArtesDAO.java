package daoArtes;

import java.sql.*;
import to.*;
import javax.swing.*;
import java.util.*;


public class ArtesDAO extends DatabaseConnect {
	protected String codigo, nome, dataInicio, dataTermino, horario, numeroVagas, valor, descricaoMaterial, nomeLivrosUtilizados,disponibilidade;  
	protected int selecionado;
	protected ArrayList<String> dadosConsult = new ArrayList<String> ();
	public ArrayList<String> buscaTodos = new ArrayList<String> ();
	//protected ResourceBundle bn = null;  
//	public ArtesTO artesConsulta=null;


	//INSERIR	
	public void inserir(ArtesTO artesTO){ 

		Connection conn = getConnection();
		String sql = "insert into dadosCursoArtes set codigo=?, nome=?, dataInicio=?, dataTermino=?, horario=?, numeroVagas=?, valor=?, descricaoMaterial=?, nomeLivrosUtilizados=?, disponibilidade=? ";

		try{

			PreparedStatement pst = conn.prepareStatement(sql);   // usa esse prepared para evitar ataques de hackers 
			pst.setString(1,artesTO.getCodigo());
			pst.setString(2,artesTO.getNome());
			pst.setString(3,artesTO.getDataInicio());
			pst.setString(4,artesTO.getDataTermino());
			pst.setString(5,artesTO.getHorario());
			pst.setString(6,artesTO.getNumeroVagas());
			pst.setString(7,artesTO.getValor());
			pst.setString(8,artesTO.getDescricaoMaterial());
			pst.setString(9,artesTO.getNomeLivrosUtilizados());
			pst.setString(10,artesTO.getDisponibilidade());
			pst.executeUpdate();
			pst.close();

	//		JOptionPane.showMessageDialog(null, (bn.getString("mensagemCursoCriado")) ,(bn.getString("messagem")), JOptionPane.INFORMATION_MESSAGE);     
		} 
		catch(Exception e) {
		//	JOptionPane.showMessageDialog(null, (bn.getString("mensagemErroCurso")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE);    
			//   e.printStackTrace();// serve para exibir o erro           
		System.out.println("erro");}
	}

	
	// DELETAR UM ALUNO
	public void deletar(ArtesTO artesTO){

		Connection conn = getConnection();

		String sql = "delete from dadosCursoArtes where codigo=?";

		try{

			PreparedStatement pst = conn.prepareStatement(sql);   // usa esse prepared para evitar ataques de hackers 
			pst.setString(1,artesTO.getCodigo());
			pst.executeUpdate();
			pst.close();

		//	JOptionPane.showMessageDialog(null, (bn.getString("delecaoSucesso")) ,(bn.getString("messagem")), JOptionPane.INFORMATION_MESSAGE);     
		} 
		catch(Exception e) {
			//  e.printStackTrace();
			//JOptionPane.showMessageDialog(null, (bn.getString("delecaoErro")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE);  
		}    
	}


	//CONSULTA PARA DEPOIS EXCLUIR  
		public ArtesTO consultar(ArtesTO artesTO){

			codigo = artesTO.getCodigo();
			Connection conn = getConnection();  //cria a coneção com o banco.

			String sql = "select * from dadosCursoArtes where codigo=?"; //ira selecionar na tabela compromisso , a tabela com nome codigo e recebe ? 

			try{

				PreparedStatement pst = conn.prepareStatement(sql);   // usa esse prepared para evitar ataques de hackers 
				pst.setString(1, artesTO.getCodigo());
				ResultSet rs = pst.executeQuery(); //sempre q for fazer o select usar o executeQuerry

				if (rs.next()) {    

					artesTO.setCodigo(rs.getString("codigo"));
					artesTO.setNome(rs.getString(2)); // o resultset pega o conteudo da descricao e coloca em uma variavel p exibir
					artesTO.setDataInicio(rs.getString(3));
					artesTO.setDataTermino(rs.getString(4));
					artesTO.setHorario(rs.getString(5));
					artesTO.setNumeroVagas(rs.getString(6));
					artesTO.setValor(rs.getString(7));
					artesTO.setDescricaoMaterial(rs.getString(8));
					artesTO.setNomeLivrosUtilizados(rs.getString(9));          
					artesTO.setDisponibilidade(rs.getString(10));      
				}

				pst.close();     
				if(codigo.equals(artesTO.getCodigo())){
				//	TelaExcluirCursoArtes telaExcluir = new TelaExcluirCursoArtes(selecionado);
					//telaExcluir.dadosPreenchidoArtes(artesTO); 
					return artesTO;
				}
				else {
//					JOptionPane.showMessageDialog(null, (bn.getString("erroBuscarCodigo")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE); 
					System.out.println("erro banco...");
				}
			}   	
			catch(Exception e) {
				  e.printStackTrace();
				//JOptionPane.showMessageDialog(null, (bn.getString("erroAleatorio")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE);    
			}
			return artesTO;
		}   


		// ALTERA
		public void alterar(ArtesTO artesTO){ 
			codigo = artesTO.getCodigo();

			Connection conn = getConnection(); 
			String sql = "update dadosCursoArtes set nome=?, dataInicio=?, dataTermino=?, horario=?, numeroVagas=?, valor=?, descricaoMaterial=?, nomeLivrosUtilizados=?,disponibilidade=? where codigo= ?";

			try{

				PreparedStatement pst = conn.prepareStatement(sql);   // usa esse prepared para evitar ataques de hackers 

				pst.setString(1,artesTO.getNome());
				pst.setString(2,artesTO.getDataInicio());
				pst.setString(3,artesTO.getDataTermino());
				pst.setString(4,artesTO.getHorario());
				pst.setString(5,artesTO.getNumeroVagas());
				pst.setString(6,artesTO.getValor());
				pst.setString(7,artesTO.getDescricaoMaterial());
				pst.setString(8,artesTO.getNomeLivrosUtilizados());
				pst.setString(9,artesTO.getDisponibilidade());
				pst.setString(10,artesTO.getCodigo());

				pst.executeUpdate();
				pst.close();


				//JOptionPane.showMessageDialog(null, (bn.getString("alteracaoSucesso")) ,(bn.getString("messagem")), JOptionPane.INFORMATION_MESSAGE);     
			} 
			catch(Exception e) {
				 e.printStackTrace();
			//	JOptionPane.showMessageDialog(null, (bn.getString("alteracaoErro")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE); 
			}
		}




	/*















	//CONSULTAR POR CODIGO PARA DEPOIS ALTERAR  
	public void consultarAlterar(ArtesTO artesTO){

		codigo = artesTO.getCodigo();
		Connection conn = getConnection();  //cria a coneção com o banco.

		String sql = "select * from dadosCursoArtes where codigo=?"; //ira selecionar na tabela compromisso , a tabela com nome codigo e recebe ? 

		try{

			PreparedStatement pst = conn.prepareStatement(sql);   // usa esse prepared para evitar ataques de hackers 
			pst.setString(1,artesTO.getCodigo());
			ResultSet rs = pst.executeQuery(); //sempre q for fazer o select usar o executeQuerry

			if (rs.next()) {    

				artesTO.setCodigo(rs.getString("codigo"));
				artesTO.setNome(rs.getString(2)); // o resultset pega o conteudo da descricao e coloca em uma variavel p exibir
				artesTO.setDataInicio(rs.getString(3));
				artesTO.setDataTermino(rs.getString(4));
				artesTO.setHorario(rs.getString(5));
				artesTO.setNumeroVagas(rs.getString(6));
				artesTO.setValor(rs.getString(7));
				artesTO.setDescricaoMaterial(rs.getString(8));
				artesTO.setNomeLivrosUtilizados(rs.getString(9));          
				artesTO.setDisponibilidade(rs.getString(10));    

				artesConsulta = artesTO;

			}
			pst.close();     
			if(codigo.equals(artesTO.getCodigo())){
				TelaAlterarCursoArtes telaAlterar = new TelaAlterarCursoArtes(selecionado);
				telaAlterar.dadosPreenchidoArtes(artesTO);
			}
			else {
				JOptionPane.showMessageDialog(null, (bn.getString("erroBuscarCodigo")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE); 

			}
		}       

		catch(Exception e) {    
			//   e.printStackTrace();     
			JOptionPane.showMessageDialog(null, (bn.getString("erroAleatorio")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE); 
		}   
	}

	


	



	// CONSULTAR TODOS OS CURSOS

	public ArrayList<String> consultarTodosCursos() {
		// String vetor[] = new String[30];

		Connection conn = getConnection();  //cria a coneção com o banco.

		String sql = "select * from dadosCursoArtes";

		try{

			PreparedStatement pst = conn.prepareStatement(sql);   // usa esse prepared para evitar ataques de hackers 
			ResultSet rs = pst.executeQuery(); //sempre q for fazer o select usar o executeQuerry

			while (rs.next()) {
				dadosConsult.add(rs.getString(1));  
				dadosConsult.add(rs.getString(2)); // o resultset pega o conteudo da descricao e coloca em uma variavel p exibir
				dadosConsult.add(rs.getString(3));
				dadosConsult.add( rs.getString(4));
				dadosConsult.add( rs.getString(5));
				dadosConsult.add( rs.getString(6));
				dadosConsult.add( rs.getString(7));
				dadosConsult.add( rs.getString(8));
				dadosConsult.add(rs.getString(9));          
				dadosConsult.add( rs.getString(10));
			}
			pst.close();     
		}       

		catch(Exception e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, (bn.getString("erroAleatorio")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE); 

		}
		return dadosConsult; 
	}



	public ArrayList<String> buscarTodosCPF() {
		// String vetor[] = new String[30];

		Connection conn = getConnection();  //cria a coneção com o banco.

		String sql = "select codigo from dadosCursoArtes";

		try{

			PreparedStatement pst = conn.prepareStatement(sql);   // usa esse prepared para evitar ataques de hackers 
			//pst.setString(1,cpf);
			ResultSet rs = pst.executeQuery(); //sempre q for fazer o select usar o executeQuerry


			while (rs.next()) {

				buscaTodos.add(rs.getString("codigo"));  
			}
			pst.close();     
		}       

		catch(Exception e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, (bn.getString("erroAleatorio")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE); 

		}
		return buscaTodos; 
	}



	public String BuscaValor(String cursoA){
		// String vetor[] = new String[30];
		String codigo = cursoA;

		Connection conn = getConnection();  //cria a coneção com o banco.

		String sql = "select valor from dadosCursoArtes where codigo=?";


		try{

			PreparedStatement pst = conn.prepareStatement(sql);   // usa esse prepared para evitar ataques de hackers 
			pst.setString(1,codigo);
			ResultSet rs = pst.executeQuery(); //sempre q for fazer o select usar o executeQuerry


			while (rs.next()) {

				valor = rs.getString(1);

			}
			pst.close();     
		}       

		catch(Exception e) {
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, (bn.getString("erroAleatorio")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE); 

		}
		//DadosMatricula dMat = new DadosMatricula(selecionado);
		//dMat.calcularDesconto(quantidade); 
		return valor;
	}   
	 */
}//fecha classe