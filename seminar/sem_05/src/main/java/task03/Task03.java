package main.java.task03;

import java.util.concurrent.CountDownLatch;

public class Task03 {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(4);

        Thread runner1 = new Thread(new Runner("Stiv", countDownLatch));
        Thread runner2 = new Thread(new Runner("Mark", countDownLatch));
        Thread runner3 = new Thread(new Runner("Karl", countDownLatch));
        runner1.start();
        runner2.start();
        runner3.start();

        while (countDownLatch.getCount() > 1){
            Thread.sleep(100);
        }
        System.out.println("На старт!");
        Thread.sleep(100);
        System.out.println("Внимание!");
        Thread.sleep(100);
        System.out.println("Марш!");
        Thread.sleep(100);
        countDownLatch.countDown();


    }
}
