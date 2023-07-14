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
import java.util.ArrayList;
import java.util.Date;
import model.config.DBConnect;
import model.entity.ContractOrder;
import model.entity.Employee;

/**
 *
 * @author Admin
 */
public class EmployeeRepository {

    public static Employee login(String username, String password) {
        try (Connection conn = DBConnect.getConnection()) {
            String query = "SELECT * FROM Account JOIN Employee ON Account.accountID = Employee.empID WHERE Account.username = ? AND Account.password = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Employee emp = new Employee();
                emp.setEmpID(rs.getString("empID"));
                emp.setEmpNames(rs.getString("empName"));
                emp.setEmpGender(rs.getBoolean("empGender"));
                emp.setEmpDOB(rs.getDate("empDOB"));
                emp.setEmpAdress(rs.getString("empAdress"));
                emp.setEmpPhone(rs.getString("empPhone"));
                emp.setEmpEmail(rs.getString("empEmail"));
                emp.setUsername(rs.getString("username"));
                emp.setPassword(rs.getString("password"));
                emp.setRole(rs.getInt("role"));
                return emp;
            }
            rs.close();
            ps.close();
            conn.close();
            return null;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("==============Loi Login Employee trong EmployeeRepo================");
        }
        return null;
    }
    
    public static java.util.List<ContractOrder> getAllAcceptedContract() {
        ArrayList<ContractOrder> list = null;
        try (Connection conn = DBConnect.getConnection()) {
            String query = "SELECT cd.orderID, cd.timeRegister, c.cusID, c.cusName, cd.roomID, cd.timeIn, cd.timeOut, cd.people\n"
                    + "FROM Customer c\n"
                    + "INNER JOIN `Order` o ON c.cusID = o.cusID\n"
                    + "INNER JOIN ContractDetail cd ON o.orderID = cd.orderID\n"
                    + "WHERE cd.status = 1 and o.orStatus = 0;";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String orderID = rs.getString(1);
                String cusID = rs.getString(3);
                String roomID = rs.getString(5);
                String cusName = rs.getString(4);
                String timeRegister = rs.getString(2);
                Date timeIn = rs.getDate(6);
                Date timeOut = rs.getDate(7);
                int people = rs.getInt(8);
                ContractOrder co = new ContractOrder(orderID, roomID, cusID, cusName, timeRegister, timeIn, timeOut, people);
                list.add(co);
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("================LOI getAllAcceptedContract trong EmployeeRepo================");
        }
        return list;
    }
    
    public static ArrayList<ContractOrder> getAllPaidContract() {
        ArrayList<ContractOrder> list = null;
        try (Connection conn = DBConnect.getConnection()) {
            String query = "SELECT cd.orderID, cd.timeRegister, c.cusID, c.cusName, cd.roomID, cd.timeIn, cd.timeOut, cd.people\n"
                    + "FROM Customer c\n"
                    + "INNER JOIN `Order` o ON c.cusID = o.cusID\n"
                    + "INNER JOIN ContractDetail cd ON o.orderID = cd.orderID\n"
                    + "WHERE o.orStatus = 1;";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String orderID = rs.getString(1);
                String cusID = rs.getString(3);
                String roomID = rs.getString(5);
                String cusName = rs.getString(4);
                String timeRegister = rs.getString(2);
                Date timeIn = rs.getDate(6);
                Date timeOut = rs.getDate(7);
                int people = rs.getInt(8);
                ContractOrder co = new ContractOrder(orderID, roomID, cusID, cusName, timeRegister, timeIn, timeOut, people);
                list.add(co);
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("================LOI getAllPaidContract trong EmployeeRepo================");
        }
        return list;
    }
    
    public static void Payment(String orderID){
        try(Connection conn = DBConnect.getConnection()) {
            String query = "UPDATE `Order` SET orStatus = 1 WHERE orderID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, orderID);
            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("========Loi PAYMENT trong EmployeeRepo==========");
        }
    }
}
