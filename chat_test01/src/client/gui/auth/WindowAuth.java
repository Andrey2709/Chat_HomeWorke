package client.gui.auth;

import client.Client;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class WindowAuth {

    private InputPanelAuth inPanel;
    private OutputPanelAuth outPanel;
    private JFrame frame;

    public WindowAuth(Consumer<String> outMass, Client client) {

        frame = new JFrame("Вход и регистрация");
        inPanel = new InputPanelAuth(outMass);
        outPanel = new OutputPanelAuth(client);
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 200);
        frame.setLocation(650, 500);
        frame.add(inPanel.getInputPanel(), BorderLayout.NORTH);
        frame.add(outPanel.getOutputPanel(), BorderLayout.SOUTH);


        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }

    public Consumer<String> onReceve() {
        return inPanel.getOnReceveAuth();
    }

    public void close() {
        frame.dispose();
    }
}
