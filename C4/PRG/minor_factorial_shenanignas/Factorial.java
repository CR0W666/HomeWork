package minor_factorial_shenanignas;

import java.util.Scanner;
import java.util.stream.LongStream;
import java.util.InputMismatchException;


public class Factorial {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            long input = Math.abs(input(sc, "factorial of: "));

            long factOfInput = fact(input);
            long recursiveFact = recursiveFact(input);
            long streamFact = streamFact(input);
            long customFact = customFact(input);

            System.out.printf(
                    "%nresult:%nNormal: %s%nRecursive: %s%nstream: %s%ncustom( O(n/2)? ): %s",
                    factOfInput, recursiveFact, streamFact, customFact);
            trial(100_000_000, input, 1_000_000);

        }
    }

    public static long input(Scanner sc, String msg) {
        System.out.println(msg);
        long input = 0;
        try {
            input = sc.nextLong();
            if (input > 20 || input < 0)
                throw new InputMismatchException(
                        input + " is out of range. Max is 20 and min is 0");
        } catch (InputMismatchException e) {
            sc.next();
            input = input(sc, "\nWrong input, please enter a number");
        }

        return input;
    }



    public static long fact(long factorialOf) {
        long result = 1;
        for (int i = 1; i <= factorialOf; i++) {
            result *= i;
        }
        return result;
    }

    public static long recursiveFact(long factorialOf) {
        if (factorialOf == 0)
            return 1;
        return (factorialOf * recursiveFact(factorialOf - 1));
    }

    public static long streamFact(long n) {
        return LongStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b);
    }

    public static long customFact(long factorialOf) {
        if (factorialOf == 0)
            return 1;
        if (factorialOf % 2 != 0)
            return customFact(factorialOf - 1) * factorialOf;

        long result = factorialOf;
        long prevVal = 0;
        for (long i = factorialOf - 2; i > 0; i -= 2) {
            prevVal += i + 2;
            result *= prevVal + i;
        }
        return result;
    }

    public static long customFactFirstAttempt(long factorialOf) {
        if (factorialOf % 2 != 0)
            return customFact(factorialOf - 1) * factorialOf;

        long[] sequence = new long[(int) (Math.ceil((double) factorialOf / 2))];
        sequence[0] = factorialOf;
        long temp = factorialOf - 2;
        for (int i = 1; i < Math.ceil((double) factorialOf / 2); i++) {
            sequence[i] = sequence[i - 1] + temp;
            temp -= 2;
        }
        long result = 1;
        for (long l : sequence) {
            result *= l;
        }
        return result;
    }

    public static long[] trial(int numOfRepetitions, long factorialOf, long format) {
        long normalStart = System.nanoTime();
        for (int i = 0; i < numOfRepetitions; i++) {
            fact(factorialOf);
        }
        long normalTime = System.nanoTime() - normalStart;

        long recurStart = System.nanoTime();
        for (int i = 0; i < numOfRepetitions; i++) {
            recursiveFact(factorialOf);
        }
        long recurTime = System.nanoTime() - recurStart;

        long streamStart = System.nanoTime();
        for (int i = 0; i < numOfRepetitions; i++) {
            streamFact(factorialOf);
        }
        long streamTime = System.nanoTime() - streamStart;

        long customStart = System.nanoTime();
        for (int i = 0; i < numOfRepetitions; i++) {
            customFact(factorialOf);
        }
        long customTime = System.nanoTime() - customStart;

        long customOldStart = System.nanoTime();
        // for (int i = 0; i < numOfRepetitions; i++) {
        // customFactFirstAttempt(factorialOf);
        // }
        long customOldTime = System.nanoTime() - customOldStart;
        customOldTime = -1;

        long[] trialResults = {normalTime, recurTime, streamTime, customTime, customOldTime};
        for (int i = 0; i < trialResults.length; i++) {
            trialResults[i] /= format;
        }
        System.out.printf(
                "%n------------------%ntrial:%n%nnano/%s:%nnormal: %s%nrecur: %s%nstream: %s%ncustom: %s%ncustom old: %s",
                format, trialResults[0], trialResults[1], trialResults[2], trialResults[3],
                trialResults[4]);
        // System.out.printf("\nnano:\nnormal: %s\nrecur: %s\nstream: %s\ncustom: %s",
        // trialResults[0], trialResults[1], trialResults[2], trialResults[3]);

        return trialResults;
    }
}


