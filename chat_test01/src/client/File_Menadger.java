package client;

import java.io.*;

public class File_Menadger {

    public FileReader input;
    public FileWriter output;
    public static String log_user;


    public File_Menadger() {
        try {
            output = new FileWriter("Log.txt");
            input = new FileReader("Log.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void write_logs_inFile(String s) {
        try {

            output.write(s);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read_logs() {
        try {
            input = new FileReader("Log.txt");
            int x;
            char[] t = new char[200];
            while ((x = input.read(t)) > 0) {
                log_user = new String(t, 0, x);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
