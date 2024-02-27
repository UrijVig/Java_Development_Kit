package main.java.homeTask;
import java.util.LinkedList;
public class Main {
    private static final  LinkedList<Philosopher> philosophers = new LinkedList<>();
    public static void main(String[] args) {
        Philosopher philosopher1 = new Philosopher();
        Philosopher philosopher2 = new Philosopher();
        Philosopher philosopher3 = new Philosopher();
        Philosopher philosopher4 = new Philosopher();
        Philosopher philosopher5 = new Philosopher();
        philosophers.add(philosopher1);
        philosophers.add(philosopher2);
        philosophers.add(philosopher3);
        philosophers.add(philosopher4);
        philosophers.add(philosopher5);
        philosopher1.setLeftNeighbor(philosopher5);
        philosopher2.setLeftNeighbor(philosopher1);
        philosopher3.setLeftNeighbor(philosopher2);
        philosopher4.setLeftNeighbor(philosopher3);
        philosopher5.setLeftNeighbor(philosopher4);
        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }
}
