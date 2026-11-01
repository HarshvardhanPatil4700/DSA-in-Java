import java.util.Scanner;

public class CheckIfArrayIsSorted {
    // TODO : Check if array is sorted or not
    public static boolean isSorted(int a[],int n) {
        // for(int i = 0; i<a.length-1;i++) {
        //     if(a[i] < a[i+1]) {
        //         return true;
        //     }
        // }
        // return false;    
        
        for(int i = 1; i < n; i++) {
            if(a[i] >= a[i-1]){

            }else {
                return false;
            }
        }
        return true;
    }

    // TODO : Check if array is sorted in descending order or not
    public static boolean isSortedDesc(int a[],int n) {
        for(int i = 1; i < n ;i++) {
            if(a[i] > a[i-1]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // TODO : Check if array is sorted or not
        System.out.print("Enter the length of array : ");
        int n = s.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of array : ");
        for(int i = 0; i < n;i++){ 
            arr[i] = s.nextInt();
        }
        System.out.println(isSorted(arr,n));

        // TODO : Check if array is sorted in descending order or not
        System.out.print("Enter the length of array : ");
        int x = s.nextInt();
        int a[] = new int[x];
        System.out.println("Enter the elements of array : ");
        for(int i = 0; i < x;i++){ 
            a[i] = s.nextInt();
        }
        System.out.println(isSortedDesc(a, x));
    }
}