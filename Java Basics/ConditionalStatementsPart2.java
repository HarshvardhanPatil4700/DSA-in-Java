import java.util.Scanner;
public class ConditionalStatementsPart2 {
    public static void main(String[] args) {
        // 3. Ternary operator
        int num = 7;
        String evenOddCheck = (num % 2 != 0) ? "Odd" : "Even";
        System.out.println(evenOddCheck);

        // Result : Pass or Fail 
        System.out.println("Enter your Marks : ");
        Scanner s = new Scanner(System.in);
        int marks = s.nextInt();

        String Result = marks >= 33 ? "Pass" : "Fail";
        System.out.println(Result);

        // 4. Switch statements
        int number = 5;
        switch(number) {
            case 1 : 
                System.out.println("Number : " + number);
                break;
            case 2 : 
                System.out.println("Number : " + number);
                break;
            case 3 :
                System.out.println("Number : " + number);
                break;
            default :
                System.out.println("No number found!");
        }

        // calculator :
        System.out.println("Enter a : ");
        int a = s.nextInt();
        System.out.println("Enter b : ");
        int b = s.nextInt();
        System.out.println("Enter operator : ");
        char operator = s.next().charAt(0); // so that only the operation entered first is choosed 

        switch (operator) {
            case '+' : System.out.println(a+b);
                        break;
            case '-' : System.out.println(a-b);
                        break;
            case '*' : System.out.println(a*b);
                        break;
            case '/' : System.out.println(a/b);
                        break;
            case '%' : System.out.println(a%b);
                        break;
            default : System.out.println("Wrong Operator entered! Try again");
        }
    }
}

