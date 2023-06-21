/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.List;
import model.entity.Contract;
import model.entity.Customer;
import model.entity.Order;
import model.entity.Room;
import model.repository.OrderRepository;

/**
 *
 * @author Admin
 */
public class OrderService {
    public static String makeOrder(Room room, Contract contract, Customer cus){
        return OrderRepository.makeOrder(room, contract, cus);
    }
    
    public static List<Order> getOrderByCustomerID(String id){
        return OrderRepository.getOrderByCustomerID(id);
    }
}
