package main.java.task01;

public class Task01 {
    private static final Object monitor1 = new Object();
    private static final Object monitor2 = new Object();

    private static final Thread thread1 = new Thread(() -> {
        synchronized (monitor1){
            System.out.println("Монитор1 заблокирован первым потоком!");
            synchronized (monitor2){
                System.out.println("Монитор2 заблокирован первым потоком!");
            }
        }
    });

    private static final Thread thread2 = new Thread(() -> {
        synchronized (monitor2){
            System.out.println("Монитор2 заблокирован вторым потоком!");
            synchronized (monitor1){
                System.out.println("Монитор1 заблокирован вторым потоком!");
            }
        }
    });

    public static void main(String[] args) {
        thread1.start();
        thread2.start();
    }
}
