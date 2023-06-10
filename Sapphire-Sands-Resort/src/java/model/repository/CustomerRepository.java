/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.config.DBConnect;
import model.entity.Customer;

/**
 *
 * @author Admin
 */
public class CustomerRepository {
    
    public static void registerCustomer(Customer a) {
        try (Connection conn = DBConnect.getConnection()) {
            String query = "insert into Customer(cusID, cusName, cusDOB, cusPhone, cusEmail, cusCCCD, cusType) values (?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, a.getAccountID());
            ps.setString(2, a.getCusName());
            ps.setDate(3, a.getCusDOB());
            ps.setString(4, a.getCusPhone());
            ps.setString(5, a.getCusEmail());
            ps.setString(6, a.getCusCCCD());
            ps.setInt(7, a.getCusType());
            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Loi dang ky Customer trong CustomerRepository");
            System.out.println(e);
        }
    }
    
    public static Customer getCustomerByID(String id){
        try(Connection conn = DBConnect.getConnection()) {
            String query = "SELECT * FROM Account JOIN Customer ON accountID = cusID WHERE cusID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String accountID = rs.getString(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                boolean role = rs.getBoolean(4);
                String cusID = rs.getString(5);
                String cusName = rs.getString(6);
                Date cusDOB = rs.getDate(7);
                String cusPhone = rs.getString(8);
                String cusEmail = rs.getString(9);
                String cusCCCD = rs.getString(10);
                int cusType = rs.getInt(11);
                Customer cus = new Customer(accountID, username, password, role, cusID, cusDOB, cusPhone, cusEmail, cusCCCD, cusType);
                return cus;
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi getCustomerByID trong CustomerRepository");
        }
        return null;
    }
}
