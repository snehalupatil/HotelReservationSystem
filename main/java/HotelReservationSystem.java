import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class HotelReservationSystem  {

    /*
            *This methis will Add  hotels
            *
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
        *this methos will Find the cheapest hotel with rate
     */
    public boolean toCheckDate(String dateToReserved, String dateFromat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(dateToReserved);
            Calendar currentDateAfter3Months = Calendar.getInstance();
            currentDateAfter3Months.add(Calendar.MONTH, 3);

            Calendar currentDateBefore3Months = Calendar.getInstance();
            currentDateBefore3Months.add(Calendar.MONTH, -3);

            if (date.before(currentDateAfter3Months.getTime()) && date.after(currentDateBefore3Months.getTime())) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }




    public String CheapestHotelAndRate(String arrivalDate, String checkoutDate) throws ParseException {


        String dateRegex = "^(([0-9])|([0-2][0-9])|([3][0-1]))(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\\d{4}$";
        if(!arrivalDate.matches(dateRegex) && !checkoutDate.matches(dateRegex)) {
            System.out.println("Invalid date");
            System.exit(0);


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
    public Date convertStringToDate(String dateString) throws ParseException{
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
