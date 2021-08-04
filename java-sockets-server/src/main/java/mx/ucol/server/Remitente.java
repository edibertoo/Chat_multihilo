package mx.ucol.server;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Remitente implements  Runnable{
    private Socket socket;
    public Remitente (Socket socket){
        this.socket = socket;
    }

    public void run(){
        try{
            DataOutputStream dataOutputStream;
            String message;

            do{
                Scanner scaner = new Scanner(System.in);
                message = scaner.nextLine();
                dataOutputStream = new DataOutputStream(this.socket.getOutputStream());
                dataOutputStream.writeUTF(message);
                dataOutputStream.flush();

            }while(!message.equals("/c"));
            dataOutputStream.close();
            socket.close();
        }catch (Exception e){
            System.out.println("Error" + e.getMessage());
        }
    }
}
