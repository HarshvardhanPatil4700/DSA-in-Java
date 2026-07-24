import java.util.*;

public class TripletSumSmaller {
    public static int tripletSumSmaller(int []arr,int target) {
        int n = arr.length;
        Arrays.sort(arr);
        int ans = 0;
        
        for(int i=0;i<n-2;i++) {
            int left = i+1, right = n-1;
            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];
                if(sum >= target) {
                    right--;
                }
                else {
                    ans = ans + (right - left); // as the array is sorted, so all teh nos. btwn left and right-1 can make pair i.e their sum is less than target
                    left++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int res = tripletSumSmaller(nums, 14);
        System.out.println(res);
    }
}
