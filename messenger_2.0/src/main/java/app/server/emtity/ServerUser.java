package main.java.app.server.emtity;

import main.java.app.client.Controller.ClientControllerInterface;

import java.io.File;

public class ServerUser {
    private final String name;
    private final String password;
    public String HISTORY_PATH;

    public ServerUser(ClientControllerInterface visitor, String repositoryPath) {
        name = visitor.getLogin();
        password = visitor.getPassword();
        createHistoryDirectory(repositoryPath + "userHistory/");
        HISTORY_PATH =repositoryPath + "userHistory/" + name + "/" + name + ".txt";

    }

    private void createHistoryDirectory(String repositoryPath) {
        File historyDir = new File(repositoryPath, name);
        if (!historyDir.exists()) historyDir.mkdir();
    }

    public String getName() {
        return name;
    }

    public String getHistoryPath() {
        return HISTORY_PATH;
    }

    public String getPassword() {
        return password;
    }
}
