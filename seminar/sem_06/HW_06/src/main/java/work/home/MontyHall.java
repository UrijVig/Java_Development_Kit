package work.home;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MontyHall {
    private final Doors doors;

    public void openTheDoor(){
        do {
            doors.openTheDoor(doors.getRandomDoor());
        } while (doors.getOpenedDoor() == doors.getSelectedDoor() || doors.getOpenedDoor() == doors.getWinDoor());
    }
}
