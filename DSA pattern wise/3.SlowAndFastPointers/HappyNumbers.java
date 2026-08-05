// A happy number is a number defined by the following process:
// Starting with any positive integer, replace the number by the sum of the squares of its digits.
// Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
// Those numbers for which this process ends in 1 are happy.
// Return true if n is a happy number, and false if not.
// Eg - n = 19 => 1^2 + 9^2 = 1+81 = 82
//      n = 82 => 64 + 4 = 68
//      n = 68 => 36 + 64 = 100
//      n = 100 => 1 + 0 + 0 = 1 (therefore, 19 is a HAPPY NUMBER)

public class HappyNumbers {
    // Slow and Fast Pointer (Floyd's Cycle Detection) - Tc = O(log n), SC = O(1)
    private static int sumOfDigtis(int n) {
        int sum = 0;
        while(n > 0) {
            int d = n % 10;
            n = n / 10;
            sum = sum + d * d;
        }
        return sum;
    }
    public static boolean isHappy(int n) {
        int slow = n, fast = n;

        while(fast != 1) {
            slow = sumOfDigtis(slow);
            fast = sumOfDigtis(fast);
            fast = sumOfDigtis(fast);

            if(slow == fast && slow != 1) {
                return false;
            }
        }
        // After while loop, the fast = 1
        return true;
    }

    public static void main(String[] args) {
        int num = 19;
        System.out.println(isHappy(num));
        System.out.println(isHappy(2));
    }
}
