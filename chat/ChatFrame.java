
package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatFrame extends JFrame {
    JTextArea chatArea;
    JTextField inputField;
    String username;

    public ChatFrame(String username) {
        this.username = username;
        setTitle("Chat - " + username);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        inputField = new JTextField();
        inputField.addActionListener(e -> sendMessage());
        add(inputField, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void sendMessage() {
        String message = inputField.getText().trim();
        if (!message.isEmpty()) {
            chatArea.append(username + ": " + message + "\n");
            inputField.setText("");
        }
    }
}
