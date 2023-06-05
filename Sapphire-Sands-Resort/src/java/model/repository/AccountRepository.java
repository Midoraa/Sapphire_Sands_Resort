/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.config.DBConnect;
import model.entity.Account;

/**
 *
 * @author Admin
 */
public class AccountRepository {
    
    public static String generateNewID() {
        String newID = null;
        try (Connection conn = DBConnect.getConnection()) {
            String selectQuery = "SELECT accountID FROM account WHERE accountID LIKE 'CUS%' ORDER BY accountID DESC LIMIT 1";
            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String lastID = resultSet.getString("accountID");
                int lastNumber = Integer.parseInt(lastID.substring(3));
                newID = "CUS" + String.format("%06d", lastNumber + 1);
            } else {
                newID = "CUS000001";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Loi generate ID trong AccountRepository!!!");
        }
        return newID;
    }
    
    public static boolean checkUserNameExist(String username) {
        try(Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("select * from Account  where username =?");
            stmt.setString(1, username);
            ResultSet resultSet = stmt.executeQuery();
            return resultSet.next();
        } catch (Exception e) {
            System.out.println("loi checkUserNameExsit(String userName) trong AccountRepository");
            e.printStackTrace();
        }
        return false;
    }

    public static void register(Account a) {
        try (Connection conn = DBConnect.getConnection()) {
            String query = "insert into account(accountID, username, password, role) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, a.getAccountID());
            ps.setString(2, a.getUsername());
            ps.setString(3, a.getPassword());
            ps.setBoolean(4, a.isRole());
            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Loi dang ky Account trong AccountRepository");
            System.out.println(e);
        }
    }

    public static Account login(String username, String password) {
        Account account = null;
        try (Connection conn = DBConnect.getConnection()) {
            String query = "SELECT * FROM Account WHERE username = ? and password = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Account a = new Account();
                a.setAccountID(rs.getString("accountID"));
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password"));
                a.setRole(rs.getBoolean("role"));
                return a;
            }
            rs.close();
            ps.close();
            conn.close();
            return null;
        } catch (Exception e) {
            System.out.println(e);
            System.err.println("Loi Database method login trong AccountRepository ");
        }
        return account;

    }

    public static void main(String[] args) {
        Account a = AccountRepository.login("adm1", "345");
        System.out.println(a.toString());
    }

}
