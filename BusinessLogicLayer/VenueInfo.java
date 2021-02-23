package BusinessLogicLayer;

public class VenueInfo {
    //Venue ID;VenueName;VenueLocation;PhoneNumber

    String venueName, venueLocation, venuePhone;
    int venueID;

    public VenueInfo(int venueID, String venueName, String venueLocation, String venuePhone) {
        this.venueID = venueID;
        this.venueName = venueName;
        this.venueLocation = venueLocation;
        this.venuePhone = venuePhone;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueLocation() {
        return venueLocation;
    }

    public void setVenueLocation(String venueLocation) {
        this.venueLocation = venueLocation;
    }

    public String getVenuePhone() {
        return venuePhone;
    }

    public void setVenuePhone(String venuePhone) {
        this.venuePhone = venuePhone;
    }

    public int getVenueID() {
        return venueID;
    }

    public void setVenueID(int venueID) {
        this.venueID = venueID;
    }
}
