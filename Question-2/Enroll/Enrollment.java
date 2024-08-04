package Enroll;

public class Enrollment {
    private int[][] studentCourses;
    private int[] count;

    public Enrollment(int maxStudents, int maxCourses) {
        studentCourses = new int[maxStudents][maxCourses];
        count = new int[maxStudents];
    }

    public void enroll(int studentID, int courseID) {
        studentCourses[studentID][count[studentID]] = courseID;
        count[studentID]++;
    }

    public void drop(int studentID, int courseID) {
        for (int i = 0; i < count[studentID]; i++) {
            if (studentCourses[studentID][i] == courseID) {
                for (int j = i; j < count[studentID] - 1; j++) {
                    studentCourses[studentID][j] = studentCourses[studentID][j + 1];
                }
                count[studentID]--;
                break;
            }
        }
    }

    public void getEnrolledCourses(int studentID, Course[] courseCatalog) {
        System.out.println("Courses enrolled by student ID " + studentID + ":");
        for (int i = 0; i < count[studentID]; i++) {
            int courseID = studentCourses[studentID][i];
            for (Course course : courseCatalog) {
                if (course.getCourseID() == courseID) {
                    System.out.println(course);
                    break;
                }
            }
        }
    }
}
