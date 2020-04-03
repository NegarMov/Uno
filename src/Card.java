import java.util.HashMap;

public class Card {

    protected final HashMap<String, String> colorsList;
    protected int score;
    protected String color;
    protected String[] cardsAppearance;

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
                            "│.0.......@@@@@..│\n" +
                            "│......@@@@@@@@@.│\n" +
                            "│.....@@@@@@@@@@@│\n" +
                            "│...@@@....@@@@@@│\n" +
                            "│..@@@..@@..@@@@@│\n" +
                            "│.@@@@.@@@@.@@@@.│\n" +
                            "│@@@@@..@@..@@@..│\n" +
                            "│@@@@@@....@@@...│\n" +
                            "│@@@@@@@@@@@.....│\n" +
                            "│.@@@@@@@@@......│\n" +
                            "│..@@@@@.......0.│\n" +
                            "└────────────────┘\n";
    }

    public String getAppearanceLine(int line) {
        return "";
    }
}
