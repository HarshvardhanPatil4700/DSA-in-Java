public class BinaryToDecimal {
    // Binary to Decimal
    public static void binToDec(int binNum){
        int myNum = binNum;
        int p = 0;
        int decNum = 0;

        while(binNum > 0) {
            int lastDigit = binNum % 10;
            decNum = decNum + (lastDigit * (int)Math.pow(2,p));
            p++;
            binNum = binNum / 10;
        }
        System.out.println("Decimal of " + myNum + " = " + decNum);
    }

    // Decimal to Binary
    public static void decToBin(int n){
        int myNum1 = n;
        int po = 0;
        int binaryNum = 0;

        while(n > 0){ 
            int rem = n % 2;
            binaryNum = binaryNum + (rem * (int)Math.pow(10, po));
            po++;
            n = n / 2;
        }
        System.out.println("Binary of " + myNum1 + " = " + binaryNum);
    }
    public static void main(String[] args) {
        // Binary to Decimal
        binToDec(101);
        binToDec(1001);

        // Decimal to Binary
        decToBin(5);        
        decToBin(10);        
        decToBin(15);        
    }
}
