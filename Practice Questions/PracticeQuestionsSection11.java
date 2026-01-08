import java.util.Scanner;
public class PracticeQuestionsSection11 {
    public static void main(String[] args) {
        // 1.
        for(int i =0; i<5 ; i++) {
            System.out.println("Hello");
            i+=2;
        } // hello is printed 2 times
        
        // 2.
        Scanner s = new Scanner(System.in);
        int number;
        int choice;
        int evenSum = 0;
        int oddSum = 0;
        do { 
            System.out.print("Enter the number ");
            number = s.nextInt();

            if(number % 2 == 0) {
                evenSum += number;
            } else {
                oddSum += number;
            }

            System.out.println("Do you want to continue? press 1 for YES or press 0 for NO");
            choice = s.nextInt();
        } while (choice == 1);

        System.out.println("Sum of even numbers : " + evenSum);
        System.out.println("Sum of odd numbers : " + oddSum);

        // 3. Factorial of a number
        System.out.print("Enter a positive number whose factorial is needed : ");
        int num = s.nextInt();
        int fact = 1;
        for(int i = 1; i<= num ; i++) {
            if (num == 0 || num == 1) {
                fact = 1;
            } else {
                fact *= i; 
            }
        }
        System.out.println("Factorial of " + num + " is : " + fact);

        // 4. Multiplication table of n :
        System.out.print("Enter the number whose multiplication table is needed : ");
        int t = s.nextInt();
        for(int i=1; i<=10; i++){
            System.out.println(t + " X " + i + " = " + t*i);
        }
    }
}
