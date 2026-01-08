public class VariablesInJava {
    public static void main(String[] args) {
        // Variable declarations :
        int a1 =10;
        char abc = 'A';
        float f = 5.5f;
        double d = 91.1;
        boolean b1 = true;

        // Getting / printing the value of variable :
        int a = 10;
        int b = 20;
        int c = 50;
        String name = "Jack";
        System.out.println("a"); // Note: this will print the String present in paranthesis "a" and not the value of variable a
        System.out.println(a);
        System.out.println(b);
        System.out.println(name);

        a = 30;
        b = c;
        System.out.println(a);
        System.out.println(b);
    }
}
