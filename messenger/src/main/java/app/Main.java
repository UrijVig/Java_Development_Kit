package src.main.java.app;

import src.main.java.app.client.GUIWindow;
import src.main.java.app.server.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        new GUIWindow(serverWindow);
        new GUIWindow(serverWindow);
    }

}
