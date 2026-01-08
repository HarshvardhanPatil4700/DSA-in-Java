import java.util.Scanner;
public class TypeConversion {
    public static void main(String[] args) {
        int a = 25;
        float b = a; // Converts int (25) to float (25.0)
        System.out.println(b);
        
        float c = 20.5f;
        // int d = c; Error: incompatible types :possible lossy conversion from float to int

        // Same goes for Scanner class object i.e we can get a data type which is converted to another compatible data type else gives error
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number: ");
        float f = s.nextInt(); // converts input int data too float implicitlly
        System.out.println("Number: " + f);

        // int i = s.nextFloat(); incompatible types: possible lossy conversion from float to int
    }
}
