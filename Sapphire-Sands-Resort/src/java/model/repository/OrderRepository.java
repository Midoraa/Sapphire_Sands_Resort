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
import java.util.Date;
import model.config.DBConnect;
import model.entity.Contract;
import model.entity.Customer;
import model.entity.Room;
import model.service.Isvalid;

/**
 *
 * @author Admin
 */
public class OrderRepository {
    
    public static String getOrderID(){
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
            return newOrderID;
            
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("============Loi generate ID trong OrderRepository!!!=============");
        }
        return null;
    }
    
    public static String makeOrder(Room room, Contract contract, Customer cus){
        try(Connection conn = DBConnect.getConnection()) {
            String query = "INSERT INTO `Order`(orderID, cusID, orDate, orStatus) VALUES (?, ?, ?, ?)";
            String orderID = getOrderID();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, getOrderID());
            ps.setString(2, cus.getCusID());
            ps.setString(3, Isvalid.getCurrentDate());
            ps.setBoolean(4, false);
            ps.executeUpdate();
            ps.close();
            createContractDetail(room, contract,orderID);
            return orderID;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("================Sai makeOrder trong OrderRepository=================");
        }
        return null;
    }

    private static void createContractDetail(Room room, Contract contract, String orderID) {
        try (Connection conn = DBConnect.getConnection()){
            String query = "Insert INTO ContractDetail(roomID, orderID, timeIn, timOut, people, timeRegister) VALUES (?, ? , ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, room.getRoomID());
            ps.setString(2, orderID);
            ps.setString(3, contract.getTimeIn());
            ps.setString(4, contract.getTimeOut());
            ps.setInt(5, contract.getPeople());
            Date currentDate = new Date();
            java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(currentDate.getTime());
            ps.setTimestamp(6, currentTimestamp);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("===========Loi createContractDetail trong OrderRepository===============");
        }
    }
//    public static void main(String[] args) {
//        Room room = new Room("R000001", "Phòng Resort Classic Hướng Biển", "asdas", 4, 300000000, false, "asdasdas", 12, "asd", "asdas", "asdas");
//        Contract contract = new Contract("R000010", "2023-06-28", "2023-06-29", 8);
//        Customer cus = new Customer("CUS000001", "bao", "123", 0, "CUS000013", "Nguyễn Quang Bảo", java.sql.Date.valueOf("2002-10-30"), "0702347748", "binnguyen301002@gmail.com", "12312312312", 1);
//        OrderRepository.makeOrder(room, contract, cus);
//    }
}
