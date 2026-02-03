import java.util.Scanner;

class Recursion{
    // 1.Sum of first n natural numbers : TC = O(N), SC = O(N)
    // 1) Parameterized - 
    public void sum(int n, int sum) {
        if(n<1){
            System.out.println(sum);
            return;
        }
        sum(n-1,sum+n); // add the current num to sum and call to sum(n-1) with sum = sum + n
    }

    // 2) Functional - 
    public int sum1(int n) {
        if (n < 1) {
            return 0;
        }
        return n + sum1(n - 1);
    }

    // 2. Factorial of a number : TC = O(N), SC = O(N) 
    public int fact(int n) {
        if(n == 0 || n==1) 
            return 1;
        return n * fact(n-1);
    }

    // 3. Reverse an array : Without recursion It can be done by swapping, loop
    // 1. Two pointers -
    public void reverseArr(int[] a, int l, int r) {
        if (l >= r)
            return;

        // swapping :
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;

        reverseArr(a, l + 1, r - 1);
    }

    // 2. Single pointer - 
    public void reverseArr1(int[] a, int i) {
        int n = a.length;

        if (i >= (n / 2))
            return;

        int temp = a[i];
        a[i] = a[n - i - 1];
        a[n - i - 1] = temp;

        reverseArr1(a, i + 1);
    }

    // 4. Check if String is Palindrome or not :
    // public boolean isPalindrome(String[] s, int i) {
    //     int n = s.length;

    //     if (i >= n / 2)
    //         return true;

    //     if (!s[i].equals(s[n - i - 1]))   
    //         return false;

    //     return isPalindrome(s, i + 1);
    // }
    public boolean isPalindrome(String s, int i) {
        int n = s.length();
        if (i >= n / 2)
            return true;
        if (s.charAt(i) != s.charAt(n - i - 1))
            return false;
        return isPalindrome(s, i + 1);
    }

    // 5. Fibonacci Number :
    public int fibonacci(int n) {
        if(n <= 1)
            return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}

public class RecursionProblems {
    public static void main(String[] args) {
        Recursion r = new Recursion();   // CHANGED: class name updated
        Scanner s = new Scanner(System.in);

        // 1. Sum (Parameterized) -
        System.out.print("Enter a number : ");
        int n = s.nextInt();
        System.out.print("Sum of first " + n + " natural numbers is = ");
        r.sum(n, 0);

        // 1. Sum (Functional) - 
        System.out.print("\nEnter a number : ");
        int n1 = s.nextInt();
        System.out.println("Sum of first " + n1 + " natural numbers is = " + r.sum1(n1));

        // 2. Factorial
        System.out.println("Factorial of 5 is = " + r.fact(5)); // ADDED text for clarity

        // 3. Reverse array
        int[] a = {1, 2, 3, 4, 5, 6};
        r.reverseArr(a, 0, a.length - 1);

        // ADDED: printing reversed array
        System.out.print("Reversed array: ");
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();

        // 3. Reverse array using Single pointer -
        int[] b = {2,4,6,8,10};
        r.reverseArr1(b, 0);

        System.out.print("Reversed array: ");
        for (int x : b) {
            System.out.print(x + " ");
        }
        System.out.println();

        // 4. Check if String is Palindrome or not :
        String name = "racecar";
        System.out.println(r.isPalindrome(name, 0));

        // 5. Fibonacci Number :
        System.out.println(r.fibonacci(5));
    }
}
