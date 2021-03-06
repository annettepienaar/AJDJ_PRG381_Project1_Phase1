package BusinessLogicLayer;

import java.io.*;
import java.util.*;
import java.net.*;

public class Email {
    String recipient;
    String message;

    public Email(String emailAddress, String messageTemplate) throws IOException{
        Socket sock = new Socket("localhost", 25);
        DataOutputStream dos = new DataOutputStream(sock.getOutputStream());

        //Messages would be writing to stream (need MSTP server to send emails)
        String message = "";

        message += "mail from: job$business.co.za \n";
        message += "rcpt to: " + emailAddress + "\n";

        message += "Subject: Your subjectline here\n";
        
        message += messageTemplate;

        message += "\n.\n";

        message += "QUIT";

        //To show what would have been email (with commands to MSTP server)
        sendEmail();
    }

    public void sendEmail(){
        System.out.println(message);
    }
}
