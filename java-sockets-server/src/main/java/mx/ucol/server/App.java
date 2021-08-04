package mx.ucol.server;

import java.io.*;
import java.net.*;

public class App {
    public static void main(String[] args) {
        try {
            int port = 3000;
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            Remitente sender = new Remitente(socket);
            Receptor receiver = new Receptor(socket);

            new Thread(sender).start();
            new Thread(receiver).start();
        } catch (IOException e) {
            System.err.print(e);
        }
    }
}
