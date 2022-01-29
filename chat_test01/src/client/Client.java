package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;

public class Client {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;


    public Client(String host,int port) {
        try {
            this.socket = new Socket(host,port);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());


        } catch (IOException e) {
            throw  new RuntimeException("Не удалось подключиться к серверу");
        }
    }


    public void send(String s){
        try {
            out.writeUTF(s);
        } catch (IOException e) {
            throw  new RuntimeException("Ошибка при передачи сообщения");
        }
    }
    public String lesson(){
        try {
            return in.readUTF();
        } catch (IOException e) {
            throw  new RuntimeException("Ошибка при получении сообщения");
        }
    }


}
