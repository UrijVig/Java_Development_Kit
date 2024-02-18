package main.java.app.client.Controller.impl;

import main.java.app.client.Controller.ClientControllerInterface;
import main.java.app.client.model.User;
import main.java.app.client.view.ClientViewInterface;
import main.java.app.client.view.impl.ClientGUI;
import main.java.app.server.controller.ServerControllerInterface;

public class ClientController implements ClientControllerInterface {
    private final User user;
    private final ClientViewInterface clientGUI;
    private final ServerControllerInterface server;
    private boolean isConnect;
    private static int count = 0;

    public ClientController(ServerControllerInterface serverController) {
        count++;
        user = new User("127.0.0.1", "15051", "login" + count, "password");
        clientGUI = new ClientGUI(this);
        this.server = serverController;
    }

    public void processMessage(String login, String message) {
        clientGUI.print(String.format("%s : %s", login, message));
    }
    public void setUser(String ip, String port,String login,String password){
        user.setIp(ip);
        user.setPort(port);
        user.setLogin(login);
        user.setPassword(password);
    }

    public String getIp() {
        return user.getIp();
    }

    public String getPort() {
        return user.getPort();
    }

    public String getLogin() {
        return user.getLogin();
    }

    public String getPassword() {
        return user.getPassword();
    }

    public void disconnectFromServer() {
        isConnect = false;
        clientGUI.print("Вы были отключены от сервера!");
        clientGUI.setVisibleLoginPanel(true);
    }

    public void connectToServer() {
        switch (server.connectUser(this)) {
            case 1 -> clientGUI.print("Ошибка подключения: указан неверный IP");
            case 2 -> clientGUI.print("Ошибка подключения: указан неверный порт!");
            case 3 -> clientGUI.print("Ошибка подключения: сервер отключён!");
            case 200 -> {
                clientGUI.print("Добро пожаловать на сервер! \n\n");
                isConnect = true;
                clientGUI.setVisibleLoginPanel(false);
                String data = server.getHistory(this);
                if (!data.isEmpty()){
                    clientGUI.print(data);
                }
            }
            default -> clientGUI.print("Что-то пошло не так(");
        }
    }

    public void sendMessage(String text) {
        if (isConnect){
            server.processMessage(this, text);
            clientGUI.cleanMessageField();
        }
    }
    public void closeWindow(){
        server.disconnectUser(this);
    }
}
