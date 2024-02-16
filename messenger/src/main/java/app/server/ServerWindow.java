package src.main.java.app.server;

import src.main.java.app.client.GUIWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

public class ServerWindow extends JFrame {
    private static final int HEIGHT = 500, WIDTH = 500;
    private static final String TITLE = "Server window", IPADDRESS = "127.0.0.1", PORT = "8189";
    private static final String HISTORY_PATH = "./src/main/java/app/server/history/history.txt";
    private JTextArea info;
    private boolean isWork;
    private final ArrayList<GUIWindow> CLIENTDB;

    public ServerWindow() {
        CLIENTDB = new ArrayList<>();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setTitle(TITLE);
        createPanel();
        setVisible(true);
        setResizable(false);
    }

    private void createPanel() {
        add(createTextPanel());
        add(createButtonPanel(),BorderLayout.SOUTH);
    }

    private Component createTextPanel() {
        info = new JTextArea();
        return new JScrollPane(info);
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        JButton btnStart = new JButton("Start");
        JButton btnStop = new JButton("Stop");

        btnStart.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isWork) {
                    isWork = true;
                    printInfo("Сервер успешно запущен!");
                } else {
                    printInfo("Сервер уже запущен! \n");
                }
            }
        });
        btnStop.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isWork) {
                    printInfo("Сервер уже остановлен!");
                } else {
                    isWork = false;
                    while (!CLIENTDB.isEmpty()){
                        disconnectUser(CLIENTDB.getLast());
                    }
                    printInfo("Сервер успешно остановлен!");
                }
            }
        });
        buttonPanel.add(btnStart);
        buttonPanel.add(btnStop);
        return buttonPanel;
    }
    private void printInfo(String data) {
        info.append(data + "\n");
    }

    public int ConnectUser(GUIWindow guiWindow) {
        if (!guiWindow.getIP().equals(IPADDRESS)) return 1;
        if (!guiWindow.getPort().equals(PORT)) return 2;
        if (!isWork) return 3;
        CLIENTDB.add(guiWindow);
        printInfo(String.format("Пользователь %s зашёл на сервер \n", guiWindow.getName()));
        return 200;
    }
    public void disconnectUser(GUIWindow user){
        CLIENTDB.remove(user);
        printInfo(String.format("Пользователь %s был отключён от сервера! \n", user.getName()));
        user.disconnectFromServer();
    }

    public void getMessage(String text) {
        saveMassageInLog(text);
        sendAnswer(text);
        printInfo(text);
    }

    private void sendAnswer(String text) {
        for (var user : CLIENTDB) {
            user.getAnswer(text);
        }
    }

    /**
     * Метод сохраняет полученное тесктовое значение в файле истории чата
     *
     * @param text полоученное сообщение
     */
    private void saveMassageInLog(String text) {
        try (FileWriter fw = new FileWriter(HISTORY_PATH,true)) {
            fw.write(text + "\n");
        } catch (IOException e) {
            printInfo("Ошибка при сохранении истории! " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Метот возвращает историю переписки из файла в памяти сервера
     *
     * @return строка с перепиской
     */
    public String getHistory() {
        StringBuilder data = new StringBuilder();
        try (FileReader fr = new FileReader(HISTORY_PATH); BufferedReader bf = new BufferedReader(fr)){
            String line;
            while ((line = bf.readLine()) != null) data.append(line).append("\n");
            return data.toString();
        } catch (FileNotFoundException e) {
            printInfo("Файл истории не найден!" + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            printInfo("Ошибка чтения файла!" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
