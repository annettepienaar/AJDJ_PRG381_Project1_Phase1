package DataAccessLayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

import BusinessLogicLayer.Event;

public class DataAccess {
    String FPathCustomer, FPathEvents, FPathVenue, FPathMenu, FPathDecoration;

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
            File myObj = new File("./DataAccessLayer");

            System.out.println("Attempting to read from file in: " + myObj.getCanonicalPath());

            Scanner myReader = new Scanner(myObj);

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
            System.out.println(info.getBookingNumber() + " " + info.getEventType() + " " + info.getEventDate() + " " + info.getEventTime() + " " + info.getConfirmationDate() + " " + info.getFoodID() + " " + info.getVenueID() + " " + info.getDecorationID() + " " + info.getTotalAdults() + " " + info.getTotalKids() + " " + info.getTotalPrice());
        }
    }

    //For each of the different files --> Customer.txt, Event.txt, Venue.txt, Menu.txt, Decoration.txt
}
