package daoArtes;



import java.sql.Connection;

public interface Connect{

    public Connection getConnection();    
    public void closeConnection();
}