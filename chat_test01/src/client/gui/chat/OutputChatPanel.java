package client.gui.chat;

import client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OutputChatPanel {

    private JPanel OutputPanel;

    public OutputChatPanel(Client client) {
        this.OutputPanel = new JPanel();
        OutputPanel.setLayout(new BorderLayout());

        JTextField field = new JTextField();
        OutputPanel.add(field, BorderLayout.CENTER);
        Icon iconbutton = new ImageIcon("massage2.png");
        JButton btn = new JButton(iconbutton);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                client.send(field.getText());
                field.setText(null);

            }
        });
        OutputPanel.add(btn, BorderLayout.WEST);


    }

    public JPanel getOutputPanel() {
        return OutputPanel;
    }
}
