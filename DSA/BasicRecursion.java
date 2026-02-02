// Recursion is when a method calls itself to solve a problem by breaking it into smaller subproblems.Basicaaly, it calls itself until a specific condition is met

// class basicRecursion {
class recursion{
    public void a() {
        System.out.println(1);
        a();
    }

    // public void printName(int i) {
    //     if(i == 0) 
    //         return;
    //     printName(i-1);
    //     System.out.print("abc" + " ");
    // }
    public void printName(int i, int n) { // TC = O(N), SC = O(N) as N function wait in stack while recursion
        if(i > n) 
            return;
        printName(i+1,n);
        System.out.print("abc ");
    }

    // public void printNums(int n) {
    //     if (n == 0)   // base condition : 
    //         return;   
    //     printNums(n - 1);   // recursive call
    //     System.out.print(n + " ");
    // }
    public void printNums(int i, int n) {
        if(i>n)
            return;
        System.out.print(i + " ");
        printNums(i+1, n);

        // for Reverse Numbers : 10,9,8,7,...
        // if(i>n)
        //     return;
        // System.out.print(n + " ");
        // printRevNums(i, n-1);
    }
    public void printRevNums(int i, int n) { // N -> 1
        if(i<1)
            return;
        System.out.print(i + " ");
        printRevNums(i-1, n);
    }

    // Recursion using backtracking : It is a problem-solving approach where a recursive function explores all possible choices, and after exploring each choice, it “undoes” the choice to try other possibilities.
    public void printNums1(int i, int n) {
        if(i<1) {
            return;
        }
        printNums1(i-1, n);
        System.out.print(i + " ");
    }
    public void printRevNums1(int i, int n) {
        if(i<1) {
            return;
        }
        printRevNums1(i-1, n+1);
        System.out.print(n + " ");
    }
}
public class BasicRecursion {
    public static void main(String[] args) {
        recursion r = new recursion();
        // r.a(); Inifite Recursion - causes stack overflow and gives Exception in thread "main" java.lang.StackOverflowError
        r.printNums(1,10); 
        System.out.println();
        r.printRevNums(5,1); 
        System.out.println();
        // r.printName(3);   
        r.printName(1,3); 
        System.out.println();
        r.printNums1(5,1); // recursion using backtracking  
        System.out.println();
        r.printRevNums1(5,1); // recursion using backtracking
    }
}
