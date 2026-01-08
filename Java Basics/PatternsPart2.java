public class PatternsPart2 {
    // 1. hollow rectangle
    public static void hollow_rectangle(int totRows, int totCols){
        for (int i = 1; i <= totRows; i++) { // row
            for (int j = 1; j <= totCols ; j++) { // column
                if(i == 1 || i == totRows || j == 1 || j == totCols){ // boundary cells
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // 2. hollow square
    public static void hollow_square(int side){
        for (int i = 1; i <= side; i++) { // row
            for (int j = 1; j <= side ; j++) { // column
                if(i == 1 || i == side || j == 1 || j == side){ // boundary cells
                    System.out.print("*" + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    // 3.
    public static void inverted_rotated_half_pyramid(int n){
        for(int i = 1; i<=n;i++){
            // spaces
            for(int j = 1; j <= n-i; j++){
                System.out.print(" ");
            }

            // stars
            for(int j=1; j <= i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 4. Inverted half pyramid with numbers
    public static void inverted_half_pyramid(int n){
        for (int i = 1; i <= n; i++) {
            for(int j =1; j <= n-i+1 ; j++){ // inner numbers
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    // 5. Floyd's Triangle
    public static void floyd_triangle(int n){
        int counter = 1;
        for(int i =1; i<=n; i++){
            for(int j = 1; j<= i; j++){
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }

    // 6. 0-1 Triangle
    public static void zero_one_triangle(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                if((i+j) % 2 == 0){
                    System.out.print("1");
                } else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    // 7. Butterfly pattern
    public static void butterfly_pattern(int n){
        // 1st half
        for(int i = 1; i<=n ; i++){
            // stars - i
            for(int j =1; j<=i; j++){
                System.out.print("*");
            }
            // spaces - 2*(n-i)
            for(int j = 1; j<= 2*(n-i); j++){
                System.out.print(" ");
            }
            // stars - i
            for(int j = 1; j<= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // 2nd half (to invert the image as it is mirror image)
        for(int i=n; i>=1; i--){
            // stars - i
            for(int j =1; j<=i; j++){
                System.out.print("*");
            }
            // spaces - 2*(n-i)
            for(int j = 1; j<= 2*(n-i); j++){
                System.out.print(" ");
            }
            // stars - i
            for(int j = 1; j<= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 8. Solid rhombus
    public static void solid_rhombus(int n){
        for(int i=1; i<=n; i++){
            // spaces = n-i
            for(int j=1; j<= n-i; j++){
                System.out.print(" ");
            }
            // stars = i
            for(int j=1; j<= n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 9. Hollow Rhombus
    public static void hollow_rhombus(int n){
        for(int i=1; i<=n; i++){
            // spaces = n-i
            for(int j=1; j<= n-i; j++){
                System.out.print(" ");
            }

            // hollow rectangle - stars
            for(int j=1; j<=n ; j++){
                if(i==1 || i==n || j==1 || j==n){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // 10. diamond
    public static void diamond_pattern(int n){
        // 1st half
        for(int i=1; i<=n; i++){
            // spaces = n-i
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            // stars = i
            for(int j=1; j<=2*i-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // 2nd half
        for(int i=n; i>=1; i--){
            // spaces = n-i
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            // stars = i
            for(int j=1; j<=2*i-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        hollow_rectangle(4, 9);
        hollow_square(7); // it looks like rectangle bcoz spaces in vertical are higher than spaces in horizantal
        inverted_rotated_half_pyramid(6);
        inverted_half_pyramid(5);
        System.out.println();
        floyd_triangle(5);
        System.out.println();
        zero_one_triangle(5);
        System.out.println();
        butterfly_pattern(5);
        System.out.println();
        solid_rhombus(5);
        System.out.println();
        hollow_rhombus(5);
        System.out.println();
        diamond_pattern(5);
    }
}
