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
        //     int lastDigit = n % 10;  // to get last digit of a number (NOT REQUIRED)
        //     n /= 10; // to get number after every extraction of last digit
        //     counter++;
        // }
        // return counter;

        // Approach 2 : TC = 1og10(N)
        // Logic: The no. of times we divide a number by 10 is the count of digits. The logarithm base 10 of a number tells us the power of 10 associated with that number. So, n = n/10 can be written as n = log10(n) + 1
        if (n == 0) return 1;
        int counter = (int)(Math.log10(n) + 1);
        return counter;
    }

    // 2. Reverse of a number :
    public int reverseNumber(int n) {
        int sign = (n < 0) ? -1 : 1;
        n = Math.abs(n);

        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + (n % 10); // rev = (rev * 10) + lastDigit;
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
    // 5. Print all divisors(Factors) : TC = O(N)
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
                if (i != (n / i)) {
                    factors.add(n / i);
                }
            }
        }
        Collections.sort(factors); // tc = O(no.of factors * log(no.of factors))
        System.out.println(factors);// tc = O(no. of factors)
    }

    // 6. Prime number check : A no. that has exactly 2 factors: 1 and itself is a PRIME Number
    public boolean primeNumCheck(int n) {
        int cntr = 0;
        // for(int i=0;i<=n;i++){ TC = O(N)
        //     if(n%i ==0) cntr++;
        // }

        for(int i=1; i<=Math.sqrt(n);i++){ // TC = O(sqrt(N))
            if(n%i==0){
                cntr++;
                if((n/i) != i){
                    cntr++;
                }
            }
        }

        // if(cntr == 2) 
        //     return true;
        // else
        //     return false;
        // (OR) 
        // return cntr == 2 ? true : false; 
        // (OR)
        return cntr == 2; 
    }
    
    // 7. GCD / HCF :
    public int gcd(int n1,int n2){ 
        // Approach 1:
        // int gcd = 1; // 1 is the smallest possible GCD of any two integers.
        // for(int i = 1; i <= Math.min(n1,n2);i++){ // TC = O(min(n1,n2))
        //     if(n1%i == 0 && n2%i == 0){
        //         gcd = i;
        //     }
        // }
        // return gcd;

        // Approach 2: // TC = O(min(n1,n2)) but time complexity is improved as it takes less steps
        // for(int i = Math.min(n1, n2); i >= 1; i--) { 
        //     if(n1%i == 0 && n2%i == 0){
        //         gcd = i;
        //         break;
        //     }
        // }
        // return gcd;

        // Approach 3: Using euclidean algorithm : TC = O(log(min(n1,n2)))
        while(n1 > 0 && n2 > 0) {
            if(n1 > n2) n1 = n1 % n2;
            else n2 = n2 % n1;
        }
        return n1 == 0 ? n2 : n1; // if n1=0 return n2(gcd) and if n2=0 then return n1(gcd)
    }

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

        // 6. Prime number check :
        System.out.print("Enter a number to check if it is prime number : ");
        int num1 = s.nextInt();
        System.out.println(b.primeNumCheck(num1));

        // 7. GCD / HCF :
        System.out.println(b.gcd(52, 10));
    }
}