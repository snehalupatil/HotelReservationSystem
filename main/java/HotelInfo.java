public class HotelInfo {

    public String hotelName;
    public int rateForRegularCustomer;

    public HotelInfo(String hotelName, int rateForRegularCustomer) {
        this.hotelName = hotelName;
        this.rateForRegularCustomer = rateForRegularCustomer;
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
        return "HotelName:"+hotelName+",RatesForRegularCustomer"+rateForRegularCustomer;
    }
}