package inventory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
        static String url = "jdbc:mysql://localhost:3306/inventory";
    static String username = "root";
    static String password = "this";
    static Connection connection;
    public static Connection getDBConnection() {
        
        
        try {
          Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(url,username, password);


            return connection;
        } catch (Exception ex) {
            return null;
        }//
    }

    PreparedStatement prepareStatement(String sql) {
       PreparedStatement pst = null;
            try {
                getDBConnection();
                pst = connection.prepareStatement(sql);   
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
       return pst;
    }

    Statement createStatement() {
        Statement st=null;
            try {
                getDBConnection();
                st=connection.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        return st; 
    }
    
}
