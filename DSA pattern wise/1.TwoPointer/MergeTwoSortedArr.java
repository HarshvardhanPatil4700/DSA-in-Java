public class MergeTwoSortedArr {
    public static int[] merge(int []arr1, int []arr2) {
        // 2 pointer approach - TC = O(n+m), SC = O(n+m)
        int n = arr1.length;
        int m = arr2.length;
        int res[] = new int[n+m];
        int id = 0;
        int left = 0, right = 0;

        while(left < n && right < m) {
            if(arr1[left] <= arr2[right]) {
                res[id] = arr1[left];
                id++;
                left++;
            }
            else {
                res[id] = arr2[right];
                id++;
                right++;
            }
        }
        while(left < n) {
            res[id] = arr1[left];
            id++;
            left++;
        }
        while(right < m) {
            res[id] = arr2[right];
            id++;
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        int []oddNums = {1,3,5,7,9};
        int []evenNums = {2,4,6,8,10,12};
        int []ans = merge(oddNums, evenNums);
        for(int n : ans) {
            System.out.print(n + " ");
        }
    }
}
