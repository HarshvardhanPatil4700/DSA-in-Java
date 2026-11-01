public class CountInversions {
    public static int merge(int[] arr,int low,int mid,int high) {
        int[] temp = new int[high-low+1];

        int left = low;
        int right = mid+1;
        int k = 0;
        int cnt = 0; // count of inversions

        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) { // if left < right then just add it to temp array 
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
                cnt += (mid - left + 1); // if left > right then as araay is sorted the remaining elements can also form the inversion
            }
        }

        while(left <= mid) {
            temp[k++] = arr[left++];
        }
        
        while(right <= high) {
            temp[k++] = arr[right++];
        }
        
        for (int i = low; i <= high; i++) { // Copy back to original array
            arr[i] = temp[i - low];
        }

        return cnt;
    }

    public static int mergeSort(int[] arr, int low,int high) {
        int cnt = 0;
        int mid = (low + high) / 2;

        if (low >= high) return cnt;

        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid+1, high);
        cnt += merge(arr, low, mid, high); // to add the count inversions of both left and right arrays while merging

        return cnt;
    }
    public static int countInversionInArray(int[] arr) {
        // 1. Brute force - TC = O(n), SC = O(1)
        // int n = arr.length;
        // int cnt = 0;
        // for(int i=0;i<n;i++) {
        //     for(int j = i+1; j<n;j++) {
        //         if(arr[i] > arr[j]) {
        //             cnt++;
        //         }
        //     }
        // }
        // return cnt;

        // 2. Optimal Sol - TC = O(N log N), since it is based on merge sort, SC = O(N) for extra temp array
        return mergeSort(arr, 0, arr.length - 1);        
    }
    public static void main(String[] args) {
        int nums[] = {5,3,2,4,1};
        int countInver = countInversionInArray(nums);
        System.out.println("Count Inversions = " + countInver);
    }
}