import java.util.Scanner;
import Enroll.Course;
import Enroll.Enrollment;

public class CourseEnrollment {
    private static Course[] courseCatalog;
    private static Enrollment enrollment;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number of students: ");
        int numStudents = scan.nextInt();
        System.out.println("Enter the number of courses: ");
        int numCourses = scan.nextInt();

        courseCatalog = new Course[numCourses];
        enrollment = new Enrollment(numStudents, numCourses);

        // Initialize courses (in a real application, you might want to load these from a file or database)
        for (int i = 0; i < numCourses; i++) {
            System.out.println("Enter course ID for course " + (i + 1) + ": ");
            int courseID = scan.nextInt();
            scan.nextLine();
            System.out.println("Enter course name for course " + (i + 1) + ": ");
            String courseName = scan.nextLine();
            System.out.println("Enter credits for course " + (i + 1) + ": ");
            int credits = scan.nextInt();
            scan.nextLine();
            courseCatalog[i] = new Course(courseID, courseName, credits);
        }

        while (true) {
            System.out.println("1. Enroll in course.");
            System.out.println("2. Drop a course.");
            System.out.println("3. View all courses enrolled by a student.");
            System.out.println("4. Exit.");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter student ID: ");
                    int studentID = scan.nextInt();
                    System.out.println("Enter course ID: ");
                    int courseID = scan.nextInt();
                    scan.nextLine();
                    enrollment.enroll(studentID, courseID);
                    break;
                case 2:
                    System.out.println("Enter student ID: ");
                    studentID = scan.nextInt();
                    System.out.println("Enter course ID: ");
                    courseID = scan.nextInt();
                    scan.nextLine();
                    enrollment.drop(studentID, courseID);
                    break;
                case 3:
                    System.out.println("Enter student ID: ");
                    studentID = scan.nextInt();
                    scan.nextLine();
                    enrollment.getEnrolledCourses(studentID, courseCatalog);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scan.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
