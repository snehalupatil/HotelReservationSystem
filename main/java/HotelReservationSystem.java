import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class HotelReservationSystem  {

    ArrayList<HotelInfo> hotelInfo = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    HotelInfo hotelReservation;
    public void addHotel() {
        hotelInfo.add(new HotelInfo("LakeWood", 110,3,90));
        hotelInfo.add(new HotelInfo("BridgeWood", 160,4,50));
        hotelInfo.add(new HotelInfo("RidgeWood", 220,5,150));
        hotelInfo.stream().forEach(System.out::println);
    }

    public String CheapestHotelAndRate(String arrivalDate, String checkoutDate) throws ParseException {
        String dateRegex = "^(([0-9])|([0-2][0-9])|([3][0-1]))(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\\d{4}$";
        if(!arrivalDate.matches(dateRegex) && !checkoutDate.matches(dateRegex)) {
            System.out.println("Invalid date");
            System.exit(0);
        }
        LocalDate StartDate = convertStringToDate(arrivalDate);
        LocalDate EndDate = convertStringToDate(checkoutDate);
        int minHotelBill = Integer.MAX_VALUE;
        String minWeeKDayHotelName = null;
        String minWeekEndHotelName=null;

        for (HotelInfo hotelDetails : hotelInfo) {
            LocalDate start = StartDate;
            LocalDate end = EndDate.plusDays(1);
            int hotelBill = 0;
            while (!(start.equals(end))) {
                int day = start.getDayOfWeek().getValue();
                if (day == 6 || day == 7){
                    hotelBill = hotelBill +hotelDetails.getWeekEndRate();
                }
                else{
                    hotelBill = hotelBill + hotelDetails.getWeekDayRate();
                }
                start = start.plusDays(1);
            }
            minWeeKDayHotelName=hotelInfo.stream().min((Comparator.comparing(HotelInfo::getWeekDayRate))).get().getHotelName();
            minWeekEndHotelName=hotelInfo.stream().min((Comparator.comparing(HotelInfo::getWeekEndRate))).get().getHotelName();

            if (hotelBill <= minHotelBill) {
                minHotelBill = hotelBill;
                System.out.println(minWeeKDayHotelName+" and "+minWeekEndHotelName+","+minHotelBill);
            }
        }

        return minWeeKDayHotelName+" and "+minWeekEndHotelName+","+minHotelBill;
    }
    public static LocalDate convertStringToDate(String dateString) {
        LocalDate date = null;
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("ddMMMyyyy");
        try {
            date = LocalDate.parse(dateString, dateTimeFormat);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
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
