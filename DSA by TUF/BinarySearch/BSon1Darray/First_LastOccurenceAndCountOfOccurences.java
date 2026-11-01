public class First_LastOccurenceAndCountOfOccurences {
    private static int lowerBound(int[] arr,int x) {
        int n = arr.length;
        int low = 0, high = n-1;
        int ans = n;
        while(low<=high) {
            int mid = (low + high) / 2;

            if(arr[mid] >= x) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }

    private static int upperBound(int[] arr,int x) {
        int n = arr.length;
        int low = 0, high = n-1;
        int ans = n;
        while(low<=high) {
            int mid = (low + high) / 2;

            if(arr[mid] > x) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    
    public static int[] firstAndLastOccur(int[] arr, int x) {
        // 1.Linear search : TC = O(n)
        // int first = -1, last = -1;
        // int n = arr.length;
        // for(int i=0;i<n;i++) {
        //     if(arr[i] == x) {
        //         first = i;
        //     }
        //     last = i;
        // }
        // return new int[]{first,last};

        // 2.using lower and upper bound : 2 * O(log2 n), SC = O(1) 
        int n = arr.length;
        int lb = lowerBound(arr, x);
        int ub = upperBound(arr, x);
        if(lb == n || arr[lb] != x){
            return new int[]{-1,-1};
        } 
        return new int[]{lb, ub - 1};
    }

    // 3. BINARY SEARCH - TC = O(log n), SC = O(1)
    public static int firstOccur(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n-1;
        int first = -1;
        
        while(low <= high) {
            int mid = (low+high)/2;
            
            if(arr[mid] == x) {
                first = mid;
                high = mid - 1; // to check if there is any other occurences
            } 
            else if(arr[mid] < x) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return first;    
    }

    public static int lastOccur(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n-1;
        int last = -1;
        
        while(low <= high) {
            int mid = (low+high)/2;
            
            if(arr[mid] == x) {
                last = mid;
                low = mid + 1; // to check if there is any other occurences
            } 
            else if(arr[mid] < x) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return last;    
    }

    public static int[] firstAndLastOccurence(int[] arr, int x) {
        int first = firstOccur(arr, x);
        int last = lastOccur(arr, x);
        
        if(first == -1) {
            return new int[]{-1,-1};
        }
        return new int[]{first,last};
    }

    public static int countOfOccurences(int[] arr,int x) {
        int[] ans = firstAndLastOccurence(arr, x);
        if(ans[0] == -1) { // first occurence is -1 (does not exist)
            return 0;
        }
        return ans[1] - ans[0] + 1;
    }

    public static void main(String[] args) {
        // int[] nums = {2,4,6,8,8,8,11,13};
        // int x = 8;
        // int[] res = firstAndLastOccur(nums, x);
        // System.out.println("First occurence of " + x + " is = " + res[0]);
        // System.out.println("Last occurence of " + x + " is = " + res[1]);

        // // Fail cases: No occurence
        // int y = 10; 
        // int[] result = firstAndLastOccur(nums, y);
        // System.out.println("First occurence of " + y + " is = " + result[0]);
        // System.out.println("Last occurence of " + y + " is = " + result[1]);

        int [] nums = {2,3,4,6,8,8,8,11,13};
        int x = 8;
        int[] res = firstAndLastOccurence(nums, x);
        System.out.println("First occurence of " + x + " is = " + res[0]);
        System.out.println("Last occurence of " + x + " is = " + res[1]);
        System.out.println("No. of occuences of " + x + " = " + countOfOccurences(nums, x));
        System.out.println();

        int y = 10; 
        int[] result = firstAndLastOccurence(nums, y);
        System.out.println("First occurence of " + y + " is = " + result[0]);
        System.out.println("Last occurence of " + y + " is = " + result[1]);

        
    }
}
