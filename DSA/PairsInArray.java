// Pairs in Array : No element is paired with itself and No element is paired with its predecessor (the element just before it in the array). T.C = O(n)

public class PairsInArray {
    public static void printPairs(int[] n){
        int tp=0;
        for(int i = 0; i < n.length; i++) {
            for(int j = i+1; j < n.length; j++){
                System.out.print("(" + n[i] + "," + n[j] + ")");
                tp++;
            }
            System.out.println();
        }
        System.out.println("total pairs = " + tp);
    }

    public static void printPairs(char[] a){
        int tp=0;
        for(int i = 0; i < a.length; i++) {
            for(int j = i+1; j < a.length; j++){
                System.out.print("(" + a[i] + "," + a[j] + ")");
                tp++;
            }
            System.out.println();
        }
        System.out.println("total pairs = " + tp);
    }
    public static void main(String[] args) {
        int n[] = {2,4,6,8,10};
        int n1[] = {100,200,300,400};
        char a[] = {'a','b','c','d','e'};
        printPairs(n);
        System.out.println();
        printPairs(n1);
        System.out.println();
        printPairs(a);
    }
}
/* less standard approach
int[] arr = {1, 2, 3, 4};
for (int i = 0; i < arr.length; i++) {
    for (int j = 0; j < arr.length; j++) {
        if (i != j && j != i - 1) {
            System.out.println("(" + arr[i] + ", " + arr[j] + ")");
        }
    }
}
*/
