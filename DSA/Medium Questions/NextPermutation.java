import java.util.Arrays;

public class NextPermutation {
    // 1. Brute force : Genrate all the permutations, sort them and use linear search to get next permutation
    // public static List<List<Integer>> getPermutations(int[] nums) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     permute(nums, new ArrayList<>(), res);
    //     return res;
    // }

    // static void permute(int[] nums, List<Integer> curr, List<List<Integer>> res) {
    //     if(curr.size() == nums.length) {
    //         res.add(new ArrayList<>(curr));
    //         return;
    //     }

    //     for(int i = 0; i < nums.length; i++) {
    //         if(curr.contains(nums[i])) continue;

    //         curr.add(nums[i]);
    //         permute(nums, curr, res);
    //         curr.remove(curr.size() - 1);
    //     }
    // }

    // public static int[] nextPermutation(int[] nums) {
    //     List<List<Integer>> perms = getPermutations(nums);

    //     // sort all permutations
    //     Collections.sort(perms, (a, b) -> {
    //         for(int i = 0; i < a.size(); i++) {
    //             if(!a.get(i).equals(b.get(i))) {
    //                 return a.get(i) - b.get(i);
    //             }
    //         }
    //         return 0;
    //     });

    //     // find current index
    //     List<Integer> current = new ArrayList<>();
    //     for(int n : nums) current.add(n);

    //     for(int i = 0; i < perms.size(); i++) {
    //         if(perms.get(i).equals(current)) {
    //             // next permutation
    //             if(i == perms.size() - 1) {
    //                 return perms.get(0).stream().mapToInt(Integer::intValue).toArray();
    //             }
    //             return perms.get(i + 1).stream().mapToInt(Integer::intValue).toArray();
    //         }
    //     }

    //     return nums;
    
    // 2. Optimal Sol :
    public static int[] nextPermutation(int[] a) {
        int n = a.length;
        int ind = -1;

        // Step 1: find breakpoint
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] < a[i + 1]) {
                ind = i;
                break;
            }
        }

        // Step 2: if no breakpoint, then reverse whole array
        if (ind == -1) {
            reverse(a, 0, n - 1);
            return a;
        }

        // Step 3: find next greater element and swap
        for (int i = n - 1; i > ind; i--) {
            if (a[i] > a[ind]) {
                int temp = a[i];
                a[i] = a[ind];
                a[ind] = temp;
                break;
            }
        }

        // Step 4: reverse right half i.e here [5,4,1,0,0] -> [0,0,1,4,5]
        reverse(a, ind + 1, n - 1);

        return a;
    }

    // the reverse function (in-place)
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,1,5,4,3,0,0};
        System.out.println(Arrays.toString(nextPermutation(nums)));
    }
}
