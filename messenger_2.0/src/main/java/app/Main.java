package main.java.app;

import main.java.app.client.Controller.impl.ClientController;
import main.java.app.server.controller.ServerControllerInterface;
import main.java.app.server.controller.impl.ServerController;
import main.java.app.server.emtity.Server;
import main.java.app.server.emtity.ext.GroupServer;

public class Main {
    public static void main(String[] args) {
        String repositoryPath = "./src/main/java/app/server/repository/historyDB/";
        Server server = new GroupServer("127.0.0.1", "15051", repositoryPath);
        ServerControllerInterface serverController = new ServerController(server);
        new ClientController(serverController);
        new ClientController(serverController);
    }
}
