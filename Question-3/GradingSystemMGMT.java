import Grading.Student;
import Grading.GradingSystem;
import Grading.Grade;

import java.util.Scanner;

public class GradingSystemMGMT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter total number of students:");
        int totalStudents = scan.nextInt();

        scan.nextLine();

        System.out.println("Enter the number of grades:");
        int totalGrades = scan.nextInt();

        scan.nextLine();

        GradingSystem g = new GradingSystem(totalStudents, totalGrades);
        while (true) {
            System.out.println("1. To add grade of student.");
            System.out.println("2. To calculate CGPA.");
            System.out.println("3. Print the report.");
            System.out.println("4. Exit.");

            System.out.println("Enter your choice:");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter student ID:");
                    int studentID = scan.nextInt();
                    scan.nextLine();

                    System.out.println("Enter the name of the Student:");
                    String name = scan.nextLine();

                    System.out.println("Enter course ID:");
                    int courseID = scan.nextInt();

                    scan.nextLine();

                    System.out.println("Enter grade (A, B, C, D, E, F):");
                    char grade = scan.next().charAt(0);

                    Student newStudent = new Student(studentID, name);
                    Grade newGrade = new Grade(studentID, courseID, grade);
                    g.addStudent(newStudent);
                    g.addGrade(newGrade);
                    break;
                case 2:
                    System.out.println("Enter student ID:");
                    int sid = scan.nextInt();
                    double cgpa = g.calculateCGPA(sid);
                    System.out.println("The CGPA for student ID " + sid + " is: " + cgpa);
                    break;
                case 3:
                    System.out.println("Enter student ID:");
                    int reportStudentID = scan.nextInt();
                    g.printStudentReport(reportStudentID);
                    break;
                case 4:
                    scan.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}
