import java.util.*;

public class LinearSearch {
    public static int linearSearch(int numbers[], int key){
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] == key){
                return i; // if key is found return its index
            } 
        }
        return -1; // key not found
    }

    // example
    public static void linearSearch1(String names[], String searchKey){
        boolean a = false;
        for(int i=0; i<names.length; i++){
            if(names[i].equals(searchKey)){
                a = true;
                System.out.println("Present");                
            }
        }
        if(!a){
            System.out.println("Absent");
        }
        
    }

    // largest and smallest number
    public static int largestAndSmallestNum(int nums[]){
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if (nums[i] >= largest){
                largest = nums[i];                
            }
            if (nums[i] <= smallest){
                smallest = nums[i];                
            }
        }
        System.out.println("Smallest value is : " + smallest);
        return largest;
    }
    public static void main(String[] args) {
        int numbers[] = {2,4,6,8,10,12,14,16};
        int key = 10;

        int index = linearSearch(numbers, key);
        if(index == -1){
            System.out.println(key +" NOT found");
        } else {
            System.out.println(key +" found at " + index + "th index (" + (index+1) + "th term)");
        }

        // example
        String names[] = {"adam", "bob", "jack", "daniel", "george", "william"};
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a name to search : ");
        String searchKey = s.next();
        linearSearch1(names, searchKey);

        // largest and smallest number
        int nums[] = {1,2,6,3,8,4,5};
        System.out.println("Largest value is : " + largestAndSmallestNum(nums));
    }
}