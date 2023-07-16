package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.config.DBConnect;
import model.entity.ContractOrder;
import model.entity.FoodCart;
import model.entity.OrderCart;
import model.entity.RoomCart;
import model.entity.RoomShowCustomer;
import model.entity.ServiceCart;

public class YourCartRepository {

    public static List<String> getOrderID(String orderID) {
        String[] listid_status = orderID.split("/");
        String[] id_status = null;

        List<String> list = new ArrayList<>();

        for (String i_s : listid_status) {
            id_status = i_s.split(":");
            list.add(new String(id_status[0]));
        }
        return list;
    }

    public static List<OrderCart> getYourCartOrder(String cusID) {
        List<OrderCart> list = new ArrayList<>();
        String query = "Select cusID, orderID, orStatus from `Order` where cusID = ?";

        try (Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cusID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderCart(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("=========LOI getYourCartOrder trong YourCartRepo==========");
        }
        return list;
    }

    public static List<FoodCart> getYourCartFood(String orderID) {
        List<FoodCart> list = new ArrayList<>();
        List<String> listOrder = getOrderID(orderID);

        String query = "Select b.orderID, a.foodID, a.foodName, a.foodPrice, b.orTime, b.Amount, b.orStatus \n"
                + "from Food a join OrderDetail b join ContractDetail c\n"
                + "on a.foodID = b.foodID and b.orderID = c.orderID and c.status = 1\n"
                + "where b.orderID = ?";
        for (String s : listOrder) {

            try (Connection conn = DBConnect.getConnection()) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, s);
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
                System.out.println("=========LOI getYourCartFood trong YourCartRepo=============");
            }

        }
        return list;
    }

    public static List<ServiceCart> getYourCartService(String orderID) {
        List<ServiceCart> list = new ArrayList<>();
        List<String> listOrder = getOrderID(orderID);

        String query = "Select b.orderID, a.serviceID, a.serviceName, a.servicePrice, b.serviceTime, b.Amount, b.serviceStatus \n"
                + "from Service a join ServiceDetail b join ContractDetail c\n"
                + "on a.serviceID = b.serviceID and b.orderID = c.orderID and c.status = 1\n"
                + "where b.orderID = ?";

        for (String s : listOrder) {
            try (Connection conn = DBConnect.getConnection()) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, s);
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
                System.out.println("=========LOI getYourCartService trong YourcartRepo=======");
            }
        }

        return list;
    }

    public static List<RoomCart> getYourCartRoom(String orderID) {
        List<RoomCart> list = new ArrayList<>();
        List<String> listOrder = getOrderID(orderID);

        String query = "Select b.orderID, a.roomID, a.roomName, a.roomType, b.timeRegister, b.timeIn, b.timeOut, b.people, a.roomPrice \n"
                + "from Room a join ContractDetail b\n"
                + "on a.roomID = b.roomID\n"
                + "where b.orderID = ? and b.status=1";

        for (String s : listOrder) {
            try (Connection conn = DBConnect.getConnection()) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, s);
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
                    System.out.println("Order ID: " + rs.getString(1) + rs.getInt(8) + "Time Stay: " + timeStay);
                }
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("==========Loi getYourCartRoom trong YourCartRepo========");
            }
        }

        return list;
    }

    public static List<OrderCart> getRoomByAccount(String cusID, int orStatus) {
        List<OrderCart> list = new ArrayList<>();
        String query = "Select a.orderID, a.orStatus, b.roomID, c.roomName from `Order` a join ContractDetail b join Room c "
                + "on a.orderID = b.orderID and b.roomID = c.roomID "
                + "Where a.cusID = ? and a.orStatus = ? and b.status = 1";

        try (Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cusID);
            ps.setInt(2, orStatus);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderCart(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getNString(4)));
                System.out.println("orderID: " + rs.getString(1) + "orStatus: " + rs.getInt(2) + "roomID: " + rs.getString(3) + "roomName: " + rs.getNString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("=========LOI getRoomByAccount trong YourCartRepo==========");
        }

        return list;
    }

    public static double getTotalPrice(String orderID) {
        double price = 0;

        List<RoomCart> listRoom = new ArrayList<>();
        List<FoodCart> listFood = new ArrayList<>();
        List<ServiceCart> listService = new ArrayList<>();

        listRoom = getYourCartRoom(orderID);
        listFood = getYourCartFood(orderID);
        listService = getYourCartService(orderID);

        for (RoomCart roomCart : listRoom) {
            price = price + roomCart.getRoomPrice() * roomCart.getDayStay();
        }

        for (FoodCart foodCart : listFood) {
            price = price + foodCart.getFoodPrice() * foodCart.getAmount();
        }

        for (ServiceCart serviceCart : listService) {
            price = price + serviceCart.getServicePrice() * serviceCart.getAmount();
        }

        return price;
    }

    public static ArrayList<RoomShowCustomer> listPendingRoomByCusID(String cusID) {
        ArrayList<RoomShowCustomer> list = null;
        try (Connection conn = DBConnect.getConnection()) {
            String query = "SELECT Room.roomID, Room.roomName, ContractDetail.timeIn, ContractDetail.timeOut, ContractDetail.people, Room.roomPrice\n"
                    + "FROM Room\n"
                    + "INNER JOIN ContractDetail ON Room.roomID = ContractDetail.roomID\n"
                    + "INNER JOIN `Order` ON ContractDetail.orderID = `Order`.orderID\n"
                    + "WHERE `Order`.cusID = ? AND `Order`.orStatus = 0;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cusID);
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String roomID = rs.getString(1);
                String roomName = rs.getString(2);
                Date timeIn = rs.getDate(3);
                Date timeOut = rs.getDate(4);
                int people = rs.getInt(5);
                double roomPrice = rs.getDouble(6);
                RoomShowCustomer rsc = new RoomShowCustomer(cusID, roomID, roomName, people, timeIn, timeOut, roomPrice);
                list.add(rsc);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("========Loi listPendingRoomByCusID trong YourCartRepo==========");
        }
        return list;
    }

    public static ArrayList<RoomShowCustomer> listAcceptedRoomByCusID(String cusID) {
        ArrayList<RoomShowCustomer> list = null;
        try (Connection conn = DBConnect.getConnection()) {
            String query = "SELECT Room.roomID, Room.roomName, ContractDetail.timeIn, ContractDetail.timeOut, ContractDetail.people, Room.roomPrice\n"
                    + "FROM Room\n"
                    + "INNER JOIN ContractDetail ON Room.roomID = ContractDetail.roomID\n"
                    + "INNER JOIN `Order` ON ContractDetail.orderID = `Order`.orderID\n"
                    + "WHERE `Order`.cusID = ? AND ContractDetail.status = 1 and `Order`.orStatus = 0;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cusID);
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String roomID = rs.getString(1);
                String roomName = rs.getString(2);
                Date timeIn = rs.getDate(3);
                Date timeOut = rs.getDate(4);
                int people = rs.getInt(5);
                double roomPrice = rs.getDouble(6);
                RoomShowCustomer rsc = new RoomShowCustomer(cusID, roomID, roomName, people, timeIn, timeOut, roomPrice);
                list.add(rsc);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("========Loi listAcceptedRoomByCusID trong YourCartRepo==========");
        }
        return list;
    }

    public static ArrayList<RoomShowCustomer> listPaidRoomByCusID(String cusID) {
        ArrayList<RoomShowCustomer> list = null;
        try (Connection conn = DBConnect.getConnection()) {
            String query = "SELECT Room.roomID, Room.roomName, ContractDetail.timeIn, ContractDetail.timeOut, ContractDetail.people, Room.roomPrice\n"
                    + "FROM Room\n"
                    + "INNER JOIN ContractDetail ON Room.roomID = ContractDetail.roomID\n"
                    + "INNER JOIN `Order` ON ContractDetail.orderID = `Order`.orderID\n"
                    + "WHERE `Order`.cusID = ? AND `Order`.orStatus = 1;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cusID);
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String roomID = rs.getString(1);
                String roomName = rs.getString(2);
                Date timeIn = rs.getDate(3);
                Date timeOut = rs.getDate(4);
                int people = rs.getInt(5);
                double roomPrice = rs.getDouble(6);
                RoomShowCustomer rsc = new RoomShowCustomer(cusID, roomID, roomName, people, timeIn, timeOut, roomPrice);
                list.add(rsc);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("========Loi listPaidRoomByCusID trong YourCartRepo==========");
        }
        return list;
    }

    public static void main(String[] args) {
//        String orderID = "OD000004";

        String orderID = "OD000007:1/OD000008:0/OD000009:1/OD000010:0/OD000011:1/OD000012:0/OD000013:1";

//        List<ServiceCart> list = new ArrayList<>(); 
//        list = YourCartService.getYourCartService(orderID);
//        System.out.println(list.toString());
//        
//        List<FoodCart> list1 = new ArrayList<>(); 
//        list1 = YourCartService.getYourCartFood(orderID);
//        System.out.println(list1.toString());
//        List<RoomCart> list2 = new ArrayList<>();
//        list2 = YourCartService.getYourCartRoom(orderID);
//        System.out.println(list2.toString());
//        String listOrderID = "OD000007:1/OD000008:0/OD000009:1/OD000010:0/OD000011:1/OD000012:0/OD000013:1";
//        List<String> list3 = new ArrayList<>();
//        list3 = getOrderID(orderID);
//        System.out.println(list3.toString());
//    List<OrderCart> list = new ArrayList<>();
//        getRoomByAccount("CUS000013", 0);
        System.out.println(getTotalPrice("OD000013"));
    }

}
