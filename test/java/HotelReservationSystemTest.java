import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;



public class HotelReservationSystemTest {

    @Test
    public void givenHotelName_And_RegularCustomerRate_ShouldAddHotel()throws Exception{
        Hotel hotel = new Hotel();
        hotel.setHotelName("Lakewood");
        hotel.setRegularCustomerRate(110);
        Assertions.assertEquals("Lakewood",hotel.getHotelName());
        Assertions.assertEquals(110,hotel.getRegularCustomerRate());
    }

    /**
     * this test case will check the cheapestHotel from the list according to the days.
     */
    @Test
    public void givenRegularCustomerRate_ShouldCheapestHotel() {
        HotelReservationSystem hotelReservation = new HotelReservationSystem();
        Hotel Lakewood = new Hotel("Lakewood",110);
        Hotel Bridgewood = new Hotel("Bridgewood",160);
        Hotel RidgeWood = new Hotel("Ridgewood",220);
        hotelReservation.addHotel(Lakewood);
        hotelReservation.addHotel(Bridgewood);
        hotelReservation.addHotel(RidgeWood);
        Hotel result = hotelReservationSystem.CheapestHotelAndRate(Days);
        System.out.println(result);
        Assertions.assertEquals(Lakewood,result);
    }
}
}
