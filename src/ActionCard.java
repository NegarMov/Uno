import java.util.HashMap;

public class ActionCard extends Card {

    private String type;
    private HashMap<String, Integer> typesList;

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

    @Override
    public String getAppearanceLine(int line) {
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
}
