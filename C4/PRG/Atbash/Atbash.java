import java.util.Scanner;
public class Atbash {
    public static void main(String[] args) {
        System.out.println("encrypted: \t"+ encrypt(input("Enter text to encrypt:\n")));
        
    }

    public static String encrypt(String sentence) {
        String encrypted = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz"; 

        for (int i = 0; i < sentence.length(); i++) {
            Character element = sentence.charAt(i);
            //------ Remember if char was upper case ---------
            boolean isUpperCase = (Character.isUpperCase(element));
            element = Character.toLowerCase(element); //convert back to lower case
            //------------------------------------------------

            //characters outside of alphabet are left as is
            if(!alphabet.contains(Character.toString(element))) {encrypted += element; continue;};
            

            int reversedPos = alphabet.length() - alphabet.indexOf(Character.toString(element)) -1; //calculates index of encrypted char in alphabet          
            Character encryptedChar = alphabet.charAt(reversedPos);
            encrypted += (isUpperCase) ? Character.toUpperCase(encryptedChar) : encryptedChar;
        }

        return encrypted;
    }

    public static String input(String msg) {
        System.out.println(msg);
        System.out.print("input: \t\t");
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        sc.close();
        return sentence;
    }


}