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
import java.util.List;
import model.config.DBConnect;
import model.entity.Service;

/**
 *
 * @author Admin
 */
public class ServiceRepository {
    public static List<Service> getListFood(){
        List<Service> list = new ArrayList<>();
        String query = "Select * from Service";
        try (Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();  
            while(rs.next()) {
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
}
