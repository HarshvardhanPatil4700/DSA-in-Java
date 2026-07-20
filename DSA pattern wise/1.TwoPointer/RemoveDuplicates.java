public class RemoveDuplicates {
    public static int removeDuplicate(int []arr) {
        int n = arr.length;
        int left = 0;
        int right = 1;

        if(n == 0) return 0;

        while(right < n) {
            if(arr[right] != arr[right-1]) { // 
                left++;
                arr[left] = arr[right];
            }
            right++;
        }

        // print unique elements
        // for (int k = 0; k <= left; k++) {
        //     System.out.print(arr[k] + " ");
        // }
        // System.out.println();

        return left+1; // the left stores the index of last unique element so no of unique eles = left + 1
    }
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,2,3,3};
        System.out.println(removeDuplicate(arr));
    }
}
// TC = O(n), SC = O(1) 