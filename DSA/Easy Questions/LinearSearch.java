// Linear search : It is the simplest searching technique where we check each element one by one from the start of the array/list until the element is found, or the array ends.
public class LinearSearch {
    public static int linearSearch(int a[],int key) {
        for(int i=0;i<a.length;i++) {
            if(a[i] == key) 
                return i; 
        }
        return -1; 
    }
    public static void main(String[] args) {
        int a[] = {5,6,7,8,9,10};
        int key = 8;
        int ind = linearSearch(a, key);
        if (ind != -1) {
            System.out.println(key + " found at " + ind + "th index");
        } else {
            System.out.println(key + " not found");
        }
    }
}