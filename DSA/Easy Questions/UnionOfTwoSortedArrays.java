// The union of two (or more) sets contains all elements that are in any of the sets without any duplicates.

// import java.util.HashSet;
// import java.util.Set;

import java.util.ArrayList;
import java.util.List;

public class UnionOfTwoSortedArrays {
    public static  List<Integer> uts(int a[],int b[]) {
        // 1. Brute force : TC = O(n1 logn + n2 logn) + O(n1+n2), SC = O(n1+n2) + O(n1+n2)
        // Set<Integer> unionSet = new HashSet<>();
        // for(int i=0;i<a.length;i++) { // tc = O(N1 LogN)
        //     unionSet.add(a[i]);
        // }
        // for(int i=0;i<b.length;i++) { // tc = O(N2 LogN)
        //     unionSet.add(b[i]);
        // }

        // for(int i : unionSet) { // tc = O(N1+N2)
        //     System.out.print(i + " ");
        // }

        // 2. Optimal approach : 2 pointer approach. TC = O(N1 + N2), SC = O(N1 + N2) {to return the answer}
        int n1 = a.length;
        int n2 = b.length;

        int i = 0;
        int j = 0;
        List<Integer> unions = new ArrayList<>();
        while(i < n1 && j < n2) {
            if(a[i] <= b[j]){
                // if(unions.size() == 0 || !unions.contains(a[i])) {
                if(unions.isEmpty() || !unions.contains(a[i])) {
                    unions.add(a[i]);
                }
                i++;
            }
            else {
                if(unions.isEmpty() || !unions.contains(b[j])) {
                    unions.add(b[j]);
                }
                j++;
            }
        }

        while(j < n2) { // when i pointer completes iterations in the array but j still has elements to iterate
            if(unions.isEmpty() || !unions.contains(b[j])) {
                unions.add(b[j]);
            }
            j++;
        }

        while(i < n1) { // when j pointer completes iterations in the array but i still has elements to iterate
            if(unions.isEmpty() || !unions.contains(a[i])) {
                unions.add(a[i]);
            }
            i++;
        }

        return unions;
    }

    public static void main(String[] args) {
        int a[] = {1,1,2,3,4,5};
        int b[] = {2,3,4,4,5,6,7};
        System.out.println(uts(a, b));
    }
}