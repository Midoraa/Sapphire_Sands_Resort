package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.config.DBConnect;
import model.entity.FoodCart;
import model.entity.RoomCart;
import model.entity.ServiceCart;

public class YourCartRepository {

    public static List<FoodCart> getYourCartFood(String orderID) {
        List<FoodCart> list = new ArrayList<>();
        String query = "Select b.orderID, a.foodID, a.foodName, a.foodPrice, b.orTime, b.Amount, b.orStatus \n"
                + "from Food a join OrderDetail b \n"
                + "on a.foodID = b.foodID\n"
                + "where b.orderID = ?";
        try (Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, orderID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new FoodCart(
                        rs.getNString(1),
                        rs.getNString(2),
                        rs.getNString(3),
                        rs.getDouble(4),
                        rs.getTimestamp(5),
                        rs.getInt(6),
                        rs.getInt(7)
                )
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static List<ServiceCart> getYourCartService(String orderID) {
        List<ServiceCart> list = new ArrayList<>();
        String query = "Select b.orderID, a.serviceID, a.serviceName, a.servicePrice, b.serviceTime, b.Amount, b.serviceStatus \n"
                + "from Service a join ServiceDetail b \n"
                + "on a.serviceID = b.serviceID\n"
                + "where b.orderID = ?";
        try (Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, orderID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ServiceCart(
                        rs.getNString(1),
                        rs.getNString(2),
                        rs.getNString(3),
                        rs.getDouble(4),
                        rs.getTimestamp(5),
                        rs.getInt(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static List<RoomCart> getYourCartRoom(String orderID) {
        List<RoomCart> list = new ArrayList<>();
        String query = "Select b.orderID, a.roomID, a.roomName, a.roomType, b.timeRegister, b.timeIn, b.timOut, b.people, a.roomPrice \n"
                + "from Room a join ContractDetail b\n"
                + "on a.roomID = b.roomID\n"
                + "where b.orderID = ? ";
        try (Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, orderID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int timeStay = (int) ((rs.getDate(7).getTime() - rs.getDate(6).getTime()) / 86400000);
                String roomTypeString;

                switch (rs.getInt(4)) {
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

                list.add(new RoomCart(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getNString(3),
                        roomTypeString,
                        rs.getTimestamp(5),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getInt(8),
                        rs.getDouble(9),
                        timeStay
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

}
