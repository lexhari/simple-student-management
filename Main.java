// CARDENAS, Alexis Harriet G.

import java.util.Scanner;

// Enum for year in college
enum Year { FRESH, SOPH, JUNIOR, SENIOR }

// Enum for support type
enum Support { TA, RA, FELLOWSHIP, OTHER }

class Student {
    protected int studentId;
    protected float gpa;
    protected String name;
    protected String college;
    protected Year year;
    protected String major;

    // Constructors
    public Student() {
        this.studentId = 0;
        this.gpa = 0.0f;
        this.name = "";
        this.college = "";
        this.year = Year.FRESH;
        this.major = "";
    }

    public Student(int id, float g) {
        this.studentId = id;
        this.gpa = g;
        this.name = "";
        this.college = "";
        this.year = Year.FRESH;
        this.major = "";
    }

    public void read() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        this.studentId = scanner.nextInt();

        System.out.print("Enter GPA: ");
        this.gpa = scanner.nextFloat();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        this.name = scanner.nextLine();

        System.out.print("Enter College: ");
        this.college = scanner.nextLine();

        System.out.print("Enter Year (FRESH, SOPH, JUNIOR, SENIOR): ");
        String yearInput = scanner.nextLine();
        this.year = Year.valueOf(yearInput.toUpperCase());

        System.out.print("Enter Major: ");
        this.major = scanner.nextLine();
    }
    
    public void print() {
        System.out.println("\n----- Student Information -----");
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("GPA: " + gpa);
        System.out.println("College: " + college);
        System.out.println("Year: " + year);
        System.out.println("Major: " + major);
        System.out.println("--------------------------------\n");
    }
}

// GradStudent class that inherits from Student
class GradStudent extends Student {
    private Support support;
    private String dept;
    private String thesis;

    // Constructors
    public GradStudent() {
        super();
        this.support = Support.TA;
        this.dept = "";
        this.thesis = "";
    }

    public GradStudent(Support support, int id, float g) {
        super(id, g);
        this.support = support;
        this.dept = "";
        this.thesis = "";
    }

    @Override 
    public void read() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        this.studentId = scanner.nextInt();

        System.out.print("Enter GPA: ");
        this.gpa = scanner.nextFloat();
        scanner.nextLine(); 

        System.out.print("Enter Name: ");
        this.name = scanner.nextLine();

        System.out.print("Enter College: ");
        this.college = scanner.nextLine();

        System.out.print("Enter Year (FRESH, SOPH, JUNIOR, SENIOR): ");
        String yearInput = scanner.nextLine();
        this.year = Year.valueOf(yearInput.toUpperCase());

        System.out.print("Enter Major: ");
        this.major = scanner.nextLine();

        System.out.print("Enter Support Type (TA, RA, FELLOWSHIP, OTHER): ");
        String supportInput = scanner.nextLine();
        this.support = Support.valueOf(supportInput.toUpperCase());

        System.out.print("Enter Department: ");
        this.dept = scanner.nextLine();

        System.out.print("Enter Thesis: ");
        this.thesis = scanner.nextLine();
    }


    @Override
    public void print() {
        System.out.println("\n----- Graduate Student Information -----");
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("GPA: " + gpa);
        System.out.println("College: " + college);
        System.out.println("Year: " + year);
        System.out.println("Major: " + major);
        System.out.println("Support Type: " + support);
        System.out.println("Department: " + dept);
        System.out.println("Thesis: " + thesis);
        System.out.println("----------------------------------------\n");
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.read();  
        student.print(); // Student details

        // instance of GradStudent
        GradStudent gradStudent = new GradStudent();
        gradStudent.read(); 
        gradStudent.print(); // GradStudent details

        // inheritance and polymorphism example
        Student gradStudentPoly = new GradStudent();
        gradStudentPoly.read();  // overridden read() from GradStudent
        gradStudentPoly.print(); // overridden print() from GradStudent
    }
}
