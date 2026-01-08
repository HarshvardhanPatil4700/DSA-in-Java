public class NestedLoopsPatterns1 {
    public static void main(String[] args) {
        // Half Pyramid Star Pattern Logic :- no. of stars in a line is equal to the index (number) of the line
        int nl = 5; // no. of lines the stars are to be printed
        for(int line = 1; line <= nl;line++){
            for (int star =1; star <= line; star++){
                System.out.print("*" + " ");
            }
            System.out.println(); // after printing stars on single line shift to next line
        }

        System.out.println();
        
        // Inverted Half Pyramid star pattern logic:As lines increases the no. of stars in line decreases. 
        int n = 5;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j<=(n-i+1);j++){ // Stars at each line = n-i+1 ... where n = no. of lines
                System.out.print("*" + " ");
            }
            System.out.println();
        }

        System.out.println();

        // Half Pyramid pattern logic: the Inner loop will run the number of line times
        int x = 5;
        for(int I = 1; I<=x; I++){
            for(int J = 1; J<=I;J++){
                System.out.print(J + " ");
            }
            System.out.println();
        }

        System.out.println();

        // Character pattern
        int y = 5;
        char ch = 'A';
        for(int M = 1; M<=y; M++) {
            for (int N = 1; N<=M ; N++) {
                System.out.print(ch + " ");
                ch++; // converts char to int and increments it which makes it as 'B' and so on
            }
            System.out.println();
        }

    }
}
