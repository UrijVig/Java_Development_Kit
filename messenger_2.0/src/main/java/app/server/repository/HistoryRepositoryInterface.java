package main.java.app.server.repository;

public interface HistoryRepositoryInterface {
    void saveMessage(String login, String message);
    String getHistory(String login);
}
