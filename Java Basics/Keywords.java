import java.util.Scanner;
public class Keywords {
    public static void main(String[] args) {
        // 1. break
        // for(int i=1; i<=5; i++){
        //     if(i == 3){
        //         break;
        //     }
        //     System.out.println(i);
        // }
        // System.out.println("Out of loop :)");

        // keep entering numbers till user enters a multiple of 10
        Scanner s = new Scanner(System.in);
        // System.out.print("Enter numbers: ");
        // do { 
        //     int n = s.nextInt();
        //     if (n % 10 == 0) break;
        //     System.out.println(n);
        // } while (true);
        // System.out.println("Sorry! you entered a multiple of 10");

        // // 2. Continue
        // for(int i = 1; i<=5; i++) {
        //     if (i == 3) {
        //         continue;
        //     }
        //     System.out.println(i);
        // }

        // // Display all the numbers entered by user except multiples of 10        
        // do { 
        //     System.out.print("Enter numbers: ");
        //     int n1 = s.nextInt();
        //     if (n1 % 10 == 0) continue;
        //     System.out.println("number was :" + n1);            
        // } while (true);

        // Check if a number is a prime or not :
        System.out.print("Enter a number to check if it is prime or not : ");
        int  n = s.nextInt();
        boolean isPrime = true;
        
        if(n == 2) {
            System.out.println(n + " is a prime number");
        }
        else{
            for (int i=2; i<=Math.sqrt(n);i++){
            if (n % i == 0){
                isPrime = false;
            }
        }

            if (isPrime == true) System.out.println(n + " is a prime number");
            else System.out.println(n + " is Not a prime number");
        }
    }
}