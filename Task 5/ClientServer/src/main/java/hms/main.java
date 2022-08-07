package hms;

import hms.client.Client;
import hms.server.Server;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {

        Thread thread1 = new Thread() {
            public void run() {
                try {
                    Server.run();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread2 = new Thread() {
            public void run() {
                Client.run();
            }
        };

        thread1.start();
        thread2.start();
    }
}
