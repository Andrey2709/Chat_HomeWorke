package client.gui.auth;

import client.Client;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class InputPanelAuth {
    private Client client;
    JTextField textLessonMessage;
    JPanel inputPanel;
    public final Consumer<String> onReceveAuth;

    public InputPanelAuth(Consumer<String> onReceveAuth) {
        inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        textLessonMessage = new JTextField();
        textLessonMessage.setEnabled(false);
        inputPanel.add(textLessonMessage, BorderLayout.CENTER);
        this.onReceveAuth = new Consumer<String>() {
            @Override
            public void accept(String s) {
                textLessonMessage.setText(null);
                textLessonMessage.setText(s);
            }
        };


    }


   public  Consumer<String> getOnReceveAuth(){
        return onReceveAuth;
   }

    public JPanel getInputPanel() {
        return inputPanel;
    }
}
