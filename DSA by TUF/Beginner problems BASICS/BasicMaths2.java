import java.util.Arrays;

public class BasicMaths2 {
    // Count of even and odd digits in a number:
    public static void countOfEvenAndOddNumbers(int n) {
        int evenC = 0, oddC = 0;
        while(n>0) {
            int digit = n % 10;
            if(digit % 2 == 0) {
                evenC++;
            } else {
                oddC++;
            }
            n = n / 10;
        }
        // return new int[]{evenC,oddC};
        System.out.println("Even Count: " + evenC + "\nOdd Count: " + oddC);
    }

    // Largest digit in a number
    public static int largestDigitOfNumber(int n) {
        int largestDigit = Integer.MIN_VALUE;
        while(n>0) {
            int currDigit = n % 10;
            largestDigit = Math.max(largestDigit, currDigit);
            n = n / 10;
        }
        return largestDigit;
    }

    // Check for perfect number
    public static boolean isPerfectNumber(int n) {
        // Approach 1 : N iterations
        // if(n<=1) return false;
        // int sum = 0;
        // for(int i=1;i<n;i++) {
        //     if(n%i == 0) {
        //         sum = sum + i;
        //     }
        // }
        // return sum == n;

        // Approach 2 : N/2 iterations
        if(n<=1) return false;
        int sum = 1;
        for(int i = 2; i <= n/i; i++) {
            if(n % i == 0) {
                sum = sum + i;

                if(i != (n/i)) {
                    sum = sum + (n/i);
                }
            }
        }
        return sum == n;
    }

    // Count of Prime nos till n
    public static int countOfPrimesTillN(int n) {
        // 1. Brute force: TC = O(n^2), SC = O(1)
        // int cntOfPrimes = 0;
        // for(int i = 2; i < n; i++) {
        //     int factors = 0;
        //     for(int j = 1; j <= i; j++) {
        //         if(i%j == 0) {
        //             factors++;
        //         } 
        //     }
        //     if(factors == 2) {
        //         cntOfPrimes++;
        //     }
        // }
        // return cntOfPrimes;

        // 2. Optimal sol: Sieve of Eratosthenes
        if (n <= 2) return 0;
        int[] arr = new int[n + 1];
        // Initially assume all numbers are prime
        Arrays.fill(arr, 1);

        // 0 and 1 are not prime numbers
        arr[0] = 0;
        arr[1] = 0;

        // Iterate up to sqrt(n)
        for (int i = 2; i * i <= n; i++) {
            // If i is prime, mark all its multiples as non-prime
            if (arr[i] == 1) {
                // Start from i*i because smaller multiples are already marked
                for (int j = i * i; j <= n; j += i) {
                    arr[j] = 0; // Mark the multiple as non-prime
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) { // Count all numbers that are still marked as prime i.e 1
            if (arr[i] == 1) {
                count++;
            }
        }
        return count;
    }
    
    // Leetcode - 1979. Find Greatest Common Divisor of Array: Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums. The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
    public static int findGCD(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }

        // Euclidean Algorithm
        while (min > 0) {
            int rem = max % min;
            max = min;
            min = rem;
        }
        return max;
    }

    // LCM of 2 nos:
    public static int lcm(int a, int b) {
        // 1. Brute force:
        // int max = Math.max(a, b);
        // for(int i = max; ; i++) {
        //     if(i%a == 0 && i%b == 0) {
        //         return i;
        //     }
        // }

        // Optimal sol: LCM(a,b) = a*b / GCD(a,b)
        // return (a*b)/(gdc(a, b));
        return (a / gdc(a, b)) * b; // to avoid integer overflow
    }
    private static int gdc(int a, int b) {
        while(a>0 && b>0) {
            if(a>b) a = a % b;
            else b = b % a;
        }
        return a == 0? b : a;
    }

    public static void main(String[] args) {
        int num = 2335453;
        countOfEvenAndOddNumbers(num);
        int nums = 21937901;
        System.out.println(largestDigitOfNumber(nums));
        System.out.println(isPerfectNumber(28));
        System.out.println(countOfPrimesTillN(10));
        int[] arr = {2,5,6,9,10};
        System.out.println(findGCD(arr));
        System.out.println(lcm(4, 6));
    }
}
