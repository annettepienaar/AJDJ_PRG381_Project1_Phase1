package PresentationLayer;

import java.util.Scanner;

public class BookingApplication {
    enum Menu {
        Customer,
        Owner,
        Exit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("0. Customer");
        System.out.println("1. Owner");

        int option = scanner.nextInt();

        while (option != 2) {
            Menu menu1 = Menu.values()[option];

            switch (menu1) {
                case Customer:
                    CustomerMenu cMenu = new CustomerMenu();
                    cMenu.showMenu();
                    break;

                case Owner:
                    OwnerMenu oMenu = new OwnerMenu();
                    oMenu.showMenu();
                    break;

                case Exit:
                    System.out.println("Exit program...");
                    break;
        
                default:
                    System.out.println("Invalid option!");
                    break;
            }

            System.out.println("0. Customer");
            System.out.println("1. Owner");

            option = scanner.nextInt();
        }  
        
        scanner.close();
    }
}
