package _cara;

import java.util.Scanner;

class Cara {
    public static void main(String[] args) {
        String spacer = "-----------------------------------------------------------";
        String message = spacer + "\njak velkou caru chces narysovat?\n"
                + "(only numbers, negative ones will be converted to positive)\n" + spacer;

        renderDots(init(message));

    }

    public static int init(String msg) {
        System.out.println(msg); // print input message

        // ---- SETUP ----
        int length = 0;
        Scanner sc = new Scanner(System.in);
        // ---------------

        // handle invalid inputs
        try {
            length = Math.abs(sc.nextInt()); // convert negative values to positive.
        } catch (Exception e) {
            length = init("invalid input, please enter a number");
        }
        // --------------------

        sc.close(); // terrible java gc
        return length;
    }

    public static void renderDots(int length) {
        System.out.println("\n--------- A SNUPEJ! ---------\n");

        for (int i = 0; i < length; i++) {
            System.out.print('.'); // dot copied from assignement -> inconsistent use of ""
        }
    }
}
