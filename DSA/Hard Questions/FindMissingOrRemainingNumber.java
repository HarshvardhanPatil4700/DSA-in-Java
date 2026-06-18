public class FindMissingOrRemainingNumber {
    public static int[] getMissingOrRepeatingNumber(int[] arr) {
        // 1. Brute force approach : TC = O(n^2), SC = O(1)
        // int n = arr.length;
        // int repeating = -1, missing = -1;
        // for(int i = 1; i <= n; i++) { // searches for numbers 1 to n 
        //     int cnt = 0;
        //     for(int j=0;j<n;j++) {
        //         if(arr[j] == i) {
        //             cnt++;
        //         }
        //     }
        //     if(cnt == 2) 
        //         repeating = i;
        //     else if (cnt == 0)
        //         missing = i;

        //     if(repeating != -1 && missing != -1) // if both are found stop early
        //         break;
        // }

        // return new int[]{repeating, missing};

        // 2. Better approach : Hashing - TC = O(n+n) 2 for loops = O(2n) = O(n), SC = O(n) - for hash array
        // int n = arr.length;
        // int[] hash = new int[n+1]; // n+1 because hash starts from 0. Hence, to store 1 to 5 numbers we need hash of size 6 i.e n+1

        // for(int i=0;i<n;i++) {
        //     hash[arr[i]]++;
        // }

        // int repeating = -1, missing = -1;
        // for(int i = 1; i <= n; i++) {
        //     if(hash[i] == 2) 
        //         repeating = i;
        //     else if(hash[i] == 0)
        //         missing = i;

        //     if (repeating != -1 && missing != -1) {
        //         break;
        //     }
        // }
        // return new int[]{repeating,missing};

        // 3. Optimal approach 1 : basic mathematics - 
        long n = arr.length;
        long Sn = (n * (n+1)) / 2; // sum of nos 1 to n
        long S2n = (n * (n+1) * (2*n+1)) / 6; // sum of squares of nos 1 to n
        long S = 0, S2 = 0;
        for(int i=0;i<n;i++) {
            S += arr[i];
            S2 += (long)arr[i] * (long)arr[i];
        }

        long val1 = S - Sn; // x - y
        long val2 = S2 - S2n; // x^2 - y^2 = (x+y)*(x-y)
        val2 = val2 / val1; // x + y
        long x = (val1 + val2) / 2; // repeating number
        long y = x - val1; // missing number

        return new int[]{(int)x, (int)y};
    }
    public static void main(String[] args) {
        // 1. Brute force approach :
        int[] nums = {3, 1, 2, 5, 4, 6, 7, 5};
        int[] result = getMissingOrRepeatingNumber(nums);
        System.out.println("The repeating number is : " + result[0]);
        System.out.println("The missing number is : " + result[1]);
    }
}
