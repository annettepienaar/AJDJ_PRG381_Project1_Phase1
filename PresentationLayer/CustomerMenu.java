package PresentationLayer;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import BusinessLogicLayer.Decoration;
import BusinessLogicLayer.Event;
import BusinessLogicLayer.Menu;
import BusinessLogicLayer.Venue;
import DataAccessLayer.*;

public class CustomerMenu {
    enum MyMenu {
        New,
        View,
        Update,
        Exit;
    }

    public void showMenu()
    {
        System.out.println("0. New Booking");
        System.out.println("1. View Booking");
        System.out.println("2. Update Menu");
        System.out.println("3. Exit");
        
        DataAccess myAccess = new DataAccess();
        //Creation and initialization of event lists
        List<Event> allEvents = new ArrayList<Event>();
        allEvents = myAccess.getEventInfo();
        List<Menu> allMenuItems = new ArrayList<Menu>();
        allMenuItems = myAccess.getMenuInfo();
        List<Venue> allVenues = new ArrayList<Venue>();
        allVenues = myAccess.getVenueInfo();
        List<Decoration> allDecorations = new ArrayList<Decoration>();
        allDecorations = myAccess.getDecorationInfo();


        Scanner scanner = new Scanner(System.in);

        int option = scanner.nextInt();

        String bookingNum, cusID;
        
        while (option != 3) {
            MyMenu menu = MyMenu.values()[option];

            switch (menu) {
                case New:
                    //Code for customer to make new booking

                    float totalPrice = 0;

                    System.out.println("Enter your customerID");
                    cusID = scanner.next();

                    System.out.println("Enter event type: Wedding or Birthday");
                    String eventType = scanner.next();
                    while(!eventType.equalsIgnoreCase("Wedding")||!eventType.equalsIgnoreCase("Birthday")){
                        System.out.println("Please choose Wedding or Birthday...");
                        eventType = scanner.next();
                    }

                    System.out.println("Enter event date in format dd/mm/yyyy");
                    String eventDate = scanner.next();

                    System.out.println("Enter event time 24hr format: hh:mm");
                    String eventTime = scanner.next();

                    //Insert menu Menu Print function here.
                    List<String> menuIDList = new ArrayList<String>();
                    
                    for (Menu menuItem: allMenuItems) {
                        menuIDList.add(menuItem.getFoodID());
                    }

                    System.out.println("Enter menu ID from selection above");
                    String menuInput = scanner.next();

                    boolean menuChk = false;
                    while (menuChk== false) {
                        for (String menuID : menuIDList) {
                            if (menuID.equalsIgnoreCase(menuInput)) {
                                menuChk = true;
                            }
                        }
                        System.out.println("Please choose a valid menu code");
                        menuInput = scanner.next();
                    }

                    System.out.println("Enter venue ID from selection above");
                    System.out.println();
                    System.out.println("Enter total amount of adults");
                    System.out.println("Enter total amount of kids");

                    break;
    
                case View:
                    //Code to show a customers bookings
                    System.out.println("Enter your customerID: ");
                    cusID = scanner.next();

                    List<Event> selectedEvents = new ArrayList<Event>();

                    for (Event thisEvent : allEvents) {
                        if (cusID.equals(thisEvent.getCustomerId())) {
                            selectedEvents.add(new Event(thisEvent.getBookingNumber(), thisEvent.getEventType(), thisEvent.getEventDate(), thisEvent.getEventTime(), thisEvent.getConfirmationDate(), thisEvent.getFoodID(), thisEvent.getVenueID(), thisEvent.getDecorationID(), thisEvent.getTotalAdults(), thisEvent.getTotalKids(), thisEvent.getTotalPrice(), thisEvent.getCustomerId()));
                        }                        
                    }

                    System.out.println("Booking Number\tEvent Type\tEvent Date\tEvent Time\tConfirmation Date\tFood ID\t\tVenue ID\tDecoration ID\tTotal Adults\tTotal Kids\tTotal Price\tCustomer Id");

                    for (Event selcEvent : selectedEvents) {
                        System.out.println(selcEvent.getBookingNumber() + "\t\t" + selcEvent.getEventType() + "\t\t" + selcEvent.getEventDate() + "\t" + selcEvent.getEventTime() + "\t\t" + selcEvent.getConfirmationDate() + " \t\t" + selcEvent.getFoodID() + "\t\t" + selcEvent.getVenueID() + "\t\t" + selcEvent.getDecorationID() + "\t\t" + selcEvent.getTotalAdults() + "\t\t" + selcEvent.getTotalKids() + "\t\t" + selcEvent.CalculateFinalPrice()+ "\t\t" + selcEvent.getCustomerId());
                    }

                    //Code for fetching event info with mathing booking number
                    break;
    
                case Update:
                    System.out.println("Enter your booking Number: ");
                    bookingNum = scanner.nextLine();
    
                    //Code for fetching and editing menu of event and confirming booking
                    break;
            
                default:
                    break;
            }

            System.out.println("0. New Booking");
            System.out.println("1. View Booking");
            System.out.println("2. Update Menu");
            System.out.println("3. Exit");

            option = scanner.nextInt();
        }

        scanner.close();
    }
}
