package BusinessLogicLayer;

public class EventInfo {
    //Booking Number;Event Type;Event Date;Event Time;Total Atendees;Kids Attending;Adults Attending;Total Price:Decoration;

    String bookingNumber, eventType, eventDate, eventTime, decoration;
    int attTotal, aTotal, kTotal, totalPrice;

    public EventInfo(String bookingNumber, String eventType, String eventDate, String eventTime, String decoration,
            int attTotal, int aTotal, int kTotal, int totalPrice) {
        this.bookingNumber = bookingNumber;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.decoration = decoration;
        this.attTotal = attTotal;
        this.aTotal = aTotal;
        this.kTotal = kTotal;
        this.totalPrice = totalPrice;
    }

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

    public String getDecoration() {
        return decoration;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    public int getAttTotal() {
        return attTotal;
    }

    public void setAttTotal(int attTotal) {
        this.attTotal = attTotal;
    }

    public int getaTotal() {
        return aTotal;
    }

    public void setaTotal(int aTotal) {
        this.aTotal = aTotal;
    }

    public int getkTotal() {
        return kTotal;
    }

    public void setkTotal(int kTotal) {
        this.kTotal = kTotal;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
