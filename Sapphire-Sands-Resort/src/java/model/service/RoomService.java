/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.List;
import model.entity.Room;
import model.repository.RoomRepository;

/**
 *
 * @author Admin
 */
public class RoomService {
    public static List<Room> getAllRoom(){
        return RoomRepository.getAllRoom();
    }
    
    public static Room getRoomByID(String id){
        return RoomRepository.getRoomByID(id);
    }
    
    public static List<Room> getChoosenRoom(String roomInputType, int roomInputMaxPeole, String timeIn, String timOut){
        return RoomRepository.getChoosenRoom(roomInputType, roomInputMaxPeole, timeIn, timOut);
    }
}
