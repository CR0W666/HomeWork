package _bin;

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class Bin {
    public static void main(String[] args) {

        long[] values = init();
        String result = convertToBase(values[0], values[1]);
        String formattedResult = properFormat(result, values[1]);
        String neg = (values[2] == 1) ? "-" : "";

        System.out.println("raw result: " + neg + result + "\nformatted: " + neg + formattedResult);

    }

    public static long[] init() {
        Scanner sc = new Scanner(System.in);
        String spacer = "-----------------------------------------------------------";
        System.out.println("ALL INPUTS MUST BE NUMBERS\n" + spacer);

        long base = input(sc,
                "please enter a base to convert to (except 10) eq: binary -> 2\ninput: ", false)[0];
        long[] number = input(sc,
                "Please input a decimal number to be converted into the selected base\ninput: ",
                true);

        System.out.println(spacer);

        sc.close(); // terrible java gc

        return new long[] {number[0], base, number[1]}; // number, base, bool is negative (0 =
                                                        // false)
    }

    public static long[] input(Scanner sc, String msg, boolean negative) {
        System.out.print(msg); // print input message
        // ---- SETUP ----
        long[] values = new long[2]; // size of two, first holds the number, second if the num was
                                     // negative
        // ---------------

        // handle invalid inputs
        try {
            long input = sc.nextLong();
            values[0] = Math.abs(input); // convert negative values to positive.
            if (input < 0)
                values[1] = 1; // if number WAS negative, store it as 1 (true)
        } catch (Exception e) {
            sc.next(); // uses up invalid token to avoid infinite loop
            return input(sc, "invalid input, please enter a number\n input: ", negative);
        }
        // --------------------
        if (!negative) { // this argument controls if negative numbers are allowed
            values[1] = 0;
        }

        return values;
    }

    public static String convertToBase(long number, long base) {
        ArrayList<String> nums = new ArrayList<>();

        while (number > 0) {
            nums.add(number % base + " ");
            number /= base;
        }
        Collections.reverse(nums);

        return String.join("", nums);
    }

    public static String properFormat(String number, long base) {
        String[] nums = number.split(" ");

        StringBuilder result = new StringBuilder();

        for (String num : nums) {
            result.append(Long.toString(Long.valueOf(num), (int) base));
        }

        return result.toString();
    }

}
