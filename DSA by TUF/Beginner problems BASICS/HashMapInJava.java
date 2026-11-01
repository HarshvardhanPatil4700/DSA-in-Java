import java.util.HashMap;
import java.util.Scanner;

public class HashMapInJava {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter total no. of numbers: ");
        int a = s.nextInt();

        int nums[] = new int[a];

        // generate random numbers (1 to 10)
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)(Math.random() * 10) + 1;
        }

        // HashMap for frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        // pre-compute
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        // fetch
        System.out.print("Enter no. of queries : ");
        int queries = s.nextInt();
        while(queries-- > 0) {
            int num = s.nextInt(); // get teh query from user
            System.out.println("Count of " + num + " is : " +  map.getOrDefault(num, 0));
        }
        System.out.print("Array : ");
        for(int n : nums){
            System.out.print(n+ " ");
        }

        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;

        int maxElement = -1;
        int minElement = -1;

        for (var entry : map.entrySet()) {
            int elem = entry.getKey();
            int freq = entry.getValue();

            if (freq > maxFreq) {
                maxFreq = freq;
                maxElement = elem;
            }

            if (freq < minFreq) {
                minFreq = freq;
                minElement = elem;
            }
        }
        System.out.println("\nHighest frequency element : " + maxElement + " (count = " + maxFreq + ")");
        System.out.println("Lowest frequency element  : " + minElement + " (count = " + minFreq + ")");

    }
}
/*
for (int x : nums) {
    map.put(x, map.getOrDefault(x, 0) + 1);
}
This loop goes through each number in nums.

map.getOrDefault(x, 0) :-If x already exists in the map → return its count and if x does NOT exist → return 0 

*Advantages of using HashMap for Hashing :
O(1) average time for insert and lookup
Works with large or unknown data ranges
Supports negative keys
Dynamic size (no pre-allocation needed)
Memory efficient for sparse data
*/