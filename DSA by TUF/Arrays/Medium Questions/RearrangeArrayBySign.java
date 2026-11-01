// import java.util.ArrayList;

import java.util.ArrayList;

public class RearrangeArrayBySign { 
    public static int[] rearrangeArrBySign(int a[]) {
        // VARIETY 1 : When the no. of positives and negatives are equal
        // 1. Brute force : Tc = O(2n) + O(n) SC = O(n/2 + n/2) = O(n)
        // int n = a.length;
        // // Step 1: Store positives and negatives
        // ArrayList<Integer> pos = new ArrayList<>();
        // ArrayList<Integer> neg = new ArrayList<>();

        // for(int i = 0; i < n; i++) {
        //     if(a[i] >= 0) pos.add(a[i]);
        //     else neg.add(a[i]);
        // }

        // // // Step 2: Fill alternately
        // // int i = 0, p = 0, ne = 0;
        // // while(p < pos.size() && ne < neg.size()) {
        // //     a[i++] = pos.get(p++);
        // //     a[i++] = neg.get(ne++);
        // // }
        // // // Step 3: Add remaining elements
        // // while(p < pos.size()) {
        // //     a[i++] = pos.get(p++);
        // // }
        // // while(ne < neg.size()) {
        // //     a[i++] = neg.get(ne++);
        // // }

        // // Step 2: fill using 2*i and 2*i+1
        // // for(int i = 0; i < pos.size(); i++) {
        // for(int i = 0; i < n/2; i++) { // (n/2) bcoz the array contains n/2 pos nums and n/2 neg nums
        //     a[2 * i] = pos.get(i);       // even index. Hence, all positives on even indexes
        //     a[2 * i + 1] = neg.get(i);   // odd index. Hence, all negatives on odd indexes
        // }

        // return a;

        // Optimal soln : 
        int n = a.length;
        int[] ans = new int[n];

        int posIndex = 0; // even index
        int negIndex = 1; // odd index

        for(int i = 0; i < n; i++) {
            if(a[i] >= 0) { // checks if the number is positive or negative
                ans[posIndex] = a[i];
                posIndex += 2; // to fill all positives in even indexes
            } else {
                ans[negIndex] = a[i];
                negIndex += 2; // to fill all negatives in odd indexes
            }
        }

        return ans;
    }

    public static int[] rearrangeArrBySign1(int a[]) {
        // VARIETY 2 : when the no. of positives and negatives are not equal(no. of pos > no. of neg OR vice versa)
        // 1. Brute force :
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int n = a.length;
        for(int i = 0;i<n;i++) {
            if(a[i] > 0) {
                pos.add(a[i]);
            } else {
                neg.add(a[i]);
            }
        }

        if(pos.size() > neg.size()) {
            for(int i=0; i<neg.size();i++) {
                a[2*i] = pos.get(i);
                a[2*i+1] = neg.get(i);
            }

            int index = neg.size()*2;
            for(int i = neg.size();i<pos.size();i++) {
                a[index] = pos.get(i);
                index++;
            }
        } else {
            for(int i=0; i<neg.size();i++) {
                a[2*i] = pos.get(i);
                a[2*i+1] = neg.get(i);
            }

            int index = pos.size()*2;
            for(int i = pos.size();i<neg.size();i++) {
                a[index] = neg.get(i);
                index++;
            }
        }
        
        return a;
    }

    public static void main(String[] args) {
        // Variety 1
        int a[] = {1, 2, -3, -1, -2, 3};
        int res[] = rearrangeArrBySign(a);
        for(int num : res) {
            System.out.print(num + ", ");
        }
        System.out.println();

        // Variety 2
        int b[] = {-2,2,3,5,-1,-3,4,7,6};
        int result[] = rearrangeArrBySign1(b);
        for(int nums : result) {
            System.out.print(nums + ", ");
        }
    }
}

/* In this problem, usually N (length of arr) is even which contains N/2 +ve nos. and N/2 -ve nos. 
Variety 1 : Tc = O(n + n/2)
Sc = O(n)
Variety 2 : TC = O(n) + O(min(pos,neg)) + O(leftovers) = O(n) + O(n) = O(2n)
SC = O(n)
*/
