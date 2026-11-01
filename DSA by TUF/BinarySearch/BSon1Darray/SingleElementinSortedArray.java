public class SingleElementinSortedArray {
    public static int singleElement(int[] arr) {
        // 1. Linear search - linear earch by comparing the prefix or suffix ele - iF prefix or suffix matches to curr element then it is repeated else its is single element. TC = O(n)
        // int n = arr.length;
        // for(int i=0;i<n;i++) {
        //     if(i == 0) {
        //         if(arr[i] != arr[i+1]) {
        //             return arr[i];
        //         }
        //     }
        //     else if(i == n-1) {
        //         if(arr[i] != arr[i-1]) {
        //             return arr[i];
        //         }
        //     }
        //     else {
        //         if(arr[i] != arr[i+1] && arr[i] != arr[i-1]) {
        //             return arr[i];
        //         }
        //     }
        // }
        // return -1;

        // 2. XOR operation : TC = O(n). we can also use hash or map but it gain uses tc of O(n)
        // int xor = 0;
        // for(int num : arr) {
        //     xor = xor ^ num;
        // }
        // return xor;

        // 3. Binary search -
        int n = arr.length;
        int low = 1, high = n - 2; // so that mid-1 and mid+1 are always valid

        if(n == 1) return arr[0]; // single element array
        // Handling edge cases : 
        if (arr[0] != arr[1]) return arr[0];
        if (arr[n - 1] != arr[n - 2]) return arr[n - 1];

        while(low <= high) {
            int mid = (low + high) / 2;


            // CASE 1 : mid is the single element
            if(arr[mid - 1] != arr[mid] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            }

            // CASE 2 - even no. of elements on both sides
            if(mid % 2 == 0) { 
                if(arr[mid-1] == arr[mid]) {
                    high = mid-1;
                } 
                else {
                    low = mid+1;
                }
            }

            // CASE 3 - odd no. of elements on both sides
            else { 
                if(arr[mid-1] == arr[mid]) {
                    low = mid+1;
                }
                else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,4,5,5,6,6};
        System.out.println(singleElement(nums));
    }
}
