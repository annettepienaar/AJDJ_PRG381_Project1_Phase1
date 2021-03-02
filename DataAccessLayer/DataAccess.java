package DataAccessLayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

import BusinessLogicLayer.Customer;
import BusinessLogicLayer.Decoration;
import BusinessLogicLayer.Event;
import BusinessLogicLayer.Menu;
import BusinessLogicLayer.Venue;

public class DataAccess {
    File fPathCustomer, fPathEvent, fPathVenue, fPathMenu, fPathDecoration;
    public DataAccess(){
        fPathCustomer = new File("./DataAccessLayer/Customer.txt"); 
        fPathEvent = new File("./DataAccessLayer/Event.txt");
        fPathVenue = new File("./DataAccessLayer/Venue.txt");
        fPathMenu = new File("./DataAccessLayer/Menu.txt");
        fPathDecoration = new File("./DataAccessLayer/Decoration.txt");
    }

    //Event.txt
    public void FileInsert()
    {
        //Inserting of new info
    }

    public void FileModify()
    {
        //Modifying / Changing of info
    }

    public void FileDelete()
    {
        //Deletetion of info
    }

    public void getEventInfo() {
        List<Event> events = new ArrayList<Event>();
        try {
            Scanner myReader = new Scanner(fPathEvent);

            while (myReader.hasNextLine()) {
              String currentLine = myReader.nextLine();

              String[] words = currentLine.split(";"); 
              
              events.add(new Event(words[0], words[1], words[2], words[3], words[4], words[5], words[6], words[7], Integer.parseInt(words[8]), Integer.parseInt(words[9]), Float.parseFloat(words[10])));
            }

            myReader.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (Event info : events) {
            System.out.println(info.getBookingNumber() + "\t\t" + info.getEventType() + "\t\t" + info.getEventDate() + "\t" + info.getEventTime() + "\t\t" + info.getConfirmationDate() + " \t\t" + info.getFoodID() + "\t\t" + info.getVenueID() + "\t\t" + info.getDecorationID() + "\t\t" + info.getTotalAdults() + "\t\t" + info.getTotalKids() + "\t\t" + info.getTotalPrice());
        }
    }

    //For each of the different files --> Customer.txt, Event.txt, Venue.txt, Menu.txt, Decoration.txt
    //Customer.txt
    public void getCustomerInfo() {
        List<Customer> customers = new ArrayList<Customer>();
        try {
            Scanner myReader = new Scanner(fPathEvent);

            while (myReader.hasNextLine()) {
              String currentLine = myReader.nextLine();

              String[] words = currentLine.split(";"); 
              
              customers.add(new Customer(words[0], words[1], words[2], words[3], words[4], words[5]));
            }

            myReader.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (Customer info : customers) {
            System.out.println(info.getName() + "\t\t" + info.getSurname() + "\t\t" + info.getPhoneNumber() + "\t" + info.getEmail() + "\t\t" + info.getAddress() + " \t\t" + info.getIdNumber());
        }
    }

    //Decoration.txt
    public void getDecorationInfo() {
        List<Decoration> decorations = new ArrayList<Decoration>();
        try {
            Scanner myReader = new Scanner(fPathEvent);

            while (myReader.hasNextLine()) {
              String currentLine = myReader.nextLine();

              String[] words = currentLine.split(";"); 
              
              decorations.add(new Decoration(words[0], words[1], Float.parseFloat(words[2])));
            }

            myReader.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (Decoration info : decorations) {
            System.out.println(info.getDecorationID() + "\t\t" + info.getName() + "\t\t" + info.getPrice());
        }
    }

    //Menu.txt
    public void getMenuInfo() {
        List<Menu> menus = new ArrayList<Menu>();
        try {
            Scanner myReader = new Scanner(fPathEvent);

            while (myReader.hasNextLine()) {
              String currentLine = myReader.nextLine();

              String[] words = currentLine.split(";"); 
              
              menus.add(new Menu(words[0], words[1], Float.parseFloat(words[2]), Float.parseFloat(words[2])));
            }

            myReader.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (Menu info : menus) {
            System.out.println(info.getFoodID() + "\t\t" + info.getName() + "\t\t" + info.getNormalPrice()+ "\t\t" + info.getChildPrice());
        }
    }

    //Venue.txt
    public void getVenueInfo() {
        List<Venue> venues = new ArrayList<Venue>();
        try {
            Scanner myReader = new Scanner(fPathEvent);

            while (myReader.hasNextLine()) {
              String currentLine = myReader.nextLine();

              String[] words = currentLine.split(";"); 
              
              venues.add(new Venue(words[0], words[1], words[2], words[2]));
            }

            myReader.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (Venue info : venues) {
            System.out.println(info.getVenueID() + "\t\t" + info.getVenueName() + "\t\t" + info.getVenueAddress()+ "\t\t" + info.getVenuePhoneNumber());
        }
    }
}
