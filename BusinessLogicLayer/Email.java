package BusinessLogicLayer;

import java.io.*;
import java.util.*;
import java.net.*;

public class Email {
    String recipient;
    String message = "";

    public Email(String emailAddress, String name, String menuType){
        //Socket sock = new Socket("localhost", 25);
        //DataOutputStream dos = new DataOutputStream(sock.getOutputStream());

        //Messages would be writing to stream (need MSTP server to send emails)

        message += "mail from: job$business.co.za \n";
        message += "rcpt to: " + emailAddress + "\n";

        message += "Subject: Customer Menu changes\n";
        
        message += "Customer " + name + "'s (" + emailAddress + ") has updated his menu to " + menuType + "\n";

        message += "\n.\n";

        message += "QUIT";

        //To show what would have been email (with commands to MSTP server)
        sendEmail();
    }

    public void sendEmail(){
        System.out.println(message);
    }
}
