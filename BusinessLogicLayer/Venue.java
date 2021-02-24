package BusinessLogicLayer;

public class Venue {
    //Venue ID;Venue Name;Venue Address;Venue Phone Number
    //Storing various venues available as a choice for events

    //Fields
    String venueID, venueName, venueAddress, venuePhoneNumber;

    //Constructor
    public Venue(String venueID, String venueName, String venueAddress, String venuePhoneNumber) {
        this.venueID = venueID;
        this.venueName = venueName;
        this.venueAddress = venueAddress;
        this.venuePhoneNumber = venuePhoneNumber;
    }

    //Getters and Setters
    public String getVenueID() {
        return venueID;
    }

    public void setVenueID(String venueID) {
        this.venueID = venueID;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueAddress() {
        return venueAddress;
    }

    public void setVenueAddress(String venueAddress) {
        this.venueAddress = venueAddress;
    }

    public String getVenuePhoneNumber() {
        return venuePhoneNumber;
    }

    public void setVenuePhoneNumber(String venuePhoneNumber) {
        this.venuePhoneNumber = venuePhoneNumber;
    }    
}
