package BusinessLogicLayer;

import java.util.List;

public class PrintFormatting {
    public static void formatAllEvent(List<Event> eventsList){
        String formatString = "%-14s %10s %20s %15s %20s %15s %15s %15s %15d %15d %20f %15s ";
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%14s %10s %20s %15s %20s %15s %15s %15s %15s %15s %20s %15s","BookingNumber","Type","Date","Time","Confirmation","MenuID","VenueID","DecorationID","TotalAdults","TotalKids","TotalPrice","CustomerID\n");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Event event : eventsList) {
            System.out.printf(formatString, event.getBookingNumber(),event.getEventType(), event.getEventDate(),event.getEventTime(),event.getConfirmationDate(),event.getFoodID(),
                event.getVenueID(),event.getDecorationID(),event.getTotalAdults(),event.getTotalKids(),event.getTotalPrice(),event.getCustomerId());
            System.out.println();
        }
    }
    public static void formatMenu(List<Menu> menuList){
        String formatString = "%-10s %15s %15f %15f";
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %15s %15s %15s","MenuID","Name","NormalPrice","ChildPrice\n");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Menu menu : menuList) {
            System.out.printf(formatString, menu.getFoodID(),menu.getName(),menu.getNormalPrice(),menu.getChildPrice());
            System.out.println();
        }
    }

    public static void formatVenue(List<Venue> venueList){
        String formatString = "%-10s %15s %20s %15s";

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %15s %20s %15s","VenueID","Name","Address","PhoneNumber\n");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Venue venue : venueList) {
            System.out.printf(formatString, venue.getVenueID(), venue.getVenueName(), venue.getVenueAddress(), venue.getVenuePhoneNumber());
            System.out.println();
        }
    }
    
    public static void formatDecoratoin(List<Decoration> decorationList){
        String formatString = "%-15s %15s %15f";
        
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%15s %15s %15s","DecorationID","Name","Price\n");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Decoration decoration : decorationList) {
            System.out.printf(formatString, decoration.getDecorationID(), decoration.getName(), decoration.getPrice());
            System.out.println();
        }
    }
}
