package Controller;

import entity.Booking;
import entity.Hotel;
import entity.Room;
import entity.RoomType;

import java.util.ArrayList;
import java.util.List;

public class BookingController {
    List<Booking> bookingList;

    public BookingController() {
        this.bookingList = new ArrayList<>();
    }


    public List<Room> findRoomsByDateAndHotel(Hotel hotel, RoomType roomType, int startDate, int endDate) {
        List<Room> bookedRooms = new ArrayList<>();
        List<Room> availableRooms = new ArrayList<>();
        for (Booking booking : bookingList) {
            bookedRooms.addAll(isBooked(booking, startDate, endDate, roomType, hotel));
        }


        for (Room room : hotel.getRoomList()) {
            if (room.getRoomType() == roomType && !bookedRooms.contains(room)) {
                availableRooms.add(room);
                //System.out.println("room =" + room.getId() + " " + room.getRoomType());
            }
        }

        return availableRooms;
    }

    private List<Room> isBooked(Booking booking, int startDate, int endDate, RoomType roomType, Hotel hotel) {
        List<Room> bookedRooms = new ArrayList<>();
        if (booking.getHotelId() != hotel.getId()) {
            return null;
        } else if (booking.getEndDate() <= startDate || booking.getStartDate() >= endDate) {
            return null;
        }
        for (Room room : booking.getRoomList()) {
            if (room.getRoomType() == roomType) {
                bookedRooms.add(room);

            }
        }
        return bookedRooms;
    }

    public List<Room> bookRooms(Hotel hotel, int startDate, int endDate, RoomType roomType, int numberOfRooms) {
        List<Room> roomList = new ArrayList<>();

        List<Room> availableRooms = findRoomsByDateAndHotel(hotel, roomType, startDate, endDate);
        int count = 0;
        for (Room room : hotel.getRoomList()) {
            if (room.getRoomType() == roomType && availableRooms.contains(room)) {
                count++;
                roomList.add(room);
                if (count == numberOfRooms) {
                    break;
                }
            }
        }
        Booking booking = new Booking();
        booking.setId(1);
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setHotelId(hotel.getId());
        booking.setRoomList(roomList);

        bookingList.add(booking);
        return roomList;

    }

}
