import java.util.Scanner;
public class Loops {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        // Loops :
        // 1. while loop
        int Counter = 0;  // initialization
        while (Counter <= 5){  // condition
            System.out.println("Hello World");
            Counter++;  // increment / decrement
        }
        System.out.println("Thank you"); // this is executed as the while loop execution completes
        // at counter = 6, the while condition (counter <= 5) is FALSE and so compiler exits the while loop 

        // Infinite loop : here, condition never becomes false so it runs infinitely
        // while (true){
        //     System.out.println("Hello World is the new ABC 🧑‍💻");            
        // }

        // Print nos. from 1 to 10
        int num = 1;
        while (num <= 10){
            System.out.print(num + " ");
            num++;            
        }
        System.out.println();

        // print num from 1 to n:
        int counter = 1;
        System.out.print("Enter Range of numbers : ");
        int range = s.nextInt();
        while (counter <= range){ 
            System.out.print(counter + " ");
            counter++;
        }
        System.out.println();

        // Sum of first n natural nos.
        int sum = 0;
        System.out.print("How many first natural numbers sum do u need ? ");
        int n2 = s.nextInt();
        int i1 = 1;
        while (i1 <= n2) {
            sum += i1; // sum = sum + i;
            i1++;
        }
        System.out.println(sum);

        // 2. for loop
        for (int i = 1; i <= 7; i++) {
            System.out.println(i + ". " + "Hello World");
        }

        // if initialization of counter iterator is done outside the for loop :
        int i =1;
        for( ; i < 4 ; i++){ // i.e we skip the part of initialisation for counter iterator
            System.out.println("Back to Basics");
        }

        // Print square pattern 
        // for(int I = 1; I <= 4; I++) {
        //     for (int j = 1; j <= 4; j++){
        //         System.out.print("*" + " ");
        //     }
        //     System.out.println();
        // } 
        // Or can also be done as :
        for(int i2 = 1; i2<=4;i2++){
            System.out.println("* * * *");
        }

        // Print reverse of a number :
        int n = 1098341739;
        while (n > 0){
            int lastDigit = n % 10;
            System.out.print(lastDigit + " ");
            n = n / 10;
        }
        System.out.println();

        // Reverse a given number : above we reversed the value here we are reversing the number itself
        int n1 = 1473948;
        System.out.println("Original number: "+ n1);
        int rev =0;
        while (n1 > 0) {
            int lastDigit1 = n1 % 10;
            rev = (rev*10) + lastDigit1;
            n1 = n1 / 10;
        }
        System.out.println("Reversed number: "+ rev);

        // 3. do-while statement
        int iter = 1;
        do {
            System.out.println("Hello World!");
            iter++;
        } while (iter <= 5);

        // even if the condition is false it atleast execute one iteration of do block as it does the 1 iteration and then check the condition
        int iter1 = 1;
        do {
            System.out.println(iter1 + "st iteration");
            iter1++;
        } while(false);
    }
}

