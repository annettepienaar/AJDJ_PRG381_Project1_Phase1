package PresentationLayer;

import java.util.Scanner;
import BusinessLogicLayer.Event;
import BusinessLogicLayer.PrintFormatting;
import DataAccessLayer.*;
import java.util.ArrayList;
import java.util.List;

public class OwnerMenu {
    enum MyMenu {
        ViewAll, Confirmed, NonConfirmed, DeleteBooking, Exit;
    }

    List<Event> ownEvent = new ArrayList<Event>();
    DataAccess obj = new DataAccess();

    public OwnerMenu() {
        getList();
    }

    public void getList() {
        ownEvent = obj.getEventInfo();
    }

    public void showMenu()
    {
        System.out.println("0. View All Bookings");
        System.out.println("1. View all Confirmed Bookings");
        System.out.println("2. View all Non-Confirmed Bookings");
        System.out.println("3. Delete a Booking");
        System.out.println("4. Exit");
        
        Scanner scanner = new Scanner(System.in);

        int option = scanner.nextInt();

        while (option != 4) {
            MyMenu menu = MyMenu.values()[option];

            switch (menu) {
                case ViewAll:
                    //Code for viewing all bookings                 
                    PrintFormatting.formatAllEvent(ownEvent);
                    break;
    
                case Confirmed:
                    //Code for viewing all confirmed bookings 
                    
                    List<Event> confirmedEvent = new ArrayList<Event>();

                    for (Event thisEvent : ownEvent) {
                        if(!thisEvent.getConfirmationDate().isBlank()){
                            confirmedEvent.add(thisEvent);
                        }
                    }
                    
                    PrintFormatting.formatAllEvent(confirmedEvent);
                    break;
    
                case NonConfirmed:
                    //Code for viewing all non-confirmed bookings
                    List<Event> nonConfirmedEvent = new ArrayList<Event>();

                    for (Event thisEvent : ownEvent) {
                        if(thisEvent.getConfirmationDate().isBlank()){
                            nonConfirmedEvent.add(thisEvent);
                        }
                    }
                    
                    PrintFormatting.formatAllEvent(nonConfirmedEvent);
                    break;

                case DeleteBooking:

                    Scanner sc = new Scanner(System.in);
                    System.out.println("Delete booking number: ");

                    String deleteNum = sc.nextLine();

                    try{
                        obj.DeleteEventInfo(deleteNum);
                        System.out.println("Event has been deleted");
                    }catch(Exception e){
                        System.out.println("Something went wrong try again later");
                    }
                    

                    getList();

                    break;

                case Exit:
                    System.out.println("Exit program...");
                    break;
            
                default:
                    System.out.println("Invalid option!");
                    break;
            }

            System.out.println("0. View All Bookings");
            System.out.println("1. View all Confirmed Bookings");
            System.out.println("2. View all Non-Confirmed Bookings");
            System.out.println("3. Delete a Booking");
            System.out.println("4. Exit");

            option = scanner.nextInt();
        }   
        
        scanner.close();
    }
}
