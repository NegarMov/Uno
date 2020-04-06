import java.util.HashMap;

public class Card {

    // List of the used color in this program
    protected static HashMap<String, String> colorsList;
    // The score of the card
    protected int score;
    // The color of the card
    protected String color;
    // The string which represents the card's appearance
    protected String[] cardsAppearance;

    /**
     * Create a new card.
     * @param score The score of the new card.
     * @param color The color of the new card.
     */
    public Card(int score, String color) {
        this.score = score;
        this.color = color;
        cardsAppearance = new String[11];
        colorsList =  new HashMap<>();
        colorsList.put("BLACK", "\u001B[100m");
        colorsList.put("RED", "\u001B[41m");
        colorsList.put("GREEN", "\u001B[42m");
        colorsList.put("YELLOW", "\u001B[43m");
        colorsList.put("BLUE", "\u001B[44m");
        colorsList.put("WHITE", "\u001B[47m");
        colorsList.put("RESET", "\u001B[0m");
        cardsAppearance[10] = "┌────────────────┐\n" +
                            "│................│\n" +
                            "│................│\n" +
                            "│................│\n" +
                            "│................│\n" +
                            "│................│\n" +
                            "│................│\n" +
                            "│................│\n" +
                            "│................│\n" +
                            "│................│\n" +
                            "│................│\n" +
                            "│................│\n" +
                            "└────────────────┘\n";
    }

    /**
     * Get the 'line'th line of the string which represents the card's look.
     * @param line The line of the the string which represents the card's look.
     * @param hidden Shows if the card is hidden or not.
     * @return The 'line'th line of the string which represents the card's look.
     */
    public String getAppearanceLine(int line, boolean hidden) {
        return colorsList.get("BLACK") + cardsAppearance[10].substring(19*line, 19*line + 18) + colorsList.get("RESET") + " ";
    }

    /**
     * Get the list of the colors in this game.
     * @return colorList field.
     */
    static HashMap<String, String> getColorsList() {
        return colorsList;
    }

    /**
     * Get the color of the card.
     * @return color field.
     */
    public String getColor() {
        return color;
    }

    public int getScore() {
        return score;
    }

    /**
     * Put this card on the table.
     * @param player The player who puts this card on table.
     */
    public void putOnTable(Player player) {
        GameManager.setCardOnTable(this);
        if (!(this instanceof WildCard))
            GameManager.setColorOnTable(color);
        System.out.println(">Puts " + toString() + " On table.");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
