package PresentationLayer;

import java.util.Scanner;

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

        int bookingNum;
        
        while (option != 3) {
            MyMenu menu = MyMenu.values()[option];

            switch (menu) {
                case New:
                    //Code for making a new booking
                    break;
    
                case View:
                    System.out.println("Enter your booking Number: ");
                    bookingNum = scanner.nextInt();
    
                    //Code for fetching event info with mathing booking number
                    break;
    
                case Update:
                    System.out.println("Enter your booking Number: ");
                    bookingNum = scanner.nextInt();
    
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
