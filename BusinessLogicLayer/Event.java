package BusinessLogicLayer;

public class Event {
    //Booking Number;Event Type;Event Date;Event Time;Total Adults;Total Kids;Total Price;Confirmation Date;FoodID;VenueID;DecorationID
    //Keeping track of all events that have been registered to date

    //Fields
    String bookingNumber, eventType, eventDate, eventTime, confirmationDate, foodID, venueID, decorationID;
    int totalAdults, totalKids;
    float totalPrice;

    //Constructor
    public Event(String bookingNumber, String eventType, String eventDate, String eventTime, String confirmationDate,
            String foodID, String venueID, String decorationID, int totalAdults, int totalKids, float totalPrice) {
        this.bookingNumber = bookingNumber;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.confirmationDate = confirmationDate;
        this.foodID = foodID;
        this.venueID = venueID;
        this.decorationID = decorationID;
        this.totalAdults = totalAdults;
        this.totalKids = totalKids;
        this.totalPrice = totalPrice;
    }

    //Getters and Setters
    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(String confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getVenueID() {
        return venueID;
    }

    public void setVenueID(String venueID) {
        this.venueID = venueID;
    }

    public String getDecorationID() {
        return decorationID;
    }

    public void setDecorationID(String decorationID) {
        this.decorationID = decorationID;
    }

    public int getTotalAdults() {
        return totalAdults;
    }

    public void setTotalAdults(int totalAdults) {
        this.totalAdults = totalAdults;
    }

    public int getTotalKids() {
        return totalKids;
    }

    public void setTotalKids(int totalKids) {
        this.totalKids = totalKids;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    //Methods
    /*public int TotalAttendees(int totalAdults, int totalKids)
    {
        Return total number of people attending the event based on total adults and total kids attending
    }*/

    /*public float CalculateDiscount()
    {
        Return discount price if attendees are more than 40
    }*/

    /*public float CalculateTotalPrice()
    {

    }*/
}
