public class TypeCasting {
    public static void main(String[] args) {
        float a = 25.5f;
        // int b = a; ERROR
        int b = (int) a;
        System.out.println(b);

        char ch1 ='a';
        int i1 = ch1;
        char ch2 = 'A';
        int i2 = ch2;
        System.out.println("a : " + i1);
        System.out.println("A : " + i2);

        // TYPE PROMOTION IN EXPRESSION :
        char x = 'a';
        char y = 'b';
        // char c = x-y; the int value of x-y i.e -1 to char is incompatible data conversion
        System.out.println((int)(x));
        System.out.println((int)(y));
        System.out.println(y-x); // the chars are converted to int due to - sign and are evaluated => 98-97 = 1

        // Rule 1:
        short m = 5;
        byte n = 25;
        char o = 'c';
        // byte sum = m+n+o; error : the + sign converts every data type to int and int cannot be converted to byte (data loss)
        byte sum = (byte) (m+n+o);
        System.out.println(sum);

        // Rule 2 :
        int g =10;
        float f = 20.25f;
        long h = 25;
        double d = 30;
        // int ans = g+f+h+d; error : conversion of double to int causes data loss
        double ans  = g+f+h+d; // converts the data type of g,f,h to double as it is largest data type present in expression
        System.out.println(ans);

        // problem cases :
        byte b1 =5;
        // byte a1 = b1*2; 
        // System.out.println(a1); incompatible types: possible lossy conversion from int to byte [the * sign converts byte to int and so int to byte may have a data loss so java gives an error]
        byte a1 = (byte) (b1*2);
        System.out.println(a1);

    }
}
