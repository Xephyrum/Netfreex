package netfreex2.pkg0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author James
 */

public class SQLUtilities {
    public static final String URL = "jdbc:sqlserver://localhost;databaseName=netfreexDB1;integratedSecurity=true;";
    public static Connection connection;
    
    public SQLUtilities(){
        
    }
    
    public static boolean Connect(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(URL);
            return true;
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
            return false;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public static boolean Disconnect(){
        try{
            connection.close();
            return true;
        }catch(SQLException ex){
            return false;
        }
    }
    
    public static ResultSet ExecuteQuery(PreparedStatement sql){
        try{
            System.out.println("Executing query");
            return sql.executeQuery();
        }catch(SQLException ex){
            Logger.getLogger(SQLUtilities.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}

