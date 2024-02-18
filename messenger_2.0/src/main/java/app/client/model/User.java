package main.java.app.client.model;

public class User {
    private   String ip;
    private String port;
    private  String login;
    private String password;
    public User(String ip, String port, String login, String password) {
        this.ip = ip;
        this.port = port;
        this.login = login;
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
