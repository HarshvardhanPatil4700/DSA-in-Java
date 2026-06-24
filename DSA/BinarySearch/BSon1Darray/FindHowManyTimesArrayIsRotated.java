public class FindHowManyTimesArrayIsRotated {
    public static int noOfTimesArrayIsRotated(int[] arr) {
        int n = arr.length;
        int low = 0, high = n-1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[low] <= arr[high]) { // che half is sorted
                // ans = Math.min(ans, arr[low]);
                if(arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                break;
            }

            if(arr[low] <= arr[mid]) { // left half is sorted
                // ans = Math.min(ans, arr[low]); 
                if(arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                low = mid+1;
            }
            else {
                // ans = Math.min(ans,arr[mid]); 
                if(arr[mid] < ans) {
                    index = mid;
                    ans = arr[mid];
                } 
                high = mid-1;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        int num = noOfTimesArrayIsRotated(nums);
        System.out.println("Arrays is rotated " + num + " times");
    }
}
// TC = O(log n), SC = O(1)