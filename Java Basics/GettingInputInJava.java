import java.util.Scanner;
public class GettingInputInJava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name :");
        String inputName = sc.next();  // gets a single word input
        System.out.println("Hello, "+inputName+ ". Have a nice Day!");

        // System.out.println("Enter your Full name :");
        // String fullName = sc.nextLine(); // gets a input lines / paragraphs  
        // System.out.println("Hello "+ fullName);

        System.out.println("Enter a number : ");
        int num = sc.nextInt();
        System.out.println("You entered : " + num);

        System.out.println("Enter weight : ");
        float weight = sc.nextFloat();
        System.out.println("Your weight is : " + weight + " kg");

        System.out.println("Enter a boolean value");
        boolean b1 = sc.nextBoolean();
        System.out.println("Boolean value : "+b1);
        
        // Sum and product of a & b (taking a and b from user) :
        System.out.println("Enter a :");
        int a = sc.nextInt();
        System.out.println("Enter b :");
        int b = sc.nextInt();
        int sum = a + b;
        System.out.println("Sum of "+ a +" and " + b +" is : "+ sum);
        int product = a * b;
        System.out.println("Product of "+ a +" and " + b +" is : "+ product);

        // Area of circle (taking radius from user)
        System.out.println("Enter radius of circle :");
        int r = sc.nextInt();
        double areaCircle = (Math.PI)*r*r; // OR float areaCircle = 3.14f*r*r;
        System.out.println("Area of circle is : " + areaCircle);
    }
}