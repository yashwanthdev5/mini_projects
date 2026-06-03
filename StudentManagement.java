import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        // creating scanner object ...
        Scanner sc = new Scanner(System.in);
        // !!! --ARRAY OF OBJECT (USED TO ACCESS OBJECTS USING ARRAYS)
        Student[] students = new Student[100];
        int id;
        String name;
        int marks;
        int count = 0;
        int accessing_while;
        boolean found;
        System.out.println("---------STUDENT MANAGEMENT SYSTEM---------");
        do {
            System.out.println("LIST OF OPERATION :");
            System.out.println("ENTER 1 TO ADD STUDENT ");
            System.out.println("ENTER 2 TO ALL DISPLAY STUDENTS ");
            System.out.println("ENTER 3 TO SEARCH STUDENT BY ID ");
            System.out.println("ENTER 4 TO UPDATE STUDENT DETAILS ");
            System.out.println("ENTER 5 TO DELETE STUDENT ");
            int expression = sc.nextInt();
            // try {

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
                    id = sc.nextInt();
                    s.setId(id);
                    // string should be string
                    sc.nextLine(); // clear newline left by nextInt()
                    while (true) {
                        System.out.println("enter the name of the student :");
                        name = sc.nextLine();
                        if (name.matches("[a-zA-z ]+")) {
                            break;
                        }
                        // validation
                        System.out.println("Alhabets only allowed !!!!");

                    }
                    s.setName(name);
                    while (true) {
                        System.out.println("enter the Marks of the student :");
                        marks = sc.nextInt();
                        if (marks >= 0 && marks <= 100) {
                            break;
                        }
                        // validation
                        System.out.println("Marks should from 0 to 100 only!!");
                    }
                    s.setMarks(marks);
                    boolean idExists = false;

                    for (int i = 0; i < count; i++) {
                        if (students[i].getId() == id) {
                            idExists = true;
                            break;
                        }
                    }
                    if (idExists) {
                        System.out.println("ID already exists!");
                        System.out.println("Student not addded !");
                    } else {
                        students[count] = s;
                        count++;

                        System.out.println("Student added successfully");
                        s.display();
                    }

                    break;
                case 2:
                    // Displaying all the students ....
                    System.out.println("Displaying All Students :");
                    if (count > 0) {

                        for (int i = 0; i < count; i++) {
                            System.out.println(" STUDENT " + (i + 1) + " DETAILS ARE :");
                            students[i].display();
                        }
                        System.out.println("Total count of students is :" + count);
                    } else {
                        System.out.println("--No students are added--");
                    }

                    break;
                case 3:
                    found = false;
                    // linear search ...
                    System.out.println("ENTER THE STUDENT ID YOU WANT SEARCH :");
                    id = sc.nextInt();

                    for (int i = 0; i < count; i++) {
                        if (students[i].getId() == id) {
                            students[i].display();
                            found = true;
                        }

                    }
                    // use of flag bit
                    if (!found) {
                        System.out.println("Student with " + id + " is not present!!");
                    }

                    break;
                case 4:
                    found = false;
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
                                    System.out.println("-----The name is updated Successfully----");
                                    break;
                                case 2:
                                    System.out.println("Enter the Marks you want to update ");
                                    int newMarks = sc.nextInt();
                                    students[i].setMarks(newMarks);
                                    System.out.println("-------The marks is updated Sucessfully------- ");
                                    break;
                                default:
                                    System.out.println("error!!!");
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
                    found = false;
                    // Deleting student
                    System.out.println("ENTER THE STUDENT ID YOU WANT DELETE :");
                    id = sc.nextInt();

                    for (int i = 0; i < count; i++) {
                        if (students[i].getId() == id) {
                            // id found then we have delete and update indexes of next elements of array
                            for (int j = i; j < count - 1; j++) {
                                students[j] = students[j + 1];
                            }
                            // we deleting student so count will get decreased..
                            count--;
                            found = true;
                            System.out.println("-----------Deleted Sucessfully--------");
                        }
                        if (!found) {
                            System.out.println("Student with " + id + " is not present!!");
                        }
                    }

                    break;

                default:

                    System.out.println("Enter the operation mentioned Above  !!");
                    break;
            }
            // } catch (Exception e) {
            // System.out.println(e);
            // }
            System.out.println("Do you want to do use operations again : press 1 to CONTINUE || press 0 to STOP!!!");
            accessing_while = sc.nextInt();
        } while (accessing_while == 1);
        sc.close();
    }
}

class Student {

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
        System.out.println("Id : " + id);
        System.out.println("Name : " + name);
        System.out.println("Marks : " + marks);
    }
}
