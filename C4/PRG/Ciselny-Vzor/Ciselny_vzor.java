import java.util.Scanner;

public class Ciselny_vzor {
    public static void main(String[] args) {
        programInfo();
        String message = "Please input the desired size of the pyramid\n"+
                         "(only numbers, numbers larger than 1000 work better)"+
                     "\n\n-----------------------------------------------------------";

        renderPyramid(String.valueOf(init(message)));

    }

    public static void programInfo() {
        String message = "This program takes in a number, for example 5321 and then prints a pyramid as such: \n\n" + 
                         "5321\n532\n53\n5\n";

        System.out.println(message);
    }

    public static int init(String msg) {
        System.out.println(msg); //print input message
        
        //---- SETUP ----
        int length = 0;
        Scanner sc = new Scanner(System.in);
        //---------------
        System.out.print("input: ");
        //handle invalid inputs
        try {
            length = sc.nextInt();    //convert negative values to positive. 
        } catch (Exception e) {
            length = init("invalid input, please enter a number");
        }
        //--------------------

        sc.close(); //terrible java gc
        return length;
    }

    public static void renderPyramid(String number) {
        int height = number.length();
        System.out.println("-------------");
        for (int i = 0; i < height; i++) {
            System.out.println(number);
            number = number.substring(0, number.length()-1);
            if(number.equals("-")) break;
        }
    }

}
