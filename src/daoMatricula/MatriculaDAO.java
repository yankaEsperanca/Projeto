package daoMatricula;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.MatriculaTO;


public class MatriculaDAO {

	protected String data, valor, statusPagamento, statusMatricula, aluno,curso;  
	protected int selecionado, codigo;
	protected ArrayList<String> dadosConsult = new ArrayList<String> ();
	public ArrayList<String> buscaTodos = new ArrayList<String> ();
	//protected ResourceBundle bn = null;  
//	public MatriculaTO artesConsulta=null;


	public ArrayList<MatriculaTO> listarMatricula() {
		MatriculaTO matriculaTO;
		ArrayList<MatriculaTO> lista = new ArrayList<>();
		String sqlSelect = "select * from dadosMatricula"; 
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					matriculaTO = new MatriculaTO();
					
					matriculaTO.setCodigo(rs.getInt("codigo"));
					matriculaTO.setData(rs.getString(2)); // o resultset pega o conteudo da descricao e coloca em uma variavel p exibir
					matriculaTO.setValor(rs.getString(3));
					matriculaTO.setStatusPagamento(rs.getString(4));
					matriculaTO.setStatusMatricula(rs.getString(5));
					matriculaTO.setAluno(rs.getString(6));
					matriculaTO.setCurso(rs.getString(7));
					lista.add(matriculaTO);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	public ArrayList<MatriculaTO> listarMatriculaAluno(String chave) {
		MatriculaTO matriculaTO;
		ArrayList<MatriculaTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT codigo, data, valor, statusPagamento, statusMatricula, aluno, curso FROM dadosMatricula where upper(aluno) like ?";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
				
					matriculaTO = new MatriculaTO();
					
					matriculaTO.setCodigo(rs.getInt("codigo"));
					matriculaTO.setData(rs.getString(2)); // o resultset pega o conteudo da descricao e coloca em uma variavel p exibir
					matriculaTO.setValor(rs.getString(3));
					matriculaTO.setStatusPagamento(rs.getString(4));
					matriculaTO.setStatusMatricula(rs.getString(5));
					matriculaTO.setAluno(rs.getString(6));
					matriculaTO.setCurso(rs.getString(7));
					lista.add(matriculaTO);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	

	public ArrayList<MatriculaTO> listarMatriculaCodigo(String chave) {
		MatriculaTO matriculaTO;
		ArrayList<MatriculaTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT codigo, data, valor, statusPagamento, statusMatricula, aluno, curso FROM dadosMatricula where upper(codigo) like ?";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
				
					matriculaTO = new MatriculaTO();
					
					matriculaTO.setCodigo(rs.getInt("codigo"));
					matriculaTO.setData(rs.getString(2)); // o resultset pega o conteudo da descricao e coloca em uma variavel p exibir
					matriculaTO.setValor(rs.getString(3));
					matriculaTO.setStatusPagamento(rs.getString(4));
					matriculaTO.setStatusMatricula(rs.getString(5));
					matriculaTO.setAluno(rs.getString(6));
					matriculaTO.setCurso(rs.getString(7));
					lista.add(matriculaTO);
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
	public void inserir(MatriculaTO matriculaTO){ 

		
		String sqlInsert = "insert into dadosMatricula (data, valor, statusPagamento, statusMatricula, aluno, curso)VALUES (?,?,?,?,?,?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conn.prepareStatement(sqlInsert);) {
			
		//	pst.setInt(1,MatriculaTO.getCodigo());
			pst.setString(1,matriculaTO.getData());
			pst.setString(2,matriculaTO.getValor());
			pst.setString(3,matriculaTO.getStatusPagamento());
			pst.setString(4,matriculaTO.getStatusMatricula());
			pst.setString(5,matriculaTO.getAluno());
			pst.setString(6,matriculaTO.getCurso());
			pst.execute();
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						matriculaTO.setCodigo(rs.getInt(1));
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	
	// DELETAR UM ALUNO
	public void deletar(MatriculaTO matriculaTO){

		String sqlDelete = "DELETE from dadosMatricula where codigo=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conn.prepareStatement(sqlDelete);) {
			
			pst.setInt(1, matriculaTO.getCodigo());
			pst.executeUpdate();

		//	JOptionPane.showMessageDialog(null, (bn.getString("delecaoSucesso")) ,(bn.getString("messagem")), JOptionPane.INFORMATION_MESSAGE);     
		} 
		catch(Exception e) {
			  e.printStackTrace();
			//JOptionPane.showMessageDialog(null, (bn.getString("delecaoErro")) , (bn.getString("msgErro")), JOptionPane.ERROR_MESSAGE);  
		}    
	}

	

		// ALTERA
		public void alterar(MatriculaTO matriculaTO){ 
			codigo = matriculaTO.getCodigo();
			String sqlUpdate = "update dadosMatricula set data=?, valor=?, statusPagamento=?, statusMatricula=?, aluno=?, curso=? where codigo= ?";
			try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conn.prepareStatement(sqlUpdate);) {
				
				pst.setString(1,matriculaTO.getData());
				pst.setString(2,matriculaTO.getValor());
				pst.setString(3,matriculaTO.getStatusPagamento());
				pst.setString(4,matriculaTO.getStatusMatricula());
				pst.setString(5,matriculaTO.getAluno());
				pst.setString(6,matriculaTO.getCurso());
				pst.setInt(7,matriculaTO.getCodigo());

				pst.executeUpdate();
		} 
			catch(Exception e) {
				 e.printStackTrace();
				}
		}

// id == codigo		
		public MatriculaTO carregar(MatriculaTO matriculaTO ) {
			MatriculaTO to = new MatriculaTO();
			to.setCodigo(matriculaTO.getCodigo());
			codigo = matriculaTO.getCodigo();
			String sqlSelect = "SELECT data, valor, statusPagamento, statusMatricula, aluno, curso FROM dadosMatricula WHERE codigo= ?";
			
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, codigo);
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {					
					
						to.setData(rs.getString(1)); // o resultset pega o conteudo da descricao e coloca em uma variavel p exibir
						to.setValor(rs.getString(2));
						to.setStatusPagamento(rs.getString(3));
						to.setStatusMatricula(rs.getString(4));
						to.setAluno(rs.getString(5));
						to.setCurso(rs.getString(6));
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
