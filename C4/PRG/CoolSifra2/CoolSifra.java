package CoolSifra2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoolSifra {
    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)) {
            String encrypted = encrypt(input(sc, "Please enter your secret.\nSecret: "));
            System.out.printf("%nencrypted: %s", encrypted);
        }
        
    }

    public static String input(Scanner sc, String msg) {
        System.out.print(msg);
        String input = " ";
        
        try {
            input = sc.nextLine();
        } catch (InputMismatchException e) {
            sc.next();
            input = input(sc, "Invalid input");
        }

        return input;
    }

    public static String encrypt(String unencrypted) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < unencrypted.length(); i++) {
            if(i%2 != 0) continue;
            sb.append(unencrypted.charAt(i));
        }

        return sb.toString();
    }
}