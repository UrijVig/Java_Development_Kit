package main.java.app.server.controller;

import main.java.app.client.Controller.ClientControllerInterface;

public interface ServerControllerInterface {
    int connectUser(ClientControllerInterface user);
    void disconnectUser(ClientControllerInterface user);
    void startServer();
    void disableServer();
    void processMessage(ClientControllerInterface clientController, String message);
    void processLog(String text);

    String getHistory(ClientControllerInterface clientController);

}
