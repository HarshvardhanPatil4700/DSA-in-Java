public class FindNthRootOfNumber {
    public static int findNthRoot(int m,int n) {
        // 1. Brute force : TC = O(log n)
        // for(int i=0;i<m;i++) {
        //     if(Math.pow(n, i) == m) {
        //         return i;
        //     } else if(Math.pow(n, i) > m) {
        //         break;
        //     }
        // }
        // return -1;

        // 2. Binary search - TC = O(log n)
        int low = 1, high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long value = 1;
            for (int i = 0; i < n; i++) {
                value *= mid;
                if (value > m) break;
            }

            if (value == m) {
                return mid;
            } else if (value > m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int res = findNthRoot(27, 3);
        System.out.println(res);
    }
}
