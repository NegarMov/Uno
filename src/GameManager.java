import java.util.ArrayList;

public class GameManager {

    // List of the players in the game
    private ArrayList<Player> players;
    // List of the UNO game cards
    private ArrayList<Card> cards;

    public void runGame() {

        players = new ArrayList<>();
        cards = new ArrayList<>();

        // Adding UNO cards to the game
        Card NC0 = new NumericCard("BLUE", 3);
        Card NC1 = new NumericCard("RED", 8);
        Card NC3 = new NumericCard("YELLOW", 5);
        Card NC4 = new NumericCard("GREEN", 2);
        Card AC0 = new ActionCard("YELLOW", "+2");
        Card AC1 = new ActionCard("BLUE", "Skip");
        Card WC0 = new WildCard("WC");
        Card WC1 = new WildCard("+4");

        //Creating players and adding cards to them
        Player P1 = new Player();

        P1.addCard(NC0);
        P1.addCard(NC1);
        P1.addCard(NC3);
        P1.addCard(NC4);
        P1.addCard(AC0);
        P1.addCard(AC1);
        P1.addCard(WC0);
        P1.addCard(WC1);

        P1.showCards("You");

        Player P2 = new Player();

        P2.addCard(NC0);
        P2.addCard(NC3);
        P2.addCard(NC4);
        P2.addCard(AC0);
        P2.addCard(WC0);
        P2.addCard(WC1);

        P2.showCards("Player 2");

    }

}
