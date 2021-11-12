package SudyDelitelnyTri;

public class SudyDelitelnyTri {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        System.out.printf("12345213668: %s", validate("12345213668"));
    }

    public static int validate(String nums) {
        int result = 0;

        for (int i = 1; i < nums.length(); i+=2) { //starting at 1 cuz it is the second position which is considered even
            int number = Character.getNumericValue(nums.charAt(i));
            
            if(number%3 == 0) {
                System.out.println(number);
                result += number;
            } 
        }

        return result;
    }
}
