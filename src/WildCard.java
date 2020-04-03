import java.util.HashMap;

public class WildCard extends Card {

    private String type;
    private HashMap<String, Integer> typesList;

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

    @Override
    public String getAppearanceLine(int line) {
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
}
