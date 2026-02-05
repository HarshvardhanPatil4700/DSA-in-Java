import java.util.HashMap;
import java.util.Scanner;

// class hash {  {TC is O(N) for each query.Hence, Q*O(N) for 'Q' queries}
//     public int charCount(char c, String str){
//         int cntr = 0;
//         for(int i=0;i<str.length();i++){
//             if(str.charAt(i) == c){
//                 cntr++;
//             }
//         }
//         return cntr;
//     }
// }

public class Hashing {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // int a[] = {1,2,3,2,1,2}; {TC is O(N) for each query.Hence, Q*O(N) for 'Q' queries}
        // int counter = 0;
        // System.out.print("Enter query : ");
        // int target = s.nextInt();
        // for(int i=0;i<a.length;i++){
        //     if(a[i] == target){
        //         counter++;
        //     }
        // }
        // System.out.println(target + " count = " + counter);

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
        while (q-- > 0) { // run the loop until the queries are not zero (i.e until queries are not completed)
            int number = s.nextInt();
            System.out.println("Count of " + number + " is: " + hash[number]);
        }

        // s.close();

        // 1. HashMap (Hashing example) : 
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Apple", 3);
        map.put("Banana", 5);
        map.put("Apple", 4); // updates value

        System.out.println(map.get("Apple")); // 4
        System.out.println(map.containsKey("Banana")); // true

        // Character Hashing: 

        // hash h = new hash();
        // String str = "abcdabefc";
        // System.out.println("Count = " + h.charCount('a', str)) ;

        // for lowercase letters only : 26 lower characters are present, so size of array is 26.
        System.out.print("Enter a string of lowercase letters  : ");
        String str = s.next();
        System.out.print("Enter number of queries : ");
        int query = s.nextInt();

        // pre compute :
        int hash1[] = new int[26];
        for(int i=0;i < str.length();i++){ // gets the count of all the characters of string and stores it in hash1 array
            // hash1[str[i] - 'a']++;
            hash1[str.charAt(i) - 'a']++;
        }

        while(query-- > 0) {
            char c = s.next().charAt(0);
            System.out.println("Count of " + c + " is: " + hash1[c - 'a']); // hash1[c - 'a'] gives the index of char in hash1 array
        }

        // for any character : Here,we dont need hash[c - 'a'] bcoz we declared array of size 255 which includes all teh chars and their ASCII values 
        System.out.print("Enter a string of lowercase letters  : ");
        String str1 = s.next();
        System.out.print("Enter number of queries : ");
        int query1 = s.nextInt();

        // pre compute :
        int hash2[] = new int[256]; // we have 256 total characters so size is 256
        for(int i=0;i < str1.length();i++){
            hash2[str1.charAt(i)]++;
        }
        // fetch
        while(query1-- > 0) {
            char c = s.next().charAt(0);
            System.out.println("Count of " + c + " is: " + hash2[c]); // hash2[c] gives index of char in the hash2 array of size 255
        }

        // Example : Create hashing of count of numbers from 1 to 10 and get their count :
        System.out.print("Enter total no. of numbers: ");
        int a = s.nextInt();

        int nums[] = new int[a];

        // generate random numbers (1 to 10)
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)(Math.random() * 10) + 1;
        }

        // hashing array
        int hashing[] = new int[11]; // because numbers are 1 to 10

        // pre-compute
        for (int i = 0; i < nums.length; i++) {
            // hashing[i]++;  WRONG logic
            hashing[nums[i]]++;
        }

        // fetch
        System.out.print("Eneter no. of queries to search : ");
        int Q = s.nextInt(); // total no. of queries
        System.out.println("Enter query numbers:");
        while (Q-- > 0) {
            int number = s.nextInt();
            System.out.println("Count of " + number + " is: " + hash[number]);
        }
        System.out.print("Array : ");
        for(int i : nums) {
            System.out.print(i + " ");
        }

        s.close();
    }
}

