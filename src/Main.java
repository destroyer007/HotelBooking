import Controller.BookingController;
import Controller.HotelController;
import entity.Hotel;
import entity.Room;
import entity.RoomType;

import java.util.List;

public class Main {
    static BookingController bookingController;
    static HotelController hotelController;

    static int GOLD_PRICE = 100;
    static int SILVER_PRICE = 50;

    public static void main(String[] args) {
        System.out.println("Hello world!");
        initializeHotelBooking();
    }

    private static void initializeHotelBooking() {
        bookingController = new BookingController();
        hotelController = new HotelController();

        createHotel(hotelController);

        runTestMethods(bookingController,hotelController);

    }



    private static void createHotel(HotelController hotelController) {
        Hotel hotel1 = new Hotel(1,"jwm",100);
        Hotel hotel2 = new Hotel(1,"radission",100);

        hotelController.getHotelList().add(hotel1);
        hotelController.getHotelList().add(hotel2);

        createRooms(hotel1);
        createRooms(hotel2);

    }

    private static void createRooms(Hotel hotel) {

        for(int i = 0 ; i < 10;i++){
            Room room = new Room(i, RoomType.GOLD,GOLD_PRICE,hotel.getId());
            hotel.getRoomList().add(room);
        }

        for(int i = 10 ; i < 20;i++){
            Room room = new Room(i, RoomType.SILVER,SILVER_PRICE,hotel.getId());
            hotel.getRoomList().add(room);
        }
    }


    private static void runTestMethods(BookingController bookingController, HotelController hotelController) {
        hotelController.getAllHotel();
        findRoomsByDateAndHotel();
        bookRooms();
        findRoomsByDateAndHotel();
        bookRooms();
        findRoomsByDateAndHotel2();

    }

    private static void bookRooms() {
        int startDate = 5;
        int endDate = 7;
        int hotelId = 1;
        RoomType roomType = RoomType.GOLD;
        int numberOfRooms = 3;

        //find Hotel By ID
        Hotel hotel = hotelController.getHotelList().get(0);
        List<Room> roomList= bookingController.bookRooms(hotel,startDate, endDate,roomType,numberOfRooms);

        System.out.println("room booked::");
        for(Room room : roomList){
            System.out.println("room="+room.getId()+" type="+room.getRoomType());
        }

    }

    private static void findRoomsByDateAndHotel() {
        int startDate = 5;
        int endDate = 6;
        List<Room> availableRooms = bookingController.findRoomsByDateAndHotel(hotelController.getHotelList().get(0),RoomType.GOLD,startDate, endDate);
        System.out.println("room available::");
        for(Room room : availableRooms){
            System.out.println("room="+room.getId()+" type="+room.getRoomType());
        }
    }
    private static void findRoomsByDateAndHotel2() {
        int startDate = 5;
        int endDate = 6;
        List<Room> availableRooms = bookingController.findRoomsByDateAndHotel(hotelController.getHotelList().get(0),RoomType.SILVER,startDate, endDate);
        System.out.println("room available::");
        for(Room room : availableRooms){
            System.out.println("room="+room.getId()+" type="+room.getRoomType());
        }
    }
}