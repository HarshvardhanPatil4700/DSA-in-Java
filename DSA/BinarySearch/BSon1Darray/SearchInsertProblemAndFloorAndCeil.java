// Search Insert problem refers to finding a smallest index where a value x can be inserted in the array without affecting sorted order of array. It is solved by using LowerBound as it works for the same problem

public class SearchInsertProblemAndFloorAndCeil {
    public static int searchInsert(int[] arr,int x) {
        int n = arr.length;
        int low = 0, high = n-1;
        int ans = n; 

        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] >= x) { 
                ans = mid;
                high = mid - 1;
            } 
            else {  
                low = mid + 1;
            }

        }
        return ans;
    }

    public static int floor(int[] arr, int x) { // largest value in array such that it is lesser than or equal to x
        int n = arr.length;
        int low = 0, high = n-1;
        int ans = -1;

        while(low <= high) {
            int mid = (low + high)/2;

            if(arr[mid] <= x) {
                ans = arr[mid]; // Here, we have to return the value and not the index like Lower and upper bound
                low = mid+1; // to check if there is another larger value for floor of x
            } 
            else {
                high = mid-1;
            }
        }
        return ans;
    }

    public static int ceil(int[] arr, int x) { // Works using lower bound just we return the value and not the index
        int n = arr.length;
        int low = 0, high = n-1;
        int ans = -1;

        while(low <= high) {
            int mid = (low + high)/2;

            if(arr[mid] >= x) {
                ans = arr[mid]; 
                high = mid-1; 
            } 
            else {
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,6,8};
        int x = 2; // to insert 2 in nums array 
        System.out.println(searchInsert(nums, x));

        int[] numbers = {10,20,30,35,40,50,60,70};
        System.out.println(floor(numbers, 25));
        System.out.println(ceil(numbers, 25));
        System.out.println(floor(numbers, 35));
        System.out.println(ceil(numbers, 35));
        System.out.println(floor(numbers, 100));
        System.out.println(floor(numbers, 100));
    }
}
