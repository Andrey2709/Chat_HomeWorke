package client.gui.chat;

import client.Client;
import client.File_Menadger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class Chat {
    private InputChatPanel in_panel;
    private OutputChatPanel out_panel;
    private Menu menu;
    private JFrame mainFrame;
    private File_Menadger file_menadger = new File_Menadger();


    public Chat(Client client) {

        in_panel = new InputChatPanel();
        out_panel = new OutputChatPanel(client);
        menu = new Menu();
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Меню");
        JMenuItem rename = new JMenuItem("История переписки", new ImageIcon("nik.png"));
        rename.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               file_menadger.read_logs();
                onReceve().accept(file_menadger.log_user);
            }
        });
        JMenuItem exet = new JMenuItem("Выход", new ImageIcon("exety.png"));
        exet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               setClose();
                mainFrame.setVisible(false);
                System.exit(0);
            }
        });


        menu.add(rename);
        menu.add(exet);
        menuBar.add(menu);

        this.mainFrame = new JFrame("Другой мир");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(in_panel.getInputPanel(), BorderLayout.CENTER);
        mainFrame.add(out_panel.getOutputPanel(), BorderLayout.SOUTH);
        mainFrame.setJMenuBar(menuBar);

        mainFrame.setBounds(500, 300, 650, 500);


        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }


    public Consumer<String> onReceve() {
        return in_panel.getOnReceveChat();
    }
    public String setClose(){
               return "cjhjrnsczxj,tpmzyd;jgeceyekb,fyfy" ;
    }
}

