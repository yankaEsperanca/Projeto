package daoInformatica;

import java.sql.*;
import to.InformaticaTO;
import java.util.ArrayList;
import daoInformatica.ConnectionFactory;


public class InformaticaDAO  {
	protected String codigo, nome, dataInicio, dataTermino, horario, numeroVagas, valor, numeroLab, registroSoft,disponibilidade;  
	protected int selecionado;
	protected ArrayList<String> dadosConsult = new ArrayList<String> ();
	public ArrayList<String> buscaTodos = new ArrayList<String> ();
	//	protected ResourceBundle bn = null;  
	public InformaticaTO infoConsulta=null;

	//INSERIR	
	public String inserir(InformaticaTO infoTO){ 

		//Connection conn = getConnection();
		String sql = "insert into dadosCursoInformatica set codigo=?, nome=?, dataInicio=?, dataTermino=?, horario=?, numeroVagas=?, valor=?, numeroLab=?, registroSoft=?, disponibilidade=? ";
		String resp;

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conn.prepareStatement(sql);) {

			//PreparedStatement pst = conn.prepareStatement(sql);   // usa esse prepared para evitar ataques de hackers 
			pst.setString(1,infoTO.getCodigo());
			pst.setString(2,infoTO.getNome());
			pst.setString(3,infoTO.getDataInicio());
			pst.setString(4,infoTO.getDataTermino());
			pst.setString(5,infoTO.getHorario());
			pst.setString(6,infoTO.getNumeroVagas());
			pst.setString(7,infoTO.getValor());
			pst.setString(8,infoTO.getNumeroLab());
			pst.setString(9,infoTO.getRegistroSoft());
			pst.setString(10,infoTO.getDisponibilidade());
			pst.executeUpdate();
			pst.close();


			//		JOptionPane.showMessageDialog(null, (bn.getString("mensagemCursoCriado")) ,(bn.getString("messagem")), JOptionPane.INFORMATION_MESSAGE);     
			resp = "Curso inserido com sucesso";
		} 
		catch(Exception e) {
			//	System.out.println("erro inserir");
			resp = "Erro ao inserir curso";
			//	JOptionPane.showMessageDialog(null, (bn.getString("mensagemErroCurso")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE); 
			//   e.printStackTrace();// serve para exibir o erro      
		}
		return resp;
	}

	// DELETAR UM CURSO
	public void deletar(InformaticaTO infoTO){

		//	Connection conn = getConnection();

		String sql = "delete from dadosCursoInformatica where codigo=?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conn.prepareStatement(sql);) {
			//	PreparedStatement pst = conn.prepareStatement(sql);   // usa esse prepared para evitar ataques de hackers 
			pst.setString(1,infoTO.getCodigo());
			pst.executeUpdate();
			pst.close();

			//JOptionPane.showMessageDialog(null, (bn.getString("delecaoSucesso")) ,(bn.getString("messagem")), JOptionPane.INFORMATION_MESSAGE);     

		} 
		catch(Exception e) {
			//e.printStackTrace();
			//JOptionPane.showMessageDialog(null, (bn.getString("delecaoErro")) ,(bn.getString("messagem")), JOptionPane.INFORMATION_MESSAGE);     

		}  
	}




	//CONSULTA PARA DEPOIS EXCLUIR  
	public InformaticaTO consultar(InformaticaTO infoTO){

		codigo = infoTO.getCodigo();
		//	Connection conn = getConnection();  //cria a coneção com o banco.

		String sql = "select * from dadosCursoInformatica where codigo=?"; //ira selecionar na tabela compromisso , a tabela com nome codigo e recebe ? 

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conn.prepareStatement(sql);) {

			//PreparedStatement pst = conn.prepareStatement(sql);   // usa esse prepared para evitar ataques de hackers 
			pst.setString(1,codigo);
			ResultSet rs = pst.executeQuery(); //sempre q for fazer o select usar o executeQuerry

			if (rs.next()) {    

				infoTO.setCodigo(rs.getString("codigo"));
				infoTO.setNome(rs.getString(2)); // o resultset pega o conteudo da descricao e coloca em uma variavel p exibir
				infoTO.setDataInicio(rs.getString(3));
				infoTO.setDataTermino(rs.getString(4));
				infoTO.setHorario(rs.getString(5));
				infoTO.setNumeroVagas(rs.getString(6));
				infoTO.setValor(rs.getString(7));
				infoTO.setNumeroLab(rs.getString(8));
				infoTO.setRegistroSoft(rs.getString(9));          
				infoTO.setDisponibilidade(rs.getString(10));
			}
			pst.close();     
			if(codigo.equals(infoTO.getCodigo())){
				//	TelaExcluirCursoInformatica telaExcluir = new TelaExcluirCursoInformatica(selecionado);
				//	telaExcluir.dadosPreenchido(infoTO); 
				return infoTO;
			}
			else {
				//	JOptionPane.showMessageDialog(null, (bn.getString("erroBuscarCodigo")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE); 
				System.out.println("erro banco ");
			}   	
		}
		catch(Exception e) {
			e.printStackTrace();
			//JOptionPane.showMessageDialog(null, (bn.getString("erroAleatorio")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE); 
		}
		return infoTO;
	}   


	// ALTERA
	public void alterar(InformaticaTO infoTO){ 
		codigo = infoTO.getCodigo();

		//	Connection conn = getConnection(); 
		String sql = "update dadosCursoInformatica set nome=?, dataInicio=?, dataTermino=?, horario=?, numeroVagas=?, valor=?, numeroLab=?, registroSoft=?,disponibilidade=? where codigo=?";  

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setString(1,infoTO.getNome());
			pst.setString(2,infoTO.getDataInicio());
			pst.setString(3,infoTO.getDataTermino());
			pst.setString(4,infoTO.getHorario());
			pst.setString(5,infoTO.getNumeroVagas());
			pst.setString(6,infoTO.getValor());
			pst.setString(7,infoTO.getNumeroLab());
			pst.setString(8,infoTO.getRegistroSoft());
			pst.setString(9,infoTO.getDisponibilidade());
			pst.setString(10,infoTO.getCodigo());
			pst.executeUpdate();
			pst.close();

			//JOptionPane.showMessageDialog(null, (bn.getString("alteracaoSucesso")) ,(bn.getString("messagem")), JOptionPane.INFORMATION_MESSAGE);             
		} 
		catch(Exception e) {
			e.printStackTrace();
			//JOptionPane.showMessageDialog(null, (bn.getString("alteracaoErro")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE); 

		}
	}








	/*	//CONSULTAR POR CODIGO PARA DEPOIS ALTERAR  
	public void consultarAlterar(InformaticaTO infoTO){

		codigo = infoTO.getCodigo();
		Connection conn = getConnection();  //cria a coneção com o banco.

		String sql = "select * from dadosCursoInformatica where codigo=?"; //ira selecionar na tabela compromisso , a tabela com nome codigo e recebe ? 

		try{

			PreparedStatement pst = conn.prepareStatement(sql);   // usa esse prepared para evitar ataques de hackers 
			pst.setString(1,codigo);
			ResultSet rs = pst.executeQuery(); //sempre q for fazer o select usar o executeQuerry

			if (rs.next()) {    

				infoTO.setCodigo(rs.getString("codigo"));
				infoTO.setNome(rs.getString(2)); // o resultset pega o conteudo da descricao e coloca em uma variavel p exibir
				infoTO.setDataInicio(rs.getString(3));
				infoTO.setDataTermino(rs.getString(4));
				infoTO.setHorario(rs.getString(5));
				infoTO.setNumeroVagas(rs.getString(6));
				infoTO.setValor(rs.getString(7));
				infoTO.setNumeroLab(rs.getString(8));
				infoTO.setRegistroSoft(rs.getString(9));          
				infoTO.setDisponibilidade(rs.getString(10));

				infoConsulta=infoTO;

			}
			pst.close();    
			if(codigo.equals(infoTO.getCodigo())){
				TelaAlterarCursoInformatica telaAlterar = new TelaAlterarCursoInformatica(selecionado);
				telaAlterar.dadosPreenchido(infoTO);
			}
			else {
				JOptionPane.showMessageDialog(null, (bn.getString("erroBuscarCodigo")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE); 

			}   	
		}  


		catch(Exception e) {

			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, (bn.getString("erroAleatorio")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE); 

		}   
	}




	// CONSULTAR TODOS OS CURSOS
	public ArrayList<String> consultarTodosCursos() {
		// String vetor[] = new String[30];
		int cont =1 ;
		Connection conn = getConnection();  //cria a coneção com o banco.

		String sql = "select * from dadosCursoInformatica";

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
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, (bn.getString("erroAleatorio")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE); 

		}
		return dadosConsult; 
	}

	public ArrayList<String> buscarTodosCPF() {
		// String vetor[] = new String[30];

		Connection conn = getConnection();  //cria a coneção com o banco.

		String sql = "select codigo from dadosCursoInformatica";

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
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, (bn.getString("erroAleatorio")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE); 

		}
		return buscaTodos; 
	}



	public String BuscaValor(String cursoI){
		// String vetor[] = new String[30];
		String codigo = cursoI;

		Connection conn = getConnection();  //cria a coneção com o banco.

		String sql = "select valor from dadosCursoInformatica where codigo=?";


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
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, (bn.getString("erroAleatorio")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE); 

		}
		//DadosMatricula dMat = new DadosMatricula(selecionado);
		//dMat.calcularDesconto(quantidade); 
		return valor;
	}
	 */
}


