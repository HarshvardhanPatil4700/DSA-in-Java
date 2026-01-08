import java.util.Scanner;

public class PracticeQuestionsSection13 {
    public static void main(String[] args) {
        // 1.
        Scanner s = new Scanner(System.in);
        System.out.print("Enter first number : ");
        int a = s.nextInt();
        System.out.print("Enter second number : ");
        int b = s.nextInt();
        System.out.print("Enter third number : ");
        int c = s.nextInt();
        System.out.println("The average of three numbers is : " + average(a, b, c));

        // 2.
        System.out.print("Enter a number : ");
        int n = s.nextInt();
        if(isEven(n)){
            System.out.println(n + " is even number");
        } else{
            System.out.println(n + " is odd number");
        }

        // 3.
        System.out.print("Enter a number to check if it is Palindrome : ");
        int palin = s.nextInt();
        if(isPalindrome(palin)){
            System.out.println("Number " + palin + " is a palindrome");
        } else{
            System.out.println("Number " + palin + " is Not a palindrome");
        }

        // 5.
        System.out.print("Enter a Number : ");
        int num1 = s.nextInt();
        System.out.println("Sum of digits of " + num1 + " is = " + sumDigits(num1));    
    }
    // 1.
    public static double average(int a,int b,int c){
        double avg = (a+b+c) / 3;
        return avg;
    }

    // 2.
    public static boolean isEven(int n){ 
        if( n % 2 == 0){
            return true;
        } else {
            return false;
        }
    }

    // 3. 
    public static boolean isPalindrome(int n1){
        int palin = n1;
        int rev =0;

        while(palin != 0){
            // logic to reverse a number:
            int remainder = palin % 10;  // getting last digit
            rev = rev * 10 + remainder;  // append digit in 'rev' number
            palin = palin / 10;  // removing last digit
        }
        if(n1 == rev){
            return true;
        }
        return false;
    }

    // 5.
    public static int sumDigits(int num){    
        int sumOfDigits = 0;
        while (num > 0){
            int lastDigit = num % 10;
            sumOfDigits += lastDigit;
            num /= 10;
        }
        return sumOfDigits;
    }
}
