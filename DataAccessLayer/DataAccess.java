package DataAccessLayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

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

    //For each of the different files --> Customer.txt, Event.txt, Venue.txt, Menu.txt, Decoration.txt
    //Customer.txt
    public List<Customer> getCustomerInfo() {
        List<Customer> customers = new ArrayList<Customer>();

        try {
            Scanner myReader = new Scanner(fPathCustomer);

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
            Scanner myReader = new Scanner(fPathDecoration);

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
            Scanner myReader = new Scanner(fPathMenu);

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
            Scanner myReader = new Scanner(fPathVenue);

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

    public void addCustomer(String name, String surname, String phone, String email, String address, String idNumber) {
        try {        
            FileWriter fileWriter = new FileWriter(fPathCustomer, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            printWriter.write(name + ";" + surname + ";" + phone + ";" + email + ";" + address + ";" + idNumber+"\r");

            bufferedWriter.close();
            printWriter.close();
            fileWriter.close();
            System.out.println("Customer added!");
        } catch(IOException e){
            System.out.println("Error: " + e.toString());
        }
    }
    public void updateEvent(List<Event> event) {

        try {        
            FileWriter fileWriter = new FileWriter(fPathEvent, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            for (Event eventItem : event) {
                printWriter.write(eventItem.getBookingNumber() + ";" + eventItem.getEventType() + ";" + eventItem.getEventDate() + ";" + eventItem.getEventTime() + ";" + eventItem.getConfirmationDate() + ";" + eventItem.getFoodID() + ";" + eventItem.getVenueID() + ";" + eventItem.getDecorationID() + ";" + eventItem.getTotalAdults() + ";" + eventItem.getTotalKids() + ";" + eventItem.getTotalPrice() + ";" + eventItem.getCustomerId());
            }

            

            bufferedWriter.close();
            printWriter.close();
            fileWriter.close();
            System.out.println("Entry updated");
        } catch(IOException e){
            System.out.println("Error: " + e.toString());
        }
    }
    public void addEvent(String bookingNumber,String eventType,String eventDate,String eventTime,String confirmationDate,String foodID,String venueID,
        String decorationID, int totalAdults, int totalKids, float totalprice, String customerID) {

        try {        
            FileWriter fileWriter = new FileWriter(fPathEvent, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            printWriter.write(bookingNumber + ";" + eventType + ";" + eventDate + ";" + eventTime + ";" + confirmationDate + ";" + foodID + ";" + venueID + ";" + 
                decorationID + ";" + totalAdults + ";" + totalKids + ";" + totalprice + ";" + customerID);

            bufferedWriter.close();
            printWriter.close();
            fileWriter.close();
            System.out.println("Your booking number is: " + bookingNumber);
        } catch(IOException e){
            System.out.println("Error: " + e.toString());
        }
    }
}
