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
import java.sql.SQLException;
import model.config.DBConnect;
import model.entity.Customer;

/**
 *
 * @author Admin
 */
public class CustomerRepository {

    public static Customer login(String username, String password) {
        try (Connection conn = DBConnect.getConnection()) {
            String query = "SELECT * FROM Account JOIN Customer ON Account.accountID = Customer.cusID WHERE Account.username = ? AND Account.password = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Customer cus = new Customer();
                cus.setAccountID(rs.getString("accountID"));
                cus.setUsername(rs.getString("username"));
                cus.setPassword(rs.getString("password"));
                cus.setRole(rs.getInt("role"));
                cus.setCusID(rs.getString("cusID"));
                cus.setCusName(rs.getString("cusName"));
                cus.setCusDOB(rs.getDate("cusDOB"));
                cus.setCusPhone(rs.getString("cusPhone"));
                cus.setCusEmail(rs.getString("cusEmail"));
                cus.setCusCCCD(rs.getString("cusCCCD"));
                cus.setCusType(rs.getInt("cusType"));
                return cus;
            }
            rs.close();
            ps.close();
            conn.close();
            return null;
        } catch (Exception e) {
            System.out.println(e);
            System.err.println("Loi Database method login trong CustomerRepository ");
        }
        return null;

    }

    public static void registerCustomer(Customer a) {
        System.out.println(a);
        try (Connection conn = DBConnect.getConnection()) {
            String accountQuery = "INSERT INTO Account(accountID, username, password, role) VALUES (?, ?, ?, ?);";
            PreparedStatement psa = conn.prepareStatement(accountQuery);
            psa.setString(1, a.getAccountID());
            psa.setString(2, a.getUsername());
            psa.setString(3, a.getPassword());
            psa.setInt(4, a.getRole());
            psa.executeUpdate(); // thiếu dòng ni đm mày :)
            psa.close();
            insertCustomer(a);
        } catch (Exception e) {
            System.out.println("Loi dang ky Customer trong CustomerRepository");
            System.out.println(e);
        }
    }

    public static Customer getCustomerByID(String id) {
        try (Connection conn = DBConnect.getConnection()) {
            String query = "SELECT * FROM Account JOIN Customer ON accountID = cusID WHERE cusID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String accountID = rs.getString(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                int role = rs.getInt(4);
                String cusID = rs.getString(5);
                String cusName = rs.getString(6);
                Date cusDOB = rs.getDate(7);
                String cusPhone = rs.getString(8);
                String cusEmail = rs.getString(9);
                String cusCCCD = rs.getString(10);
                int cusType = rs.getInt(11);
                Customer cus = new Customer(accountID, username, password, role, cusID, cusName, cusDOB, cusPhone, cusEmail, cusCCCD, cusType);
                return cus;
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi getCustomerByID trong CustomerRepository");
        }
        return null;
    }

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
            System.out.println("Loi generate ID trong CustomerRepository!!!");
        }
        return newID;
    }

    public static boolean checkUserNameExist(String username) {
        try (Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("select * from Account  where username =?");
            stmt.setString(1, username);
            ResultSet resultSet = stmt.executeQuery();
            return resultSet.next();
        } catch (Exception e) {
            System.out.println("loi checkUserNameExsit(String userName) trong CustomerRepository");
            e.printStackTrace();
        }
        return false;
    }

//    public static void main(String[] args) {
//        Customer a = new Customer("1234", "username", "123", 0, "abc", "test", new Date(0), "1243", "acv", "123", 0);
//        CustomerRepository.registerCustomer(a);
//    }
    static void insertCustomer(Customer a) {
        try (Connection conn = DBConnect.getConnection()) {
            String customerQuery = "insert into Customer(cusID, cusName, cusDOB, cusPhone, cusEmail, cusCCCD, cusType) values (?,?,?,?,?,?,?);";
            PreparedStatement psc = conn.prepareStatement(customerQuery);
            psc.setString(1, a.getAccountID());
            psc.setString(2, a.getCusName());
            psc.setDate(3, a.getCusDOB());
            psc.setString(4, a.getCusPhone());
            psc.setString(5, a.getCusEmail());
            psc.setString(6, a.getCusCCCD());
            psc.setInt(7, a.getCusType());
            psc.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Loi insert vao bang Customer");
        }
    }

    public static void inforUserUpdate(Customer c) {
        try (Connection conn = DBConnect.getConnection()) {
            String query = "UPDATE Customer\n"
                    + "JOIN Account ON Customer.cusID = Account.accountID\n"
                    + "SET Customer.cusPhone = ?,\n"
                    + "    Customer.cusEmail = ?,\n"
                    + "    Account.username = ?,\n"
                    + "    Account.password = ?\n"
                    + "WHERE Customer.cusID = ?;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, c.getCusPhone());
            ps.setString(2, c.getCusEmail());
            ps.setString(3, c.getUsername());
            ps.setString(4, c.getPassword());
            ps.setString(5, c.getCusID());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("=========Loi UpdateUser trong CustomerRepo==========");
        }
    }
    
    public static Customer getCusByUsernameAndEmail(String usernameInput, String emailInput){
        try (Connection conn = DBConnect.getConnection()){
            String query = "SELECT * FROM Account JOIN Customer ON accountID = cusID WHERE Account.username = ? AND Customer.cusEmail = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, usernameInput);
            ps.setString(2, emailInput);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String accountID = rs.getString(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                int role = rs.getInt(4);
                String cusID = rs.getString(5);
                String cusName = rs.getString(6);
                Date cusDOB = rs.getDate(7);
                String cusPhone = rs.getString(8);
                String cusEmail = rs.getString(9);
                String cusCCCD = rs.getString(10);
                int cusType = rs.getInt(11);
                Customer cus = new Customer(accountID, username, password, role, cusID, cusName, cusDOB, cusPhone, cusEmail, cusCCCD, cusType);
                return cus;
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("=========Loi getCusByUsernameAndEmail trong CustomerRepo=========");
        }
        return null;
    }
}
