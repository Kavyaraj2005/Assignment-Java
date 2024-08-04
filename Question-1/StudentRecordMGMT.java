import java.util.Scanner;
import Record.Student;
import Record.StudentRecordSystem;

public class StudentRecordMGMT {
    public static void main(String[] args) {
        StudentRecordSystem s = new StudentRecordSystem();
        Scanner scan = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. To add new student data.");
            System.out.println("2. To search student based on student id.");
            System.out.println("3. To display all student data.");
            System.out.println("4. To exit.");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine(); // Consume newline

            switch (choice) {
                case 1: 
                    System.out.print("Enter student ID: ");
                    int id = scan.nextInt();
                    scan.nextLine(); // Consume newline
                    System.out.print("Enter student name: ");
                    String name = scan.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scan.nextInt();
                    scan.nextLine(); // Consume newline
                    System.out.print("Enter student department: ");
                    String department = scan.nextLine();
                    Student newStudent = new Student(id, name, age, department);
                    s.addStudent(newStudent);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter student ID to search: ");
                    int searchId = scan.nextInt();
                    Student foundStudent = s.getStudent(searchId);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student with ID " + searchId + " not found.");
                    }
                    break;

                case 3:
                    System.out.println("Displaying all student data:");
                    s.displayAllStudents();
                    break;

                case 4: 
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
