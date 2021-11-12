package test2021_10_7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CorrectArmstrong {
    public static void main(String[] args) {
        int input = input("enter a number \n");
        System.out.println("input is: "+input);
        findArmstrongsUpTo(input);
    }

    public static int input(String msg) {
        System.out.println(msg);
        try (Scanner sc = new Scanner(System.in)) {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            return 1000;
        }
    }

    public static void findArmstrongsUpTo(int ceil) {
        for (int i = 1; i < ceil; i++) {
            if(isArmstrong(i)) System.out.println(i);
        }
    }

    public static boolean isArmstrong(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int sum = 0;
        for (char digit : digits) {
            int idigit = Character.getNumericValue(digit);
            sum += Math.pow(idigit, digits.length);
        }

        return sum == num;
    }
}
