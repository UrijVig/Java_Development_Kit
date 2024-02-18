package main.java.app.client.Controller;

public interface ClientControllerInterface {

    String getIp();

    String getPort();

    String getLogin();

    String getPassword();

    void setUser(String text, String text1, String text2, String string);

    void connectToServer();

    void sendMessage(String text);

    void closeWindow();

    void processMessage(String login, String message);

    void disconnectFromServer();
}
