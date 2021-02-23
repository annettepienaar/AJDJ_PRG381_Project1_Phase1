package BusinessLogicLayer;

public class FoodInfo {
    //Booking Number;Adult Meals;Kid Meals;Total Desserts

    String bookingNumber;
    int adultM, kidM, totalDesserts;

    public FoodInfo(String bookingNumber, int adultM, int kidM, int totalDesserts) {
        this.bookingNumber = bookingNumber;
        this.adultM = adultM;
        this.kidM = kidM;
        this.totalDesserts = totalDesserts;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public int getAdultM() {
        return adultM;
    }

    public void setAdultM(int adultM) {
        this.adultM = adultM;
    }

    public int getKidM() {
        return kidM;
    }

    public void setKidM(int kidM) {
        this.kidM = kidM;
    }

    public int getTotalDesserts() {
        return totalDesserts;
    }

    public void setTotalDesserts(int totalDesserts) {
        this.totalDesserts = totalDesserts;
    }    
}
