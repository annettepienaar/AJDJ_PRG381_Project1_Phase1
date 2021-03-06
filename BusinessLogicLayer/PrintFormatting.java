package BusinessLogicLayer;

import java.util.List;
import java.util.ArrayList;

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
}
