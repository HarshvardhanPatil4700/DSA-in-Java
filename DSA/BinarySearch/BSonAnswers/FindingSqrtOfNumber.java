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
