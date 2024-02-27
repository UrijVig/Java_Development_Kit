package main.java.hw2;

public class Philosopher extends Thread {
    private final String name;
    private int eaten = 0;
    private boolean hungry = false;
    Fork leftFork;
    Fork rightFork;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.name = "Филосов № " + id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private boolean takeRightFork() {
        return rightFork.pickUp();
    }

    private boolean takeLeftFork() {
        return leftFork.pickUp();
    }

    private void putDownForks() {
        rightFork.putDown();
        leftFork.putDown();
        System.out.printf("%s положил вилки %s и %s на место! \n", name, leftFork, rightFork);
    }

    private long getRandomTime() {
        return (long) (Math.random() * 1000 + 500);
    }

    @Override
    public void run() {
        try {
            while (eaten != 3) {
                if (hungry){
                    if (takeRightFork()) {
                        System.out.println(name + " взял вилку " + rightFork);
                        if (takeLeftFork()) {
                            System.out.println(name + " взял вилку " + leftFork);
                            eat();
                            //                        putDownForks();
                            leftFork.putDown();
                            System.out.println(name + " положил вилку " + leftFork);
                        }
                        rightFork.putDown();
                        System.out.println(name + " положил вилку " + rightFork);
                        Thread.sleep(500);
                    }
                } else {
                    think();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " Наелся и встал из-за стола!");
    }

    private void eat() throws InterruptedException {
            eaten++;
            System.out.printf("%s принимается за еду в %d-й раз!\n",
                    name, eaten);
            Thread.sleep(getRandomTime());
            hungry = !hungry;
            System.out.printf("%s закончил есть в %d-й раз!\n",
                    name, eaten);
    }

    private void think() throws InterruptedException {
        if (!hungry) {
            System.out.printf("%s принимается за размышления!\n",
                    name);
            Thread.sleep(getRandomTime());
            hungry = !hungry;
            System.out.printf("%s закончил размышления и ждёт возможности поесть!\n",
                    name);
        }
    }
}
