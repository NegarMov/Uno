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
        // Run a new game
        GameManager gm = new GameManager(numberOfPlayers);
        gm.runGame();

    }
}
