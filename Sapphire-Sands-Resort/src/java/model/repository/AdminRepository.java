/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.config.DBConnect;
import model.entity.ContractOrder;
import model.entity.Customer;
import model.entity.Employee;
import model.entity.Service;

/**
 *
 * @author Admin
 */
public class AdminRepository {
    public static void registerEmployee(Employee emp) {
        System.out.println(emp);
        try (Connection conn = DBConnect.getConnection()) {
            String accountQuery = "INSERT INTO Account(accountID, username, password, role) VALUES (?, ?, ?, ?);";                  
            PreparedStatement psa = conn.prepareStatement(accountQuery);
            psa.setString(1, emp.getEmpID());
            psa.setString(2, emp.getUsername());
            psa.setString(3, emp.getPassword());
            psa.setInt(4, emp.getRole());
            psa.executeUpdate(); 
            psa.close();
            insertEmployee(emp);   
        } catch (Exception e) {
            System.out.println("Loi dang ky Employee trong EmployeeRepository");
            System.out.println(e);
        }
    }
    
    static void insertEmployee(Employee emp) {
        try(Connection conn = DBConnect.getConnection()) {
            String customerQuery =  "insert into Employee(empID, empName, empGender, empDOB, empAdress, empPhone, empEmail) values (?,?,?,?,?,?,?);";
            PreparedStatement psc = conn.prepareStatement(customerQuery);
            psc.setString(1, emp.getEmpID());
            psc.setString(2, emp.getEmpNames());
            psc.setBoolean(3, emp.isEmpGender());
            psc.setDate(4, (Date) emp.getEmpDOB());
            psc.setString(5, emp.getEmpAdress());
            psc.setString(6, emp.getEmpPhone());
            psc.setString(6, emp.getEmpEmail());
            psc.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Loi insert vao bang Employee");
        }
    }
    
    public static String generateNewID() {
        String newID = null;
        try (Connection conn = DBConnect.getConnection()) {
            String selectQuery = "SELECT accountID FROM account WHERE accountID LIKE 'EMP%' ORDER BY accountID DESC LIMIT 1";
            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String lastID = resultSet.getString("accountID");
                int lastNumber = Integer.parseInt(lastID.substring(3));
                newID = "EMP" + String.format("%06d", lastNumber + 1);
            } else {
                newID = "EMP000001";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Loi generate ID trong EmployeeRepository!!!");
        }
        return newID;
    }
    
    public static Employee getEmployeeByID(String id) {
        try (Connection conn = DBConnect.getConnection()) {
            String query = "SELECT * FROM Account JOIN Employee ON accountID = empID WHERE empID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String username = rs.getString(1);
                String password = rs.getString(2);
                String empID = rs.getString(3);
                String empNames = rs.getString(4);
                boolean gender = rs.getBoolean(5);
                Date empDOB = rs.getDate(6);
                String empAdress = rs.getString(7);
                String empPhone = rs.getString(8);
                String empEmail = rs.getString(9);
                int role = rs.getInt(10);
                Employee emp = new Employee(username, password, role, empID, empNames, gender, empDOB, empPhone, empAdress, empEmail );
                return emp;
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi getEmployeeByID trong EmployeeRepository");
        }
        return null;
    }
    public static boolean checkUserNameExist(String username) {
        try (Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("select * from Account  where username =?");
            stmt.setString(1, username);
            ResultSet resultSet = stmt.executeQuery();
            return resultSet.next();
        } catch (Exception e) {
            System.out.println("loi checkUserNameExsit(String userName) trong EmployeeRepository");
            e.printStackTrace();
        }
        return false;
    }
    
    public static ArrayList<Employee> getAllEmployee(){
        ArrayList<Employee> list = null;
        try (Connection conn = DBConnect.getConnection()){
            String query = "SELECT * FROM Account JOIN Employee ON Account.accountID = Employee.empID WHERE Account.role=1";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String accountID = rs.getString(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                int role = rs.getInt(4);
                String empID = rs.getString(5);
                String empNames = rs.getString(6);
                boolean gender = rs.getBoolean(7);
                Date empDOB = rs.getDate(8);
                String empAdress = rs.getString(9);
                String empPhone = rs.getString(10);
                String empEmail = rs.getString(11);
                Employee emp = new Employee(username, password, role, empID, empNames, gender, empDOB, empAdress, empPhone, empEmail);
                list.add(emp);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("=========LOI getAllEMployee trong Admin REpo==========");
        }
        return list;
    }
    public static ArrayList<Employee> getAllManager(){
        ArrayList<Employee> list = null;
        try (Connection conn = DBConnect.getConnection()){
            String query = "SELECT * FROM Account JOIN Employee ON Account.accountID = Employee.empID WHERE Account.role=3";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String accountID = rs.getString(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                int role = rs.getInt(4);
                String empID = rs.getString(5);
                String empNames = rs.getString(6);
                boolean gender = rs.getBoolean(7);
                Date empDOB = rs.getDate(8);
                String empAdress = rs.getString(9);
                String empPhone = rs.getString(10);
                String empEmail = rs.getString(11);
                Employee emp = new Employee(username, password, role, empID, empNames, gender, empDOB, empAdress, empPhone, empEmail);
                list.add(emp);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("=========LOI getAllManager trong Admin REpo==========");
        }
        return list;
    }
    
    public static ArrayList<Customer> getAllCustomer(){
        ArrayList<Customer> list = null;
        try(Connection conn = DBConnect.getConnection()) {
            String query = "SELECT * FROM Account JOIN Customer ON Account.accountID = Customer.cusID";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
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
                list.add(cus);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("=====Loi getAllCustomer trong AdminRepo======");
        }
        return list;
    }
    
//    public static void main(String[] args) {
//        System.out.println(getAllCustomer());
//    }
}
