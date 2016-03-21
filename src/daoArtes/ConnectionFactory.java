package daoArtes;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConnectionFactory implements Connect {

   // atributo
   public Connection conn;

  	  // construtor (usar no pc de casa)
    public ConnectionFactory() {
      conn            = null;
      String url      = "jdbc:mysql://127.0.0.1:3306/"; // localizacao do servidor
      String dbName   = "cursoArtes";                    // nome do banco de dados
      String driver   = "com.mysql.jdbc.Driver";   // nome do driver de conexao
      String userName = "root";                    // nome do usuario do banco
      String password = "alunos";                    // respectiva senha
  
	 
//usar na facu 
	 /* public ConnectionFactory() {
        conn            = null;
	     String url      = "jdbc:mysql://localhost/"; // localizacao do servidor
        String dbName   = "aluno";                    // nome do banco de dados
        String driver   = "com.mysql.jdbc.Driver";   // nome do driver de conexao
        String userName = "root";                    // nome do usuario do banco
//        String password = "";                    // respectiva senha
        String password = "mysql@2012";                    // respectiva senha
        		// ou  sa senha � alunos
	*/ 
	     
      try {
         Class.forName(driver);
         conn = DriverManager.getConnection(url + dbName, userName, password);
      }
      catch (Exception e) {
         JOptionPane.showMessageDialog(
                     null,
                    "Erro no Banco de Dados!\n\nContate seu Administrador do Sistema!",
                    "Erro...",
                    JOptionPane.WARNING_MESSAGE
            );
            
         e.printStackTrace();
      }
   }
    
    // fornece a conexão com o banco de dados Mysql
   public Connection getConnection(){
      return conn;
   }
   
     
    //Fecha a conecção com bco de dados
   public void closeConnection() {
      try                { 
         conn.close(); 
      }
      catch(Exception e) { 
         e.printStackTrace(); 
      }
        
   }  
}