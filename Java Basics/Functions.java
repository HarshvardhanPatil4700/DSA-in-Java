import java.util.Scanner;
public class Functions {
    // function to print hello world 
    public static void printHelloWorld() { // void eans it must not have return statement and it is static so it can be executed without creating object
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");
    }

    public static void calculateSum(int num1, int num2) {        
        int sum = num1 + num2;
        System.out.println("Sum is : " + sum);
    }

    public static int calculateSum1(int num3, int num4) {        
        int sum1 = num3 + num4;
        return sum1;
    }

    // check if number is Prime or not
    // corner cases (these are cases for which logic is defined seperately)
    public static boolean isPrime(int n){
        if(n == 0 || n == 1){ // corner case
            return false;
        }
        if (n == 2){ // corner case
        return true;
        }      
        for(int i =2; i<=Math.sqrt(n); i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    // Print all the prime nos. in range
    public static void primesInRange(int n1, int n2){
        for(int i =n1; i<=n2; i++){
            if(isPrime(i)){
                System.out.print(i + " ");
            }
            
        }
        System.out.println();
    }

    public static void main(String[] args) { // this is also a function named 'main' which is vid data type and takes 'String[] args' as input
        printHelloWorld(); // function call to printHelloWorld() function  
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = s.nextInt();
        System.out.print("Enter b: ");
        int b = s.nextInt();
        
        calculateSum(a, b); // the function with void just need to be call as it has syso() in function itself
        int sum1 = calculateSum1(a, b); // the function with return statement must be displayed with syso() as it does not have a syso() in the function
        System.out.println("Sum by sum1 : " + sum1);
        // NOTE: the sum1 variable declared above(in main function) and the sum1 (in the calculateSum1 funct.) are different       
        
        // Prime no. 
        System.out.println(isPrime(5));
        System.out.println(isPrime(12));
        System.out.println(isPrime(2));
        System.out.println(isPrime(1));

        // Print all the prime nos. in range
        primesInRange(0, 20); 
        primesInRange(5, 100); 
    }
}
