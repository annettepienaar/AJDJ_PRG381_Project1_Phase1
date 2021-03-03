package PresentationLayer;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

import java.util.List;
import java.util.ArrayList;

import BusinessLogicLayer.Event;
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
        
        Scanner scanner = new Scanner(System.in);

        int option = scanner.nextInt();

        String bookingNum, cusID;
        
        while (option != 3) {
            MyMenu menu = MyMenu.values()[option];

            switch (menu) {
                case New:
                    //Code for making a new booking
                    break;
    
                case View:
                    System.out.println("Enter your customerID: ");
                    cusID = scanner.next();

                    DataAccess myAccess = new DataAccess();

                    List<Event> allEvents = new ArrayList<Event>();
                    allEvents = myAccess.getEventInfo();

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
    
                    //Code for fetching and editing menu of event
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
