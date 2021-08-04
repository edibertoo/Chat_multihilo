package mx.ucol.client;

import java.io.*;
import java.net.*;

public class App {
    public static void main(String[] args) {
        try {
            int port = 3000;
            Socket socket = new Socket("localhost", port);
            Remitente sender = new Remitente(socket);
            Receptor receiver = new Receptor(socket);

            new Thread(sender).start();
            new Thread(receiver).start();
        } catch (Exception e) {
            System.err.print(e);
        }
    }
}
