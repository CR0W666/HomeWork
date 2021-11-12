package Cool_Sifra_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoolSifra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String encrypted = encrypt(input(sc, "Please enter your secret.\nSecret: "));
            System.out.printf("\nencrypted: %s", encrypted);
        } finally {
            sc.close();
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