
public class FindMissingNumber {
    public static int missingNum(int a[]) {
        // 1. Brute force : TC = O(N * n), SC = O(1)
        // int n = a.length;
        // int N = n + 1; // total numbers should be 1 to N

        // for (int i = 1; i <= N; i++) {
        //     int flag = 0; // reset flag for each number we check
        //     for (int j = 0; j < n; j++) {
        //         if (a[j] == i) {
        //             flag = 1;
        //             break;
        //         }
        //     }
        //     if (flag == 0) {
        //         return i;
        //     }
        // }
        // return -1; 

        // 2. Better : Hashing - Tc = O(N) + O(n), SC = (N)
        // int n = a.length; // actual array size
        // int N = n + 1; // total range is 1..N
        // int hash[] = new int[N + 1];

        // for (int i = 0; i < n; i++) { // Traverse in the actual array and set the hash as 1 for the numbers present as 1
        //     hash[a[i]] = 1;
        // }

        // for (int i = 1; i <= N; i++) { // Check in hash array : If hash = 0 means that number is missing
        //     if (hash[i] == 0) {
        //         return i;
        //     }
        // }

        // return -1;

        // 3. Optimal Solution 1 : using sum of n natural nos - TC = O(n), SC = O(1)
        // int n = a.length; // actual array size
        // int N = n + 1; // total range is 1..N
        // int expectS = (N * (N + 1)) / 2;
        // int actualS = 0;
        // for(int i=0;i<n;i++) {
        //     actualS = actualS + a[i];
        // }
        // // return expectS - actualS; when array is passed with no missing nums as : 1,2,3,4,5 then it returns 6 so :
        
        // int missingNum = expectS - actualS;
        // return (missingNum >= 1 && missingNum <= N) ? missingNum : -1; // if missingNum is in the range return it else return -1

        // Optimal Solution 2 : using XOR(^) operation - a^a = 0 when we xor with same number result is 0 - TC = O(N), SC = O(1)
        int n = a.length; // actual array size
        int N = n + 1; // total range is 1..N
        int xor1 = 0;
        int xor2 = 0;
        // for (int i = 1; i <= N; i++) {
        //     xor1 = xor1 ^ i;         // XOR of 1 to N
        // }

        for (int i = 0; i < n; i++) {
            xor2 = xor2 ^ a[i];      // XOR of all array elements
            xor1 = xor1 ^ (i+1);     // XOR of 1 to N-1
        }
        xor1 = xor1 ^ N;             // XOR of N-1 to N (i.e from 1 to N)

        // return xor1 ^ xor2; // missing number
        int missingNum = xor1 ^ xor2; // missing number
        return (missingNum >= 1 && missingNum <= n) ? missingNum : -1;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 5};
        int res = missingNum(a);
        if (res != -1) {
            System.out.print("Missing number = " + res);
        } else {
            System.out.println("No numbers are missing");
        }
    }
}