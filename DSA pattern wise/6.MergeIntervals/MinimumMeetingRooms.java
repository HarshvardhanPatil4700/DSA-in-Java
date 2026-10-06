
import java.util.Arrays;

public class MinimumMeetingRooms {
    // Merge intervals: TC = O(n + 2*(n logn) + n) = O(n logn),SC = O(2*n) = O(n)
    public static int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int start[] = new int[n]; 
        int end[] = new int[n]; 
        
        for(int i = 0; i < n; i++) {
            start[i] = intervals[i][0]; // check-in times
            end[i] = intervals[i][1]; // check-out times
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0;
        int res = 0;
        int i = 0, j = 0;
        while(i<n && j<n) { // 2-pointer approach (like Merge 2 sorted array)
            // New meeting starts before the earliest meeting ends -> need a new room
            if(start[i] < end[j]) { // 
                rooms++;
                res = Math.max(res, rooms);
                i++;
            }
            // A meeting has ended before the next meeting starts -> free a room
            else {
                rooms--;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 4},{10, 15},{7, 10}};
        System.out.println(minMeetingRooms(intervals));
        int[][] interval = {{2,4}, {9,12}, {6,10}};
        System.out.println(minMeetingRooms(interval));
    }
}
