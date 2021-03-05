package DataAccessLayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.io.*;

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

    public List<Event> getEventInfo() {
        List<Event> events = new ArrayList<Event>();
        
        try {
            Scanner myReader = new Scanner(fPathEvent);

            while (myReader.hasNextLine()) {
              String currentLine = myReader.nextLine();

              String[] words = currentLine.split(";"); 
              
              events.add(new Event(words[0], words[1], words[2], words[3], words[4], words[5], words[6], words[7], Integer.parseInt(words[8]), Integer.parseInt(words[9]), Float.parseFloat(words[10]), words[11]));
            }

            myReader.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return events;
    }

    public void DeleteEventInfo(String bookingNumber) throws IOException {

        List<Event> ownEvent = new ArrayList<>();
        ownEvent = getEventInfo();

        List<Event> newEventLst = new ArrayList<Event>();

            for (Event thisEvent : ownEvent) {
                if(!thisEvent.getBookingNumber().equalsIgnoreCase(bookingNumber)){
                    newEventLst.add(thisEvent);
                }
            }
                    
            FileWriter myWriter = new FileWriter(fPathEvent);

            for (Event info : newEventLst) {
                myWriter.write(info.getBookingNumber() + ";" + info.getEventType() + ";" + info.getEventDate() + ";" + info.getEventTime() + ";" + info.getConfirmationDate() + ";" + info.getFoodID() + ";" + info.getVenueID() + ";" + info.getDecorationID() + ";" + info.getTotalAdults() + ";" + info.getTotalKids() + ";" + info.getTotalPrice()+ ";" + info.getCustomerId() + "\n");
            }

            myWriter.close();
    }

    //For each of the different files --> Customer.txt, Event.txt, Venue.txt, Menu.txt, Decoration.txt
    //Customer.txt
    public List<Customer> getCustomerInfo() {
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

        return customers;
    }

    //Decoration.txt
    public List<Decoration> getDecorationInfo() {
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

        return decorations;
    }

    //Menu.txt
    public List<Menu> getMenuInfo() {
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

        return menus;
    }

    //Venue.txt
    public List<Venue> getVenueInfo() {
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

        return venues;
    }
}
