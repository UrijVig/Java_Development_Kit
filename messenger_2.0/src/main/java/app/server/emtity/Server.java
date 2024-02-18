package main.java.app.server.emtity;

import main.java.app.client.Controller.ClientControllerInterface;

import java.util.ArrayList;

public abstract class Server {
    private  String ipAddress;
    private  String connection_port;
    private final ArrayList<ServerUser> userDB;
    protected String repositoryPath;

    public Server(String ipAddress, String connection_port,String repositoryPath) {
        this.ipAddress = ipAddress;
        this.connection_port = connection_port;
        userDB = new ArrayList<>();
        this.repositoryPath = repositoryPath;
    }

    public ArrayList<ServerUser> getUserDB() {
        return userDB;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getConnection_port() {
        return connection_port;
    }

    public void setConnection_port(String connection_port) {
        this.connection_port = connection_port;
    }
    public void addUser(ClientControllerInterface visitor){
        ServerUser user = new ServerUser(visitor, repositoryPath);
        userDB.add(user);
    }
    public void removeUser(ServerUser user){
        userDB.remove(user);
    }
    public String getUserPath(String name){
        for (ServerUser user : userDB) {
            if (user.getName().equals(name)){
                return user.getHistoryPath();
            }
        }return null;
    }

    public String getRepositoryPath() {
        return repositoryPath;
    }
}
