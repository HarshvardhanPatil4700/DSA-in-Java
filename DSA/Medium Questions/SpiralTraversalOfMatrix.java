import java.util.ArrayList;
import java.util.List;

public class SpiralTraversalOfMatrix {
    public static List spiralTraversalMatrix(int[][] matrix) {
        // Optimal sol : TC = O(n*m), SC = O(n*m) ...where n=no.of rows, m = no.of col 
        List result = new ArrayList<>();

        int top = 0; // Starting row
        int bottom = matrix.length-1; // Ending row
        int left = 0; // Starting col
        int right = matrix[0].length-1; // Ending col
        
        // Loop until all elements are traversed
        while(top <= bottom && left <= right) {
            // Traverse left to right in top {top is constant}
            for(int i=left;i<=right;i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse the right boundary (top to bottom in right boundary) {right is constant}
            for(int i=top;i<=bottom;i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if(top <= bottom) { // Check when there is only a single row
                // Traverse the bottom boundary right to left {bottom is constant}
                for(int i=right;i>=left;i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if(left <= right) {
                // Traverse the left boundary from bottom to top {left is constant}
                for(int i=bottom;i>=top;i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            { 1,  2,  3,  4,  5,  6},
            {20, 21, 22, 23, 24,  7},
            {19, 32, 33, 34, 25,  8},
            {18, 31, 36, 35, 26,  9},
            {17, 30, 29, 28, 27, 10},
            {16, 15, 14, 13, 12, 11}
        };

        List ans = spiralTraversalMatrix(matrix);

        for(Object x : ans) {
            System.out.print(x + " ");
        }
    }
}
