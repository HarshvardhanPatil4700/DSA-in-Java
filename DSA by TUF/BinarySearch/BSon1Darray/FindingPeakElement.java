// Finding Peak element (Peak Index in Mountain Array Problem) - A peak element is an element that is strictly greater than its neighbors. i.e arr[i-1] < arr[i] > arr[i+1] then arr[i] is Peak element
// Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
// You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array. therefore , arr[] = -∞{1,2,3,4,5}-∞

public class FindingPeakElement {
    public static int peakEle(int[] arr) {
        // 1. Linear search - TC = O(n), SC = O(1)

        // int n = arr.length;
        // if(n == 1) return arr[0]; // single ele array
        // // Handling edge cases -
        // if(arr[0] > arr[1]) return arr[0];
        // if(arr[n-2] < arr[n-1]) return arr[n-1];

        // for(int i=1;i<n-1;i++) {
        //     if(arr[i-1] < arr[i] && arr[i] > arr[i+1]) {
        //         return arr[i];
        //     }
        // }
        // return -1;

        // 2. Binary search - 
        int n = arr.length;
        if(n==1) return arr[0];
        if(arr[0] > arr[1]) return arr[0];
        if(arr[n-1] > arr[n-2]) return arr[n-1];

        int low = 1,high = n-2;
        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid+1]) {
                return arr[mid];
            }
            else if(arr[mid] > arr[mid-1]) {
                low = mid+1;
            }
            else if(arr[mid] > arr[mid+1]) {
                high = mid-1;
            }
        }
        return -1;
    }

    public static int multiplePeakEle(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;

        int low = 0, high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Descending slope: peak is at mid or on the left side
            if (arr[mid] > arr[mid + 1]) {
                high = mid;
            }
            // Ascending slope: peak is on the right side
            else {
                low = mid + 1;
            }
        }
        System.out.println("Peak element = " + arr[low]);
        return low; // index of a peak element
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,5,1};
        System.out.println(peakEle(nums));

        // multiple peaks :
        int[] numbers = {1, 3, 2, 4, 1, 5, 0};
        System.out.println("Peak Element is present at " + multiplePeakEle(numbers) + " index");
    }
}
/*
1. why return low ?
The loop condition is: while (low < high)
So it stops only when: low == high . At that point, the search space contains exactly one index.
Example:
low = 3
high = 3
Since throughout the algorithm we always keep at least one peak inside the search range [low, high], when the range shrinks to a single index, that index must be a peak.
Therefore: return low; (or) return high;
both work because: low == high 

2. why high = mid ?
Since the slope is going down after mid, a peak must exist at mid or somewhere to its left. so we write high = mid and not high = mid-1
*/