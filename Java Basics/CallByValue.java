public class CallByValue {
    // Call by value :
    // swap 2 nos.
    public static void swap(int x, int y){
        System.out.println("Before Swap : " + x + " " + y); // copy of variables 'x' and 'y' is passed so the changes made in this function will not be the same outside function(i.e inside function x=10,y=5) but outside function x=5,y=10 
        int temp = x;
        x = y;
        y = temp; 
        System.out.println("After Swap : " + x + " " + y);
    }

    // product of 2 nos.
    public static int multiply(int a, int b) {
        int p = a*b;
        return p;
    }

    // factorial of a number
    public static int factorial(int n) {
        int facto = 1; 
        for(int i = 1; i<=n; i++){
            facto *= i;
        }        
        return facto;
    }

    // Binomial coefficient using factorial function:
    public static int binomialCoefficient(int N,int r){
        int nFactorial = factorial(N);  //calling another function(factorial()) in a function(BinomialCoefficient(N, r))
        int rFactorial = factorial(r);
        int nrFactorial = factorial(N-r);

        int binoC = nFactorial / (rFactorial * nrFactorial);
        return binoC;
    } 

    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        swap (x,y);
        System.out.println("Outside function "+ x + " " + y);

        int product = multiply(x,y); // copy of x and y will be passed to multiply function
        System.out.println("Product : " + product);
        product = multiply(5,8);
        System.out.println("Product : " + product);   
        System.out.println(multiply(2, 4));

        // int fact = factorial(5);
        System.out.println(factorial(5));
        System.out.println(factorial(7));

        // Binomial coefficient
        System.out.println(binomialCoefficient(5, 2));
        System.out.println(binomialCoefficient(10, 3));
    }
}
