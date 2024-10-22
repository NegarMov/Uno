/**
 * The class NumericCard represents an UNO game card which has a number on it. This card has its
 * own color, number, score(Which is equal to the number on the card) and appearance.
 * Also this class is a subclass of Card.
 *
 * @author Negar Movaghatian
 * @since 2020-04-03
 */
public class NumericCard extends Card {

    // The number on the card
    private int number;

    /**
     * Create a new numeric card.
     * @param color The color of the card.
     * @param number The number on the card.
     */
    public NumericCard(String color, int number) {
        super(number, color);
        this.number = number;

        cardsAppearance[0] = "┌────────────────┐\n" +
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
        cardsAppearance[1] = "┌────────────────┐\n" +
                            "│.1.......@@@@@..│\n" +
                            "│......@@@@@@@@@.│\n" +
                            "│.....@@@@@@@@@@@│\n" +
                            "│...@@@@@@@@@@@@@│\n" +
                            "│..@@@....@@@@@@@│\n" +
                            "│.@@@@@@..@@@@@@.│\n" +
                            "│@@@@@@@..@@@@@..│\n" +
                            "│@@@@@@@..@@@@...│\n" +
                            "│@@@@@@@@@@@.....│\n" +
                            "│.@@@@@@@@@......│\n" +
                            "│..@@@@@.......1.│\n" +
                            "└────────────────┘\n";
        cardsAppearance[2] = "┌────────────────┐\n" +
                            "│.2.......@@@@@..│\n" +
                            "│......@@@@@@@@@.│\n" +
                            "│.....@@@@@@@@@@@│\n" +
                            "│...@@@....@@@@@@│\n" +
                            "│..@@@.@@@.@@@@@@│\n" +
                            "│.@@@@@@@.@@@@@@.│\n" +
                            "│@@@@@@..@@@@@@..│\n" +
                            "│@@@@@.....@@@...│\n" +
                            "│@@@@@@@@@@@.....│\n" +
                            "│.@@@@@@@@@......│\n" +
                            "│..@@@@@.......2.│\n" +
                            "└────────────────┘\n";
        cardsAppearance[3] = "┌────────────────┐\n" +
                            "│.3.......@@@@@..│\n" +
                            "│......@@@@@@@@@.│\n" +
                            "│.....@@@@@@@@@@@│\n" +
                            "│...@@@....@@@@@@│\n" +
                            "│..@@@@@@@@.@@@@@│\n" +
                            "│.@@@@@....@@@@@.│\n" +
                            "│@@@@@@@@@@.@@@..│\n" +
                            "│@@@@@@....@@@...│\n" +
                            "│@@@@@@@@@@@.....│\n" +
                            "│.@@@@@@@@@......│\n" +
                            "│..@@@@@.......3.│\n" +
                            "└────────────────┘\n";
        cardsAppearance[4] = "┌────────────────┐\n" +
                            "│.4.......@@@@@..│\n" +
                            "│......@@@@@@@@@.│\n" +
                            "│.....@@..@@@@@@@│\n" +
                            "│...@@@.@.@@@@@@@│\n" +
                            "│..@@@.@@.@@@@@@@│\n" +
                            "│.@@@.......@@@@.│\n" +
                            "│@@@@@@@@.@@@@@..│\n" +
                            "│@@@@@@@...@@@...│\n" +
                            "│@@@@@@@@@@@.....│\n" +
                            "│.@@@@@@@@@......│\n" +
                            "│..@@@@@.......4.│\n" +
                            "└────────────────┘\n";
        cardsAppearance[5] = "┌────────────────┐\n" +
                            "│.5.......@@@@@..│\n" +
                            "│......@@@@@@@@@.│\n" +
                            "│.....@@@@@@@@@@@│\n" +
                            "│...@@@.....@@@@@│\n" +
                            "│..@@@@.@@@@@@@@@│\n" +
                            "│.@@@@@.....@@@@.│\n" +
                            "│@@@@@@@@@@@.@@..│\n" +
                            "│@@@@@@.....@@...│\n" +
                            "│@@@@@@@@@@@.....│\n" +
                            "│.@@@@@@@@@......│\n" +
                            "│..@@@@@.......5.│\n" +
                            "└────────────────┘\n";
        cardsAppearance[6] = "┌────────────────┐\n" +
                            "│.6.......@@@@@..│\n" +
                            "│......@@@@@@@@@.│\n" +
                            "│.....@@@@@@@@@@@│\n" +
                            "│...@@@.....@@@@@│\n" +
                            "│..@@@.@@@@@@@@@@│\n" +
                            "│.@@@@......@@@@.│\n" +
                            "│@@@@@.@@@@@.@@..│\n" +
                            "│@@@@@@.....@@...│\n" +
                            "│@@@@@@@@@@@.....│\n" +
                            "│.@@@@@@@@@......│\n" +
                            "│..@@@@@.......6.│\n" +
                            "└────────────────┘\n";
        cardsAppearance[7] = "┌────────────────┐\n" +
                            "│.7.......@@@@@..│\n" +
                            "│......@@@@@@@@@.│\n" +
                            "│.....@@@@@@@@@@@│\n" +
                            "│...@@@.....@@@@@│\n" +
                            "│..@@@@@@@@.@@@@@│\n" +
                            "│.@@@@@@@@.@@@@@.│\n" +
                            "│@@@@@@@@.@@@@@..│\n" +
                            "│@@@@@@@.@@@@@...│\n" +
                            "│@@@@@@@@@@@.....│\n" +
                            "│.@@@@@@@@@......│\n" +
                            "│..@@@@@.......7.│\n" +
                            "└────────────────┘\n";
        cardsAppearance[8] = "┌────────────────┐\n" +
                            "│.8.......@@@@@..│\n" +
                            "│......@@@@@@@@@.│\n" +
                            "│.....@@@@@@@@@@@│\n" +
                            "│...@@@....@@@@@@│\n" +
                            "│..@@@.@@@@.@@@@@│\n" +
                            "│.@@@@@....@@@@@.│\n" +
                            "│@@@@@.@@@@.@@@..│\n" +
                            "│@@@@@@....@@@...│\n" +
                            "│@@@@@@@@@@@.....│\n" +
                            "│.@@@@@@@@@......│\n" +
                            "│..@@@@@.......8.│\n" +
                            "└────────────────┘\n";
        cardsAppearance[9] = "┌────────────────┐\n" +
                            "│.9.......@@@@@..│\n" +
                            "│......@@@@@@@@@.│\n" +
                            "│.....@@@@@@@@@@@│\n" +
                            "│...@@@.....@@@@@│\n" +
                            "│..@@@.@@@@@.@@@@│\n" +
                            "│.@@@@@......@@@.│\n" +
                            "│@@@@@@@@@@@.@@..│\n" +
                            "│@@@@@@.....@@...│\n" +
                            "│@@@@@@@@@@@.....│\n" +
                            "│.@@@@@@@@@......│\n" +
                            "│..@@@@@.......9.│\n" +
                            "└────────────────┘\n";
    }

    public int getNumber() {
        return number;
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
            if (cardsAppearance[number].charAt(i)=='\n')
                ans = ans.concat(colorsList.get("RESET") + " ");
            else {
                if (cardsAppearance[number].charAt(i) != '@' && cardsAppearance[number].charAt(i) != (char) number + 48)
                    ans = ans.concat(colorsList.get(color));
                else
                    ans = ans.concat(colorsList.get("WHITE"));
                ans = ans.concat("" + cardsAppearance[number].charAt(i));
            }
        }
        return ans;
    }

    @Override
    public String toString() {
        return color + " " + number;
    }
}
