/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public interface DBConnect {
    public static String user = "root";
    public static String password = "1234"; 
    String url = "jdbc:mysql://localhost:3306/SapphireSands";
    
    public static Connection getConnection() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Kết nối tới cơ sở dữ liệu thành công.");
            return conn;
        } catch (ClassNotFoundException ex) {
            System.out.println("Lỗi: " + ex.getMessage());
            return null;
        }
    }   
    
//    Test connection
    public static void main(String[] args) throws SQLException {
        Connection conn = DBConnect.getConnection();
        System.out.println(conn);
    }
}
