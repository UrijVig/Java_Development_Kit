package work.home;

import java.util.ArrayList;
import java.util.List;

/**
 * Monty Hall show
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the monty hall show");
        List<Boolean> winList = new ArrayList<>();
        int gameCount = 1000000;
        for (int i = 0; i < gameCount; i++) {
            winList.add(game());
        }
        int winCount = 0;
        int losingCount = 0;
        for (boolean result : winList) {
            if (result) {
                winCount++;
//                System.out.println("win");
            } else {
                losingCount++;
//                System.out.println("losing");
            }
        }
        System.out.printf("За %d игр вы победили %d раз и проиграли %d раз \n", gameCount, winCount, losingCount);

    }

    private static boolean game() {
        Game game = new Game();
        return game.newGame();
    }
}
