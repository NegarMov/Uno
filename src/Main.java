import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Ask about the number of players
        System.out.println("PLease enter the number of players.");
        // Run a new game
        GameManager gm = new GameManager(new Scanner(System.in).nextInt());
        gm.runGame();

    }
}
