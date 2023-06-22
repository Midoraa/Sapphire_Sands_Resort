/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.config.DBConnect;
import model.entity.ContractOrder;

/**
 *
 * @author Admin
 */
public class ManagerRepository {

    public static List<ContractOrder> getAllPendingContract() {
        ArrayList<ContractOrder> list = null;
        try (Connection conn = DBConnect.getConnection()) {
            String query = "SELECT cd.orderID, cd.timeRegister, c.cusID, c.cusName, cd.roomID, cd.timeIn, cd.timOut, cd.people\n"
                    + "FROM Customer c\n"
                    + "INNER JOIN `Order` o ON c.cusID = o.cusID\n"
                    + "INNER JOIN ContractDetail cd ON o.orderID = cd.orderID\n"
                    + "WHERE cd.status = 0;";
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
            System.out.println("================LOI getAllPendingContract trong ManagerRepo================");
        }
        return list;
    }

    public static List<ContractOrder> getAllAcceptedContract() {
        ArrayList<ContractOrder> list = null;
        try (Connection conn = DBConnect.getConnection()) {
            String query = "SELECT cd.orderID, cd.timeRegister, c.cusID, c.cusName, cd.roomID, cd.timeIn, cd.timOut, cd.people\n"
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
            System.out.println("================LOI getAllAcceptedContract trong ManagerRepo================");
        }
        return list;
    }

    public static List<ContractOrder> getAllPaidContract() {
        ArrayList<ContractOrder> list = null;
        try (Connection conn = DBConnect.getConnection()) {
            String query = "SELECT cd.orderID, cd.timeRegister, c.cusID, c.cusName, cd.roomID, cd.timeIn, cd.timOut, cd.people\n"
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
            System.out.println("================LOI getAllPaidContract trong ManagerRepo================");
        }
        return list;
    }

    public static void acceptOrder(String orderID, String cusID, String roomID) {
        try {
            Connection con = DBConnect.getConnection();
            String query = "UPDATE ContractDetail\n"
                    + "SET status = 1\n"
                    + "WHERE orderID = ? \n"
                    + "  AND orderID IN (SELECT orderID FROM `Order` WHERE cusID = ?)\n"
                    + "  AND roomID = ?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, orderID);
            ps.setString(2, cusID);
            ps.setString(3, roomID);
            ps.executeUpdate();
            con.close();
            ps.close();
            updateRoomStatus(orderID, roomID);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("===========Loi method acceptOrder() trong ManagerRepository.java===========");
        }
    }

    public static void updateRoomStatus(String orderID, String roomID) {
        try (Connection conn = DBConnect.getConnection()) {
            String query = "UPDATE Room\n"
                    + "JOIN ContractDetail ON Room.roomID = ContractDetail.roomID\n"
                    + "SET Room.roomStatus = CASE\n"
                    + "    WHEN CURDATE() BETWEEN ContractDetail.timeIn AND ContractDetail.timOut THEN 1\n"
                    + "    ELSE 0\n"
                    + "    END\n"
                    + "WHERE ContractDetail.orderID = ?\n"
                    + "    AND ContractDetail.roomID = ?;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, orderID);
            ps.setString(2, roomID);
            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("===============LOI updateStatusRoom trong ManagerRepo=============");
        }
    }

    public static void removeOrder(String orderID) {
        try {
            Connection con = DBConnect.getConnection();
            String query = "delete from ContractDetail `Order` where orderID=?;";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, orderID);
            stmt.executeUpdate();
            String queryy = "delete from `Order` where orderID=?";
            PreparedStatement ps = con.prepareStatement(queryy);
            ps.setString(1, orderID);
            ps.executeUpdate();
            stmt.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("=============Loi method removeOrder(String id) trong ManagerRepo==========");
        }
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
            System.out.println("========Loi PAYMENT trong ManagerRepo==========");
        }
    }

//    public static void main(String[] args) {
//        acceptOrder("OD000005", "CUS000013", "R000010");
//    }
}
