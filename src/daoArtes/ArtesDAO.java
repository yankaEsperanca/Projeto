package daoArtes;

import java.sql.*;
import to.*;
import java.util.*;


public class ArtesDAO {
	protected String nome, dataInicio, dataTermino, horario, numeroVagas, valor, descricaoMaterial, nomeLivrosUtilizados,disponibilidade;  
	protected int selecionado, codigo;
	protected ArrayList<String> dadosConsult = new ArrayList<String> ();
	public ArrayList<String> buscaTodos = new ArrayList<String> ();
	//protected ResourceBundle bn = null;  
//	public ArtesTO artesConsulta=null;


	
	public ArrayList<ArtesTO> listarCursoArtes() {
		ArtesTO artesTO;
		ArrayList<ArtesTO> lista = new ArrayList<>();
		String sqlSelect = "select * from dadosCursoArtes"; 
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					artesTO = new ArtesTO();
					
					artesTO.setCodigo(rs.getInt("codigo"));
					artesTO.setNome(rs.getString(2)); // o resultset pega o conteudo da descricao e coloca em uma variavel p exibir
					artesTO.setDataInicio(rs.getString(3));
					artesTO.setDataTermino(rs.getString(4));
					artesTO.setHorario(rs.getString(5));
					artesTO.setNumeroVagas(rs.getString(6));
					artesTO.setValor(rs.getString(7));
					artesTO.setDescricaoMaterial(rs.getString(8));
					artesTO.setNomeLivrosUtilizados(rs.getString(9));          
					artesTO.setDisponibilidade(rs.getString(10));      
					lista.add(artesTO);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	public ArrayList<ArtesTO> listarCursoArtes(String chave) {
		ArtesTO artesTO;
		ArrayList<ArtesTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT codigo, nome, dataInicio, dataTermino, horario, numeroVagas, valor, descricaoMaterial, nomeLivrosUtilizados, disponibilidade  FROM dadosCursoArtes where upper(nome) like ?";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
				
					artesTO = new ArtesTO();
					
					artesTO.setCodigo(rs.getInt("codigo"));
					artesTO.setNome(rs.getString(2)); // o resultset pega o conteudo da descricao e coloca em uma variavel p exibir
					artesTO.setDataInicio(rs.getString(3));
					artesTO.setDataTermino(rs.getString(4));
					artesTO.setHorario(rs.getString(5));
					artesTO.setNumeroVagas(rs.getString(6));
					artesTO.setValor(rs.getString(7));
					artesTO.setDescricaoMaterial(rs.getString(8));
					artesTO.setNomeLivrosUtilizados(rs.getString(9));          
					artesTO.setDisponibilidade(rs.getString(10));      
					lista.add(artesTO);
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
	public void inserir(ArtesTO artesTO){ 

		
		String sqlInsert = "insert into dadosCursoArtes (nome, dataInicio, dataTermino, horario, numeroVagas, valor, descricaoMaterial, nomeLivrosUtilizados, disponibilidade) VALUES (?,?,?,?,?,?,?,?,?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conn.prepareStatement(sqlInsert);) {
			
		//	pst.setInt(1,artesTO.getCodigo());
			pst.setString(1,artesTO.getNome());
			pst.setString(2,artesTO.getDataInicio());
			pst.setString(3,artesTO.getDataTermino());
			pst.setString(4,artesTO.getHorario());
			pst.setString(5,artesTO.getNumeroVagas());
			pst.setString(6,artesTO.getValor());
			pst.setString(7,artesTO.getDescricaoMaterial());
			pst.setString(8,artesTO.getNomeLivrosUtilizados());
			pst.setString(9,artesTO.getDisponibilidade());
			pst.execute();
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						artesTO.setCodigo(rs.getInt(1));
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	
	// DELETAR UM ALUNO
	public void deletar(ArtesTO artesTO){

		String sqlDelete = "DELETE from dadosCursoArtes where codigo=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conn.prepareStatement(sqlDelete);) {
			
			pst.setInt(1, artesTO.getCodigo());
			pst.executeUpdate();

		//	JOptionPane.showMessageDialog(null, (bn.getString("delecaoSucesso")) ,(bn.getString("messagem")), JOptionPane.INFORMATION_MESSAGE);     
		} 
		catch(Exception e) {
			  e.printStackTrace();
			//JOptionPane.showMessageDialog(null, (bn.getString("delecaoErro")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE);  
		}    
	}

	

		// ALTERA
		public void alterar(ArtesTO artesTO){ 
			codigo = artesTO.getCodigo();
			String sqlUpdate = "update dadosCursoArtes set nome=?, dataInicio=?, dataTermino=?, horario=?, numeroVagas=?, valor=?, descricaoMaterial=?, nomeLivrosUtilizados=?,disponibilidade=? where codigo= ?";
			try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conn.prepareStatement(sqlUpdate);) {
				
				pst.setString(1,artesTO.getNome());
				pst.setString(2,artesTO.getDataInicio());
				pst.setString(3,artesTO.getDataTermino());
				pst.setString(4,artesTO.getHorario());
				pst.setString(5,artesTO.getNumeroVagas());
				pst.setString(6,artesTO.getValor());
				pst.setString(7,artesTO.getDescricaoMaterial());
				pst.setString(8,artesTO.getNomeLivrosUtilizados());
				pst.setString(9,artesTO.getDisponibilidade());
				pst.setInt(10,artesTO.getCodigo());

				pst.executeUpdate();
		} 
			catch(Exception e) {
				 e.printStackTrace();
				}
		}

// id == codigo		
		public ArtesTO carregar(ArtesTO ArtesTO ) {
			ArtesTO to = new ArtesTO();
			to.setCodigo(ArtesTO.getCodigo());
			codigo = ArtesTO.getCodigo();
			String sqlSelect = "SELECT nome, dataInicio, dataTermino, horario, numeroVagas, valor, descricaoMaterial, nomeLivrosUtilizados, disponibilidade  FROM dadosCursoArtes WHERE codigo= ?";
			
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, codigo);
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {					
					
						to.setNome(rs.getString(1)); // o resultset pega o conteudo da descricao e coloca em uma variavel p exibir
						to.setDataInicio(rs.getString(2));
						to.setDataTermino(rs.getString(3));
						to.setHorario(rs.getString(4));
						to.setNumeroVagas(rs.getString(5));
						to.setValor(rs.getString(6));
						to.setDescricaoMaterial(rs.getString(7));
						to.setNomeLivrosUtilizados(rs.getString(8));          
						to.setDisponibilidade(rs.getString(9));      
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return to;
		}
	}
