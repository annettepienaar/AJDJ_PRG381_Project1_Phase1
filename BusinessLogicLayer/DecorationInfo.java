package BusinessLogicLayer;

public class DecorationInfo {
    //Booking Number;Number of Decorations;Decoration Type;Decoration Colour;
    String bookingNumber, decoType, decoColour;
    int decoAmount;

    public DecorationInfo(String bookingNumber, String decoType, String decoColour, int decoAmount) {
        this.bookingNumber = bookingNumber;
        this.decoType = decoType;
        this.decoColour = decoColour;
        this.decoAmount = decoAmount;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getDecoType() {
        return decoType;
    }

    public void setDecoType(String decoType) {
        this.decoType = decoType;
    }

    public String getDecoColour() {
        return decoColour;
    }

    public void setDecoColour(String decoColour) {
        this.decoColour = decoColour;
    }

    public int getDecoAmount() {
        return decoAmount;
    }

    public void setDecoAmount(int decoAmount) {
        this.decoAmount = decoAmount;
    }
}
