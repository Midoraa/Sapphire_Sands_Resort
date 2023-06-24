package model.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DBConnect {
    public static String user = "root";
    public static String password = "15082001"; 
    String url = "jdbc:mysql://localhost:3306/SapphireSands";
    
    public static Connection getConnection() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connect Database Success");
            return conn;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
            System.err.println("Error: Connection Database Fail!");
            return null;
        }
    }   
    
//    Test connection
    public static void main(String[] args) throws SQLException {
        Connection conn = DBConnect.getConnection();
        System.out.println(conn);
    }
}