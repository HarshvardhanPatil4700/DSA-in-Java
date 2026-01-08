import java.util.Scanner;

public class ConditionalStatementsPart1 {
    public static void main(String[] args) {
        // 1. if-else Statements
        int age = 18;
        if (age >= 18) {
            System.out.println("Adult : can drive , vote");
        }
        else {
            System.out.println("Not Adult : cannot drive , vote");
        }

        // 1.1 Multiple if statements in if-else:
        System.out.println("Enter your age: ");
        Scanner s = new Scanner(System.in);
        int age1 = s.nextInt();
        if (age1 >= 18) {
            System.out.println("Adult");
        }
        if (age1 > 13 && age1 < 18) {
            System.out.println("Teenage");
        }
        else System.out.println("Not adult");

        // Print largest of 2 nos.
        int A = 1;
        int B = 3;
        if (A >= B) {
            System.out.println("A is larger than B");
        } else {
            System.out.println("B is larger than A");
        }

        // Print if a number is even or odd :
        System.out.println("Enter a number :");
        int num = s.nextInt();
        if (num % 2 == 0) System.out.println(num + " is an EVEN number"); // Even no. after dividing by 2 gives remainder as 0
        else System.out.println(num + " is an ODD number");

        // 2. else-if Statements 
        int Age = 20;
        if(Age >= 18) {
            System.out.println("Adult");
        }
        else if (Age > 13 && Age < 18) {
            System.out.println("Teenager");
        } 
        else {
            System.out.println("Not adult");
        }

        // Income Tax calculator
        System.out.println("Enter your income :");
        int income = s.nextInt();
        int tax;
        if (income < 500000) {
            tax = 0;
        } 
        else if (income >= 500000 && income < 100000) {
            tax = (int) (income * 0.2); // tax = 20% of income
        }
        else{ 
            tax = (int) (income * 0.3); // tax = 30% of income
        }
        System.out.println("Your Tax is : " + tax);

        // Print largest of 3 nos. 
        System.out.println("Enter three Numbers : ");
        int x = s.nextInt();
        int y = s.nextInt();
        int z = s.nextInt();
        if (x>y && x>z){
            System.out.println(x + " is largest of three numbers");
        } 
        else if (y>x && y>z) {
            System.out.println(y + " is largest of three numbers");
        }
        else{
            System.out.println(z + " is largest of three numbers");
        }
    }
}

