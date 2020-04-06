import java.util.*;

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

    /**
     * Create a new Game manager.
     * @param numberOfPlayers The number of players in this game.
     */
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
        for (int i=0; i<numberOfPlayers; i++) {
            players.add(new Player((i==0)? "HUMAN" : "COMPUTER"));
            for (int j = 0; j < 7; j++) {
                int randomCard = Math.abs(rnd.nextInt()) % cards.size();
                players.get(i).addCard(cards.get(randomCard));
                cards.remove(randomCard);
            }
        }

        // Determine the card on the table
        cardOnTable = cards.get(Math.abs(rnd.nextInt()) % cards.size());
        while (cardOnTable instanceof WildCard)
            cardOnTable = cards.get(Math.abs(rnd.nextInt()) % cards.size());

        turn = Math.abs(rnd.nextInt()) % numberOfPlayers;
        colorOnTable = cardOnTable.getColor();
        cardOnTable.putOnTable(new Player("MANAGER"));
        if (cardOnTable instanceof ActionCard && ((ActionCard) cardOnTable).getType().equals("+2")) {
            players.get(turn).addCard(giveRandomCard());
            players.get(turn).addCard(giveRandomCard());
            skipTurn();
        }
    }

    /**
     * Add the number of cards the next player should receive.
     * @param plusCards The number of cards to add to the plusCard field.
     */
    static void addPlusCards(int plusCards) {
        GameManager.plusCards += plusCards;
    }

    /**
     * Set the number of cards the next player should receive.
     * @param plusCards The number of cards to set the plusCard field to.
     */
    static void setPlusCards(int plusCards) {
        GameManager.plusCards = plusCards;
    }

    /**
     * Set The color which other players should continue with.
     * @param color The color to set the
     */
    static void setColorOnTable(String color) {
        colorOnTable = color;
    }

    /**
     * Skip one player's turn.
     */
    static void skipTurn() {
        turn = (turn + direction + numberOfPlayers*2) % numberOfPlayers;
    }

    /**
     * Get the color which now rules the table.
     * @return colorOnTable field
     */
    public static String getColorOnTable() {
        return colorOnTable;
    }

    /**
     * Reverse the direction of the game. (Change clockwise into
     * anticlockwise and anticlockwise to clockwise as well)
     */
    static void reverseDirection() {
        direction = -1 * direction;
    }

    /**
     * Change the card which is now the last card on the table.
     * @param cardOnTable The card to put on table.
     */
    static void setCardOnTable(Card cardOnTable) {
        GameManager.cardOnTable = cardOnTable;
    }

    /**
     * Get the last card whihc is now on the table.
     * @return cardOnTable field.
     */
    public static Card getCardOnTable() {
        return cardOnTable;
    }

    /**
     * Take a random card out of stack.
     * @return A random card from the stack.
     */
    static Card giveRandomCard() {
        Random rnd = new Random();
        Card randomCard = cards.get(Math.abs(rnd.nextInt()) % cards.size());
        cards.remove(randomCard);
        return randomCard;
    }

    /**
     * Show all the cards of the players
     */
    public void showPlayersCards() {
        players.get(0).showCards("You");
        for (int i=1; i<numberOfPlayers; i++)
            players.get(i).showCards("You");//"Player" + (i+1));
    }

    /**
     * Show the table in this round.
     */
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

    /**
     * Check if the game is over (if any of the players has zero cards left)
     * or not.
     * @return True if the game is over and false otherwise.
     */
    public boolean isGameOver() {
        boolean ans = false;
        for (Player player : players)
            ans = ans || player.hasZeroCards();
        return ans;
    }

    /**
     * Run a UNO game and show players' scores at the end.
     */
    public void runGame() {
        // Run the UNO game while no player has zero card.
        while (!isGameOver()) {
            showPlayersCards();
            showTable();
            if (turn != 0) {
                System.out.println("[Player " + (turn + 1) + "]");
                players.get(turn).computerPlay();
            }
            else {
                System.out.println("[YOU]");
                players.get(0).HumanPlay();
            }
            skipTurn();
            if (!((getCardOnTable() instanceof ActionCard && ((ActionCard) getCardOnTable()).getType().equals("+2"))
                    || (getCardOnTable() instanceof WildCard && ((WildCard) getCardOnTable()).getType().equals("+4")))) {
                plusCards = 0;
            }
            else {
                for (int j=0; j<plusCards; j++)
                    players.get(turn).addCard(giveRandomCard());
                skipTurn();
            }
        }

        // Show final scores
        System.out.println("\n\n<<GAME OVER!>>\nFinal Scores ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        while(players.size()!=0) {
            int minScore = 108*50, minIndex = 0;
            for (int i=0; i<players.size(); i++)
                if (players.get(i).getScore()<minScore) {
                    minScore = players.get(i).getScore();
                    minIndex = i;
                }
            System.out.println(((minIndex==0)? "YOU: " : ("Player " + (minIndex + 1) + ": ")) + minScore);
            players.remove(minIndex);
        }

    }

}
