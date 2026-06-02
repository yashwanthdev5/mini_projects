import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {

    }
}

class Student {
    private int id;
    private String name;
    private int marks;

    public void setId(int id) {
         this.id=id;
    }

    public void setName(String name) {
          this.name=name;
    }

    public void setMarks(int marks) {
         this.marks=marks;
    }
    public int getId()
    {
       return id;   
    }
    public String getName()
    {
        return name;
    }
    public int getMarks()
    {
        return marks;
    }
    public void display()
    {
        System.out.println("Student  Id : "+id);
        System.out.println("Student  Name : "+name);
        System.out.println("Student  Marks : "+marks);
    }
}
