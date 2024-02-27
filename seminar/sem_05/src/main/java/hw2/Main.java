package main.java.hw2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Fork> forks = Arrays.asList(new Fork(1),
                new Fork(2), new Fork(3), new Fork(4), new Fork(5));
        List<Philosopher> philosophers = new ArrayList<>();
        for (int i = 0; i < forks.size(); i++) {
            philosophers.add(new Philosopher(i + 1, forks.get(i), forks.get((i + 1) % 5)));
        }
        for (Philosopher pf : philosophers) {
            pf.start();
        }
    }
}
