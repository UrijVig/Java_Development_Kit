package work.home;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Player {
    private final Doors doors;

    public void chooseADoor(){
        doors.chooseADoor(doors.getRandomDoor());
    }

    public void switchDoor(){
        do {
            doors.switchDoor(doors.getRandomDoor());
        } while (doors.getNewSelectedDoor() == doors.getOpenedDoor() || doors.getNewSelectedDoor() == doors.getSelectedDoor());
    }
}
