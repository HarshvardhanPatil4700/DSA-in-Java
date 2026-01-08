public class FunctionOverloading {
    // with no. of Parameters
    // func to calculate sum of 2 nos.
    public static int sum (int a, int b){
        return a+b;
    }
    // func to calculate sum of 3 nos.
    public static int sum (int a, int b, int c){
        return a+b+c;
    }

    // with data type of Parameters
    // func to calculate sum of 2 int nos.
    public static int add(int A,int B) {
        return A+B;
    }
    // func to calculate sum of 2 float nos.
    public static float add(float A, float B) {
        return A+B;
    }

    // with order of parameters
    // func to calculate sum of 2 int nos. and one char
    public static int sum1(int x, int y, char ch){
        return x+y+ch;
    }
    // func to calculate sum of 2 int nos. and one char (changing the order of parameters)
    public static int sum1(int x,char ch, int y ){
        return x+y+ch+5;
    }
    public static void main(String[] args) {
        // with no. of Parameters
        System.out.println(sum(3,4)); 
        System.out.println(sum(2,3,6));

        // with data type of Parameters
        System.out.println(add(5,10));
        System.out.println(add(5.5f,10.5f));

        // with order of parameters
        System.out.println(sum1(5, 10, 'A'));
        System.out.println(sum1(5, 'A', 10)); 
    }
}
