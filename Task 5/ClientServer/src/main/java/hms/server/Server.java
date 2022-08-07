package hms.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Scanner;

import hms.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Server {

    private static final Logger log = LogManager.getLogger(Server.class);
    //private static final Logger log = LogManager.getLogger("hms.server.Server-Log");

    public static void run() throws IOException {

        JdeSerializer deSerializer = new JdeSerializer();

        log.debug("SERVER - App Start");
        Socket socket ;
        InputStreamReader inputStreamReader ;
        BufferedReader bufferedReader ;
        ServerSocket serversocket ;

        log.debug("SERVER - Assigned The Port Number 6666");
        serversocket = new ServerSocket(6666);

            try {

                log.debug("SERVER - Starting To Accept hms.client.Client Requests");
                socket = serversocket.accept();

                inputStreamReader = new InputStreamReader(socket.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReader);

                Scanner input = new Scanner(System.in);

                String choice;

                Context contextSQL = new Context(new MySQLdb());
                Context contextMongo = new Context(new Mongodb());

                while (true) {

                    log.debug("SERVER - While Loop Started");

                    String data = bufferedReader.readLine();
                    log.debug("SERVER - Received Data : " + data);

                    if (data.equalsIgnoreCase("end")) {
                        break;
                    } else {

                        Student student = deSerializer.doOperation(data);
                        student.printData();

                        System.out.print("Select The DB To Add Data (M : Mongo, S : MySQL) : ");
                        choice = input.nextLine();

                        if (choice.equalsIgnoreCase("s")) {

                            log.debug("SERVER - Starting To Add Data To MySQL DB");
                            contextSQL.executeStrategy(student);
                            log.debug("SERVER - Added The Data To MySQL DB");
                        } else if (choice.equalsIgnoreCase("m")) {

                            log.debug("SERVER - Starting To Add Data To Mongo DB");
                            contextMongo.executeStrategy(student);
                            log.debug("SERVER - Added The Data To Mongo DB");
                        }


                    }
                }

            } catch (IOException | SQLException e) {
                log.error("SERVER - An ERROR Caused : " + e);
                e.printStackTrace();
            }
    }
}
