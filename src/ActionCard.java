import java.util.HashMap;

/**
 * The class ActionCard represents an UNO game card which can perform an action. This card has its
 * own color, type, score(Which is equal to the number on the card) and appearance. An action card
 * type can be "Skip" (Skip the next player's turn), "Rev" (Reverse the game's direction) or "+2"
 * (Draw 2 cards)
 * Also this class is a subclass of Card.
 *
 * @author Negar Movaghatian
 * @since 2020-04-03
 */
public class ActionCard extends Card {

    // The type of the card
    private String type;
    //[Skip-> 0, +2-> 1, Rev-> 2]
    private HashMap<String, Integer> typesList;

    /**
     * Create a new numeric card.
     * @param color The color of the card.
     * @param type The type on the card. [Skip, +2, Rev]
     */
    public ActionCard(String color, String type) {
        super(20, color);
        this.type = type;
        typesList = new HashMap<>();
        typesList.put("Skip", 0);
        typesList.put("+2", 1);
        typesList.put("Rev", 2);
        cardsAppearance[0] = "┌────────────────┐\n" +
                        "│.Skip....@@@@@..│\n" +
                        "│......@@@@@@@@@.│\n" +
                        "│.....@@@@@@@@@@@│\n" +
                        "│...@@@@.....@@@@│\n" +
                        "│..@@@.@@@.@@.@@@│\n" +
                        "│.@@@.@@@.@@@.@@.│\n" +
                        "│@@@@.@@.@@@.@@..│\n" +
                        "│@@@@@.....@@@...│\n" +
                        "│@@@@@@@@@@@.....│\n" +
                        "│.@@@@@@@@@......│\n" +
                        "│..@@@@@....Skip.│\n" +
                        "└────────────────┘\n";
        cardsAppearance[1] = "┌────────────────┐\n" +
                        "│.+2......@@@@@..│\n" +
                        "│......@@@@@@@@@.│\n" +
                        "│.....@@@@@@@@@@@│\n" +
                        "│...@@@@@....@@@@│\n" +
                        "│..@@@@@@....@@@@│\n" +
                        "│.@@@@.......@@@.│\n" +
                        "│@@@@@....@@@@@..│\n" +
                        "│@@@@@....@@@@...│\n" +
                        "│@@@@@@@@@@@.....│\n" +
                        "│.@@@@@@@@@......│\n" +
                        "│..@@@@@......+2.│\n" +
                        "└────────────────┘\n";
        cardsAppearance[2] = "┌────────────────┐\n" +
                            "│.Rev.....@@@@@..│\n" +
                            "│......@@@@@@@@@.│\n" +
                            "│.....@...@@@@@@@│\n" +
                            "│...@@.@.@.@@.@@@│\n" +
                            "│..@@@@.@@@@.@@@@│\n" +
                            "│.@@@@.@@@@.@@@@.│\n" +
                            "│@@@@.@@.@.@.@@..│\n" +
                            "│@@@@@@@@...@@...│\n" +
                            "│@@@@@@@@@@@.....│\n" +
                            "│.@@@@@@@@@......│\n" +
                            "│..@@@@@.....Rev.│\n" +
                            "└────────────────┘\n";

    }

    /**
     * Get the 'line'th line of the string which represents the card's look.
     * @param line The line of the the string which represents the card's look.
     * @param hidden Shows if the card is hidden or not.
     * @return The 'line'th line of the string which represents the card's look.
     */
    @Override
    public String getAppearanceLine(int line, boolean hidden) {
        if (hidden)
            return super.getAppearanceLine(line, true);
        String ans = "";
        for (int i=19*line; i<19*(line+1); i++) {
            if (cardsAppearance[typesList.get(type)].charAt(i)=='\n')
                ans = ans.concat(colorsList.get("RESET") + " ");
            else {
                if (cardsAppearance[typesList.get(type)].charAt(i) != '@' && !type.contains("" + cardsAppearance[typesList.get(type)].charAt(i)))
                    ans = ans.concat(colorsList.get(color));
                else
                    ans = ans.concat(colorsList.get("WHITE"));
                ans = ans.concat("" + cardsAppearance[typesList.get(type)].charAt(i));
            }
        }
        return ans;
    }

    public String getType() {
        return type;
    }

    /**
     * Put this card on the table.
     * @param player The player who puts this card on table.
     */
    @Override
    public void putOnTable(Player player) {
        if (type.equals("Skip"))
            GameManager.skipTurn();
        else if (type.equals("Rev"))
            GameManager.reverseDirection();
        else
            GameManager.addPlusCards(2);
        super.putOnTable(player);
    }

    @Override
    public String toString() {
        return color + " " + type;
    }
}
