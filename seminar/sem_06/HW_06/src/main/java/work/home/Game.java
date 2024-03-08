package work.home;

public class Game {
    private final Doors doors;
    private final Player player;
    private final MontyHall montyHall;

    public Game() {
        doors = new Doors();
        player = new Player(doors);
        montyHall = new MontyHall(doors);
    }
    public boolean newGame(){
        player.chooseADoor();
        montyHall.openTheDoor();
        player.switchDoor();
        return doors.getWinDoor() == doors.getNewSelectedDoor();
    }
}
