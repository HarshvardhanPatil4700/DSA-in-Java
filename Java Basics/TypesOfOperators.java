public class TypesOfOperators {
    public static void main(String[] args) {
        // 1. Arithematic operators
        // 1.1 Binary Operators
        int a = 10;
        int b =5;
        System.out.println("Add = " + (a+b));
        System.out.println("Subtract = " + (a-b));
        System.out.println("Multiplication = " + (a*b));
        System.out.println("Divide = " + (a/b));
        System.out.println("Modulo(Remainder) = " + (a%b));

        // 1.2 Unary operators
        // Pre-increment (++a)
        int A = 10;
        System.out.println("Before inc. " + A);
        int B = ++A;        
        System.out.println("After inc. " + A);
        System.out.println(B);

        // Post-increment (a++)
        int A1 = 10;
        int B1 = A1++;
        System.out.println(A1);
        System.out.println(B1);

        // Pre-decrement (--a)
        int x = 10;
        int y = --x;
        System.out.println(x);
        System.out.println(y);

        // Post-decrement (a--)
        int x1 = 10;
        int y1 = x1--; // y1 = 10, but decrements the value of x1 by 1 in memory
        System.out.println(x1);
        System.out.println(y1);       
        
        // 2. Relational operators : they always return a boolean value
        // 2.1 == (Equals)
        int m = 10;
        int n =5;
        int o = 10;
        System.out.println(m == n);
        System.out.println(m == o);

        // 2.2 != (not equal to)
        System.out.println(m != n);
        System.out.println(m != o);

        // 2.3 > (greater than)
        System.out.println(m>n);
        System.out.println(n>m);
        System.out.println(m>o); // false as they both are equal

        // 2.4 < (lesser than)
        System.out.println(m<n);
        System.out.println(n<m);
        System.out.println(m<o); // false as they both are equal

        // 2.5 >= (greater than or equal to)
        System.out.println(m >= n);
        System.out.println(n >= m);
        System.out.println(m >= o);

        // 2.6 <= (lesser than or equal to)
        System.out.println(m <= n);
        System.out.println(n <= m);
        System.out.println(m <= o);

        // 3. Relational operators :
        // 3.1 && (logical AND) [multiplication]
        boolean b1 = true;
        boolean b2 = false;
        boolean b3 = true;
        boolean b4 = false;
        System.out.println(b1 && b2);
        System.out.println(b1 && b3);
        System.out.println((3>2) && (5<10));
        System.out.println((3<2) && (5<10));

        // 3.2 || (logical OR) [addition]
        System.out.println(b1 || b2);
        System.out.println(b1 || b3);
        System.out.println(b2 || b4);
        System.out.println((3>2) || (5<10));
        System.out.println((3<2) || (5<10));
        System.out.println((3<2) || (5>10)); // both are false

        // 3.3 ! (logical NOT) [inverts value]
        System.out.println(! b1);
        System.out.println(! b2);
        System.out.println(! (6>2));
        System.out.println(! (6<2));

        // 4. Assignment opertaors: 
        // 4.1  = (Assignment) 
        int k1 = 100;
        int sum = a+b;

        // 4.2 += 
        int k = 20;
        int l = 10;
        k += 5; // (or) k = k + 5;
        System.out.println(k);
        k += l; // k = k + l;
        System.out.println(k);

        // 4.3 -=
        int r = 20;
        int s = 10;
        r -= 5; // r = r - 5;
        System.out.println(r);
        r -= s; // r = r - s; 
        System.out.println(r);

        // 4.4 *=
        int t = 10;
        int u = 5;
        t *= 10; // t = t*10
        System.out.println(t);
        t *= u;
        System.out.println(t);

        // 4.5 /= 
        int w = 100;
        int v = 5;
        w /= 10; // w = w / 10
        System.out.println(w);
        w /= v; // w = w/v
        System.out.println(w);

        // %=
        int num = 100;
        int n1 = 10;
        num %= n1; // num = num % n1
        System.out.println(num);
    }
}
