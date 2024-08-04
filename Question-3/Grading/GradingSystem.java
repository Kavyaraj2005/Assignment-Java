package Grading;

public class GradingSystem {

    private Student[] students;
    private Grade[] grades;
    private int[] courseCredits;
    private int studentCount = 0;
    private int gradeCount = 0;

    public GradingSystem(int totalstudents, int totalgrades) {
        students = new Student[totalstudents];
        grades = new Grade[totalgrades];
        courseCredits = new int[totalgrades];
    }

    public void addStudent(Student student) {
        if (studentCount < students.length)
            students[studentCount++] = student;
        else
            System.out.println("Maximum student limit reached.");
    }

    public void addGrade(Grade grade) {
        if (gradeCount < grades.length)
            grades[gradeCount++] = grade;
        else
            System.out.println("Grade limit reached.");
    }

    public void addCourseCredits(int courseID, int credits) {
        courseCredits[courseID] = credits;
    }

    public double calculateCGPA(int studentID) {
        int totalcredits = 0;
        int totalpoints = 0;
        for (Grade g : grades) {
            if (g != null && g.getStudentID() == studentID) {
                int courseId = g.getcourseID();
                int credits = courseCredits[courseId];

                totalcredits += credits;
                totalpoints += gradeToPoint(g.getgrade()) * credits;
            }
        }
        return totalcredits == 0 ? 0 : (double) totalpoints / totalcredits;
    }

    private int gradeToPoint(char grade) {
        switch (grade) {
            case 'A': return 10;
            case 'B': return 8;
            case 'C': return 6;
            case 'D': return 4;
            case 'E': return 2;
            case 'F': return 0;
            default: return 0;
        }
    }

    public void printStudentReport(int studentID) {
        boolean studentFound = false;
        for (Student s : students) {
            if (s != null && s.getStudentID() == studentID) {
                studentFound = true;
                System.out.println("Student Name: " + s.getName());
                System.out.println("Student ID: " + s.getStudentID());
                for (Grade g : grades) {
                    if (g != null && g.getStudentID() == studentID) {
                        System.out.println("Course ID: " + g.getcourseID() + ", Grade: " + g.getgrade());
                    }
                }
                double cgpa = calculateCGPA(studentID);
                System.out.println("CGPA: " + cgpa);
                break;
            }
        }
        if (!studentFound) {
            System.out.println("Student ID not found.");
        }
    }
}
