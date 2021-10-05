import java.util.Scanner;

class test {
    public static void main(String[] args) {
        divideBySeven();
        printPrimeHundred(100);
    } 

    public static void divideBySeven() {
        int input;
        Scanner sc = new Scanner(System.in);
        input = sc.nextInt();
        if(input % 7 == 0) {
            System.out.println("je delitelne 7");
        } else {
            System.out.println("neni delitelne 7");
        }
    }

    public static void printPrimeHundred(int nin) {
        String  primeNumbers = "";
        int num = 0;
        int n = nin;
        for (int i = 1; i <= n; i++) { 		 		  
           int counter=0; 		  
            for(num =i; num>=1; num--) {
                if(i%num==0) {
                counter = counter + 1;
                }
            }    
            if (counter == 2) {
            
            primeNumbers += i + " ";
            
            }	
        }	
        System.out.println("Prime numbers from 1 to " + nin + " are :");
        System.out.println(primeNumbers);
    }
}
