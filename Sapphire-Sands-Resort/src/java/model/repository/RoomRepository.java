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
import model.config.DBConnect;
import model.entity.Room;

/**
 *
 * @author Admin
 */
public class RoomRepository {
    
    public static Room getRoomByID(String id){
        try(Connection conn = DBConnect.getConnection()) {
            String query = "select * from Room WHERE roomID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String roomID = rs.getString(1);
                String roomName = rs.getString(2);
                int roomType = rs.getInt(3);
                int maxPeople = rs.getInt(4);
                double roomPrice = rs.getDouble(5);
                boolean roomStatus = rs.getBoolean(6);
                String roomDescript = rs.getString(7);
                double roomArea = rs.getDouble(8);
                String bedRoom = rs.getString(9);
                String bathRoom = rs.getString(10);
                String roomDirection = rs.getString(11);
                
                double dollaPrice = Math.floor(roomPrice/20000);
                String roomTypeString;
                switch (roomType) {
                    case 1:
                        roomTypeString = "Phòng nghỉ dưỡng";
                        break;
                    case 2:
                        roomTypeString = "SUITE";
                        break;
                    case 3:
                        roomTypeString = "Penthouses & Villas";
                        break;
                    default:
                        roomTypeString = "Unknown";
                        break;
                }
                
                Room room = new Room(roomID, roomName, roomTypeString, maxPeople, dollaPrice, roomStatus, roomDescript, roomArea, bedRoom, bathRoom, roomDirection);
                return room;
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi getRoomByID trong RoomRepository");
        }
        return null;
    }

    public static ArrayList<Room> getAllRoom() {
        ArrayList<Room> listRoom = new ArrayList<Room>();
        try (Connection con = DBConnect.getConnection()) {
            String query = "select * from Room";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet results = ps.executeQuery();
            while (results.next()) {
                String roomID = results.getString(1);
                String roomName = results.getString(2);
                int roomType = results.getInt(3);
                int maxPeople = results.getInt(4);
                double roomPrice = results.getDouble(5);
                boolean roomStatus = results.getBoolean(6);
                String roomDescript = results.getString(7);
                double roomArea = results.getDouble(8);
                String bedRoom = results.getString(9);
                String bathRoom = results.getString(10);
                String roomDirection = results.getString(11);
                
                
                double dollaPrice = Math.floor(roomPrice/20000);
                String roomTypeString;
                switch (roomType) {
                    case 1:
                        roomTypeString = "Phòng nghỉ dưỡng";
                        break;
                    case 2:
                        roomTypeString = "SUITE";
                        break;
                    case 3:
                        roomTypeString = "Penthouses & Villas";
                        break;
                    default:
                        roomTypeString = "Unknown";
                        break;
                }
                Room r = new Room(roomID, roomName, roomTypeString, maxPeople, dollaPrice, true, roomDirection, roomArea, bedRoom, bathRoom, roomDirection);
                listRoom.add(r);
            }
        } catch (Exception e) {
            System.err.println("Loi database method listRoom class RoomRepository");
        }
        return listRoom;

    }
//    public static void main(String[] args) {
//        System.out.println(getRoomByID("R000001"));
//    }
}
