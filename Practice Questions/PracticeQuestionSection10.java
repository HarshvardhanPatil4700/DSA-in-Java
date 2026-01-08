import java.util.Scanner;
public class PracticeQuestionSection10 {
    public static void main(String[] args) {
        // 1.
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int num = s.nextInt();
        String number = num >= 0 ? "Positive" : "Negative";
        System.out.println(number);

        // 2.
        double temp = 103.5;
        String feverCheck = temp > 100 ? "You have Fever" : "You dont have Fever";
        System.out.println(feverCheck + " temperature = " + temp + "F");

        // 3.
        System.out.println("Enter a number for weekdays (1-7) : ");
        int weekDay = s.nextInt();
        switch(weekDay){
            case 1 : System.out.println("Monday"); break;
            case 2 : System.out.println("Tuesday"); break;
            case 3 : System.out.println("Wednesday"); break;
            case 4 : System.out.println("Thursday"); break;
            case 5 : System.out.println("Friday"); break;
            case 6 : System.out.println("Saturday"); break;
            case 7 : System.out.println("Sunday"); break;
            default : System.out.println("Wrong input! Enter a number between 1 to 7");        
        }

        // 5.
        System.out.println("Enter year : ");
        int year = s.nextInt();
        boolean x = year % 4 == 0;
        boolean y = year % 100 != 0;
        boolean z = (year % 100 == 0) && (year % 400 == 0);

        if (x && (y || z)) {
            System.out.println(year + " is a leap year");
        } else {
            System.out.println(year + " is not a leap year");
        }
    }
}
