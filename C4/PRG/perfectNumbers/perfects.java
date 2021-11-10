import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Perfects {
    public static void main(String[] args) {
        findPerfects(inputNum("enter a number"));
    }

    public static int inputNum(String message) {
        int input = 1000;
        System.out.println(message);
        try (Scanner sc = new Scanner(System.in)) {
            input = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("wrong input");
        }
        return input;
    }

    public static boolean isPerfect(int num) {
        int i, sum = 0;
        for(i = 1; i < num; i++) {
            if(num % i == 0)  {
                sum += i;
            }
        }
        return sum == num;
    }

    public static void findPerfects(int ceil) {
        ArrayList<Integer> perfects = new ArrayList<>();
        for (int i = 1; i < ceil; i++) {
            if (isPerfect(i)) perfects.add(i);
        }
        System.out.println("Perfect numbers to " + ceil + ": ");
        for (int num : perfects) {
            System.out.println(num);
        }
        System.out.println("There is " + perfects.size() + " numbers up to " + ceil);
    }
}