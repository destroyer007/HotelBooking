package entity;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    int id;
    String name;
    int locationID;

    List<Room> roomList = new ArrayList<>();

    public Hotel(int id, String name, int locationID) {
        this.id = id;
        this.name = name;
        this.locationID = locationID;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }
}
