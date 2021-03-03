package PresentationLayer;

import java.util.Scanner;
import BusinessLogicLayer.Event;
import DataAccessLayer.*;

import java.util.ArrayList;
import java.util.List;

public class OwnerMenu {
    enum MyMenu {
        ViewAll,
        Confirmed,
        NonConfirmed,
        Exit;
    }

    public void showMenu ()
    {
        System.out.println("0. View All Bookings");
        System.out.println("1. View all Confirmed Bookings");
        System.out.println("2. View all Non-Confirmed Bookings");
        System.out.println("3. Exit");
        
        Scanner scanner = new Scanner(System.in);

        int option = scanner.nextInt();

        while (option != 3) {
            MyMenu menu = MyMenu.values()[option];

            switch (menu) {
                case ViewAll:
                    //Code for viewing all bookings
                    List<Event> ownEvent = new ArrayList<Event>();

                    DataAccess obj = new DataAccess();

                    ownEvent = obj.getEventInfo();
                    
                    System.out.println("Booking Number\tEvent Type\tEvent Date\tEvent Time\tConfirmation Date\tFood ID\t\tVenue ID\tDecoration ID\tTotal Adults\tTotal Kids\tTotal Price\tCustomer Id");

                    for (Event info : ownEvent) {
                        System.out.println(info.getBookingNumber() + "\t\t" + info.getEventType() + "\t\t" + info.getEventDate() + "\t" + info.getEventTime() + "\t\t" + info.getConfirmationDate() + " \t\t" + info.getFoodID() + "\t\t" + info.getVenueID() + "\t\t" + info.getDecorationID() + "\t\t" + info.getTotalAdults() + "\t\t" + info.getTotalKids() + "\t\t" + info.getTotalPrice()+ "\t\t" + info.getCustomerId());
                    }

                    break;
    
                case Confirmed:
                    //Code for viewing all confirmed bookings
                    break;
    
                case NonConfirmed:
                    //Code for viewing all non-confirmed bookings
                    break;

                case Exit:
                    System.out.println("Exit program...");
                    break;
            
                default:
                    System.out.println("Invalid option!");
                    break;
            }

            System.out.println("0. View All Bookings");
            System.out.println("2. View all Confirmed Bookings");
            System.out.println("1. View all Non-Confirmed Bookings");
            System.out.println("3. Exit");

            option = scanner.nextInt();
        }   
        
        scanner.close();
    }
}
