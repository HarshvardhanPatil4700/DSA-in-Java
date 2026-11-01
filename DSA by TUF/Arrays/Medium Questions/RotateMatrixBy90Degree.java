public class RotateMatrixBy90Degree {
    public static int[][] rotateMatrixBy90deg(int[][] matrix) {
        // 1. Brute force : TC = O(n^2), SC = O(n^2)
        // int rotated[][] = new int[n][n]; // intialize another arr of (nxn) in which changes are done 
        // for(int i=0;i<n;i++) {
            //     for(int j=0;j<n;j++) {
                //         rotated[j][(n-1)-i] = matrix[i][j];
                //     }
        // }
        
        // return rotated;
        
        // 2. Optimal Sol : Transpose (row becomes col and col becomes row) and reverse every row
        // TC = O(N²),We traverse every element once during transposition and again during reversal of each row, resulting in a total of O(N²) time, SC = O(1)
        int n = matrix.length; // matrix is nxn
        // Transpose : Observation- the diagonal elements remains as it is and the non-diagonal elements are swapped i.e m[i][j] -> m[j][i]
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                // swap matrix[i][j] and matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse every row :
        for(int i = 0; i < n; i++) {
            int left = 0, right = n - 1;

            while(left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }

        return matrix;
    }
    public static void main(String[] args) {
        // 1. brute force
        // int[][] matrix = {
        //     {0,1,2},
        //     {3,4,5},
        //     {1,3,1}
        // };
        // int rotated[][] =rotateMatrixBy90deg(matrix);

        // for(int[] row : rotated) {
        //     for(int value : row) {
        //         System.out.print(value + " ");
        //     }
        //     System.out.println();
        // }

        // 2. Optimal sol :
        int[][] matrix = {
            {0,1,2},
            {3,4,5},
            {1,3,1}
        };
        int res[][] = rotateMatrixBy90deg(matrix);
        for(int[] row : res) {
            for(int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
