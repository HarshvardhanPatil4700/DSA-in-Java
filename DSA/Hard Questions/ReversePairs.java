public class ReversePairs {
    public static int reversePairsInArray(int[] arr) {
        // 1. Brute force : TC = O(n^2), SC = O(1)
        int n = arr.length;
        int cnt = 0;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                if(arr[i] > 2 * arr[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] nums = {40,25,19,12,9,6,2};
        int reversePairsCount = reversePairsInArray(nums);
        System.out.println("No. of reverse pairs = " + reversePairsCount);
    }
}