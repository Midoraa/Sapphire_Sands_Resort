package model.entity;

public class Room {
    String roomID, roomName, roomType;
    int maxPeople;
    double roomPrice;
    boolean roomStatus;
    String roomDescript;
    double roomArea;
    String bedRoom, bathRoom, roomDirection;

    public Room() {
    }

    public Room(String roomID, String roomName, String roomType, int maxPeople, double roomPrice, boolean roomStatus, String roomDescript, double roomArea, String bedRoom, String bathRoom, String roomDirection) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.roomType = roomType;
        this.maxPeople = maxPeople;
        this.roomPrice = roomPrice;
        this.roomStatus = roomStatus;
        this.roomDescript = roomDescript;
        this.roomArea = roomArea;
        this.bedRoom = bedRoom;
        this.bathRoom = bathRoom;
        this.roomDirection = roomDirection;
    }

    @Override
    public String toString() {
        return "Room{" + "roomID=" + roomID + ", roomName=" + roomName + ", roomType=" + roomType + ", maxPeople=" + maxPeople + ", roomPrice=" + roomPrice + ", roomStatus=" + roomStatus + ", roomDescript=" + roomDescript + ", roomArea=" + roomArea + ", bedRoom=" + bedRoom + ", bathRoom=" + bathRoom + ", roomDirection=" + roomDirection + '}';
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public boolean isRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(boolean roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRoomDescript() {
        return roomDescript;
    }

    public void setRoomDescript(String roomDescript) {
        this.roomDescript = roomDescript;
    }

    public double getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(double roomArea) {
        this.roomArea = roomArea;
    }

    public String getBedRoom() {
        return bedRoom;
    }

    public void setBedRoom(String bedRoom) {
        this.bedRoom = bedRoom;
    }

    public String getBathRoom() {
        return bathRoom;
    }

    public void setBathRoom(String bathRoom) {
        this.bathRoom = bathRoom;
    }

    public String getRoomDirection() {
        return roomDirection;
    }

    public void setRoomDirection(String roomDirection) {
        this.roomDirection = roomDirection;
    }

}