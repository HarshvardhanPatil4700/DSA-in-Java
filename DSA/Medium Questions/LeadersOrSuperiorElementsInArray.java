// Leaders are the elements in array for which everything on the right side of it should be smaller. Eg = [10,22,12,3,0,6] In this array leaders are (22,12,6)

import java.util.ArrayList;

public class LeadersOrSuperiorElementsInArray {
    public static int[] findLeader (int a[]) {
        // 1. Brute force : TC = O(N^2), SC = O(N) eg: in worst-case if array is [5,4,3,2,1]
        // int n = a.length;
        // ArrayList leaders = new ArrayList<>();
        // for(int i=0;i<n;i++) {
        //     boolean isLeader = true;
        //     for(int j=i+1;j<n;j++) {
        //         if(a[j] > a[i]) { // if any ele is greater than curr ele then it is not a Leader
        //             isLeader = false;
        //             break;
        //         }
        //     }

        //     if(isLeader == true) {
        //         leaders.add(a[i]);
        //     }
        // }

        // int[] result = new int[leaders.size()];
        // for(int i = 0; i < leaders.size(); i++) {
        //     result[i] = (int) leaders.get(i);
        // }

        // return result;

        // 2. Optimal sol : In brute force we compare leader with all elements rather we can start from right end and just compare with the maximum(largest) number only and if leader > maximum no. then verification for leader is true and we need not to check with all elements. TC = O(N), SC = O(1)
        ArrayList leaders = new ArrayList<>();
        int n = a.length;
        int maxi = Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--) {
            if(a[i] > maxi) {
                leaders.add(a[i]);
            }
            maxi = Math.max(maxi, a[i]);
        }

        int[] result = new int[leaders.size()];
        for(int i = 0; i < leaders.size(); i++) {
            result[i] = (int) leaders.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int a[] = {10,22,12,3,0,6};
        int answer[] = findLeader(a);
        for(int n : answer) {
            System.out.print(n + ", ");
        }
    }
}