package main.java.app.server.view.impl;

import main.java.app.server.controller.ServerControllerInterface;
import main.java.app.server.controller.impl.ServerController;
import main.java.app.server.view.ServerViewInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ServerWindow extends JFrame implements ServerViewInterface {
    private static final int HEIGHT = 500;
    private static final int WIDTH = 500;
    private static final String TITLE = "Server window";
    private JTextArea info;
    private final ServerControllerInterface serverController;

    public ServerWindow(ServerController serverController) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setTitle(TITLE);
        createPanel();

        this.serverController = serverController;
        setResizable(false);
        setVisible(true);
    }

    private void createPanel() {
        add(createTextPanel());
        add(createButtonPanel(),BorderLayout.SOUTH);
    }

    private Component createTextPanel() {
        info = new JTextArea();
        return new JScrollPane(info);
    }

    private Component createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        JButton btnStart = new JButton("Start");
        JButton btnStop = new JButton("Stop");
        btnStart.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverController.startServer();
            }
        });
        btnStop.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverController.disableServer();
            }
        });
        buttonPanel.add(btnStart);
        buttonPanel.add(btnStop);
        return buttonPanel;
    }

    @Override
    public void printLog(String text) {
        info.append(text + "\n");
    }
}
