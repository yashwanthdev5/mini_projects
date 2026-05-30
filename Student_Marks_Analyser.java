
import java.util.Scanner;

public class Student_Marks_Analyser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        calculations c = new calculations();
        // asking for the number of students..
        System.out.println("Enter the number of students :");
        // Taking user input..
        int students = sc.nextInt();
        // created an array of marks
        int marks[] = new int[students];
        System.out.println("Enter the marks of the students :");
        for (int i = 0; i < marks.length; i++) {
            // Taking user input for the marks..
            System.out.println("enter the marks of student " + (i + 1) + " ");
            marks[i] = sc.nextInt();
        }
        // report
        // using method to return or calculate average/highest/lowest
        int average = c.average(marks);
        int highest = c.highest(marks);
        int lowest = c.lowest(marks);
        System.out.println("-----------[The Report of The Student Marks]-----------------");
        System.out.println("---[The Marks of the Students]--");
        for (int i = 0; i < marks.length; i++) {
            System.out.println(marks[i]);
        }
        System.out.println("The Average of all the Student marks is : " + average);
        System.out.println("The Highest  marks scored :" + highest);
        System.out.println("The Lowest marks scored :" + lowest);
        sc.close();
    }
}

class calculations {
    int average(int marks[]) {
        int sum = 0;
        // calculating the sum of the marks..
        for (int i = 0; i < marks.length; i++) {
            sum = sum + marks[i];
        }
        // calculating the average of the of the marks..
        int average = sum / marks.length;
        return average;
    }

    int highest(int marks[]) {
        int highest = 0;
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] > highest) {
                highest = marks[i];
            }
        }
        return highest;
    }

    int lowest(int marks[]) {
        int lowest = marks[0];
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < lowest) {
                lowest = marks[i];
            }
        }
        return lowest;
    }

}
