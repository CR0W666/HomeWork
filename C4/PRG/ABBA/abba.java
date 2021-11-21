import java.util.Scanner;

class Abba {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        test();
        System.out.println("Enter a string: \n");
        try {
            while (sc.hasNext()) {
                input = sc.next();
                validate(input);
                System.out.println("\nEnter a string: \n");
            }
        } finally {sc.close();}

    }


    public static void validate(String input) {
        input = input.toUpperCase();
        String secondPass = input;
        System.out.print(input + ": ");
        boolean ab = search(input, 0);
        input = clean(input, 0);
        boolean ba = search(input, 1);
        input = clean(input, 1);
        boolean sba = search(secondPass, 1);
        secondPass = clean(secondPass, 1);
        boolean sab = search(secondPass, 0);
        secondPass = clean(secondPass, 0);
        boolean result = (ab && ba) || (sab && sba);
        System.out.print(result);
        System.out.println("");
    }

    public static boolean search(String input, int phase) {
        String phaseString = (phase == 0) ? "AB" : "BA";
        return input.contains(phaseString);
    }

    public static String clean(String input, int phase) {
        char[] chars = input.toCharArray();
        String phaseString = (phase == 0) ? "AB" : "BA";
        for (int i = 0; i < chars.length; i++) {
            if(i+1 >= chars.length)break;
            if(chars[i]==phaseString.toCharArray()[0] && chars[i+1]==phaseString.toCharArray()[1]) {
                chars[i] = '#';
                chars[i+1] = '#';
            }
        }
        input = "";
        StringBuilder builder = new StringBuilder();
        for (char c : chars) {
            builder.append(c);
        }
        return builder.toString();
    }


    public static void test() {
        validate("ABA");
        validate("ABBA");
        validate("BABA");
        validate("BANAN");
        validate("BAB");
        validate("BAABA");
        validate("KABAT");
        validate("ZABOBA");
        validate("OBANABI");
        validate("OBAMA");
        validate("OBIWAN KENOBI");
        validate("");
        validate("ABBAABBAABABBABA");
        validate("ABAAB");
    }



}
