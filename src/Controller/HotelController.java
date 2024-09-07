package Controller;

import entity.Hotel;
import service.HotelService;

import java.util.ArrayList;
import java.util.List;

public class HotelController {
    List<Hotel> hotelList;

    public HotelController() {
        this.hotelList = new ArrayList<>();
    }

    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    public void getAllHotel(){
        HotelService hotelService = new HotelService();
        hotelService.getAllHotels(hotelList);

    }
}
