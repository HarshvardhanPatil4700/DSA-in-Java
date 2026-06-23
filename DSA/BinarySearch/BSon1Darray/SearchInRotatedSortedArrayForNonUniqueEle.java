// In this problem, we have to just return whether the target is present in the array or not (unlike the for unique ele problem where we return the index of target)

public class SearchInRotatedSortedArrayForNonUniqueEle {
    public static boolean searchInRoataredSortedArr(int[] arr,int target) {
        int n = arr.length;
        int low = 0, high = n-1;
        
        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] == target) {
                return true;
            }

            // Trim down the condition 
            if(arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low+1;
                high = high-1;
                continue;
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
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {6,7,1,2,3,4,4,5};
        boolean b1 = searchInRoataredSortedArr(nums, 1);
        System.out.println(b1);

        int[] num = {3,3,1,2,3,3,3,3};
        boolean b2 = searchInRoataredSortedArr(num, 2);
        System.out.println(b2);
    }
}