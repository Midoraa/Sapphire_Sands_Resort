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
import java.util.List;
import model.config.DBConnect;
import model.entity.Contract;
import model.entity.Customer;
import model.entity.Order;
import model.entity.Room;
import model.service.Isvalid;

/**
 *
 * @author Admin
 */
public class OrderRepository {

    public static String getOrderID() {
        try (Connection conn = DBConnect.getConnection()) {
            String query = "SELECT MAX(SUBSTRING(orderID, 3)) AS maxID FROM `Order`";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            int lastID = 0;
            if (rs.next()) {
                String maxID = rs.getString("maxID");
                if (maxID != null) {
                    lastID = Integer.parseInt(maxID);
                }
            }

            String newOrderID = "OD" + String.format("%06d", lastID + 1);
            System.out.println(newOrderID);
            conn.close();
            preparedStatement.close();
            rs.close();
            return newOrderID;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("============Loi generate ID trong OrderRepository!!!=============");
        }
        return null;
    }

    public static List<Order> getOrderByCustomerID(String cusID) {
        List<Order> list = new ArrayList<>();
        try (Connection conn = DBConnect.getConnection()) {
            String query = "select * from `Order` where cusID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cusID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getBoolean(4)));
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("=============SAI getOrderByCusID trong OrderRepo==============");
        }
        return list;
    }

    public static String makeOrder(Room room, Contract contract, Customer cus) {
        try (Connection conn = DBConnect.getConnection()) {
            String query = "INSERT INTO `Order`(orderID, cusID, orDate, orStatus) VALUES (?, ?, ?, ?)";
            String orderID = getOrderID();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, getOrderID());
            ps.setString(2, cus.getCusID());
            ps.setString(3, Isvalid.getCurrentDate());
            ps.setBoolean(4, false);
            ps.executeUpdate();
            ps.close();
            createContractDetail(room, contract, orderID);
            return orderID;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("================Sai makeOrder trong OrderRepository=================");
        }
        return null;
    }

    private static void createContractDetail(Room room, Contract contract, String orderID) {
        try (Connection conn = DBConnect.getConnection()) {
            String query = "Insert INTO ContractDetail(roomID, orderID, timeIn, timeOut, people, timeRegister, status) VALUES (?, ? , ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, room.getRoomID());
            ps.setString(2, orderID);
            ps.setString(3, contract.getTimeIn());
            ps.setString(4, contract.getTimeOut());
            ps.setInt(5, contract.getPeople());
            Date currentDate = new Date();
            java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(currentDate.getTime());
            ps.setTimestamp(6, currentTimestamp);
            ps.setInt(7, 0);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("===========Loi createContractDetail trong OrderRepository===============");
        }
    }

    private static void setStatusRoom(Room room) {
        try (Connection conn = DBConnect.getConnection()) {
            String query = "UPDATE Room SET roomStatus = 1 WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, room.getRoomID());
            conn.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("=============SAI setStatusRoom trong OrderRepo===============");
        }
    }

    public static void sendRequestCancelRoom(String orderID) {
        try (Connection conn = DBConnect.getConnection()) {
            String query = "UPDATE ContractDetail\n"
                    + "SET status = 3\n"
                    + "WHERE orderID = ?;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, orderID);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("==========Loi sendRequestCancelRoom trong OrderRepo==========");
        }
    }
    public static void notAcceptRequestCancelRoom(String orderID) {
        try (Connection conn = DBConnect.getConnection()) {
            String query = "UPDATE ContractDetail\n"
                    + "SET status = 1\n"
                    + "WHERE orderID = ?;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, orderID);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("==========Loi notAcceptRequestCancelRoom trong OrderRepo==========");
        }
    }
//    public static void main(String[] args) {
//        Room room = new Room("R000001", "Phòng Resort Classic Hướng Biển", "asdas", 4, 300000000, false, "asdasdas", 12, "asd", "asdas", "asdas");
//        Contract contract = new Contract("R000010", "2023-06-28", "2023-06-29", 8);
//        Customer cus = new Customer("CUS000001", "bao", "123", 0, "CUS000013", "Nguyễn Quang Bảo", java.sql.Date.valueOf("2002-10-30"), "0702347748", "binnguyen301002@gmail.com", "12312312312", 1);
//        OrderRepository.makeOrder(room, contract, cus);
//            System.out.println(OrderRepository.getOrderByCustomerID("CUS000001"));
//    }
}
