package C4.prg.tests.test16_09_2021;

import java.util.InputMismatchException;
import java.util.Scanner;

class Test16x9x2021 {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int numOfLines = input(sc, "Enter a number of max size: " + Integer.MAX_VALUE);
            System.out.println("-------");
            renderSymbols("0", numOfLines);
        }
    }

    public static int input(Scanner sc, String msg) {
        System.out.println(msg);
        int input = 0;
        try {
            input = sc.nextInt();
        } catch (InputMismatchException e) {
            sc.next();
            input = input(sc, "\nWrong input, please enter a number");
        }

        return input;
    }

    public static void renderSymbols(String symbol, int numOfLines) {
        int count = 0;
        for (int i = 0; i <= numOfLines; i++) {
            int numOfSymbols = i * i;
            if (numOfSymbols == 0)
                continue;
            for (int j = 0; j < numOfSymbols; j++) {
                System.out.print(symbol);
                count++;
            }
            System.out.println();

        }
        System.out.println("Number of printed symbol( " + symbol + " ): " + count);

    }

}
