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

                    DataAccess obj = new DataAccess();
                    System.out.println("Booking Number\tEvent Type\tEvent Date\tEvent Time\tConfirmation Date\tFood ID\t\tVenue ID\tDecoration ID\tTotal Adults\tTotal Kids\tTotal Price");
                    obj.getEventInfo();
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
