package PresentationLayer;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import BusinessLogicLayer.Decoration;
import BusinessLogicLayer.Event;
import BusinessLogicLayer.Menu;
import BusinessLogicLayer.Venue;
import BusinessLogicLayer.Customer;
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
        List<Customer> allCustomers = new ArrayList<Customer>();
        allCustomers = myAccess.getCustomerInfo();

        Scanner scanner = new Scanner(System.in);

        int option = scanner.nextInt();

        String bookingNum, cusID;
        
        while (option != 3) {
            MyMenu menu = MyMenu.values()[option];

            switch (menu) {
                case New:
                    //Code for customer to make new booking
                    cusID = scanner.nextLine();
                    boolean customerChk = false;
                    while (customerChk == false) {
                        for (Customer customer : allCustomers) {
                            if (!customer.getIdNumber().equalsIgnoreCase(cusID)) {
                                System.out.println("Please enter valid customer ID");
                                cusID = scanner.next();
                            }
                            else{
                                
                                customerChk = true;
                            }
                        }
                    }
                    //generates auto booking number
                    String bookingNumAuto = "";
                    int lastBookingNum = Integer.parseInt(allEvents.get(allEvents.size()-1).getBookingNumber());
                    System.out.println(lastBookingNum);


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

                    //Insert menu print function here.
                    System.out.println("Enter menu ID from selection above");
                    String menuInput = scanner.next();

                    boolean menuChk = false;
                    while (menuChk == false) {
                        for (Menu menuItem : allMenuItems ) {
                            if (menuItem.getFoodID().equalsIgnoreCase(menuInput)) {
                                menuChk = true;
                            }
                        }
                        System.out.println("Please choose a valid menu code");
                        menuInput = scanner.next();
                    }

                    //insert venue print function here
                    System.out.println("Enter venue ID from selection above");
                    String venueInput = scanner.next();

                    boolean venueChk = false;
                    while (venueChk == false) {
                        for (Venue venueItem : allVenues) {
                            if(venueItem.getVenueID().equalsIgnoreCase(venueInput)){
                                venueChk = true;
                            }
                        }
                        System.out.println("Please choose a valid venue code");
                        venueInput = scanner.next();
                    }

                    //insert decoration print function
                    System.out.println("Enter decoration from selection above");
                    String decorInput = scanner.next();

                    boolean decorChk = false;
                    while (decorChk == false) {
                        for (Decoration decorItem : allDecorations) {
                            if (decorItem.getDecorationID().equalsIgnoreCase(decorInput)) {
                                decorChk = true;
                            }
                        }                       
                        System.out.println("Please choose a valid decoration code");
                        decorInput = scanner.next();
                    }
                    System.out.println("Enter total amount of adults");
                    int totalAdults = scanner.nextInt();
                    System.out.println("Enter total amount of kids");
                    int totalChild = scanner.nextInt();

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
                        System.out.println(selcEvent.getBookingNumber() + "\t\t" + selcEvent.getEventType() + "\t\t" + selcEvent.getEventDate() + "\t" + selcEvent.getEventTime() + "\t\t" + selcEvent.getConfirmationDate() + " \t\t" + selcEvent.getFoodID() + "\t\t" + selcEvent.getVenueID() + "\t\t" + selcEvent.getDecorationID() + "\t\t" + selcEvent.getTotalAdults() + "\t\t" + selcEvent.getTotalKids() + "\t\t" + selcEvent.getTotalPrice()+ "\t\t" + selcEvent.getCustomerId());
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
