import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class Primes {
    public static void main(String[] args) {
        primesTo(inputNum("Enter a number"));
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

    public static boolean[] calculatePrimes(int ceil) {
        boolean[] primes = new boolean[ceil + 1];
        Arrays.fill(primes, true);
        for (int p = 2; p * p <= ceil; p++) {
            if (primes[p]) {
                for (int i = p * p; i <= ceil; i += p) primes[i] = false;
            }
        }

        return primes;
    }

    public static void primesTo(int ceil) {
        System.out.println("Primes up to number " + ceil);
        boolean[] primes = calculatePrimes(ceil);
        int counter = 0;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                System.out.println(i);
                counter++;
            }
        }
        System.out.println("overall there were " + counter + " prime numbers up to " + ceil);
    }
}
