package main.java.homeTask;
import java.util.concurrent.atomic.AtomicBoolean;
public class Fork {
    private final AtomicBoolean isFree;
    public Fork() {
        isFree = new AtomicBoolean(true);
    }
    public synchronized boolean getForkFlag(){
        return isFree.get();
    }

    public synchronized void setIsFree(boolean flag) {
        this.isFree.set(flag);
    }
}
