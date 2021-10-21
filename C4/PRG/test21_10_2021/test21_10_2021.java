import java.util.Scanner;
public class test21_10_2021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many numbers you want");
        int numCount = sc.nextInt();
        int[] nums = new int[numCount];
        for (int i = 0; i < numCount; i++) {
            System.out.println("Enter number " + (i+1) +".");
            nums[i] = sc.nextInt();
        }
        double avg = 0;
        for (int num : nums) {
            avg += num;
        }
        avg /= nums.length;

        int sum = 0;
        for (int num : nums) {
            if(num >= Math.ceil(avg)) sum += num;
        }
        System.out.println("Sum of numbers bigger then the average of the total sum: " + sum);
    }
}
