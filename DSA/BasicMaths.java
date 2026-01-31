import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BasicMaths {
    // 1. Count Digits :
    public int countDigits(int n) {
        // Approach 1: TC = N
        // int counter = 0;
        // while(n > 0) {
        //     int lastDigit = n % 10; to get last digit of a number
        //     n /= 10; // to get number after every extraction of last digit
        //     counter++;
        // }
        // return counter;

        // Approach 2 : TC = 1og10(N)
        int counter = (int)(Math.log10(n) + 1);
        return counter;
    }

    // 2. Reverse of a number :
    public int reverseNumber(int n) {
        int sign = n < 0 ? -1 : 1;
        n = Math.abs(n);

        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n /= 10;
        }
        return rev * sign;
    }

    // 3. Check Palindrome of Number :
    public boolean checkPalindrome(int n) {
        int sign = n < 0 ? -1 : 1;
        n = Math.abs(n);
        
        int dup = n; // copy of n for checking palindrome
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n /= 10;
        }
        rev *= sign;
        
        // return (dup == rev) ? true : false;
        return dup == rev;
    }

    // 4. Armstrong numbers :
    public boolean armstrongNum(int n) {
        int sum = 0;
        int temp = n;
        while(n>0) {
            int ld = n%10;
            sum = sum + (ld*ld*ld);
            n /= 10;
        }
        return temp == sum;
    }
    // 5. Print all divisors : TC = O(N)
    public void printDivisors(int n) {
        // Approach 1:
        // for(int i = 0; i<=n;i++){ // divide by zero exception
        // for(int i = 1; i<=n;i++){
        //     if(n % i == 0) {
        //         System.out.print(i + " ");
        //     }
        // }

        // Approach 2 : TC = O(√n log n)
        List<Integer> factors = new ArrayList<>(); // to store the numbers for sorting
        for (int i = 1; i <= Math.sqrt(n); i++) { // tc = O((sqrt(n)))
            if (n % i == 0) {
                factors.add(i);
                if (i != n / i) {
                    factors.add(n / i);
                }
            }
        }
        Collections.sort(factors); // tc = O(no.of factors * log(no.of factors))
        System.out.println(factors);// tc = O(no. of factors)
    }

    // 6. Check for prime :
    

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // 1. Count Digits :
        BasicMaths b = new BasicMaths();
        System.out.print("Enter a number : ");
        // int a = s.nextInt();
        int num = b.countDigits(s.nextInt());
        System.out.println("Countdigits : " + num);

        // 2. Reverse of a number : 
        System.out.print("Enter a number : ");
        int reverseNumber = b.reverseNumber(s.nextInt());
        System.out.println("Rev num : " + reverseNumber);

        // 3. Check Palindrome of Number :
        System.out.print("Enter a number : ");
        boolean cp = b.checkPalindrome(s.nextInt());
        System.out.println(cp ? "Palindrome" : "Not a palindrome");   
        
        // 4. Armstrong numbers : 
        System.out.print("Enter a number : ");
        boolean an = b.armstrongNum(s.nextInt());
        System.out.println(an ? "Armstrong number" : "Not an Armstrong number");

        // 5. Print all divisors :
        System.out.print("Divisors of 36 : ");
        b.printDivisors(36);
    }
}