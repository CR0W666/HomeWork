import java.util.Scanner;

class test30_09_2021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        System.out.println("Enter a number: \n");
        try {
            while (sc.hasNext()) {
                
                input = sc.next();
                validate(input);
                System.out.println("\nEnter a number: \n");
            }
        } finally {sc.close();}


    }

    public static boolean isNumber(String input) {
        for (char num : input.toCharArray()) {
            if(!Character.isDigit(num)) return false;
        }
        return true;
    }

    public static int addUp(String numbers) {
        int total = 0;
        for (char num : numbers.toCharArray()) {
            total += Integer.parseInt(String.valueOf(num));
        }
        return total;
    }

    public static void validate(String input) {
        if(isNumber(input)) System.out.print(input + ": " + addUp(input));
        else System.out.println("Your input is not a number.");
    }
}