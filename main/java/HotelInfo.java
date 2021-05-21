public class HotelInfo {

    public String hotelName;
    public int rateForRegularCustomer;
    public int ratings;

    public HotelInfo(String hotelName, int rateForRegularCustomer,int hotelratings) {
        this.hotelName = hotelName;
        this.rateForRegularCustomer = rateForRegularCustomer;
        this.ratings=hotelratings;
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

    public int getRateForRegularCustomer() {
        return rateForRegularCustomer;
    }

    public void setRateForRegularCustomer(int rateForRegularCustomer) {
        this.rateForRegularCustomer = rateForRegularCustomer;
    }
    public String toString(){
        return "HotelName:"+hotelName+",RatesForRegularCustomer:"+rateForRegularCustomer;
    }
}