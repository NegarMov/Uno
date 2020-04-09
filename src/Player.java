import java.util.*;

/**
 * The class Player represents a player. It has a list of the player's cards
 * and determines if this player is human or computer. This class also runs
 * one round of the game and makes decision for the next move.
 *
 * @author Negar Movaghatian
 * @since 2020-04-03
 */
public class Player {
    // The list of the cards player owns
    private ArrayList<Card> cardsList;
    // The list of the valid cards in this round
    private ArrayList<Card> validCards;
    // Shows if the player is computer or human
    private String whoIsPlayer;

    /**
     * Create a new player.
     */
    public Player(String whoIsPlayer) {
        cardsList = new ArrayList<>();
        validCards = new ArrayList<>();
        this.whoIsPlayer = whoIsPlayer;
    }

    /**
     * Check if this player has no cards left or not.
     * @return True if the player has no card left and false otherwise.
     */
    public boolean hasZeroCards() {
        return cardsList.size()==0;
    }

    /**
     * Get the score of the player by adding up their cards' score.
     * @return The summation of the scores of the cards player owns.
     */
    public int getScore() {
        int score = 0;
        for (Card card : cardsList)
            score += card.getScore();
        return score;
    }

    /**
     * Add a new card to the player's owned cards.
     * @param cardToAdd The card to add to the player's list.
     */
    public void addCard(Card cardToAdd) {
        cardsList.add(cardToAdd);
    }

    /**
     * Show all the cards the player has.
     * @param playerName The name of the player to show at the top.
     */
    public void showCards(String playerName) {
        System.out.println("\n\n" + playerName + " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        for (int i=0; i<13; i++) {
            for (Card card: cardsList)
                if (whoIsPlayer.equals("HUMAN"))
                    System.out.print(card.getAppearanceLine(i, false));
                else
                    System.out.print(card.getAppearanceLine(i, true));
            System.out.println();
        }
    }

    /**
     * Determine who is this player, computer or a human.
     * @return whoIsPlayer field.
     */
    public String getWhoIsPlayer() {
        return whoIsPlayer;
    }

    /**
     * Set the list of the valid cards according to the game's rules in this round.
     */
    private void selectValidCards() {
        validCards.clear();
        Card cardToCheck = GameManager.getCardOnTable();
        for (Card card : cardsList)
            if (GameManager.getColorOnTable().equals(card.getColor()) && card.getColor()!="BLACK" ||
                    (card instanceof NumericCard && cardToCheck instanceof NumericCard && ((NumericCard) card).getNumber() == ((NumericCard) cardToCheck).getNumber()) ||
                        card instanceof ActionCard && cardToCheck instanceof ActionCard && ((ActionCard) card).getType() == ((ActionCard) cardToCheck).getType() ||
                            card instanceof WildCard && ((WildCard) card).getType().equals("WC"))
                validCards.add(card);
        if (validCards.size()==0 || (validCards.size()==1 && validCards.get(0) instanceof WildCard && ((WildCard) validCards.get(0)).getType().equals("WC")) ||
                (validCards.size()==2 && ((validCards.get(0) instanceof WildCard && ((WildCard) validCards.get(0)).getType().equals("WC")) ||
                    (validCards.get(1) instanceof WildCard && ((WildCard) validCards.get(1)).getType().equals("WC")))))
            for (Card card : cardsList)
                if (card instanceof WildCard && ((WildCard) card).getType().equals("+4"))
                    validCards.add(card);
    }

    /**
     * Take a random card from stack and play it if possible.
     */
    private void drawRandomCard(String player) {
        Card randomCard = GameManager.giveRandomCard();
        addCard(randomCard);
        System.out.println(">Takes a card from stack. " + ((player.equals("HUMAN"))? ("(" + randomCard.toString() + ")") : ""));
        selectValidCards();
        if (validCards.size()!=0) {
            validCards.get(0).putOnTable(this);
            cardsList.remove(validCards.get(0));
        }
    }

    /**
     * Check if this player owns a draw card (+2 or wild draw).
     * @return a list of the draw cards this player owns.
     */
    public ArrayList<Card> hasDrawCard() {
        ArrayList<Card> drawCards = new ArrayList<>();
        selectValidCards();
        for (Card card : validCards)
            if (card instanceof ActionCard && ((ActionCard) card).getType().equals("+2")
                || card instanceof WildCard && ((WildCard) card).getType().equals("+4"))
                drawCards.add(card);
        return drawCards;
    }

    /**
     * Show the common color of the player's cards.
     * @return The common color among the player's cards.
     */
    public String colorPreference() {
        HashMap<String, Integer> colorsNumber = new HashMap<>();
        for (Card card : cardsList) {
            if (!card.color.equals("BLACK"))
                if (colorsNumber.containsKey(card.color))
                    colorsNumber.replace(card.color, colorsNumber.get(card.color)+1);
                else
                    colorsNumber.put(card.color, 1);
        }
        int max = 0;
        String maxColor = "";
        for (String color : colorsNumber.keySet())
            if (colorsNumber.get(color) > max) {
                max = colorsNumber.get(color);
                maxColor = color;
            }
        return maxColor;
    }

    /**
     * Run a turn for a human player.
     */
    public void computerPlay(){
        try
        {
            Thread.sleep(750);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        selectValidCards();
        if (validCards.size()!=0) {
            Random rnd = new Random();
            int cardNumber = Math.abs(rnd.nextInt()) % validCards.size();
            validCards.get(cardNumber).putOnTable(this);
            cardsList.remove(validCards.get(cardNumber));
        }
        else
            drawRandomCard("COMPUTER");
    }

    /**
     * Run a turn for a human player.
     */
    public void HumanPlay() {
        selectValidCards();
        if (validCards.size()!=0) {
            System.out.println("Choose one of your cards to play.");
            int i = 1;
            for (Card card : validCards)
                System.out.println(i++ + ") " + card.toString());
            Scanner scn = new Scanner(System.in);
            int chosenCard = scn.nextInt()-1;
            while (chosenCard<0 || chosenCard>=validCards.size()) {
                System.out.println("This input is invalid. please Enter a number between 1 and " + validCards.size());
                chosenCard = scn.nextInt()-1;
            }
            validCards.get(chosenCard).putOnTable(this);
            cardsList.remove(validCards.get(chosenCard));

        }
        else
            drawRandomCard("HUMAN");
    }
}
