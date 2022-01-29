package server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Server {
    public ServerSocket socket;
    public Socket client;
    public static List<Castomer> castomers = new ArrayList<>();
    public static Set<ClientManedger> manedgers;
    private DataOutputStream out;
    private DataInputStream in;


    public Server() {
        try {
            manedgers = new HashSet<>();
            socket = new ServerSocket(8941);

            while (true) {
                System.out.println("Ожидание подключения пользователей к чату");
                client = socket.accept();
                in = new DataInputStream(client.getInputStream());
                out = new DataOutputStream(client.getOutputStream());
                System.out.println("Клиент " + client.getInetAddress() + "подключен");
                new Thread(() -> new ClientManedger(client, this)).start();

            }


        } catch (IOException e) {
            throw new RuntimeException("Подключение неудалось");

        }


    }

    public void sendAll(String s) {
            for (ClientManedger cm : manedgers) {
                cm.send(s);
            }

    }

    public boolean serchUsre(ClientManedger clientManedger, Castomer clientcast) {
        for (ClientManedger cm : manedgers) {
            if (cm.getCastom().equals(clientcast)) return true;
        }
        return false;
    }


    public void sendUser(String[] arg) {
        for (ClientManedger cm : manedgers) {
            if (cm.getCastom().login.equals(arg[1])) {
                for (int i = 2; i < arg.length; i++) {
                    cm.send(arg[i]);
                }
            }
        }
    }

    public static List<Castomer> getCastomers() {
        return castomers;
    }

    public void addClient(ClientManedger manedger) {
        manedgers.add(manedger);
    }

    public void removeClient(ClientManedger clientManedger) {
        manedgers.remove(clientManedger);
    }

}
