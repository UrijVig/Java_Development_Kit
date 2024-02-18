package main.java.app.client.view.impl;

import main.java.app.client.Controller.ClientControllerInterface;
import main.java.app.client.view.ClientViewInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class ClientGUI extends JFrame implements ClientViewInterface {
    private static final int HEIGHT = 500, WIDTH = 500, IPLIMIT = 15, PORTLIMIT = 5, PASSWORDLIMIT = 6;
    private static final String TITLE = "Graphic Client Interface";
    private JTextArea textPanel;
    private JTextField ipAddress, port, message, login;
    private final ClientControllerInterface clientController;
    private JPanel loginPanel;

    public ClientGUI(ClientControllerInterface clientController) {
        this.clientController = clientController;
        setSize(WIDTH, HEIGHT);
        setTitle(TITLE);
        createPanel();
        setVisible(true);
        setResizable(false);
    }

    private void createPanel() {
        add(createLoginPanel(), BorderLayout.NORTH);
        add(createChat());
        add(createMessagePanel(), BorderLayout.SOUTH);
    }

    private Component createChat() {
        textPanel = new JTextArea();
        return new JScrollPane(textPanel);
    }

    private Component createLoginPanel() {
        loginPanel = new JPanel(new GridLayout(2, 3));
        ipAddress = new JTextField(clientController.getIp());
        port = new JTextField(clientController.getPort());
        login = new JTextField(clientController.getLogin());
        JPasswordField password = new JPasswordField(clientController.getPassword());
        JButton btnEnter = new JButton("Enter");
        ipAddress.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();
                if (((key < '0' || key > '9') && key != '.')
                        | (ipAddress.getText().length() >= IPLIMIT
                        & key != KeyEvent.VK_BACK_SPACE
                        & key == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }
        });
        port.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();
                if ((key < '0' || key > '9')
                        | (ipAddress.getText().length() >= PORTLIMIT
                        & key != KeyEvent.VK_BACK_SPACE
                        & key == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }
        });
        btnEnter.addActionListener(e -> {
            clientController.setUser(ipAddress.getText(),
                    port.getText(),
                    login.getText(),
                    Arrays.toString(password.getPassword()));
            clientController.connectToServer();
        });
        loginPanel.add(ipAddress);
        loginPanel.add(port);
        loginPanel.add(new Panel());
        loginPanel.add(login);
        loginPanel.add(password);
        loginPanel.add(btnEnter);
        return loginPanel;
    }

    private JPanel createMessagePanel() {
        JPanel messagePanel = new JPanel(new BorderLayout());
        message = new JTextField();
        JButton btnSend = new JButton("Send");
        /*
          Метод устанавливает слушателя клавиатуры, реагирующего на нажатие клавиши Enter
         */
        message.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n') getMessage();
            }
        });
        btnSend.addActionListener(e -> getMessage());
        messagePanel.add(message);
        messagePanel.add(btnSend, BorderLayout.EAST);
        return messagePanel;
    }

    public void setVisibleLoginPanel(boolean flag) {
        loginPanel.setVisible(flag);
    }
    public void cleanMessageField(){
        message.setText("");
    }

    @Override
    public void print(String text) {
        textPanel.append(text + "\n");
    }

    @Override
    public void getMessage() {
        if (!message.getText().isEmpty())
            clientController.sendMessage(message.getText());
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING){
            clientController.closeWindow();
        }
        super.processWindowEvent(e);
    }
}
