package daoAluno;

import javax.swing.JOptionPane;
import to.*;
import java.util.ArrayList;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import to.*;

public class AlunoDAO {
	
	protected String nome, endereco, telefone, cpf, rg, email, usuario, senha;  
	protected int selecionado;
	public ArrayList<String> buscaTodos = new ArrayList<String> ();
	//protected ResourceBundle bn = null;
	public AlunoTO alunoConsulta =null;
		
	
	
	//INSERIR	
	public void inserir(AlunoTO alunoTO){ 
		
	//	Connection conn = getConnection();
		String sql = "insert into dadosAluno set nome=?, endereco=?, telefone=?, cpf=?, rg=?, email=?, usuario=?, senha=? ";

	
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conn.prepareStatement(sql);) {
				
		//	PreparedStatement pst = conn.prepareStatement(sql);   // usa esse prepared para evitar ataques de hackers 
			pst.setString(1,alunoTO.getNome());
			pst.setString(2,alunoTO.getEndereco());
			pst.setString(3,alunoTO.getTelefone());
			pst.setString(4,alunoTO.getCpf());
			pst.setString(5,alunoTO.getRg());
			pst.setString(6,alunoTO.getEmail());
			pst.setString(7,alunoTO.getLogin());
			pst.setString(8,alunoTO.getSenha());

			pst.executeUpdate();
			pst.close();
			//JOptionPane.showMessageDialog(null, ("mensagemSucessoAlunoCriado") ,("messagemAluno"), JOptionPane.INFORMATION_MESSAGE); 
		 } 
		catch(Exception e) {
			System.out.println("erro na inserção do aluno");
			//e.printStackTrace();   		
			//JOptionPane.showMessageDialog(null, (bn.getString("mensagemErroAlunoCriado")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE);
		}
	}

	//CONSULTAR POR CPF 
	public AlunoTO consultarCPF(AlunoTO alunoTO){
		
	
		String sql = "select * from dadosAluno where cpf=?"; //ira selecionar na tabela compromisso , a tabela com nome codigo e recebe ? 
		 AlunoTO alunoCpfTO = new AlunoTO();

			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement pst = conn.prepareStatement(sql);) {
		
		   // usa esse prepared para evitar ataques de hackers 
			pst.setString(1, alunoTO.getCpf());
			ResultSet rs = pst.executeQuery(); //sempre q for fazer o select usar o executeQuerry

			if (rs.next()) {  
				alunoCpfTO.setNome(rs.getString(1));
				alunoCpfTO.setEndereco(rs.getString(2)); // o resultset pega o conteudo da descricao e coloca em uma variavel p exibir
				alunoCpfTO.setTelefone(rs.getString(3));
				alunoCpfTO.setCpf(rs.getString(4));
				alunoCpfTO.setRg(rs.getString(5));
				alunoCpfTO.setEmail(rs.getString(6));
				alunoCpfTO.setLogin(rs.getString(7));
				alunoCpfTO.setSenha(rs.getString(8));
				
				alunoConsulta = alunoCpfTO;
				//AlunoDAOTest test = new AlunoDAOTest();
				//test.Busca(alunoCpfTO);
			}
			pst.close();   
			if(alunoTO.getCpf().equals(alunoCpfTO.getCpf())){
			
				return alunoCpfTO;
			}
			else { 
				JOptionPane.showMessageDialog(null, ("erroAleatorio") , ("msgErro"), JOptionPane.ERROR_MESSAGE); 
			}
		}       

		catch(Exception e) {
			e.printStackTrace();            
			JOptionPane.showMessageDialog(null, ("cpfInexistente"), ("msgErro"), JOptionPane.ERROR_MESSAGE); 

		}
		return alunoCpfTO;
	}
	
	// DELETAR UM ALUNO
	public void deletar(AlunoTO alunoTO){

		//Connection conn = getConnection();

		String sql = "delete from dadosAluno where cpf =?";


		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conn.prepareStatement(sql);) {
	//		PreparedStatement pst = conn.prepareStatement(sql);   // usa esse prepared para evitar ataques de hackers 
			pst.setString(1,alunoTO.getCpf());
			pst.executeUpdate();
			pst.close();
			//JOptionPane.showMessageDialog(null, (bn.getString("sucessoExcluirAluno")),(bn.getString("messagemAluno")), JOptionPane.INFORMATION_MESSAGE);
		} 
		catch(Exception e) {
			//e.printStackTrace();
			//JOptionPane.showMessageDialog(null, (bn.getString("erroExcluirAluno")), (bn.getString("invalidoLog")), JOptionPane.ERROR_MESSAGE);
		}
	}

	
	

	// ALTERA
	public void alterar(AlunoTO alunoTO){ 

		String sql = "update dadosAluno set nome=?, endereco=?, telefone=?, rg=?, email=?, usuario=?, senha=? where cpf= ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conn.prepareStatement(sql);) {

			//PreparedStatement pst = conn.prepareStatement(sql);   // usa esse prepared para evitar ataques de hackers 
			pst.setString(1,alunoTO.getNome());
			pst.setString(2,alunoTO.getEndereco());
			pst.setString(3,alunoTO.getTelefone());
			pst.setString(4,alunoTO.getRg());
			pst.setString(5,alunoTO.getEmail());
			pst.setString(6,alunoTO.getLogin());
			pst.setString(7,alunoTO.getSenha());
			pst.setString(8,alunoTO.getCpf());
			pst.executeUpdate();
			pst.close();
		} 

		catch(Exception e) {
	//		JOptionPane.showMessageDialog(null, (bn.getString("erroAleatorio")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE); 
			e.printStackTrace();
		}
	}
	

	
	/*
	 * 

	//CONSULTAR POR CPF PARA DEPOIS ALTERAR  
	public void consultarAlterar(AlunoTO alunoTO){

		Connection conn = getConnection();  //cria a coneção com o banco.
		String sql = "select * from dadosAluno where cpf=?"; //ira selecionar na tabela compromisso , a tabela com nome codigo e recebe ? 

		AlunoTO AlunoCpfAlterarTO = new AlunoTO();
		try{

			PreparedStatement pst = conn.prepareStatement(sql);   // usa esse prepared para evitar ataques de hackers 
			pst.setString(1, alunoTO.getCpf());
			ResultSet rs = pst.executeQuery(); //sempre q for fazer o select usar o executeQuerry

			if (rs.next()) {    

				AlunoCpfAlterarTO.setNome(rs.getString(1));
				AlunoCpfAlterarTO.setEndereco(rs.getString(2)); // o resultset pega o conteudo da descricao e coloca em uma variavel p exibir
				AlunoCpfAlterarTO.setTelefone(rs.getString(3));
				AlunoCpfAlterarTO.setCpf(rs.getString(4));
				AlunoCpfAlterarTO.setRg(rs.getString(5));
				AlunoCpfAlterarTO.setEmail(rs.getString(6));
				AlunoCpfAlterarTO.setLogin(rs.getString(7));
				AlunoCpfAlterarTO.setSenha(rs.getString(8));

			}
			pst.close();   
			
			if(alunoTO.getCpf().equals(AlunoCpfAlterarTO.getCpf())){  
				TelaAlterar telaAlterar = new TelaAlterar(selecionado);
				telaAlterar.dadosPreenchido(AlunoCpfAlterarTO);
			}
			else{
				JOptionPane.showMessageDialog(null, (bn.getString("cpfInexistente")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE); 
			}
		}       

		catch(Exception e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, (bn.getString("erroAleatorio")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE); 
		}

	}


	public void consultarExcluir(AlunoTO alunoTO){
		
		Connection conn = getConnection();  //cria a coneção com o banco.
		
		String sql = "select * from dadosAluno where cpf=?"; //ira selecionar na tabela compromisso , a tabela com nome codigo e recebe ? 
		AlunoTO dadosPreenchidosTO = new AlunoTO();
		try{

			PreparedStatement pst = conn.prepareStatement(sql);   // usa esse prepared para evitar ataques de hackers 
			pst.setString(1,alunoTO.getCpf());
			ResultSet rs = pst.executeQuery(); //sempre q for fazer o select usar o executeQuerry

			if (rs.next()) {    

				dadosPreenchidosTO.setNome(rs.getString(1));
				dadosPreenchidosTO.setEndereco(rs.getString(2)); // o resultset pega o conteudo da descricao e coloca em uma variavel p exibir
				dadosPreenchidosTO.setTelefone(rs.getString(3));
				dadosPreenchidosTO.setCpf(rs.getString(4));
				dadosPreenchidosTO.setRg(rs.getString(5));
				dadosPreenchidosTO.setEmail(rs.getString(6));
				dadosPreenchidosTO.setLogin(rs.getString(7));
				dadosPreenchidosTO.setSenha(rs.getString(8));
			}

			pst.close();     
			if(alunoTO.getCpf().equals(dadosPreenchidosTO.getCpf())){
				TelaExcluir telaExcluir = new TelaExcluir(selecionado);
				telaExcluir.dadosPreenchido(dadosPreenchidosTO);
			}
			else { 
							JOptionPane.showMessageDialog(null, (bn.getString("cpfInexistente")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE); 
				
			}
		}       
		catch(Exception e) {         
			JOptionPane.showMessageDialog(null, (bn.getString("erroAleatorio")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE); 
			//  e.printStackTrace();
		} 
	}   



	public ArrayList<String> buscarTodosCPF() {
		// String vetor[] = new String[30];

		Connection conn = getConnection();  //cria a coneção com o banco.

		String sql = "select cpf from dadosAluno";

		try{

			PreparedStatement pst = conn.prepareStatement(sql);   // usa esse prepared para evitar ataques de hackers 
			//pst.setString(1,cpf);
			ResultSet rs = pst.executeQuery(); //sempre q for fazer o select usar o executeQuerry


			while (rs.next()) {

				buscaTodos.add(rs.getString("cpf"));  
			}
			pst.close();     
		}       

		catch(Exception e) {
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, (bn.getString("erroAleatorio")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE); 
		}
		return buscaTodos; 
	}
*/
	
}




