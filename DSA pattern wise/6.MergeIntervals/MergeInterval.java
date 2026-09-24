// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public static int[][] merge(int[][] inter) {
        List<int[]> res = new ArrayList<>();
        // sort the intervals w.r.t start
        Arrays.sort(inter, (a,b) -> Integer.compare(a[0], b[0]));

        int start1 = inter[0][0];
        int end1 = inter[0][1];
        for(int i = 1; i < inter.length; i++) {
            int start2 = inter[i][0];
            int end2 = inter[i][1];

            // check if intervals are overlapping
            if(end1 >= start2) {
                // merge the overlapping intervals as :
                // start1 = start1;
                end1 = Math.max(end1, end2);
                continue;
            }
            // push it into answer
            res.add(new int[]{start1,end1});
            start1 = start2;
            end1 = end2;
        }
        // Add the last interval
        res.add(new int[]{start1,end1});
        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(intervals);
        for (int[] interval : result) {
            System.out.println(
                "[" + interval[0] + ", " + interval[1] + "]"
            );
        }
    }
}
