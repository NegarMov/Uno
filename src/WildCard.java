import java.util.*;

/**
 * The class WildCard represents an UNO game card which can perform an action but is also wild!
 * This card has its own type, score(Which is equal to the number on the card) and appearance. a
 * wild card type can be either "WC" (Stands for Wild Color- Choose the color to continue the game with)
 * or "+4" (Draw 4 cards)
 * Also this class is a subclass of Card.
 *
 * @author Negar Movaghatian
 * @since 2020-04-03
 */
public class WildCard extends Card {

    // The type of the card
    private String type;
    //[WC-> 0, +4-> 1]
    private HashMap<String, Integer> typesList;

    /**
     * Create a new numeric card.
     * @param type The type on the card. [WC, +4]
     */
    public WildCard(String type) {
        super(50, "BLACK");
        this.type = type;
        typesList = new HashMap<>();
        typesList.put("WC", 0);
        typesList.put("+4", 1);
        cardsAppearance[0] = "┌────────────────┐\n" +
                            "│.WC......***^^..│\n" +
                            "│......*****^^^^.│\n" +
                            "│.....*****^^^^^^│\n" +
                            "│...******^^^^^^^│\n" +
                            "│..******^^^^^^^^│\n" +
                            "│.((((((>>>>>>>>.│\n" +
                            "│((((((>>>>>>>>..│\n" +
                            "│(((((>>>>>>>>...│\n" +
                            "│((((>>>>>>>.....│\n" +
                            "│.((>>>>>>>......│\n" +
                            "│..(>>>>......WC.│\n" +
                            "└────────────────┘\n";
        cardsAppearance[1] = "┌────────────────┐\n" +
                            "│.+4......@@@@@..│\n" +
                            "│......@@@@@@@@@.│\n" +
                            "│.....@@^^^^@@@@@│\n" +
                            "│...@@@@^^^^@@@@@│\n" +
                            "│..@@***^^>>>>@@@│\n" +
                            "│.@@@****@>>>>@@.│\n" +
                            "│@@((((**@>>>>@..│\n" +
                            "│@@((((@@@@@@@...│\n" +
                            "│@@((((@@@@@@....│\n" +
                            "│.@@@@@@@@@......│\n" +
                            "│..@@@@@......+4.│\n" +
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
                if (cardsAppearance[typesList.get(type)].charAt(i)=='*')
                    ans = ans.concat(colorsList.get("RED"));
                else if (cardsAppearance[typesList.get(type)].charAt(i)=='(')
                    ans = ans.concat(colorsList.get("YELLOW"));
                else if (cardsAppearance[typesList.get(type)].charAt(i)=='^')
                    ans = ans.concat(colorsList.get("BLUE"));
                else if (cardsAppearance[typesList.get(type)].charAt(i)=='>')
                    ans = ans.concat(colorsList.get("GREEN"));
                else if (cardsAppearance[typesList.get(type)].charAt(i) != '@' && !type.contains("" + cardsAppearance[typesList.get(type)].charAt(i)))
                    ans = ans.concat(colorsList.get("BLACK"));
                else
                    ans = ans.concat(colorsList.get("WHITE"));
                ans = ans.concat("" + cardsAppearance[typesList.get(type)].charAt(i));
            }
        }
        return ans;
    }

    /**
     * Get the type of this card.
     * @return The type field.
     */
    public String getType() {
        return type;
    }

    /**
     * Put this card on the table.
     * @param player The player who puts this card on table.
     */
    @Override
    public void putOnTable(Player player) {
        if (type.equals("+4"))
            GameManager.addPlusCards(4);
        if (player.getWhoIsPlayer().equals("HUMAN")) {
            System.out.println("Choose a color to continue the game with:\n1) Red\n2) Blue\n3) Green\n4) Yellow");
            Scanner scn = new Scanner(System.in);
            int ans = scn.nextInt();
            while (ans<=0 || ans>4) {
                System.out.println("Please enter a number between 1 and 4.");
                ans = scn.nextInt();
            }
            GameManager.setColorOnTable((ans==1)? "RED" : (ans==2)? "BLUE" : (ans==3)? "GREEN" : "YELLOW");
        }
        else
            GameManager.setColorOnTable(player.colorPreference());
        super.putOnTable(player);
    }

    @Override
    public String toString() {
        return "Wild Card " + type;
    }
}
