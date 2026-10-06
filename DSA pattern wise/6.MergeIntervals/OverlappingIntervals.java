import java.util.Arrays;

public class OverlappingIntervals {
    // Merge intervals : TC = O(n), SC = O(1)
    public static boolean isIntersecting(int[][] inter) {
        int n = inter.length;
        Arrays.sort(inter, (a,b) -> Integer.compare(a[0], b[0]));

        int start1 = inter[0][0];
        int end1 = inter[0][1];
        for(int i = 1; i < n; i++) {
            int start2 = inter[i][0];
            int end2 = inter[i][1];
            // check if any two intervals intersect with each other
            if(end1 >= start2) {
                return true;
            } 
            start1 = start2;
            end1 = Math.max(end1, end2);
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {5, 7}, {2, 4}, {6, 8}};
        System.out.println(isIntersecting(intervals));
        int[][] interval = {{1, 2}, {3, 4}, {5, 7}, {9, 12}};
        System.out.println(isIntersecting(interval));
    }
}