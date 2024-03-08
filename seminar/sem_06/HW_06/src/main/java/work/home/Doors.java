package work.home;

import lombok.Getter;
import java.util.Random;

@Getter
public class Doors {
    private final int LEFT = 0;
    private final int CENTER = 1;
    private final int RIGHT = 2;

    private int winDoor, selectedDoor, openedDoor, newSelectedDoor;
    private static final Random random = new Random();

    public Doors() {
        hideTheCar();
    }

    private void hideTheCar() {
        this.winDoor = getRandomDoor();
    }
    public void chooseADoor(int door){
        this.selectedDoor = door;
    }

    public void openTheDoor(int door){
        this.openedDoor = door;
    }
    public void switchDoor(int door){
        this.newSelectedDoor = door;
    }

    public int getRandomDoor() {
        int number = random.nextInt(3);
        switch (number) {
            case 0:
                return LEFT;
            case 1:
                return CENTER;
            case 2:
                return RIGHT;
            default:
                System.out.println("ups");
                return -1;
        }
    }

}
