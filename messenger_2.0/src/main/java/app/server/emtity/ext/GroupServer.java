package main.java.app.server.emtity.ext;

import main.java.app.server.emtity.Server;

public class GroupServer extends Server {
    private static int count = 0;
    private final String name;

    public GroupServer(String ipAddress, String connection_port, String repositoryPath) {
        super(ipAddress, connection_port, repositoryPath);
        name = "GroupServer" + count++;
        this.repositoryPath = repositoryPath + "serverHistory/" + name + ".txt";
    }
}
