package numparse;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.InputMismatchException;
import java.util.regex.Matcher;

public class NumParse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = parse(input(sc, "Neco napis more...\nsem pis: "));
        if (num != 0)
            System.out.println(num);
        else
            System.out.println("nebylo tam cislo ://");
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

    public static long parse(String msg) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(msg);
        long value = 0;
        while (m.find()) {
            value += Long.valueOf(m.group());
        }
        return value;
    }

}
