// set matrix zeroes refers to a function that set entire row and column to 0 if an element in the matrix is 0
public class SetMatrixZeroes {
    
    public static void setZeroes(int[][] matrix) {
        // 1. Brute force : TC = O(m + n + (m+n)), SC = O(1) - We are not using any extra data structures, only modifying the matrix in place (apart from a few variables).
        // // Get number of rows
        // int m = matrix.length;
        // // Get number of columns
        // int n = matrix[0].length;

        // // First pass: mark rows and columns
        // for (int i = 0; i < m; i++) { // get the row of element which is 0 (O(m))
        //     for (int j = 0; j < n; j++) { // get the col of element which is 0 (O(n))
        //         // If the cell is zero
        //         if (matrix[i][j] == 0) {
        //             // Mark entire row as -1 (except zeros)
        //             for (int col = 0; col < n; col++) {
        //                 if (matrix[i][col] != 0)
        //                     matrix[i][col] = -1;
        //             }
        //             // Mark entire column as -1 (except zeros)
        //             for (int row = 0; row < m; row++) {
        //                 if (matrix[row][j] != 0)
        //                     matrix[row][j] = -1;
        //             }
        //         }
        //     }
        // }

        // // Second pass: replace -1 with 0
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (matrix[i][j] == -1)
        //             matrix[i][j] = 0;
        //     }
        // }

        // 2. Optimal sol : TC = O(3*(m * n)) = O(m*n), SC = O(1)
        int m = matrix.length; // Get number of rows
        int n = matrix[0].length; // Get number of columns
        boolean firstRow = false, firstCol = false;

        // Set markers in first row and first col
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j] == 0) { // if any ele in matrix is zero then mark its firstRow and firstCol as '0'
                    if(i == 0) firstRow = true;
                    if(j == 0) firstCol = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Replace inner matrix
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) { // if preserved elements (i.e firstRow or firstCol is 0 then mark that entire row/col as 0)
                    matrix[i][j] = 0;
                }
            }
        }

        // last remaining checks i.e for the preserved elements
        if(firstRow) {
            for(int i=0;i<n;i++) {
                matrix[0][i] = 0;
            }
        }
        if(firstCol) {
            for(int j=0;j<m;j++) {
                matrix[j][0] = 0;
            }
        }
    }
    
    public static void main(String[] args) {
        // 1. Brute force
        // // Example matrix
        // int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        // setZeroes(matrix);
        
        // // Print result
        // for (int[] row : matrix) {
        //     for (int val : row) {
        //         System.out.print(val + " ");
        //     }
        //     System.out.println();
        // }

        // 2. Optimal sol :
        // int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        setZeroes(matrix);

        // Print result
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}