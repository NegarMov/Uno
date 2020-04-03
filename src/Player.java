import java.util.ArrayList;

public class Player {
    private ArrayList<Card> cardsList;

    public Player() {
        cardsList = new ArrayList<>();
    }

    public void addCard(Card cardToAdd) {
        cardsList.add(cardToAdd);
    }

    public void showCards(String playerName) {
        System.out.println(playerName + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        for (int i=0; i<13; i++) {
            for (Card card: cardsList)
                System.out.print(card.getAppearanceLine(i));
            System.out.println();
        }
    }
}
