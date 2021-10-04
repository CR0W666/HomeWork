import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

class ValidaceBankovnichUctu {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String accountNumber = input(sc, "enter your bank account number: ");
        System.out.println(checkAccountNumber(accountNumber));

        sc.close();
    }

    public static String input(Scanner sc, String msg) {
        System.out.print(msg); //print input message
        //---- SETUP ----
        String value = "";
        //---------------

        //handle invalid inputs
        try {
            value = sc.nextLine(); 
            value = removeBankCode(value);
            int maxLen = (value.contains("-")) ? 16 : 10;
            if(value.length() > maxLen || !value.matches("[-0-9]+")) throw new InputMismatchException();
        } catch (Exception e) {
            //sc.next(); //uses up invalid token to avoid infinite loop | DEPRECATED
            return input(sc, "invalid input, please enter a number with maximum of 10 digits\n input: ");
        }
        //--------------------

       
        return value;
    }

    public static String removeBankCode(String accountNumber) {
        return (accountNumber.contains("/")) ? accountNumber.split("/")[0] : accountNumber;
    }

    public static boolean validate(String accountNumberString) {
        StringBuffer sbuff = new StringBuffer(accountNumberString);
        accountNumberString = sbuff.reverse().toString();
        final int[] weights = {1, 2, 4, 8, 5, 10, 9, 7, 3, 6};
        int numberLength = accountNumberString.length();
        int sum = 0;
        for (int i = 0; i < numberLength; i++) {
            int current = Character.getNumericValue(accountNumberString.charAt(i));
            int multiplied = current * weights[i];
            sum += multiplied;
        }
        
        return sum%11 == 0;
    }

    public static boolean checkAccountNumber(String accountNumber) {
        ArrayList<Boolean> results = new ArrayList<>();

        if(accountNumber.indexOf("-") != 1) {
            
            String[] parts = accountNumber.split("-");
            for (String part : parts) {
                results.add(validate(part));
            }

        } else {
            results.add(validate(accountNumber));
        }

        return results.stream().allMatch(result -> result == true);
       
        

    }
}