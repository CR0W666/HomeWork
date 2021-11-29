package oz_two;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OzTwo {
    /*
     * PHASE ONE: vstup N -> # zelenin vstup N -> # ovoce vyplnit zel. & ov. !! KONTROLA DUPLICITY
     * -> neulozit & upozornit !!
     * 
     * PHASE TWO: vstup X -> je X ov., zel., nebo "ostatni". !! DOKUD NEZADA "END" !!
     * 
     * PHASE THREE: po "END" vypise OVOCE: x1, x2, x3, x4, x5, x6 ZELENINA: y1, y2, y3, y4
     */
    public static void main(String[] args) {

        // ------ PHASE ONE --------------
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej pocet zeleniny");
        int countZel = Integer.parseInt(sc.nextLine());

        System.out.println("Zadej pocet ovoce");
        int countOvc = Integer.parseInt(sc.nextLine());
        // sc.nextLine(); // due to bug -> first iteration in input loop was being skipped.
        List<String> zel = fillGroup("Zeleninu", countZel, sc);
        List<String> ovc = fillGroup("Ovoce", countOvc, sc);

        // ------ PHASE TWO --------------
        checkType(zel, ovc, sc);

        // ------ PHASE THREE ------------
        printTypes(zel, ovc);

    }

    public static List<String> fillGroup(String group, int size, Scanner sc) {
        ArrayList<String> groupArr = new ArrayList<>();
        int i = 0;
        while (i < size) {

            System.out.println("Zadej " + (i + 1) + ". " + group);
            String input = sc.nextLine();
            if (groupArr.contains(input)) {
                System.out.println("toto uz bylo zadano.");
                i--;
            } else
                groupArr.add(input);

            i++;
        }

        return groupArr;
    }

    public static void checkType(List<String> zel, List<String> ovc, Scanner sc) {
        String input = "";
        System.out.println("Zadej neco co chces identifikovat. (\"END\" pro konec.) ");
        do {
            input = sc.nextLine();
            if (zel.contains(input) && ovc.contains(input))
                System.out.println("Ovoce i Zelenina?");
            else if (zel.contains(input))
                System.out.println("Zelenina.");
            else if (ovc.contains(input))
                System.out.println("Ovoce.");
            else
                System.out.println("Ostatni.");
        } while (!input.equals("END"));
    }

    public static void printTypes(List<String> zel, List<String> ovc) {
        System.out.print("\nZelenina: ");
        for (String z : zel)
            System.out.print(z + ", ");
        System.out.print("\nOvoce: ");
        for (String o : ovc)
            System.out.print(o + ", ");
    }


}
