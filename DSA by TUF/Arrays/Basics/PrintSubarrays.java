public class PrintSubarrays {
    public static void printSubarrays(int n[]) {
        int ts = 0;
        for(int i = 0; i < n.length; i++) { // to get start
            int start = i;
            for(int j = i; j < n.length; j++) { // to get end
                int end = j; 
                for(int k = start; k <= end; k++){ // to print all the elements between start and
                    System.out.print(n[k] + " ");
                }
                ts++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("total subarrays = " + ts);
    }
    public static void main(String[] args) {
        int n[] = {2,4,6,8,10};
        printSubarrays(n);
    }
}
