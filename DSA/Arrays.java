import java.util.Scanner;
public class Arrays {
    public static void main(String[] args) {
        // Type of declarations (Creating of Arrays) : 
        // 1.
        int Marks[] = new int [5]; //Creates an empty array of size 5.The size can't changed during run time as array is static
        // int []Marks = new int [5];  NOTE :- []arrName , arrName[] both are allowed 

        // 2.
        int numbers[] = {1,2,3,4,5};
        int moreNumbers[] = {10,20,30,40,50};
        String fruits[] = {"apples","oranges","pineapples","watermelons"};

        // 3.
        int alphabets[];
        alphabets = new int [5];    

        // Array input/output
        int marks[] = new int[100]; 
        Scanner s = new Scanner(System.in);
        System.out.print("Enter your marks : ");
        marks[0] = s.nextInt();
        marks[1] = s.nextInt();
        marks[2] = s.nextInt();

        // we can also update the data of array as : Let us assume 1 question was wrong in maths paper so 1 bonus mark
        marks[2] += 1; // marks[2] = marks[2] + 1

        System.out.println("Physics : " + marks[0]);
        System.out.println("Chemistry : " + marks[1]);
        System.out.println("Maths : " + marks[2]);

        double percentage = ((marks[0] + marks[1] + marks[2]) / 3);
        System.out.println("Percentage = " + percentage);        

        // Length of array : 
        System.out.println("Length of array = " + marks.length); // 100 bcoz we initialised array with size as 100
        System.out.println(numbers.length);
        System.out.println(fruits.length);

        // Passing arrays as argument :
        int scores[] = {91,97,92,98};
        int n = 10;
        System.out.print("Marks before update = ");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        updateScoreby1(scores);
        System.out.print("\nMarks after update = ");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.print("\n" + n); //We can see: n(int) even after calling update does not changes Bcoz int is passed by PASS BY VALUE due to which its copy is passed and changed.The changes does not reflect outside function but array is passed by PASS BY REFERENCE due to which actual array is passed and changed.The changes reflect even outside function
        
    }
    public static void updateScoreby1(int scores[]){
        int n =20; // Changing value of int data type to 20
        for(int i=0; i<scores.length; i++){  // (not i<=scores.length bcoz length is one greater than last index)
            scores[i] += 1;
        }
    }
}