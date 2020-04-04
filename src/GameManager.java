import java.util.ArrayList;
import java.util.Random;

public class GameManager {

    // List of the players in the game
    private ArrayList<Player> players;
    // List of the UNO game cards
    private static ArrayList<Card> cards;
    // Number of players
    private static int numberOfPlayers;
    // Current card on the table
    private static Card cardOnTable;
    // The number of the player whose turn is now
    private static int turn;
    // The direction of the rotation between players
    private static int direction; // [+1-> CW, -1-> ACW]
    // The number of cards which should be added to the player next round
    private static int plusCards;
    // The color of the card on table
    private static String colorOnTable;

    public GameManager(int numberOfPlayers) {

        players = new ArrayList<>();
        cards = new ArrayList<>();
        GameManager.numberOfPlayers = numberOfPlayers;
        direction = 1;
        plusCards = 0;

        // Adding UNO cards to the game
        String[] colors = {"BLUE", "RED", "GREEN", "YELLOW"};
        for (int c=0; c<4; c++) {
            cards.add(new NumericCard(colors[c], 0));
            cards.add(new WildCard("WC"));
            cards.add(new WildCard("+4"));
        }
        for (int i=1; i<10; i++)
            for (int c=0; c<4; c++)
                for (int j=0; j<2; j++)
                    cards.add(new NumericCard(colors[c], i));
        for (int c=0; c<4; c++)
            for (int j=0; j<2; j++) {
                cards.add(new ActionCard(colors[c], "Skip"));
                cards.add(new ActionCard(colors[c], "Rev"));
                cards.add(new ActionCard(colors[c], "+2"));
            }

        //Creating players and adding 7 cards to them
        Random rnd = new Random();
        for (int i=0; i<numberOfPlayers; i++)
            for (int j=0; j<7; j++) {
                players.add(new Player());
                int randomCard = Math.abs(rnd.nextInt()) % cards.size();
                players.get(i).addCard(cards.get(randomCard));
                cards.remove(randomCard);
            }

        // Determine the card on the table
        cardOnTable = cards.get(Math.abs(rnd.nextInt()) % cards.size());
        while (cardOnTable instanceof WildCard)
            cardOnTable = cards.get(Math.abs(rnd.nextInt()) % cards.size());

        turn = Math.abs(rnd.nextInt()) % numberOfPlayers;
        colorOnTable = cardOnTable.getColor();
        cardOnTable.putOnTable();
    }

    static void addPlusCards(int plusCards) {
        GameManager.plusCards += plusCards;
    }

    static void setPlusCards(int plusCards) {
        GameManager.plusCards = plusCards;
    }

    static void setColorOnTable(String color) {
        colorOnTable = color;
    }

    static void skipTurn() {
        turn = (turn + direction) % numberOfPlayers;
    }

    static void reverseDirection() {
        direction = -1 * direction;
    }

    static void setCardOnTable(Card cardOnTable) {
        GameManager.cardOnTable = cardOnTable;
    }

    public static Card getCardOnTable() {
        return cardOnTable;
    }

    static Card giveRandomCard() {
        Random rnd = new Random();
        Card randomCard = cards.get(Math.abs(rnd.nextInt()) % cards.size());
        cards.remove(randomCard);
        return randomCard;
    }

    public void showPlayersCards() {
        players.get(0).showCards("You");
        for (int i=1; i<numberOfPlayers; i++)
            players.get(i).showCards("Player" + (i+1));
    }

    public void showTable() {
        System.out.println("┌─────────────────────────────────────────────────┐");
        System.out.println("│                                                 │");
        for (int i=0; i<13; i++)
            System.out.println("│ " + new Card(0, "BLACK").getAppearanceLine(i, true) +
                    cardOnTable.getAppearanceLine(i, false) +
                    ((i==5 || i==4)? ("  " + Card.getColorsList().get(colorOnTable) + "░░░" + Card.getColorsList().get("RESET") + "  ") :
                            (i==7 && direction==1)? "   ┌─>   " : (i==8 && direction==1)? "   └─    " :
                                    (i==7)? "   ┌─    " : (i==8)? "   └─>   " :
                            "         ") + " │");
        System.out.println("│                                                 │");
        System.out.println("└─────────────────────────────────────────────────┘\n\n");

    }

    public void runGame() {
        showPlayersCards();
        showTable();
        while (true) {
            for (int i = 0; i < numberOfPlayers; i++) {
                if (i != 0)
                    players.get(i).computerPlay();
                else
                    players.get(0).HumanPlay();
                turn = (turn + direction) % numberOfPlayers;
                showPlayersCards();
                showTable();
            }
        }
    }

}
