package client;

import client.gui.auth.WindowAuth;
import client.gui.chat.Chat;

import java.util.function.Consumer;

public class Adapter {


    private final String HOST = "127.0.0.1";
    private final int PORT = 8941;
    private Client connect;
    private WindowAuth windowAuth;
    private Chat chat;
    private String[] ar;
    private File_Menadger file_menadger = new File_Menadger();

    public Adapter() {

        connect = new Client(HOST, PORT);
        windowAuth = new WindowAuth(new Consumer<String>() {
            @Override
            public void accept(String s) {
                connect.send(s);
            }
        }, connect);

        while (true) {
            String s = connect.lesson();
            windowAuth.onReceve().accept(s);
            ar = s.split(" ");

            if (ar[0].equals("Добро") & ar[1].equals("пожаловать")) {
                windowAuth.close();
                break;
            }
            ar = null;
        }


        chat = new Chat(connect);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    String writ = connect.lesson();
                    chat.onReceve().accept(writ);
                    file_menadger.write_logs_inFile(writ);
                }
            }
        }).start();


    }


}

