// Java provides Math.sqrt(n) method to find the sqrt of a number n
public class FindingSqrtOfNumber {
    public static int sqrtOfNumber(int n) {
        // 1.Brute force - Linear search - TC = O(n)
        // int ans = 1;
        // for(int i=0;i<=n;i++) {
        //     if(i * i <= n) {
        //         ans = i;
        //     }else {
        //         break;
        //     }
        // }
        // return ans;

        // 2. Binary search - Tc = O(log n), sc = O(1)
        if( n < 2) return n; // Handle the small numbers directly

        int low = 1, high = n;
        int ans = 0;
        while(low <= high) {
            int mid = (low + high)/2;

            if(mid * mid <= n) { // mid maybe the answer so eliminate the left half and search in right half
                ans = mid;
                low = mid + 1;
            }
            else{ // eliminate the right half and search in left half
                high = mid-1;
            }
        }
        return ans; // (or)  return high;
    }

    public static void main(String[] args) {
        int n = 25;
        System.out.println(sqrtOfNumber(n));
        int x = 1;
        System.out.println(sqrtOfNumber(x));
        int y = 40;
        System.out.println(sqrtOfNumber(y)); // returns the floor value

    }
}
/*
The naive method tries every number, which is slow when n is large. But our possible answer space (from 1 to n) is sorted, meaning if a certain number squared is less than or equal to n, then all smaller numbers will also work. This allows us to apply Binary Search on the answer space to efficiently find the largest number whose square is less than or equal to n.
1.First, note that the answer lies between 1 and the given number n.
2.Set the search range with the smallest value as 1 and the largest value as n.
3.Use binary search within this range to test possible numbers.
4.At each step, take the middle number and check if its square is less than or equal to n.
5.If it is, record this number as a candidate and move right to check for a larger number.
6.If the square is greater than n, move left to check smaller numbers.
7.Continue this process until the range closes, and the largest recorded number will be the square root.
 */