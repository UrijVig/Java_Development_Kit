package main.java.app.server.repository.imp;

import main.java.app.server.controller.ServerControllerInterface;
import main.java.app.server.controller.impl.ServerController;
import main.java.app.server.emtity.Server;
import main.java.app.server.repository.HistoryRepositoryInterface;

import java.io.*;

public class HistoryRepository implements HistoryRepositoryInterface {
    private final ServerControllerInterface serverController;
    private final Server server;
    public HistoryRepository(ServerController serverController, Server server) {
        this.serverController =serverController;
        this.server = server;
    }

    @Override
    public void saveMessage(String login, String message) {
        try (FileWriter fw = new FileWriter(server.getRepositoryPath(),true)) {
            fw.write(login + " : " + message + "\n");
        } catch (IOException e) {
            serverController.processLog("Ошибка при сохранении истории! " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public String getHistory(String login) {
        StringBuilder data = new StringBuilder();
        try (FileReader fr = new FileReader(server.getRepositoryPath()); BufferedReader bf = new BufferedReader(fr)){
            String line;
            while ((line = bf.readLine()) != null) data.append(line).append("\n");
            return data.toString();
        } catch (FileNotFoundException e) {
            serverController.processLog("Файл истории не найден!" + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            serverController.processLog("Ошибка чтения файла!" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
