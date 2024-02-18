package main.java.app.server.controller.impl;

import main.java.app.client.Controller.ClientControllerInterface;
import main.java.app.server.controller.ServerControllerInterface;
import main.java.app.server.emtity.Server;
import main.java.app.server.repository.HistoryRepositoryInterface;
import main.java.app.server.repository.imp.HistoryRepository;
import main.java.app.server.view.ServerViewInterface;
import main.java.app.server.view.impl.ServerWindow;

import java.util.ArrayList;

public class ServerController implements ServerControllerInterface {
    private boolean isWorks;
    private final Server server;
    private final ServerViewInterface serverWindow;
    private final ArrayList<ClientControllerInterface> clientList;
    private final HistoryRepositoryInterface repository;

    public ServerController(Server server) {
        serverWindow = new ServerWindow(this);
        clientList = new ArrayList<>();
        this.server = server;
        repository = new HistoryRepository(this, server);
    }
    @Override
    public void startServer() {
        if (!isWorks) {
            isWorks = true;
            serverWindow.printLog("Сервер успешно запущен!");
        } else {
            serverWindow.printLog("Сервер уже запущен! \n");
        }
    }

    @Override
    public void disableServer() {
        if (!isWorks) {
            serverWindow.printLog("Сервер уже остановлен!");
        } else {
            isWorks = false;
            while (!clientList.isEmpty()){
                disconnectUser(clientList.getLast());
            }
            serverWindow.printLog("Сервер успешно остановлен!");
        }
    }

    @Override
    public void processMessage(ClientControllerInterface user, String message) {
        repository.saveMessage(user.getLogin(), message);
        answer(user.getLogin(),message);
        serverWindow.printLog(String.format("%s : %s", user.getLogin(), message));
    }

    @Override
    public void processLog(String text) {
        serverWindow.printLog(text);
    }

    @Override
    public String getHistory(ClientControllerInterface user) {
        return repository.getHistory(user.getLogin());
    }

    private void answer(String login, String message) {
        for (ClientControllerInterface user: clientList) {
            user.processMessage(login, message);
        }
    }

    @Override
    public int connectUser(ClientControllerInterface visitor) {
        if (!visitor.getIp().equals(server.getIpAddress())) return 1;
        if (!visitor.getPort().equals(server.getConnection_port())) return 2;
        if (!isWorks) return 3;
        clientList.add(visitor);
        server.addUser(visitor);
        serverWindow.printLog(String.format("Пользователь %s зашёл на сервер \n", visitor.getLogin()));
        return 200;
    }

    @Override
    public void disconnectUser(ClientControllerInterface visitor) {
        clientList.remove(visitor);
        serverWindow.printLog(String.format("Пользователь %s был отключён от сервера! \n", visitor.getLogin()));
        visitor.disconnectFromServer();
    }


}
