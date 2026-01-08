public class Scope {
    public static int sum(int a, int b){
        // 1. Function Scope
        System.out.println("Hello world");
        // System.out.println(s); error: 's' cannot be accessed here as it is out of scope of 's'
        a = a + 10;
        int s = a+b;
        System.out.println("Thank you");
        return s;
    }

    // 2. Block scope
    int p = 12;
    {
        System.out.println("hello w");
        // n = n + 5; scope starts after line of declaration 
        int n = 45;
        System.out.println(n);
        System.out.println(p);  // accessible as p is declared in the bloack (main() function)
    } 
    public static void main(String[] args) {
        // 1. Function Scope
        System.out.println(sum(5,10));
        // System.out.println(s); error : 's' cannot be accessed here as it is out of scope of 's'

        // 2. Block scope
        // System.out.println(n); cannot access as it is out of scope (block)
        for (int i = 0; i <= 3; i++) {
            System.out.println("Java");
        }
        // System.out.println(i); cannot access as it is out of scope (block) 

    }
}
