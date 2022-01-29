package client.gui.chat;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class InputChatPanel {
    private Consumer<String> onReceveChat;
    private JPanel InputPanel;

    public InputChatPanel() {
        this.InputPanel = new JPanel();
        InputPanel.setLayout(new BorderLayout());

        JTextArea area = new JTextArea();
        area.setEnabled(false);
        onReceveChat = new Consumer<String>() {
            @Override
            public void accept(String s) {
                area.append(s + "\n");
            }
        };

        InputPanel.add(area, BorderLayout.CENTER);

    }

    public Consumer<String> getOnReceveChat() {
        return onReceveChat;
    }

    public JPanel getInputPanel() {
        return InputPanel;
    }
}
