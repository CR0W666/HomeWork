package C4.prg.aoc2021.day1;

/**
 * PartOne
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayOne {

    public static void main(String[] args) {
        int[] data = getInput();
        System.out.println("Part One: " + partOne(data));
        System.out.println("Part Two: " + partTwo(data));
    }

    public static int partOne(int[] data) {
        int answer = 0;
        int prevVal = data[0];
        for (int currentVal : data) {
            if(currentVal > prevVal) answer++;
            prevVal = currentVal;
        }

        return answer;
    }

    public static int partTwo(int[] data) {
        int answer = 0;
        int sumOfLast = data[0] + data[1] + data[2];
        
        for(int i = 1; i+2 < data.length; i++) {
            int sumCurr = data[i] + data[i+1] + data[i+2];
            if(sumCurr > sumOfLast) answer++;
            sumOfLast = sumCurr;
        }

        return answer;
    }

    public static int[] getInput() {
        try(Scanner sc = new Scanner(new File("D:\\skola\\HomeWork\\C4\\prg\\aoc2021\\day1\\input.txt"))) {
            
            final StringBuilder sb = new StringBuilder();
            while (sc.hasNext()) {
                sb.append(sc.nextLine()+ "\n");
            }
            final String[] inputStrings = sb.toString().split("\n");
            int[] input = new int[inputStrings.length];
            for(int i = 0; i < inputStrings.length; i++) {
                input[i] = Integer.parseInt(inputStrings[i]);
            }
    
            return input;
        } catch (FileNotFoundException e) {
            return new int[0];
        }

    }
}