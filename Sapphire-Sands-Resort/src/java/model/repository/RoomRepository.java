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
import java.util.List;
import model.config.DBConnect;
import model.entity.Room;

/**
 *
 * @author Admin
 */
public class RoomRepository {

    public static Room getRoomByID(String id) {
        try (Connection conn = DBConnect.getConnection()) {
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

                double dollaPrice = Math.floor(roomPrice / 20000);
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

                double dollaPrice = Math.floor(roomPrice / 20000);
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

    public static ArrayList<Room> getChoosenRoom(String roomInputType, int maxInputPeople) {
        ArrayList<Room> listChoosenRoom = new ArrayList<Room>();
        try (Connection conn = DBConnect.getConnection()) {
            String query = "SELECT * FROM Room WHERE roomStatus = 0 AND roomType = ? AND maxPeople >= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            if (roomInputType.equalsIgnoreCase("Phòng nghỉ dưỡng")) {
                ps.setInt(1, 1);
            } else if (roomInputType.equalsIgnoreCase("SUITE")) {
                ps.setInt(1, 2);
            } else {
                ps.setInt(1, 3);
            }       
            ps.setInt(2, maxInputPeople);
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

                double dollaPrice = Math.floor(roomPrice / 20000);
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
                Room r = new Room(roomID, roomName, roomTypeString, maxPeople, dollaPrice, roomStatus, roomDescript, roomArea, bedRoom, bathRoom, roomDirection);
                listChoosenRoom.add(r);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Loi lay CHoosen room trong RoomRepository");
        }
        return listChoosenRoom;
    }
//    public static void main(String[] args) {
//        System.out.println(getChoosenRoom("SUITE", 4));
//    }
    public static List<Room> getListRoom(){
        List<Room> list = new ArrayList<>();
        String query = "Select * from Room";
        try (Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Room(rs.getString(1), rs.getNString(2), "Penthouses & Villas", rs.getInt(4), rs.getDouble(5), Boolean.getBoolean(String.valueOf(rs.getInt(6))), rs.getNString(7), rs.getDouble(8), rs.getNString(9), rs.getNString(10), rs.getNString(11)));
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public static void main(String[] args) {
        List<Room> list = new ArrayList<>();
        list = getListRoom();
        System.out.println(list.toString());
    }
}
