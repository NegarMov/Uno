import java.util.HashMap;
import java.util.Scanner;

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

    public String getType() {
        return type;
    }

    @Override
    public void putOnTable() {
        if (type=="+4")
            GameManager.setPlusCards(4);
        /*System.out.println("Choose a color to continue the game with:\n1) Red\n2) Blue\n3) Green\n4) Yellow");
        Scanner scn = new Scanner(System.in);
        int ans = scn.nextInt();
        while (ans<=0 || ans>4) {
            System.out.println("Please enter a number between 1 and 4.");
            ans = scn.nextInt();
        }
        GameManager.setColorOnTable((ans==1)? "RED" : (ans==2)? "BLUE" : (ans==3)? "GREEN" : "YELLOW");*/
        super.putOnTable();
    }

    @Override
    public String toString() {
        return "Wild Card " + type;
    }
}
