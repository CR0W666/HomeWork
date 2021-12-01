package C4.prg.aoc2021.day1;

/**
 * PartOne
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartOne {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("D:\\skola\\HomeWork\\C4\\prg\\aoc2021\\day1\\input.txt"));
        
        int answer = 0;
        int prevVal = sc.nextInt();
        while (sc.hasNext()) {
            int currentVal = sc.nextInt();
            if(currentVal > prevVal) answer++;
            prevVal = currentVal;
        }

        System.out.println(answer);
        sc.close();
    }
}