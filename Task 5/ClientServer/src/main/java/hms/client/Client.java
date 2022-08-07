package hms.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import hms.Jserializer;
import hms.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Client {

    private static final Logger log = LogManager.getLogger(Client.class);

    public static void run() {
        log.debug("CLIENT - App Start");
        Socket socket = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        Scanner input = new Scanner(System.in);
        Jserializer serializer = new Jserializer();

        try {
            log.debug("CLIENT - Trying To Connect Port 6666 Localhost");
            socket = new Socket("localhost", 6666);
            log.debug("CLIENT - Connected Successfully");
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            log.debug("CLIENT - Ready To Send Data To hms.server.Server");

            String name;
            String address;
            long number;

            while (true){

                System.out.print("Enter The Name : ");
                name = input.nextLine();

                System.out.print("Enter The Address : ");
                address = input.nextLine();

                System.out.print("Enter The Phone Number : ");
                number = input.nextLong();

                System.out.println("----------------------------------");

                log.debug("CLIENT - Starting To Send The Data To hms.server.Server");

                Student studentTemp = new Student(0, name, address, number);
                String data = serializer.doOperation(studentTemp);
                log.debug("CLIENT - Data Sent : " + data);
                bufferedWriter.write(data);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                log.debug("CLIENT - Menu Displayed");
                System.out.println("\n\n--------------------------");
                System.out.println("\nDo You Want To Add Another hms.Student ? (Y/N)");
                input.nextLine();
                String choice = input.nextLine();

                if (choice.equalsIgnoreCase("N")) {
                    log.debug("CLIENT - User Chose To Break Loop");
                    bufferedWriter.write("end");
                    break;
                } else {
                    log.debug("CLIENT - Loop Continues");
                    continue;
                }
            }

            System.out.println("Thank You For Using The Software, Have A Nice Day");
            log.debug("CLIENT - Program Stopped");

        } catch (IOException e) {
            log.error("CLIENT - An ERROR Caused : " + e);
            e.printStackTrace();
        } finally {
        }
    }
}
