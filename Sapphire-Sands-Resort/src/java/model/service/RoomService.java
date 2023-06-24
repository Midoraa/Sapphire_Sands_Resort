package model.service;

import java.util.List;
import model.entity.Room;
import model.repository.RoomRepository;

public class RoomService {
    public static List<Room> getAllRoom(){
        return RoomRepository.getAllRoom();
    }
    
    public static Room getRoomByID(String id){
        return RoomRepository.getRoomByID(id);
    }
    
    public static List<Room> getChoosenRoom(String roomInputType, int roomInputMaxPeole){
        return RoomRepository.getChoosenRoom(roomInputType, roomInputMaxPeole);
    }
}
