public class IntroAndExamples {
    public static int binarySearch(int[] arr,int low, int high, int target) {
        int n = arr.length;

        if(low > high) { // search space exhausted
            return -1;
        }

        int mid = (low + high) / 2;

        if(arr[mid] == target) {
            return mid;
        }
        else if (arr[mid] < target) {
            return binarySearch(arr,mid + 1, high, target);
        } 
        else {
            return binarySearch(arr, low, mid - 1, target);
        }
    }
    public static void main(String[] args) {
        int[] nums = {3,4,6,7,9,12,16,17};
        int targ = 6;
        int pos = binarySearch(nums, 0, nums.length-1, targ);
        System.out.println("The element " + targ + " is present at " + pos + "nd index");

        int posi = binarySearch(nums, 0, nums.length-1, 13);
        if(posi == -1) {
            System.out.println("target NOT FOUND");
        }
    }
}