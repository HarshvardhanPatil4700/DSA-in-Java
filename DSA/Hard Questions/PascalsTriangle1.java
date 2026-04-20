/* In this problem 3 types of questions are asked:
1. At given c Row and c Column, which element is present in PT?
2. Print the Nth row of PT
3. Print the entire PT until Nth row
*/

import java.util.*;

public class PascalsTriangle1 {
    public static int nCr(int r, int c) { // function to calculate the value of nCr = n! / (r! * (n-r)!)
        int res = 1;
        for(int i=0;i<c;i++) {
            res = res * (r-i); // Eg: 10C3 : 10*9*8 (this calc i.e numerator is computed in this step)
            res = res / (i+1); // this step computes the denominator of nCr
        }
        return res;
    }

    public static int elementInPT(int r, int c) { // rth row and cth col
        // 1. Type 1 Question - Brute force: TC = O(c) SC = O
        return nCr(r-1, c-1);
    }

    public static void printNthRow(int n) {
        // Type 2 Question:
        // 1. Brute force : Using (n-1 C r-1). TC = O(n * r) ... n by for loop and r by the nCr function 
        // for(int c=1;c<=n;c++) {
        //     System.out.print(nCr(n-1, c-1) + " ");
        // }

        // 2. Optimal sol : Tc = O(n) SC = O(1)
        int ans = 1;
        System.out.print(ans + " ");
        for(int c=1;c<n;c++) {
            ans = ans * (n-c);
            ans = ans / c;
            System.out.print(ans + " ");
        }
    }

    public static List<List<Integer>> generatePtTillNthRow(int numRows) {
        // Result list to hold all rows
        List<List<Integer>> triangle = new ArrayList<>();

        // Loop for each row
        for (int i = 0; i < numRows; i++) {
            // Create a row with size (i+1)
            List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));

            // Fill elements from index 1 to i-1 (middle values)
            for (int j = 1; j < i; j++) {
                // Each element = sum of two elements above it
                row.set(j, triangle.get(i - 1).get(j - 1) +
                           triangle.get(i - 1).get(j));
            }

            // Add current row to the triangle
            triangle.add(row);
        }
        return triangle;
    }
    
    public static void main(String[] args) {
        // System.out.println(elementInPT(5, 3));
        // printNthRow(5);
        System.out.println(generatePtTillNthRow(6));
        
    }
}
