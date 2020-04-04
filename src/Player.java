import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {
    // The list of the cards player owns
    private ArrayList<Card> cardsList;
    // The list of the valid cards in this round
    private ArrayList<Card> validCards;

    /**
     * Create a new player.
     */
    public Player() {
        cardsList = new ArrayList<>();
        validCards = new ArrayList<>();
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
                if (playerName=="You")
                    System.out.print(card.getAppearanceLine(i, false));
                else
                    System.out.print(card.getAppearanceLine(i, true));
            System.out.println();
        }
    }

    private void selectValidCards() {
        validCards.clear();
        Card cardToCheck = GameManager.getCardOnTable();
        for (Card card : cardsList)
            if (cardToCheck.getColor().equals(card.getColor()) ||
                    (card instanceof NumericCard && cardToCheck instanceof NumericCard && ((NumericCard) card).getNumber() == ((NumericCard) cardToCheck).getNumber()) ||
                        card instanceof ActionCard && cardToCheck instanceof ActionCard && ((ActionCard) card).getType() == ((ActionCard) cardToCheck).getType())
                validCards.add(card);
        if (validCards.size()==0)
            for (Card card : cardsList)
                if (card instanceof WildCard)
                    validCards.add(card);
    }

    public void computerPlay() {
        selectValidCards();
        if (validCards.size()!=0) {
            Random rnd = new Random();
            int cardNumber = Math.abs(rnd.nextInt()) % validCards.size();
            validCards.get(cardNumber).putOnTable();
            cardsList.remove(validCards.get(cardNumber));
        }
        else {
            addCard(GameManager.giveRandomCard());
            selectValidCards();
            if (validCards.size()!=0) {
                validCards.get(0).putOnTable();
                cardsList.remove(validCards.get(0));
            }
        }
    }

    public void HumanPlay() {
        selectValidCards();
        if (validCards.size()!=0) {
            System.out.println("Choose one of your cards to play.");
            int i = 1;
            for (Card card : validCards)
                System.out.println(i++ + ") " + card.toString());
            int chosenCard = new Scanner(System.in).nextInt()-1;
            validCards.get(chosenCard).putOnTable();
            cardsList.remove(validCards.get(chosenCard));

        }
        else {
            addCard(GameManager.giveRandomCard());
            selectValidCards();
            if (validCards.size()!=0) {
                validCards.get(0).putOnTable();
                cardsList.remove(validCards.get(0));
            }
        }
    }
}
