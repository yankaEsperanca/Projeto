package daoUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import factory.ConnectionFactory;
import to.UsuarioTO;

public class UsuarioDAO {
	public boolean validar(UsuarioTO to) {
		String sqlSelect = "SELECT usuario, senha FROM login "+
				"WHERE usuario = ? and senha = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, to.getUsuario());
			stm.setString(2, to.getSenha());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return false;
	}

}
