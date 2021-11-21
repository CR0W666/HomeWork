package suma_nadprumernych_cisel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Snc {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            List<Double> nums = getNums(sc);
            System.out.println("Sum of numbers bigger then the average of the total sum: "
                    + sumAboveAvg(nums));
        } catch (Exception e) {
            System.out.println("Something has gone wrong, exiting program.\n" + e);
        }

    }

    public static List<Double> getNums(Scanner sc) {
        ArrayList<Double> nums = new ArrayList<>();
        System.out.println("Enter numbers eq.: 1 or 1,5. To finish press Ctrl+D");
        try {
            while (sc.hasNext()) {
                nums.add(sc.nextDouble());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return nums;
    }

    public static double avg(List<Double> nums) {
        return nums.stream().mapToDouble(Double::valueOf).average().orElseThrow();
    }

    public static double sumAboveAvg(List<Double> nums) {
        double avg = avg(nums);
        double sum = 0;
        for (double num : nums) {
            if (num >= avg)
                sum += num;
        }
        return sum;
    }
}
