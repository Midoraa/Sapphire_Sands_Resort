package model.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.config.DBConnect;
import model.entity.Service;
import model.entity.ServiceCart;
import java.sql.*;

public class ServiceRepository {

    public static List<Service> getListService() {
        List<Service> list = new ArrayList<>();
        String query = "Select * from Service";
        try (Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Service(
                        rs.getNString(1),
                        rs.getNString(2),
                        rs.getDouble(3)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static String resetCookieCart(String txt) {

        String[] id_amount = txt.split("/");
        String cookieCart = "";

        Map<String, Integer> map = new HashMap<>();

        for (String element : id_amount) {
            String[] e = element.split(":");

            String id = e[0];
            int amount = Integer.parseInt(e[1]);

            if (map.containsKey(id)) {
                map.put(id, map.get(id) + amount);
            } else {
                map.put(id, amount);
            }

        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (!cookieCart.isEmpty()) {
                cookieCart = cookieCart + "/" + entry.getKey() + ":" + entry.getValue();
            } else {
                cookieCart = entry.getKey() + ":" + entry.getValue();
            }

        }
        return cookieCart;
    }

    public static List<ServiceCart>  getListServiceCart(String txt){
//        Reset lại chuỗi cookie đầu vào cho đúng form: ID:Amount
        
        List<ServiceCart> list = new ArrayList<>();
        
        String [] id_amount = txt.split("/");
        
        for (String element : id_amount) {
            String [] e = element.split(":");
            String query = "Select * from Service where serviceID = ?";
            try(Connection conn = DBConnect.getConnection()) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, e[0]);
                ResultSet rs = ps.executeQuery();
                
                while (rs.next()) {                    
                    list.add(new ServiceCart(rs.getString(1), rs.getNString(2), Integer.parseInt(e[1]), rs.getDouble(3)));
                    System.out.println(rs.getString(1));
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        return list;
    }
    
    public static void insertintoServiceDetail(String txt, String orderID){
        
        Timestamp serviceTime = new Timestamp(System.currentTimeMillis());
        
        String [] id_amount = txt.split("/");
        
        for (String element : id_amount) {
            String query = "Insert into ServiceDetail(orderID, serviceID, serviceTime, Amount, serviceStatus) Values(?,?,?,?,?)";
            String [] el = element.split(":");
            try(Connection conn = DBConnect.getConnection()) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, orderID);
                ps.setString(2, el[0]);
                ps.setTimestamp(3, serviceTime);
                ps.setInt(4, Integer.parseInt(el[1]));
                ps.setInt(5, 0);
                
                ps.executeUpdate();
                ps.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public static List<ServiceCart> updateQuantityService(String txt, String serviceID ,int num){
        List<ServiceCart> list = new ArrayList<>();
        list = getListServiceCart(txt);
        
        for (ServiceCart s : list) {
            if (s.getServiceID().equals(serviceID)) {
                if (s.getAmount() + num >= 1) {
                    s.setAmount(s.getAmount() + num);
                }
            }
        }       
        return list;
    }
    
    
    public static String deleteServiceCart(String txt, String serviceID){
        String cookieCart = "";
        
        List<ServiceCart> list = new ArrayList<>();
        list = getListServiceCart(txt);
        
        list.removeIf(ServiceCart -> ServiceCart.getServiceID().equals(serviceID));
        
        for (ServiceCart s : list) {
            if (cookieCart != null) {
                cookieCart = cookieCart + "/" + s.getServiceID() + ":" + s.getAmount();
            }else
                cookieCart = s.getServiceID() + ":" + s.getAmount();
        }
        
        return cookieCart;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
//        Chuỗi Test
        String txt = "SV000002:3/SV000001:2/SV000004:1/SV000003:2";
        
//        Kiểm tra đẩy dịch vụ lên client
//        List<Service> list = new ArrayList<>();
//        list = ServiceDouble.getService();
//        System.out.println(list.toString());   

//          Kiểm tra hàm reset là chuỗi cookie form
//        System.out.println(ServiceDouble.resetCookieCart(txt));
        
////        Kiểm tra hàm Service Cart đã được đọc từ cookie hay chưa
//        List<ServiceCart> list = new ArrayList<>();
//        list = getListServiceCart(txt);
//        System.out.println(list.toString());
//        
////        Kiểm tra hàm insert dữ liệu vào ServiceDetail đã chạy hay chưa
//        String orderID = "OD000005";
//        insertintoServiceDetail(txt, orderID);
//        
////        Kiểm tra hàm xóa 1 service khỏi cookie
//        String delete = deleteServiceCart(txt, "SV000001");
//        System.out.println(delete);

    }
}
