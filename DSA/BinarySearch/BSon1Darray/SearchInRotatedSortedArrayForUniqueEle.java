public class SearchInRotatedSortedArrayForUniqueEle {
    public static int searchInRotatedSortedArr(int[] arr,int target) {
        // 1. Linear search - TC = O(n)
        // int n = arr.length;
        // for(int i=0;i<n;i++) {
        //     if(arr[i] == target) {
        //         return i;
        //     }
        // }
        // return -1;

        // 2. Binary search - TC = O(log n)
        int n = arr.length;
        int low = 0, high = n-1;
        
        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] == target) {
                return mid;
            }
                
            // identify the sorted half i.e left / right:
            if(arr[low] <= arr[mid]) { // checks if left half is sorted
                if(arr[low] <= target && target <= arr[mid]) { 
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            else { // checks if right half is sorted
                if(arr[mid] <= target && target <= arr[high]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1; //target does not exist
    }
    public static void main(String[] args) {
        int[] nums = {7,8,9,1,2,3,4,5,6};
        System.out.println(searchInRotatedSortedArr(nums,1));
    }
}