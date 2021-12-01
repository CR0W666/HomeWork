package C4.prg.primes;

import java.util.Scanner;

class Primes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadejte cislo do ktereho chcete najit prvocisla");
        findPrimes(sc.nextInt());
        sc.close();
    }

    public static boolean isPrime(int number) {
        if (number == 1)
            return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static void findPrimes(int ceil) {
        System.out.println("--------------------\nPrimes up to " + ceil + ": ");
        for (int i = 2; i <= ceil; i++) {
            if (isPrime(i))
                System.out.println(i);
        }
    }


}
