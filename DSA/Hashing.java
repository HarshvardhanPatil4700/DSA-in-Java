import java.util.HashMap;
import java.util.Scanner;

public class Hashing {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("Enter size of input array : ");
        int n = s.nextInt(); 
        int[] arr = new int[n]; // array to store all the numbers

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt(); // gets the user input (numbers) and stores it in array (input array)
        }

        // precompute hashing (assuming values <= 12)
        int[] hash = new int[13];

        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }

        // number of queries
        System.out.print("Enter number of queries: ");
        int q = s.nextInt();

        // process queries
        System.out.println("Enter query numbers:");
        while (q-- > 0) {
            int number = s.nextInt();
            System.out.println("Count of " + number + " is: " + hash[number]);
        }

        s.close();

        // 1. HashMap (Hashing example) : 
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Apple", 3);
        map.put("Banana", 5);
        map.put("Apple", 4); // updates value

        System.out.println(map.get("Apple")); // 4
        System.out.println(map.containsKey("Banana")); // true
    }
}
