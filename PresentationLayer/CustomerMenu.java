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
        NewBook,
        NewCus,
        View,
        Update,
        Exit;
    }

    public void showMenu()
    {
        System.out.println("0. New Booking");
        System.out.println("1. New Customer");
        System.out.println("2. View Booking");
        System.out.println("3. Update Menu");
        System.out.println("4. Exit");
        
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

        String bookingNum = "", cusID = "";
        
        while (option != 4) {
            MyMenu menu = MyMenu.values()[option];

            switch (menu) {
                case NewBook:
                    //Code for customer to make new booking
                    
                    float totalPrice = 0;
                    boolean customerChk = false;
                    while (customerChk == false) {
                        System.out.println("Please enter customer ID");
                        cusID = scanner.next();
                        for (Customer customer : allCustomers) {
                            if (customer.getIdNumber().equalsIgnoreCase(cusID)) {
                                customerChk = true;
                            }
                        }
                    }

                    //generates auto booking number
                    String bookingNumAuto = "";
                    int lastBookingNum = Integer.parseInt(allEvents.get(allEvents.size()-1).getBookingNumber());
                    if (lastBookingNum<10) {
                        lastBookingNum++;
                        bookingNumAuto = "00" + lastBookingNum;
                    }
                    else if(lastBookingNum < 100){
                        lastBookingNum++;
                        bookingNumAuto = "0" + lastBookingNum;
                    }
                    else{
                        lastBookingNum++;
                        bookingNumAuto ="" + lastBookingNum;
                    }
                    String eventType = "";
                    boolean eventTypeChk = false;
                    while(eventTypeChk == false){
                        System.out.println("Enter event type: Wedding or Birthday");
                        eventType = scanner.next();
                        for (Event event : allEvents) {
                            if (event.getEventType().equalsIgnoreCase(eventType)) {
                                eventTypeChk = true;
                            }
                        }
                    }

                    System.out.println("Enter event date in format dd/mm/yyyy");
                    String eventDate = scanner.next();

                    System.out.println("Enter event time 24hr format: hh:mm");
                    String eventTime = scanner.next();

                    //Insert menu print function here.
                    
                    String menuInput = "";

                    float childPrice = 0, adultPrice = 0;

                    boolean menuChk = false;
                    while (menuChk== false) {
                        System.out.println("Enter menu ID from s election above");
                        menuInput = scanner.next();
                        for (Menu menuID : allMenuItems) {
                            if (menuID.getFoodID().equalsIgnoreCase(menuInput)) {
                                menuChk = true;
                                childPrice = menuID.getChildPrice();
                                adultPrice = menuID.getNormalPrice();
                            }
                        }
                    }

                    //insert venue print function here
                    String venueInput = "";
                    boolean venueChk = false;
                    while (venueChk == false) {
                        System.out.println("Enter venue ID from selection above");
                        venueInput = scanner.next();
                        for (Venue venueItem : allVenues) {
                            if(venueItem.getVenueID().equalsIgnoreCase(venueInput)){
                                venueChk = true;
                            }
                        }
                    }

                    //insert decoration print function
                    String decorInput = "";
                    float decoPrice = 0;

                    boolean decorChk = false;
                    while (decorChk == false) {
                        System.out.println("Enter decoration from selection above");
                        decorInput = scanner.next();
                        for (Decoration decorItem : allDecorations) {
                            if (decorItem.getDecorationID().equalsIgnoreCase(decorInput)) {
                                decorChk = true;
                                decoPrice = decorItem.getPrice();
                            }
                        }                       
                    }
                    System.out.println("Enter total amount of adults");
                    int totalAdults = scanner.nextInt();
                    System.out.println("Enter total amount of kids");
                    int totalChild = scanner.nextInt();

                    String confirmationDate = "";
                    
                    float totalPriceCalc = (float)(totalAdults * adultPrice) + (totalChild * childPrice) + decoPrice;

                    myAccess.addEvent(bookingNumAuto, eventType, eventDate, eventTime, confirmationDate, menuInput, venueInput, decorInput, totalAdults, totalChild,totalPriceCalc,cusID);
                    

                    break;

                case NewCus:
                    Scanner myScanner = new Scanner(System.in);

                    System.out.println("Enter your name: ");
                    String cusName = myScanner.nextLine();

                    System.out.println("Enter your surname: ");
                    String cusSur = myScanner.nextLine();

                    System.out.println("Enter your phone number: "); 
                    String cusPhone = myScanner.nextLine();

                    System.out.println("Enter your email address: ");
                    String cusEmail = myScanner.nextLine();

                    System.out.println("Enter your address: ");
                    String cusAddress = myScanner.nextLine();

                    String cusIDAuto = "";
                    int lastCusID = Integer.parseInt(allCustomers.get(allCustomers.size()-1).getIdNumber());
                    if (lastCusID<10) {
                        lastCusID++;
                        cusIDAuto = "000" + lastCusID;
                    }
                    else if (lastCusID<100) {
                        lastCusID++;
                        cusIDAuto = "00" + lastCusID;
                    }
                    else if (lastCusID<1000) {
                        lastCusID++;
                        cusIDAuto = "0" + lastCusID;
                    }
                    else {
                        lastCusID++;
                        cusIDAuto = "" + lastCusID;;
                    }

                    myAccess.addCustomer(cusName, cusSur, cusPhone, cusEmail, cusAddress, cusIDAuto);
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

                    //Code for fetching event info with matching booking number
                    break;
    
                case Update:
                    
                    String menuIn = "";
                    boolean updateChk = false;
                    while (updateChk == false) {
                        System.out.println("Enter your booking Number: ");
                        bookingNum = scanner.nextLine();
                        
                    }
                    //insert menu print function
                    menuChk = false;
                    while (menuChk == false) {
                        System.out.println("Enter menu ID from selection above");
                        menuIn = scanner.next();
                        for (Menu menuItem : allMenuItems ) {
                            if (menuItem.getFoodID().equalsIgnoreCase(menuIn)) {
                                menuChk = true;
                            }
                        }
                    }
                    for (Event event : allEvents) {
                        if (event.getBookingNumber().equalsIgnoreCase(bookingNum)) {
                            event.setFoodID(menuIn);
                        }
                    }

                    myAccess.updateEvent(allEvents);
                    

                    //Code for fetching and editing menu of event and confirming booking
                    break;
            
                default:
                    break;
            }

            System.out.println("0. New Booking");
            System.out.println("1. New Customer");
            System.out.println("2. View Booking");
            System.out.println("3. Update Menu");
            System.out.println("4. Exit");

            option = scanner.nextInt();
        }

        scanner.close();
    }
}
