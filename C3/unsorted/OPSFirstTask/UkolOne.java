import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class UkolOne {
    
    public static ArrayList<Integer> nums = new ArrayList<>();
    
    
    public static void main(String[] args) {
        
            
            String input = "";
            File outputFile = new File("output.txt");
            Scanner sc = new Scanner(System.in);
            
            while (!input.equals("END") && sc.hasNextLine()) {
                input = sc.nextLine();
                try {
                    nums.add(Integer.parseInt(input));
                } catch (NumberFormatException e) {
                    continue;
                }
            } 

            sc.close();
            logicOps();
            //printList();

    }


    public static void printList() {
        for(int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));
        }
    }
    
    public static void logicOps() {
            sortList();
            System.out.println("Suma: "+sumCalc());
            System.out.println("Nejmensi cislo: "+findLowest());
            System.out.println("Nejvetsi cislo: "+findHighest());
        }
        public static void sortList() {
            Collections.sort(nums);
        }
        
        public static int sumCalc() {
            int sum = 0;
            for(int i : nums) {
                sum += i;
            }
            return sum;
        }

        public static int findLowest() {
            return nums.get(0);
        }

        public static int findHighest() {
            return nums.get(nums.size()-1);
        }
}