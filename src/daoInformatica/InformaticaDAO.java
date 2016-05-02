package daoInformatica;

import java.sql.*;


import to.InformaticaTO;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import daoInformatica.ConnectionFactory;


public class InformaticaDAO  {
	
	protected String nome, dataInicio, dataTermino, horario, numeroVagas, valor, numeroLab, registroSoft,disponibilidade;  
	protected int selecionado, codigo;
	protected ArrayList<String> dadosConsult = new ArrayList<String> ();
	public ArrayList<String> buscaTodos = new ArrayList<String> ();
	//	protected ResourceBundle bn = null;  
	public InformaticaTO infoConsulta=null;

	
	
	public ArrayList<InformaticaTO> listarCursoInformatica() {
		InformaticaTO to;
		ArrayList<InformaticaTO> lista = new ArrayList<>();
		String sqlSelect = "select * from dadosCursoInformatica"; 
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new InformaticaTO();
					
				
			
					to.setCodigo(rs.getInt("codigo"));
					to.setNome(rs.getString(2)); // o resultset pega o conteudo da descricao e coloca em uma variavel p exibir
					to.setDataInicio(rs.getString(3));
					to.setDataTermino(rs.getString(4));
					to.setHorario(rs.getString(5));
					to.setNumeroVagas(rs.getString(6));
					to.setValor(rs.getString(7));
					to.setNumeroLab(rs.getString(8));
					to.setRegistroSoft(rs.getString(9));          
					to.setDisponibilidade(rs.getString(10));      
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	public ArrayList<InformaticaTO> listarCursoInformatica(String chave) {
		InformaticaTO to;
		ArrayList<InformaticaTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT codigo, nome, dataInicio, dataTermino, horario, numeroVagas, valor, numeroLab, registroSoft, disponibilidade  FROM dadosCursoInformatica where upper(nome) like ?";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
				
					to = new InformaticaTO();
					
					to.setCodigo(rs.getInt("codigo"));
					to.setNome(rs.getString(2)); // o resultset pega o conteudo da descricao e coloca em uma variavel p exibir
					to.setDataInicio(rs.getString(3));
					to.setDataTermino(rs.getString(4));
					to.setHorario(rs.getString(5));
					to.setNumeroVagas(rs.getString(6));
					to.setValor(rs.getString(7));
					to.setNumeroLab(rs.getString(8));
					to.setRegistroSoft(rs.getString(9));          
					to.setDisponibilidade(rs.getString(10));      
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	//INSERIR	
	public void inserir(InformaticaTO infoTO){ 

		String sqlInsert = "INSERT INTO dadosCursoInformatica (nome, dataInicio, dataTermino, horario, numeroVagas, valor, numeroLab, registroSoft, disponibilidade)  VALUES (?,?,?,?,?,?,?,?,?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conn.prepareStatement(sqlInsert);) {

			//PreparedStatement pst = conn.prepareStatement(sql);   // usa esse prepared para evitar ataques de hackers 
	//		pst.setInt(1,infoTO.getCodigo());
			pst.setString(1,infoTO.getNome());
			pst.setString(2,infoTO.getDataInicio());
			pst.setString(3,infoTO.getDataTermino());
			pst.setString(4,infoTO.getHorario());
			pst.setString(5,infoTO.getNumeroVagas());
			pst.setString(6,infoTO.getValor());
			pst.setString(7,infoTO.getNumeroLab());
			pst.setString(8,infoTO.getRegistroSoft());
			pst.setString(9,infoTO.getDisponibilidade());
			pst.execute();
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						infoTO.setCodigo(rs.getInt(1));
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	// DELETAR UM CURSO
	public void deletar(InformaticaTO infoTO){

		//	Connection conn = getConnection();

		String sqlDelete = "delete from dadosCursoInformatica where codigo=?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conn.prepareStatement(sqlDelete);) {
			pst.setInt(1,infoTO.getCodigo());
			pst.executeUpdate();
			} 
			catch(Exception e) {
				  e.printStackTrace();
			}    
		}



	// ALTERA
	public void alterar(InformaticaTO infoTO){ 
		codigo = infoTO.getCodigo();
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
			pst.setInt(10,infoTO.getCodigo());
			pst.execute();

		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	//id == codigo
	public InformaticaTO carregar(InformaticaTO infoTO) {
		InformaticaTO too = new InformaticaTO();
		too.setCodigo(infoTO.getCodigo());
		codigo = infoTO.getCodigo();
		String sqlSelect = "SELECT nome, dataInicio, dataTermino, horario, numeroVagas, valor,  numeroLab, registroSoft, disponibilidade  FROM dadosCursoInformatica where codigo=?";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, codigo);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {					
					too.setNome(rs.getString(1)); // o resultset pega o conteudo da descricao e coloca em uma variavel p exibir
					too.setDataInicio(rs.getString(2));
					too.setDataTermino(rs.getString(3));
					too.setHorario(rs.getString(4));
					too.setNumeroVagas(rs.getString(5));
					too.setValor(rs.getString(6));
					too.setNumeroLab(rs.getString(7));
					too.setRegistroSoft(rs.getString(8));          
					too.setDisponibilidade(rs.getString(9));      
					
		
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return too;
	}
	
	
	public InformaticaTO consultar(InformaticaTO infoTO){
		
		
		String sql = "select * from dadosCursoInformatica where codigo=?"; //ira selecionar na tabela compromisso , a tabela com nome codigo e recebe ? 
		 InformaticaTO to = new InformaticaTO();

			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement pst = conn.prepareStatement(sql);) {
		
		   // usa esse prepared para evitar ataques de hackers 
			pst.setInt(1, to.getCodigo());
			ResultSet rs = pst.executeQuery(); //sempre q for fazer o select usar o executeQuerry

			if (rs.next()) {
				to.setCodigo(rs.getInt(1));
				to.setNome(rs.getString(2)); // o resultset pega o conteudo da descricao e coloca em uma variavel p exibir
				to.setDataInicio(rs.getString(3));
				to.setDataTermino(rs.getString(4));
				to.setHorario(rs.getString(5));
				to.setNumeroVagas(rs.getString(6));
				to.setValor(rs.getString(7));
				to.setNumeroLab(rs.getString(8));
				to.setRegistroSoft(rs.getString(9));          
				to.setDisponibilidade(rs.getString(10));      
				
				infoConsulta = to;
				//AlunoDAOTest test = new AlunoDAOTest();
				//test.Busca(alunoCpfTO);
				
				
				
			}
			pst.close();   
			if(infoTO.getCodigo() == (to.getCodigo())){
			
				return to;
			}
			else { 
				JOptionPane.showMessageDialog(null, ("erroAleatorio") , ("msgErro"), JOptionPane.ERROR_MESSAGE); 
			}
		}       

		catch(Exception e) {
			e.printStackTrace();            
			JOptionPane.showMessageDialog(null, ("cpfInexistente"), ("msgErro"), JOptionPane.ERROR_MESSAGE); 

		}
		return to;
	}
	
	
}

