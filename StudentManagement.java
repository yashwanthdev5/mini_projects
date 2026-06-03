import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        // creating scanner object ...
        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[100];
        int count = 0;
        int accessing_while;
        boolean found = false;
        do {
            System.out.println("ENTER 1 TO ADD STUDENT ");
            System.out.println("ENTER 2 TO ALL DISPLAY STUDENTS ");
            System.out.println("ENTER 3 TO SEARCH STUDENT BY ID ");
            System.out.println("ENTER 4 TO UPDATE STUDENT DETAILS ");
            System.out.println("ENTER 5 TO DELETE STUDENT ");
            int expression = sc.nextInt();
            try {

                switch (expression) {
                    case 1:
                        // adding the students ...
                        // creating object inside switch because where we want add
                        // add new Student the object should be updated
                        // example : students[0]=s
                        // entering second student students[1]=s//but here s acts as s1 ..
                        Student s = new Student();
                        // user Input
                        System.out.println("enter the id of the student :");
                        int id = sc.nextInt();
                        System.out.println("enter the name of the student :");
                        String name = sc.next();
                        System.out.println("enter the Marks of the student :");
                        int marks = sc.nextInt();
                        // setting private variables
                        s.setId(id);
                        s.setName(name);
                        s.setMarks(marks);
                        students[count] = s;
                        // increasing count useful for adding new student
                        count++;

                        break;
                    case 2:
                        // Displaying all the students ....
                        System.out.println("Displaying All Students :");
                        for (int i = 0; i < count; i++) {
                            System.out.println(" STUDENT " + (i + 1) + " DETAILS ARE :");
                            students[i].display();
                        }
                        System.out.println("Total count of students is :" + count);

                        break;
                    case 3:
                        // linear search ...
                        System.out.println("ENTER THE STUDENT ID YOU WANT SEARCH :");
                        id = sc.nextInt();

                        for (int i = 0; i < count; i++) {
                            if (students[i].getId() == id) {
                                students[i].display();
                                found = true;
                            }
                            if (!found) {
                                System.out.println("Student with " + id + " is not present!!");
                            }
                        }

                        break;
                    case 4:
                        // updating student
                        System.out.println("ENTER THE STUDENT ID YOU WANT UPDATE :");
                        id = sc.nextInt();

                        for (int i = 0; i < count; i++) {
                            if (students[i].getId() == id) {
                                System.out.println("what do you want to update :");
                                System.out.println("Enter 1 for --> NAME");
                                System.out.println("Enter 2 for --> Marks");
                                int value1 = sc.nextInt();
                                switch (value1) {
                                    case 1:
                                        System.out.println("Enter the name you want to update ");
                                        String newName = sc.next();
                                        students[i].setName(newName);
                                        System.out.println("The name is updated to " + students[i].getName());
                                        break;
                                    case 2:
                                        System.out.println("Enter the Marks you want to update ");
                                        int newMarks = sc.nextInt();
                                        students[i].setMarks(newMarks);
                                        System.out.println("The marks is updated to " + students[i].getMarks());
                                        break;
                                    default:
                                        break;
                                }
                                found = true;
                            }
                            if (!found) {
                                System.out.println("Student with " + id + " is not present!!");
                            }
                        }

                        break;
                    case 5:
                        // Deleting student

                        break;

                    default:

                        System.out.println("Error !!");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Do you want to do operations again : press 1 to CONTINUE || press 0 to STOP!!!");
            accessing_while = sc.nextInt();
        } while (accessing_while == 1);
        sc.close();
    }
}

class Student {
    Scanner sc = new Scanner(System.in);
    // using privare variable for Data security
    private int id;
    private String name;
    private int marks;

    // setters and getters for accessing them..
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    // creating display method
    public void display() {
        System.out.println("Student  Id : " + id);
        System.out.println("Student  Name : " + name);
        System.out.println("Student  Marks : " + marks);
    }
}
