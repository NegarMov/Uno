import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Ask about the number of players
        System.out.println("PLease enter the number of players. (3-5)");
        Scanner scn = new Scanner(System.in);
        int numberOfPlayers = scn.nextInt();
        while (numberOfPlayers<3 || numberOfPlayers>5) {
            System.out.println("Please enter a number between 3 and 5.");
            numberOfPlayers = scn.nextInt();
        }

        // Ask about the game mode
        System.out.println("Do you want to play with computer or human?\n1) Computer\n2) Human");
        int gameMode = scn.nextInt();
        while (gameMode<1 || gameMode>2) {
            System.out.println("Please enter a number between 1 and 2.");
            gameMode = scn.nextInt();
        }

        // Run a new game
        GameManager gm = new GameManager(numberOfPlayers, (gameMode==1)? "SP" : "MP");
        gm.runGame();

    }
}
