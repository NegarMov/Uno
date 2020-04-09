import java.util.Scanner;

/**
 * Main class asks if the other players are human or computer and the number of players.
 * After, it creates a new Game Manager and runs an UNO game.
 *
 * @author Negar Movaghatian
 * @since 2020-04-03
 */
public class Main {
    public static void main(String[] args) {

        // Ask about the game mode
        Scanner scn = new Scanner(System.in);
        System.out.println("Do you want to play with computer or human?\n1) Computer\n2) Human");
        int gameMode = scn.nextInt();
        while (gameMode<1 || gameMode>2) {
            System.out.println("Please enter a number between 1 and 2.");
            gameMode = scn.nextInt();
        }

        // Ask about the number of players
        System.out.println("PLease enter the number of players." + ((gameMode==1)? "(3-5)" : ""));
        int numberOfPlayers = scn.nextInt();
        while ((gameMode==1 && (numberOfPlayers<3 || numberOfPlayers>5)) || (gameMode==2 && numberOfPlayers<1)) {
            System.out.println("Please enter a valid number.");
            numberOfPlayers = scn.nextInt();
        }

        // Run a new game
        GameManager gm = new GameManager(numberOfPlayers, (gameMode==1)? "SP" : "MP");
        gm.runGame();

    }
}
