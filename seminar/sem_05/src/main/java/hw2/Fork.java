package main.java.hw2;

import java.util.concurrent.locks.ReentrantLock;

public class Fork {
    private final int id;
    private ReentrantLock lock = new ReentrantLock();

    public Fork(int id) {
        this.id = id;
    }

    public boolean pickUp() {
        return lock.tryLock();
    }

    public void putDown() {
        lock.unlock();
    }

    @Override
    public String toString() {
        return "" + id;
    }
}
