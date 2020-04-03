public class Main {

    public static void main(String[] args) {
	// write your code here
        /*String zero = "┌────────────────┐\n" +
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
                "└────────────────┘";

        String one = "┌────────────────┐\n" +
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
                "└────────────────┘";

        String two = "┌────────────────┐\n" +
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
                "└────────────────┘";

        String three = "┌────────────────┐\n" +
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
                "└────────────────┘";

        String four = "┌────────────────┐\n" +
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
                "└────────────────┘";

        String five = "┌────────────────┐\n" +
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
                "└────────────────┘";

        String six = "┌────────────────┐\n" +
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
                "└────────────────┘";

        String seven = "┌────────────────┐\n" +
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
                "└────────────────┘";

        String eight = "┌────────────────┐\n" +
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
                "└────────────────┘";

        String nine = "┌────────────────┐\n" +
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
                "└────────────────┘";

        String skip = "┌────────────────┐\n" +
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
                "└────────────────┘";

        String reverse = "┌────────────────┐\n" +
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
                "└────────────────┘";

        String draw2 = "┌────────────────┐\n" +
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
                "└────────────────┘";

        String wildColor = "┌────────────────┐\n" +
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
                "└────────────────┘";

        String wildDraw = "┌────────────────┐\n" +
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
                "└────────────────┘";

        for (int i=0; i<zero.length(); i++) {
            if (zero.charAt(i)=='\n')
                System.out.println("\u001B[0m");
            else {
                if (zero.charAt(i) != '@' && zero.charAt(i) != '0')
                    System.out.print("\u001B[41m");
                else
                    System.out.print("\u001B[47m");
                System.out.print(zero.charAt(i));
            }
        }

        System.out.println("\u001B[0m\n");

        for (int i=0; i<one.length(); i++) {
            if (one.charAt(i)=='\n')
                System.out.println("\u001B[0m");
            else {
                if (one.charAt(i) != '@' && one.charAt(i) != '1')
                    System.out.print("\u001B[43m");
                else
                    System.out.print("\u001B[47m");
                System.out.print(one.charAt(i));
            }
        }

        System.out.println("\u001B[0m\n");

        for (int i=0; i<two.length(); i++) {
            if (two.charAt(i)=='\n')
                System.out.println("\u001B[0m");
            else {
                if (two.charAt(i) != '@' && two.charAt(i) != '2')
                    System.out.print("\u001B[44m");
                else
                    System.out.print("\u001B[47m");
                System.out.print(two.charAt(i));
            }
        }

        System.out.println("\u001B[0m\n");

        for (int i=0; i<three.length(); i++) {
            if (three.charAt(i)=='\n')
                System.out.println("\u001B[0m");
            else {
                if (three.charAt(i) != '@' && three.charAt(i) != '3')
                    System.out.print("\u001B[42m");
                else
                    System.out.print("\u001B[47m");
                System.out.print(three.charAt(i));
            }
        }

        System.out.println("\u001B[0m\n");

        for (int i=0; i<four.length(); i++) {
            if (four.charAt(i)=='\n')
                System.out.println("\u001B[0m");
            else {
                if (four.charAt(i) != '@' && four.charAt(i) != '4')
                    System.out.print("\u001B[41m");
                else
                    System.out.print("\u001B[47m");
                System.out.print(four.charAt(i));
            }
        }

        System.out.println("\u001B[0m\n");

        for (int i=0; i<five.length(); i++) {
            if (five.charAt(i)=='\n')
                System.out.println("\u001B[0m");
            else {
                if (five.charAt(i) != '@' && five.charAt(i) != '5')
                    System.out.print("\u001B[43m");
                else
                    System.out.print("\u001B[47m");
                System.out.print(five.charAt(i));
            }
        }

        System.out.println("\u001B[0m\n");

        for (int i=0; i<six.length(); i++) {
            if (six.charAt(i)=='\n')
                System.out.println("\u001B[0m");
            else {
                if (six.charAt(i) != '@' && six.charAt(i) != '6')
                    System.out.print("\u001B[44m");
                else
                    System.out.print("\u001B[47m");
                System.out.print(six.charAt(i));
            }
        }

        System.out.println("\u001B[0m\n");

        for (int i=0; i<seven.length(); i++) {
            if (seven.charAt(i)=='\n')
                System.out.println("\u001B[0m");
            else {
                if (seven.charAt(i) != '@' && seven.charAt(i) != '7')
                    System.out.print("\u001B[42m");
                else
                    System.out.print("\u001B[47m");
                System.out.print(seven.charAt(i));
            }
        }

        System.out.println("\u001B[0m\n");

        for (int i=0; i<eight.length(); i++) {
            if (eight.charAt(i)=='\n')
                System.out.println("\u001B[0m");
            else {
                if (eight.charAt(i) != '@' && eight.charAt(i) != '8')
                    System.out.print("\u001B[41m");
                else
                    System.out.print("\u001B[47m");
                System.out.print(eight.charAt(i));
            }
        }

        System.out.println("\u001B[0m\n");

        for (int i=0; i<nine.length(); i++) {
            if (nine.charAt(i)=='\n')
                System.out.println("\u001B[0m");
            else {
                if (nine.charAt(i) != '@' && nine.charAt(i) != '9')
                    System.out.print("\u001B[43m");
                else
                    System.out.print("\u001B[47m");
                System.out.print(nine.charAt(i));
            }
        }

        System.out.println("\u001B[0m\n");

        for (int i=0; i<skip.length(); i++) {
            if (skip.charAt(i)=='\n')
                System.out.println("\u001B[0m");
            else {
                if (skip.charAt(i) != '@' && skip.charAt(i) != 'S' && skip.charAt(i) != 'k' && skip.charAt(i) != 'i' && skip.charAt(i) != 'p')
                    System.out.print("\u001B[44m");
                else
                    System.out.print("\u001B[47m");
                System.out.print(skip.charAt(i));
            }
        }

        System.out.println("\u001B[0m\n");

        for (int i=0; i<reverse.length(); i++) {
            if (reverse.charAt(i)=='\n')
                System.out.println("\u001B[0m");
            else {
                if (reverse.charAt(i) != '@' && reverse.charAt(i) != 'R' && reverse.charAt(i) != 'e' && reverse.charAt(i) != 'v')
                    System.out.print("\u001B[42m");
                else
                    System.out.print("\u001B[47m");
                System.out.print(reverse.charAt(i));
            }
        }

        System.out.println("\u001B[0m\n");

        for (int i=0; i<draw2.length(); i++) {
            if (draw2.charAt(i)=='\n')
                System.out.println("\u001B[0m");
            else {
                if (draw2.charAt(i) != '@' && draw2.charAt(i) != '2'  && draw2.charAt(i) != '+')
                    System.out.print("\u001B[41m");
                else
                    System.out.print("\u001B[47m");
                System.out.print(draw2.charAt(i));
            }
        }

        System.out.println("\u001B[0m\n");

        for (int i=0; i<wildColor.length(); i++) {
            if (wildColor.charAt(i)=='\n')
                System.out.println("\u001B[0m");
            else {
                if (wildColor.charAt(i)=='*')
                    System.out.print("\u001B[41m");
                else if (wildColor.charAt(i)=='(')
                    System.out.print("\u001B[43m");
                else if (wildColor.charAt(i)=='^')
                    System.out.print("\u001B[44m");
                else if (wildColor.charAt(i)=='>')
                    System.out.print("\u001B[42m");
                else if (wildColor.charAt(i) != '@' && wildColor.charAt(i) != 'W'  && wildColor.charAt(i) != 'C')
                    System.out.print("\u001B[100m");
                else
                    System.out.print("\u001B[47m");
                System.out.print(wildColor.charAt(i));
            }
        }

        System.out.println("\u001B[0m\n");

        for (int i=0; i<wildDraw.length(); i++) {
            if (wildDraw.charAt(i)=='\n')
                System.out.println("\u001B[0m");
            else {
                if (wildDraw.charAt(i)=='*')
                    System.out.print("\u001B[41m");
                else if (wildDraw.charAt(i)=='(')
                    System.out.print("\u001B[43m");
                else if (wildDraw.charAt(i)=='^')
                    System.out.print("\u001B[44m");
                else if (wildDraw.charAt(i)=='>')
                    System.out.print("\u001B[42m");
                else if (wildDraw.charAt(i) != '@' && wildDraw.charAt(i) != '+'  && wildDraw.charAt(i) != '4')
                    System.out.print("\u001B[100m");
                else
                    System.out.print("\u001B[47m");
                System.out.print(wildDraw.charAt(i));
            }
        }*/

        GameManager gm = new GameManager();
        gm.runGame();

    }
}
