public class HotelInfo {
    public String hotelName;
    public int weekDayRate;
    public int ratings;
    public int weekEndRate;

    public HotelInfo(String hotelName, int rateForRegularCustomer,int hotelratings,int weekDayRate) {
        this.hotelName = hotelName;
        this.weekDayRate = rateForRegularCustomer;
        this.ratings=hotelratings;
        this.weekEndRate=weekDayRate;
    }

    public int getWeekEndRate() {
        return weekEndRate;
    }

    public void setWeekEndRate(int weekEndRate) {
        this.weekEndRate = weekEndRate;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getWeekDayRate() {
        return weekDayRate;
    }

    public void setWeekDayRate(int rateForRegularCustomer) {
        this.weekDayRate = rateForRegularCustomer;
    }
    public String toString(){
        return "HotelName:"+hotelName+",RatesForRegularCustomer:"+weekDayRate;
    }
}