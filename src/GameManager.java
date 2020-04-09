import java.util.*;

/**
 * GameManager is a class to manage UNO game. It holds a list of UNO cards and sets the basic UNO
 * setups such as giving each player 7 random cards initially, manages the turn of the players and
 * the direction of the game and determines when a player should do an action.
 *
 * @author Negar Movaghatian
 * @since 2020-04-03
 */
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
    // Determine if the players are all human or not
    private String gameMode;

    /**
     * Create a new Game manager.
     * @param numberOfPlayers The number of players in this game.
     * @param gameMode Determines if the game's players are human or computer. ["MP" or "SP"]
     */
    public GameManager(int numberOfPlayers, String gameMode) {

        players = new ArrayList<>();
        cards = new ArrayList<>();
        GameManager.numberOfPlayers = numberOfPlayers;
        direction = -1;
        plusCards = 0;
        this.gameMode = gameMode;

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
            if (gameMode.equals("SP"))
                players.add(new Player((i==0)? "HUMAN" : "COMPUTER"));
            else
                players.add(new Player("HUMAN"));
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
    }

    /**
     * Add the number of cards the next player should receive.
     * @param plusCards The number of cards to add to the plusCard field.
     */
    static void addPlusCards(int plusCards) {
        GameManager.plusCards += plusCards;
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
     * Get the last card which is now on the table.
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
        if (cards.size()==0) {
            System.out.println("Stack is empty!");
            skipTurn();
        }
        Random rnd = new Random();
        Card randomCard = cards.get(Math.abs(rnd.nextInt()) % cards.size());
        cards.remove(randomCard);
        return randomCard;
    }

    /**
     * Show all the cards of the players.
     */
    public void showPlayersCards() {
        for (int i=0; i<numberOfPlayers; i++)
            if (gameMode.equals("SP")) {
                if (players.get(i).getWhoIsPlayer().equals("COMPUTER"))
                    players.get(i).showCards("Player" + (i + 1));
                else
                    players.get(i).showCards("You");
            }
            else {
                players.get(i).showCards("Player" + (i + 1));
            }
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
                            (i==7 && direction==-1)? "   ┌─>   " : (i==8 && direction==-1)? "   └─    " :
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
     * Draw cards if there is a draw on table and the player is not going to use
     * another draw.
     */
    private void drawPlusCards() {
        for (int j=0; j<plusCards; j++)
            players.get(turn).addCard(giveRandomCard());
        if (players.get(turn).getWhoIsPlayer().equals("COMPUTER"))
            System.out.println("\n[Player " + (turn + 1) + "]");
        else
            System.out.println(gameMode.equals("SP")? "[YOU]" : ("[Player " + (turn + 1) + "]"));
        System.out.println(">Draws " + plusCards + " cards.");
        plusCards = 0;
        skipTurn();
    }

    /**
     * Run a UNO game and show players' scores at the end.
     */
    public void runGame() {
        boolean isFirstRound = true;
        // Run the UNO game while no player has zero card.
        while (!isGameOver()) {
            // Show table
            showPlayersCards();
            showTable();

            if (plusCards!=0 && players.get(turn).hasDrawCard().size()!=0) {
                if (isFirstRound)
                    drawPlusCards();
                if (players.get(turn).getWhoIsPlayer().equals("COMPUTER")) {
                    System.out.println("\n\n[Player " + (turn + 1) + "]");
                    players.get(turn).hasDrawCard().get(0).putOnTable(players.get(turn));

                    skipTurn();
                }
                else {
                    System.out.println("\n\n" + (gameMode.equals("SP")? "[YOU]" : ("[Player " + (turn + 1) + "]")) + "\n1) Draw cards\n2) Use your draw");
                    Scanner scn = new Scanner(System.in);
                    int drawOrNot = scn.nextInt();
                    while (drawOrNot<1 || drawOrNot>2) {
                        System.out.println("Please enter a number between 1 and 2.");
                        drawOrNot = scn.nextInt();
                    }
                    if (drawOrNot==2) {
                        int i = 1;
                        ArrayList<Card> drawCards = players.get(turn).hasDrawCard();
                        for (Card drawCard : drawCards)
                            System.out.println(i++ + ") " + drawCard.toString());
                        int drawNumber = scn.nextInt();
                        while (drawNumber<1 || drawNumber>drawCards.size()) {
                            System.out.println("Please enter a number between 1 and " + drawCards.size());
                            drawNumber = scn.nextInt();
                        }
                        drawCards.get(drawNumber-1).putOnTable(players.get(turn));
                    }
                    else {
                        for (int j=0; j<plusCards; j++)
                            players.get(turn).addCard(giveRandomCard());
                        plusCards = 0;
                    }
                    skipTurn();
                }
            }
            else if (plusCards!=0)
                drawPlusCards();
            else {
                // Play a round
                if (gameMode.equals("SP"))
                    if (players.get(turn).getWhoIsPlayer().equals("COMPUTER")) {
                        System.out.println("[Player " + (turn + 1) + "]");
                        players.get(turn).computerPlay();
                    } else {
                        System.out.println("[YOU]");
                        players.get(0).HumanPlay();
                    }
                else {
                    System.out.println("[Player " + (turn + 1) + "]");
                    players.get(turn).HumanPlay();
                }

                skipTurn();
            }
            isFirstRound = false;
        }

        // Show final scores
        System.out.println("\n\n<<GAME OVER!>>\nFinal Scores ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        HashMap<String, Integer> playersScores = new HashMap<>();
        int counter = 2;
        for (Player player : players)
            if (gameMode.equals("SP"))
                playersScores.put(player.getWhoIsPlayer().equals("HUMAN")? "   -You" : ("   -player" + counter++), player.getScore());
            else
                playersScores.put((" -player" + ((counter++)-1)), player.getScore());
        while(playersScores.size()!=0) {
            int minScore = 108*50;
            String minPlayerName = "";
            for (String playerName : playersScores.keySet()) {
                if (playersScores.get(playerName)<minScore) {
                    minScore = playersScores.get(playerName);
                    minPlayerName = playerName;
                }
            }
            System.out.println(minPlayerName + " " + minScore);
            playersScores.remove(minPlayerName);
        }

    }

}
