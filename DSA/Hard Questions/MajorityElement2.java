import java.util.*;

public class MajorityElement2 {
    public static List<Integer> majorityElements(int a[]) {
        // 1. Brute force : TC =O(n^2), Sc = O{2} => O(1)
        // List<Integer> result = new ArrayList<>();
        // int n = a.length;

        // for (int i = 0; i < n; i++) {
        //     if (result.contains(a[i])) continue;

        //     int cnt = 0;
        //     for (int j = 0; j < n; j++) {
        //         if (a[j] == a[i]) {
        //             cnt++;
        //         }
        //     }

        //     if (cnt > n / 3) {
        //         result.add(a[i]);
        //     }

        //     if (result.size() == 2)
        //         break;
        // }
        // return result;
        

        // 2. Better Sol : Hashing : O(N * logN), where N is the size of the given array. For using a map data structure, where insertion in the map takes logN time, and we are doing it for N elements. So, it results in the first term O(N * logN). On using unordered_map instead, the first term will be O(N) for the best and average case, and for the worst case, it will be O(N^2). Space Complexity: O(N) for using a map data structure.
        
        // List<Integer> result = new ArrayList<>();
        // HashMap<Integer,Integer> ans = new HashMap<>();
        // int n = a.length;
        // int minimum = n / 3 + 1;

        // for(int i=0;i<n;i++) {
        //     ans.put(a[i], ans.getOrDefault(a[i], 0) + 1); // If a[i] exists in map → get its value, If not → take default 0 and then add 1 (increase frequency)

        //     if(ans.get(a[i]) == minimum) {
        //         result.add(a[i]);
        //     }
        // }
        // return result;

        // 3. Optimal sol : Moore's Voting Algorithm (cancellation logic)
        // Tc = O(2N) = O(N) - where N is the size of the input array. We traverse the array twice: once to find potential candidates and once to validate them. SC = O(1)
        int n = a.length;
        int cnt1 = 0, cnt2 = 0;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;

        for(int i=0;i<n;i++) {
            if(cnt1==0 && a[i] != el2) { // bcoz el1 and el2 are unique integers that appears > n/3 times
                cnt1 = 1;
                el1 = a[i]; 
            }
            else if(cnt2 == 0 && a[i] != el1) { // bcoz el1 and el2 are unique integers that appears > n/3 times
                cnt2 = 1;
                el2 = a[i]; 
            }

            else if(el1 == a[i]) cnt1++;
            else if(el2 == a[i]) cnt2++;

            else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0; cnt2 = 0; 
        for (int i = 0; i < n; i++) {
            if (a[i] == el1) cnt1++; 
            if (a[i] == el2) cnt2++;
        }

        int mini = n / 3 + 1;
        List<Integer> result = new ArrayList<>(); 
        if (cnt1 >= mini) result.add(el1);
        if (cnt2 >= mini && el1 != el2) result.add(el2);

        return result;
    }

    public static void main(String[] args) {
        int a[] = {1,1,1,3,3,2,2,2};
        System.out.println("The majority elements are : "+ majorityElements(a));
    }
}