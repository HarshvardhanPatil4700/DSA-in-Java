import java.util.Scanner;
public class PracticeQuestionSection8 {
    public static void main(String[] args) {
        // 1.
        Scanner s = new Scanner(System.in);
        System.out.println("Enter 3 numbers :");
        int A = s.nextInt();
        int B = s.nextInt();
        int C = s.nextInt();
        int avg = (A+B+C) / 3;
        System.out.println("the average of "+ A + ", " + B +" and " + C + " is : " + avg );

        // 2.
        System.out.println("Enter the side of Square : ");
        int side = s.nextInt();
        int areaSquare = side*side;
        System.out.println("Area of square : " + areaSquare);

        // 3.
        System.out.println("Enter the prices of items: ");
        float pencilCost = s.nextFloat();
        float penCost = s.nextFloat();
        float eraserCost = s.nextFloat();
        float total = pencilCost+penCost+eraserCost;
        System.out.println("Bill is : " + total + " rs");
        // Bill inclusive of gst :
        float gst = (float) (0.18)*(pencilCost+penCost+eraserCost);
        float newTotal = pencilCost+penCost+eraserCost + gst;
        System.out.println("The total cost of the items is :" + newTotal + " rs");
        
        // 4.
        byte b = 4;
        char c = 'a';
        short s1 = 512;
        int i = 1000;
        float f = 3.14f;
        double d = 99.9954;
        double result = (f*b) + (i%c) - (d*s1);
        System.out.println(result);

        // 5.
        int $ = 25;
        System.out.println($); // therefore, we can use $ as variable name as Identifier Rules says that the identifiers can start with alphabet or '_' or '$' 
    }
}
