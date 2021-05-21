import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class HotelReservationSystem  {

    /*
            Add  hotels
     */

    ArrayList<HotelInfo> hotelInfo = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    HotelInfo hotelReservation;
    public void addHotel() {
        hotelInfo.add(new HotelInfo("LakeWood", 110,3));
        hotelInfo.add(new HotelInfo("BridgeWood", 160,4));
        hotelInfo.add(new HotelInfo("RidgeWood", 220,5));
        hotelInfo.stream().forEach(System.out::println);
    }

    /*
        *Find the cheapest hotel with rate
     */

    public String CheapestHotelAndRate(String arrivalDate, String checkoutDate) {

        Date StartDate = convertStringToDate(arrivalDate);
        Date EndDate = convertStringToDate(checkoutDate);
        long Duration = EndDate.getTime()-StartDate.getTime();

        int Days = (int) TimeUnit.DAYS.convert(Duration,TimeUnit.MILLISECONDS);

        for (int hotel = 0; hotel < hotelInfo.size(); hotel++) {
            int newRate = getRateForRegularCustomer() * (Days);
            hotelInfo.get(hotel).setRateForRegularCustomer(newRate);
        }
        int regularRate = hotelInfo.stream().min(Comparator.comparing(HotelInfo::getRateForRegularCustomer)).get().getRateForRegularCustomer();
        String hotelName = hotelInfo.stream().min(Comparator.comparing(HotelInfo::getRateForRegularCustomer)).get().getHotelName();

        System.out.println(hotelName + ", Total Rates: $" + regularRate);

        return hotelName + ", $" + regularRate;

    }

    /*
            Convert string date to date format ddmmyyyy
     */
    public Date convertStringToDate(String dateString) {
        Date date;
        DateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
        date = dateFormat.parse(dateString);
        return date;
    }

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hotel Reservation System");

        System.out.println("Enter arrival date: ");
        String arrivalDate = scanner.nextLine();
        System.out.println("Enter the checkout date: ");
        String checkoutDate =scanner.nextLine();
        addHotel();
        CheapestHotelAndRate(arrivalDate,checkoutDate);

    }
}
