import java.util.ArrayList;

public class Player {
    // The list of the cards player owns
    private ArrayList<Card> cardsList;

    /**
     * Create a new player.
     */
    public Player() {
        cardsList = new ArrayList<>();
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
        System.out.println("\n\n" + playerName + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        for (int i=0; i<13; i++) {
            for (Card card: cardsList)
                if (playerName=="You")
                    System.out.print(card.getAppearanceLine(i, false));
                else
                    System.out.print(card.getAppearanceLine(i, true));
            System.out.println();
        }
    }
}
