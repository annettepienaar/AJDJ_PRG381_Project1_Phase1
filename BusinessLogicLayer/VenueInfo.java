package BusinessLogicLayer;

public class VenueInfo {
    //Venue ID;VenueName;VenueLocation;PhoneNumber

    String venueName, venueLocation, venuePhone;

    public VenueInfo(String venueName, String venueLocation, String venuePhone) {
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
}
