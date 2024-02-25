package main.java.task03;

import java.util.concurrent.CountDownLatch;

public class Runner implements Runnable{
    private final String name;
    private final CountDownLatch countDownLatch;

    public Runner(String name, CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            goToStart();
            countDownLatch.await();
            running();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void goToStart() throws InterruptedException {
        System.out.println(name + " Готовится к старту!");
        Thread.sleep(getRandomTime());
        System.out.println(name + " готов!");
        countDownLatch.countDown();
    }

    private void running() throws InterruptedException {
        System.out.println(name + " стартовал!");
        Thread.sleep(getRandomTime());
        System.out.println(name + " финишировал!");
    }

    private long getRandomTime(){
        return (long) (Math.random() * 5000 + 1000);
    }
}
