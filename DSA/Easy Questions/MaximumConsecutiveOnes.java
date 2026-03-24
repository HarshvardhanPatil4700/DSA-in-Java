public class MaximumConsecutiveOnes { // TC = O(n)
    public static int maxConsOnes(int a []) {
        int counter = 0; // counter
        int maximum = 0; // maximum of counter
        for(int i = 0; i<a.length; i++) {
            if(a[i] == 1) {
                counter++;
                maximum = Math.max(maximum,counter);
            }else {
                counter = 0;
            }
        }
        return maximum;
    }
    public static void main(String[] args) {
        int a[] = {1,1,0,1,1,1,0,1,1};
        System.out.println(maxConsOnes(a));

    }    
}
