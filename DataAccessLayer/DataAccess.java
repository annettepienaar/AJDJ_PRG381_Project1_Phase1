package DataAccessLayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

import BusinessLogicLayer.Event;

public class DataAccess {
    File fPathCustomer, fPathEvent, fPathVenue, fPathMenu, fPathDecoration;
    public DataAccess(){
        fPathCustomer = new File("./DataAccessLayer/Customer.txt"); 
        fPathEvent = new File("./DataAccessLayer/Event.txt");
        fPathVenue = new File("./DataAccessLayer/Venue.txt");
        fPathMenu = new File("./DataAccessLayer/Menu.txt");
        fPathDecoration = new File("./DataAccessLayer/Decoration.txt");
    }

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
}
