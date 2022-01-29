package client.gui.auth;

import client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.function.Consumer;


public class OutputPanelAuth {

    private JPanel outputPanel;


    public OutputPanelAuth(Client client)  {// отвечает за отправку логин пароля от клиента к сереверу
        this.outputPanel = new JPanel();
        GridLayout grid = new GridLayout(3, 3, 5, 12);
        outputPanel.setLayout(grid);

        JLabel loginText = new JLabel("LOGIN:");
        outputPanel.add(loginText);

        JTextField fieldLog = new JTextField();// Поле ввода логина
        outputPanel.add(fieldLog);


        JLabel passwordText = new JLabel("PASSWORD:");
        outputPanel.add(passwordText);

        JTextField fieldPas = new JTextField();// Поле ввода пароля
        outputPanel.add(fieldPas);

        JButton registrations = new JButton("Регистрация");
        outputPanel.add(registrations);
        JButton enter = new JButton("Вход");
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                client.send(fieldLog.getText() + " " + fieldPas.getText());
                fieldLog.setText(null);
                fieldPas.setText(null);
            }
        });

        outputPanel.add(enter);
    }


    public JPanel getOutputPanel() {
        return outputPanel;
    }

}
