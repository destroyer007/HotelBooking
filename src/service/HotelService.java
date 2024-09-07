package service;

import entity.Hotel;

import java.util.List;

public class HotelService {
    public void getAllHotels(List<Hotel> hotelList) {
        System.out.println("list of hotels");
        for(Hotel hotel : hotelList){
            System.out.println("id = "+hotel.getId()+" name="+hotel.getName());
        }
    }
}
