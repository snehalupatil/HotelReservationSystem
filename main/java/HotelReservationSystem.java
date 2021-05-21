import java.util.ArrayList;

public class HotelReservationSystem  {
    ArrayList<HotelInfo> hotelInfo=new ArrayList<HotelInfo>();

    public  void addHotelNameAndRatesForRegularCustomer()  {

        hotelInfo.add(new HotelInfo("LakeWood",110));
        hotelInfo.add(new HotelInfo("BridgeWood",160));
        hotelInfo.add(new HotelInfo("RidgeWood",220));
        hotelInfo.stream().forEach(System.out::println);
    }
}

    public static void main(String[] args){

        System.out.println("Welcome to Hotel Reservation System");
        addHotelNameAndRatesForRegularCustomer();
    }
}