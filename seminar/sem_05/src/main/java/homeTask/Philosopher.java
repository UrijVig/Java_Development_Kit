package main.java.homeTask;


public class Philosopher extends Thread {
    private static int count = 0;
    private final String name;
    private String neighborName;
    private final Fork rightFork;
    private boolean hunger = true;
    private int portionSpaghetti = 3;
    private Philosopher leftNeighbor;


    public Philosopher() {
        leftNeighbor = null;
        rightFork = new Fork();
        name = "Филосов №" + ++count;
        System.out.println(name + " Сел за стол со своей вилкой, положив её справа");
    }

    @Override
    public void run() {
        while (portionSpaghetti != 0) {
            if (leftForkIsFree() && isRightForkIsFree() && hunger) {
                try {
                    takeAFork(false);
                    setRightForkIsFree(false);
                    System.out.println(name + " берёт вилку справа");
                    System.out.println(name + " берёт вилку у " + neighborName);
                    eit();
                    setRightForkIsFree(true);
                    System.out.println(name + " кладёт вилку справа");
                    takeAFork(true);
                    System.out.println(name + " возвращает вилку " + neighborName);
                    hunger = !hunger;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    System.out.println(name + " В раздумиях...");
                    Thread.sleep(1000);
                    hunger = !hunger;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(name + " Наелся!!_____________________________");
    }

    private void eit() throws InterruptedException {
        System.out.println(name + " поедает спагетти");
        Thread.sleep((long) (Math.random() * 1000));
        portionSpaghetti--;
    }

    public String getPhilosopherName() {
        return name;
    }

    public void setLeftNeighbor(Philosopher leftNeighbor) {
        this.leftNeighbor = leftNeighbor;
        this.neighborName = leftNeighbor.getPhilosopherName();
    }

    public boolean isRightForkIsFree() {
        return rightFork.getForkFlag();
    }

    public void setRightForkIsFree(boolean flag) {
        this.rightFork.setIsFree(flag);
    }

    private boolean leftForkIsFree() {
        return leftNeighbor.isRightForkIsFree();
    }

    private void takeAFork(boolean flag) {
        leftNeighbor.setRightForkIsFree(flag);
    }

}
