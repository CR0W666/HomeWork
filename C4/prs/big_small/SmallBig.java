package C4.prs.big_small;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

public class SmallBig {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> inputs = new ArrayList<>();
        try {
            System.out.println("enter numbers |ctrl+D to exit|");
            while (sc.hasNext()) {
                inputs.add(sc.nextInt());
            }
        } catch (InputMismatchException e) {
            System.out.println("------------");
        } finally {
            sc.close();
        }

        System.out.printf("Biggest Number: %s%nSmallest Number: %s", Collections.max(inputs),
                Collections.min(inputs));
    }
}
