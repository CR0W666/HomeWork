package _ryba;

import java.util.Scanner;

public class Ryba {
    public static void main(String[] args) {

        String message = """
                Please input how many fish will you eat for dinner\"""
                "(only numbers, negative ones will be converted to positive)
                "\"""\"""-----------------------------------------------------------""";

        renderFish(init(message));

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

    public static void renderFish(int length) {
        System.out.println("\n--------- DINNER ---------\n");

        for (int i = 0; i < length; i++) {
            System.out.println("<° )))-<");
        }
    }

}
