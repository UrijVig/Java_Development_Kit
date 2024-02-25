package main.java.task02;

public class Task02 {
    public static volatile boolean switcher;
    public static boolean work = true;
    private static final Thread changer = new Thread(() -> {
        while (work) {
            try {
                switcher = !switcher;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    });

    private static final Thread counter = new Thread(() -> {
        int count = 100;
        while (count > 0) {
            if (switcher) {
                System.out.println(count--);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        work = false;
    });

    public static void main(String[] args) {
        changer.start();
        counter.start();
    }
}
