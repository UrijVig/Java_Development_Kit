package src.main.java.app.client;

import src.main.java.app.server.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIWindow extends JFrame {
    private static int count = 0;
    private static final int HEIGHT = 500, WIDTH = 500, IPLIMIT = 15, PORTLIMIT = 5, PASSWORDLIMIT = 6;
    private static final String TITLE = "Graphic Client Interface";
    private JTextArea chat;
    private JTextField ipAddress, port, message, login;
    private final ServerWindow server;
    private boolean isConnect;
    private JPanel loginPanel;
    private String name;

    public GUIWindow(ServerWindow server) {
        count++;
        setLocation(server.getX() + 500 * count, server.getY());
        this.server = server;
        setSize(WIDTH, HEIGHT);
        setTitle(TITLE);
        createPanel();
        setVisible(true);
        setResizable(false);
    }
    private void print(String text){
        chat.append(text + "\n");
    }

    private void createPanel() {
        add(createLoginPanel(), BorderLayout.NORTH);
        add(createChat());
        add(createMessagePanel(), BorderLayout.SOUTH);
    }

    private Component createChat() {
        chat = new JTextArea();
        return new JScrollPane(chat);
    }


    private Component createLoginPanel() {
        loginPanel = new JPanel(new GridLayout(2,3));
        ipAddress = new JTextField("127.0.0.1");
        port = new JTextField("8189");
        login = new JTextField("login" + count);
        JPasswordField password = new JPasswordField("password");
        JButton btnEnter = new JButton("Enter");
        ipAddress.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();
                if (((key < '0' || key > '9') && key != '.')
                        | (ipAddress.getText().length() >= IPLIMIT
                        & key != KeyEvent.VK_BACK_SPACE
                        & key == KeyEvent.VK_DELETE)){
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
                        & key == KeyEvent.VK_DELETE)){
                    e.consume();
                }
            }
        });
        btnEnter.addActionListener(e -> connectToServer());
        loginPanel.add(ipAddress);
        loginPanel.add(port);
        loginPanel.add(new Panel());
        loginPanel.add(login);
        loginPanel.add(password);
        loginPanel.add(btnEnter);
        return loginPanel;
    }

    private void connectToServer() {
        switch (server.ConnectUser(this)) {
            case 1 -> print("Ошибка подключения: указан неверный IP");
            case 2 -> print("Ошибка подключения: указан неверный порт!");
            case 3 -> print("Ошибка подключения: сервер отключён!");
            case 200 -> {
                print("Добро пожаловать на сервер! \n\n");
                isConnect = true;
                loginPanel.setVisible(false);
                name = login.getText();
                String data = server.getHistory();
                if (!data.isEmpty()){
                    print(data);
                }
            }
            default -> print("Что-то пошло не так(");
        }
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
                if (e.getKeyChar() == '\n') sendMessage();
            }
        });
        btnSend.addActionListener(e -> sendMessage());
        messagePanel.add(message);
        messagePanel.add(btnSend,BorderLayout.EAST);
        return messagePanel;
    }

    private void sendMessage() {
        if (isConnect && !message.getText().isEmpty()){
            server.getMessage(String.format("\t%s : %s", name, message.getText()));
            message.setText("");
        }
    }

    public String getIP(){
        return ipAddress.getText();
    }
    public String getPort(){
        return port.getText();
    }
    public String getName(){
        return name;
    }

    public void disconnectFromServer(){
        isConnect = false;
        print("Вы были отключены от сервера!");
        loginPanel.setVisible(true);
    }
    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING){
            server.disconnectUser(this);
        }
        super.processWindowEvent(e);
    }

    public void getAnswer(String text) {
        print(text);
    }
}
