package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Objects;

public class ClientManedger {

    private final Socket client;
    private Server server;
    private DataOutputStream out;
    private DataInputStream in;
    private Castomer clientcast;


    public ClientManedger(Socket client, Server server) {
        this.client = client;
        this.server = server;
        try {
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException("Возникла проблема с передачей данных");
        }
        auth();

    }

    private void auth() {
        send("Введите логин и пароль.");
        while (true) {
            String auth_user = lesson();
            String[] arg = auth_user.split(" ");
            DBConnector connect = new DBConnector();
            clientcast = connect.select_user(arg[0], arg[1]);

            if (clientcast == null) {
                send("Неверный логин или пароль");
            }
            if (server.serchUsre(this, clientcast)) {
                send("Неверный логин или пароль");
            }

            if (clientcast != null) {
                send("Добро пожаловать");
                server.addClient(this);
                chat_session();
            }
        }
    }


    public void send(String s) {
        try {
            out.writeUTF(s);
        } catch (IOException e) {
            server.sendAll(clientcast.name + " вышел из чата");
            throw new RuntimeException("Ошибка передачи сообщения");
        }
    }

    public String lesson() {
        try {
            return in.readUTF();
        } catch (IOException e) {
            server.sendAll(clientcast.name + " вышел из чата");
            throw new RuntimeException("Ошибка получения сообщения");
        }

    }

    private void chat_session() {
        server.sendAll(clientcast.name + " вошел в чат");
        while (true) {
            String user_massage = lesson();
            String[] arg = user_massage.split(" ");
            if (arg[0].equals("\\")) {
                server.sendUser(arg);
            } else {
                server.sendAll(clientcast.name + ": " + user_massage);
            }

            if (user_massage.equals("cjhjrnsczxj,tpmzyd;jgeceyekb,fyfy")) {
                server.sendAll(clientcast.name + " вышел из чата");
                server.removeClient(this);
            }

//            if(user_massage.equals("sdfasdasdfsdfasdafdf3rwkobml")){
//                send("Введите новый ник");
//                DBConnector connect = new DBConnector();
//                String user_massage_rename = lesson();
//
//            }


        }
    }

    // когда обязательно переопределять equals и hashcode?
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientManedger that = (ClientManedger) o;
        return Objects.equals(clientcast, that.clientcast);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientcast);
    }


    public Castomer getCastom() {
        return clientcast;
    }

}
